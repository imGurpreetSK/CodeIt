
package com.gurpreetsingh.codeit;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Gurpreet Singh on 06-Sep-15.
 */

public class QuesDatabase extends SQLiteOpenHelper {

    private static final String DBname = "QUESTIONS";
    private static final int DBversion = 3;

    public QuesDatabase(Context context) {
        super(context, DBname, null, DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Create Database
        try {
            sqLiteDatabase.execSQL("CREATE TABLE QUESTIONS_LIST(_id INTEGER PRIMARY KEY AUTOINCREMENT, QUESTION TEXT, ANSWER TEXT, SUBJECT TEXT);");
            CodeItAsyncTask ci = new CodeItAsyncTask(sqLiteDatabase);
            ci.execute();
            Log.i("DATABASE ASYNCTASK", "Database created!");
        }catch(SQLiteException e){
            e.printStackTrace();
        }
    }

    protected void putData(SQLiteDatabase db, String name, String body, String subject){
        ContentValues values = new ContentValues();
        values.put("QUESTION", name);
        values.put("ANSWER", body);
        values.put("SUBJECT", subject);
        db.insert("QUESTIONS_LIST", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS QUESTIONS_LIST");
        onCreate(sqLiteDatabase);
    }


    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        super.onDowngrade(db, oldVersion, newVersion);
        db.execSQL("DROP TABLE IF EXISTS QUESTIONS_LIST");
        onCreate(db);
    }

    private class CodeItAsyncTask extends AsyncTask<Void, Void, Void>{

        SQLiteDatabase sqLiteDatabase;

        public CodeItAsyncTask(SQLiteDatabase sqLiteDatabase) {
            this.sqLiteDatabase = sqLiteDatabase;
        }

        @Override
        protected Void doInBackground(Void... nulls) {

            //C PROGRAMS
            putData(sqLiteDatabase, "To input an integer and then print it", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "  int a;\n" +
                    " \n" +
                    "  printf(\"Enter an integer\\n\");\n" +
                    "  scanf(\"%d\", &a);\n" +
                    " \n" +
                    "  printf(\"Integer that you have entered is %d\", a);\n" +
                    "  return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "To check odd or even (using modulus operator)", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int n;\n" +
                    " \n" +
                    "   printf(\"Enter an integer\\n\");\n" +
                    "   scanf(\"%d\", &n);\n" +
                    " \n" +
                    "   if (n%2 == 0)\n" +
                    "      printf(\"Even\\n\");\n" +
                    "   else\n" +
                    "      printf(\"Odd\\n\");\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Perform addition, subtraction, multiplication and division", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int first, second, add, subtract, multiply;\n" +
                    "   float divide;\n" +
                    " \n" +
                    "   printf(\"Enter two integers\\n\");\n" +
                    "   scanf(\"%d%d\", &first, &second);\n" +
                    " \n" +
                    "   add = first + second;\n" +
                    "   subtract = first - second;\n" +
                    "   multiply = first * second;\n" +
                    "   divide = first / (float)second;   //typecasting\n" +
                    " \n" +
                    "   printf(\"Sum = %d\\n\",add);\n" +
                    "   printf(\"Difference = %d\\n\",subtract);\n" +
                    "   printf(\"Multiplication = %d\\n\",multiply);\n" +
                    "   printf(\"Division = %.2f\\n\",divide);\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Check whether input alphabet is a vowel or not", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "  char ch;\n" +
                    " \n" +
                    "  printf(\"Input a character\\n\");\n" +
                    "  scanf(\"%c\", &ch);\n" +
                    " \n" +
                    "  switch(ch)\n" +
                    "  {\n" +
                    "    case 'a':\n" +
                    "    case 'A':\n" +
                    "    case 'e':\n" +
                    "    case 'E':\n" +
                    "    case 'i':\n" +
                    "    case 'I':\n" +
                    "    case 'o':\n" +
                    "    case 'O':\n" +
                    "    case 'u':\n" +
                    "    case 'U':\n" +
                    "      printf(\"%c is a vowel.\\n\", ch);\n" +
                    "      break;\n" +
                    "    default:\n" +
                    "      printf(\"%c is not a vowel.\\n\", ch);\n" +
                    "  }              \n" +
                    " \n" +
                    "  return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Find and print factorial of a number", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "  int c, n, fact = 1;\n" +
                    " \n" +
                    "  printf(\"Enter a number to calculate it's factorial\\n\");\n" +
                    "  scanf(\"%d\", &n);\n" +
                    " \n" +
                    "  for (c = 1; c <= n; c++)\n" +
                    "    fact = fact * c;\n" +
                    " \n" +
                    "  printf(\"Factorial of %d = %d\\n\", n, fact);\n" +
                    " \n" +
                    "  return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Factorial using Recursion", "#include<stdio.h>\n" +
                    " \n" +
                    "long factorial(int);\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "  int n;\n" +
                    "  long f;\n" +
                    " \n" +
                    "  printf(\"Enter an integer to find factorial\\n\");\n" +
                    "  scanf(\"%d\", &n); \n" +
                    " \n" +
                    "  if (n < 0)\n" +
                    "    printf(\"Negative integers are not allowed.\\n\");\n" +
                    "  else\n" +
                    "  {\n" +
                    "    f = factorial(n);\n" +
                    "    printf(\"%d! = %ld\\n\", n, f);\n" +
                    "  }\n" +
                    " \n" +
                    "  return 0;\n" +
                    "}\n" +
                    " \n" +
                    "long factorial(int n)\n" +
                    "{\n" +
                    "  if (n == 0)\n" +
                    "    return 1;\n" +
                    "  else\n" +
                    "    return(n * factorial(n-1));\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Find highest common factor and least common multiple of two integers", "#include <stdio.h>\n" +
                    " \n" +
                    "int main() {\n" +
                    "  int a, b, x, y, t, gcd, lcm;\n" +
                    " \n" +
                    "  printf(\"Enter two integers\\n\");\n" +
                    "  scanf(\"%d%d\", &x, &y);\n" +
                    " \n" +
                    "  a = x;\n" +
                    "  b = y;\n" +
                    " \n" +
                    "  while (b != 0) {\n" +
                    "    t = b;\n" +
                    "    b = a % b;\n" +
                    "    a = t;\n" +
                    "  }\n" +
                    " \n" +
                    "  gcd = a;\n" +
                    "  lcm = (x*y)/gcd;\n" +
                    " \n" +
                    "  printf(\"Greatest common divisor of %d and %d = %d\\n\", x, y, gcd);\n" +
                    "  printf(\"Least common multiple of %d and %d = %d\\n\", x, y, lcm);\n" +
                    " \n" +
                    "  return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Convert decimal number to binary", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "  int n, c, k;\n" +
                    " \n" +
                    "  printf(\"Enter an integer in decimal number system\\n\");\n" +
                    "  scanf(\"%d\", &n);\n" +
                    " \n" +
                    "  printf(\"%d in binary number system is:\\n\", n);\n" +
                    " \n" +
                    "  for (c = 31; c >= 0; c--)\n" +
                    "  {\n" +
                    "    k = n >> c;\n" +
                    " \n" +
                    "    if (k & 1)\n" +
                    "      printf(\"1\");\n" +
                    "    else\n" +
                    "      printf(\"0\");\n" +
                    "  }\n" +
                    " \n" +
                    "  printf(\"\\n\");\n" +
                    " \n" +
                    "  return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Swap two numbers", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int x, y, temp;\n" +
                    " \n" +
                    "   printf(\"Enter the value of x and y\\n\");\n" +
                    "   scanf(\"%d%d\", &x, &y);\n" +
                    " \n" +
                    "   printf(\"Before Swapping\\nx = %d\\ny = %d\\n\",x,y);\n" +
                    " \n" +
                    "   temp = x;\n" +
                    "   x    = y;\n" +
                    "   y    = temp;\n" +
                    " \n" +
                    "   printf(\"After Swapping\\nx = %d\\ny = %d\\n\",x,y);\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Reverse a number", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int n, reverse = 0;\n" +
                    " \n" +
                    "   printf(\"Enter a number to reverse\\n\");\n" +
                    "   scanf(\"%d\", &n);\n" +
                    " \n" +
                    "   while (n != 0)\n" +
                    "   {\n" +
                    "      reverse = reverse * 10;\n" +
                    "      reverse = reverse + n%10;\n" +
                    "      n       = n/10;\n" +
                    "   }\n" +
                    " \n" +
                    "   printf(\"Reverse of entered number is = %d\\n\", reverse);\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Check whether a number is prime or not", "#include<stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int n, i = 3, count, c;\n" +
                    " \n" +
                    "   printf(\"Enter the number of prime numbers required\\n\");\n" +
                    "   scanf(\"%d\",&n);\n" +
                    " \n" +
                    "   if ( n >= 1 )\n" +
                    "   {\n" +
                    "      printf(\"First %d prime numbers are :\\n\",n);\n" +
                    "      printf(\"2\\n\");\n" +
                    "   }\n" +
                    " \n" +
                    "   for ( count = 2 ; count <= n ;  )\n" +
                    "   {\n" +
                    "      for ( c = 2 ; c <= i - 1 ; c++ )\n" +
                    "      {\n" +
                    "         if ( i%c == 0 )\n" +
                    "            break;\n" +
                    "      }\n" +
                    "      if ( c == i )\n" +
                    "      {\n" +
                    "         printf(\"%d\\n\",i);\n" +
                    "         count++;\n" +
                    "      }\n" +
                    "      i++;\n" +
                    "   }\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Check whether a number is Armstrong or not", "#include <stdio.h>\n" +
                    " \n" +
                    "int power(int, int);\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int n, sum = 0, temp, remainder, digits = 0;\n" +
                    " \n" +
                    "   printf(\"Input an integer\\n\");\n" +
                    "   scanf(\"%d\", &n);\n" +
                    " \n" +
                    "   temp = n;\n" +
                    "   // Count number of digits\n" +
                    "   while (temp != 0) {\n" +
                    "      digits++;\n" +
                    "      temp = temp/10;\n" +
                    "   }\n" +
                    " \n" +
                    "   temp = n;\n" +
                    " \n" +
                    "   while (temp != 0) {\n" +
                    "      remainder = temp%10;\n" +
                    "      sum = sum + power(remainder, digits);\n" +
                    "      temp = temp/10;\n" +
                    "   }\n" +
                    " \n" +
                    "   if (n == sum)\n" +
                    "      printf(\"%d is an Armstrong number.\\n\", n);\n" +
                    "   else\n" +
                    "      printf(\"%d is not an Armstrong number.\\n\", n);\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}\n" +
                    " \n" +
                    "int power(int n, int r) {\n" +
                    "   int c, p = 1;\n" +
                    " \n" +
                    "   for (c = 1; c <= r; c++) \n" +
                    "      p = p*n;\n" +
                    " \n" +
                    "   return p;   \n" +
                    "}", "C");
            putData(sqLiteDatabase, "Print Fibonacci series till n terms", "#include<stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int n, first = 0, second = 1, next, c;\n" +
                    " \n" +
                    "   printf(\"Enter the number of terms\\n\");\n" +
                    "   scanf(\"%d\",&n);\n" +
                    " \n" +
                    "   printf(\"First %d terms of Fibonacci series are : \",n);\n" +
                    " \n" +
                    "   for ( c = 0 ; c < n ; c++ )\n" +
                    "   {\n" +
                    "      if ( c <= 1 )\n" +
                    "         next = c;\n" +
                    "      else\n" +
                    "      {\n" +
                    "         next = first + second;\n" +
                    "         first = second;\n" +
                    "         second = next;\n" +
                    "      }\n" +
                    "      printf(\"%d\\n\",next);\n" +
                    "   }\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Add two numbers using pointers", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int first, second, *p, *q, sum;\n" +
                    " \n" +
                    "   printf(\"Enter two integers to add\\n\");\n" +
                    "   scanf(\"%d%d\", &first, &second);\n" +
                    " \n" +
                    "   p = &first;\n" +
                    "   q = &second;\n" +
                    " \n" +
                    "   sum = *p + *q;\n" +
                    " \n" +
                    "   printf(\"Sum of entered numbers = %d\\n\",sum);\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "C");
            putData(sqLiteDatabase, "Swap two strings", "#include <stdio.h>\n" +
                    "#include <string.h>\n" +
                    "#include <malloc.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   char first[100], second[100], *temp;\n" +
                    " \n" +
                    "   printf(\"Enter the first string\\n\");\n" +
                    "   gets(first);\n" +
                    " \n" +
                    "   printf(\"Enter the second string\\n\");\n" +
                    "   gets(second);\n" +
                    " \n" +
                    "   printf(\"\\nBefore Swapping\\n\");\n" +
                    "   printf(\"First string: %s\\n\",first);\n" +
                    "   printf(\"Second string: %s\\n\\n\",second);\n" +
                    " \n" +
                    "   temp = (char*)malloc(100);\n" +
                    " \n" +
                    "   strcpy(temp,first);\n" +
                    "   strcpy(first,second);\n" +
                    "   strcpy(second,temp);\n" +
                    " \n" +
                    "   printf(\"After Swapping\\n\");\n" +
                    "   printf(\"First string: %s\\n\",first);\n" +
                    "   printf(\"Second string: %s\\n\",second);\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "C");

            //ADA PROGRAMS
            putData(sqLiteDatabase, "To find maximum element in array", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "  int array[100], maximum, size, c, location = 1;\n" +
                    " \n" +
                    "  printf(\"Enter the number of elements in array\\n\");\n" +
                    "  scanf(\"%d\", &size);\n" +
                    " \n" +
                    "  printf(\"Enter %d integers\\n\", size);\n" +
                    " \n" +
                    "  for (c = 0; c < size; c++)\n" +
                    "    scanf(\"%d\", &array[c]);\n" +
                    " \n" +
                    "  maximum = array[0];\n" +
                    " \n" +
                    "  for (c = 1; c < size; c++)\n" +
                    "  {\n" +
                    "    if (array[c] > maximum)\n" +
                    "    {\n" +
                    "       maximum  = array[c];\n" +
                    "       location = c+1;\n" +
                    "    }\n" +
                    "  }\n" +
                    " \n" +
                    "  printf(\"Maximum element is present at location %d and it's value is %d.\\n\", location, maximum);\n" +
                    "  return 0;\n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Linear search", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int array[100], search, c, n;\n" +
                    " \n" +
                    "   printf(\"Enter the number of elements in array\\n\");\n" +
                    "   scanf(\"%d\",&n);\n" +
                    " \n" +
                    "   printf(\"Enter %d integer(s)\\n\", n);\n" +
                    " \n" +
                    "   for (c = 0; c < n; c++)\n" +
                    "      scanf(\"%d\", &array[c]);\n" +
                    " \n" +
                    "   printf(\"Enter the number to search\\n\");\n" +
                    "   scanf(\"%d\", &search);\n" +
                    " \n" +
                    "   for (c = 0; c < n; c++)\n" +
                    "   {\n" +
                    "      if (array[c] == search)     /* if required element found */\n" +
                    "      {\n" +
                    "         printf(\"%d is present at location %d.\\n\", search, c+1);\n" +
                    "         break;\n" +
                    "      }\n" +
                    "   }\n" +
                    "   if (c == n)\n" +
                    "      printf(\"%d is not present in array.\\n\", search);\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Binary search", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int c, first, last, middle, n, search, array[100];\n" +
                    " \n" +
                    "   printf(\"Enter number of elements\\n\");\n" +
                    "   scanf(\"%d\",&n);\n" +
                    " \n" +
                    "   printf(\"Enter %d integers\\n\", n);\n" +
                    " \n" +
                    "   for (c = 0; c < n; c++)\n" +
                    "      scanf(\"%d\",&array[c]);\n" +
                    " \n" +
                    "   printf(\"Enter value to find\\n\");\n" +
                    "   scanf(\"%d\", &search);\n" +
                    " \n" +
                    "   first = 0;\n" +
                    "   last = n - 1;\n" +
                    "   middle = (first+last)/2;\n" +
                    " \n" +
                    "   while (first <= last) {\n" +
                    "      if (array[middle] < search)\n" +
                    "         first = middle + 1;    \n" +
                    "      else if (array[middle] == search) {\n" +
                    "         printf(\"%d found at location %d.\\n\", search, middle+1);\n" +
                    "         break;\n" +
                    "      }\n" +
                    "      else\n" +
                    "         last = middle - 1;\n" +
                    " \n" +
                    "      middle = (first + last)/2;\n" +
                    "   }\n" +
                    "   if (first > last)\n" +
                    "      printf(\"Not found! %d is not present in the list.\\n\", search);\n" +
                    " \n" +
                    "   return 0;   \n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Reverse an array", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int n, c, d, a[100], b[100];\n" +
                    " \n" +
                    "   printf(\"Enter the number of elements in array\\n\");\n" +
                    "   scanf(\"%d\", &n);\n" +
                    " \n" +
                    "   printf(\"Enter the array elements\\n\");\n" +
                    " \n" +
                    "   for (c = 0; c < n ; c++)\n" +
                    "      scanf(\"%d\", &a[c]);\n" +
                    " \n" +
                    " \n" +
                    "   for (c = n - 1, d = 0; c >= 0; c--, d++)\n" +
                    "      b[d] = a[c];\n" +
                    " \n" +
                    "   /*\n" +
                    " \n" +
                    "   for (c = 0; c < n; c++)\n" +
                    "      a[c] = b[c];\n" +
                    " \n" +
                    "   printf(\"Reverse array is\\n\");\n" +
                    " \n" +
                    "   for (c = 0; c < n; c++)\n" +
                    "      printf(\"%d\\n\", a[c]);\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Insert an element in an array", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int array[100], position, c, n, value;\n" +
                    " \n" +
                    "   printf(\"Enter number of elements in array\\n\");\n" +
                    "   scanf(\"%d\", &n);\n" +
                    " \n" +
                    "   printf(\"Enter %d elements\\n\", n);\n" +
                    " \n" +
                    "   for (c = 0; c < n; c++)\n" +
                    "      scanf(\"%d\", &array[c]);\n" +
                    " \n" +
                    "   printf(\"Enter the location where you wish to insert an element\\n\");\n" +
                    "   scanf(\"%d\", &position);\n" +
                    " \n" +
                    "   printf(\"Enter the value to insert\\n\");\n" +
                    "   scanf(\"%d\", &value);\n" +
                    " \n" +
                    "   for (c = n - 1; c >= position - 1; c--)\n" +
                    "      array[c+1] = array[c];\n" +
                    " \n" +
                    "   array[position-1] = value;\n" +
                    " \n" +
                    "   printf(\"Resultant array is\\n\");\n" +
                    " \n" +
                    "   for (c = 0; c <= n; c++)\n" +
                    "      printf(\"%d\\n\", array[c]);\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Delete an element from an array", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int array[100], position, c, n;\n" +
                    " \n" +
                    "   printf(\"Enter number of elements in array\\n\");\n" +
                    "   scanf(\"%d\", &n);\n" +
                    " \n" +
                    "   printf(\"Enter %d elements\\n\", n);\n" +
                    " \n" +
                    "   for ( c = 0 ; c < n ; c++ )\n" +
                    "      scanf(\"%d\", &array[c]);\n" +
                    " \n" +
                    "   printf(\"Enter the location where you wish to delete element\\n\");\n" +
                    "   scanf(\"%d\", &position);\n" +
                    " \n" +
                    "   if ( position >= n+1 )\n" +
                    "      printf(\"Deletion not possible.\\n\");\n" +
                    "   else\n" +
                    "   {\n" +
                    "      for ( c = position - 1 ; c < n - 1 ; c++ )\n" +
                    "         array[c] = array[c+1];\n" +
                    " \n" +
                    "      printf(\"Resultant array is\\n\");\n" +
                    " \n" +
                    "      for( c = 0 ; c < n - 1 ; c++ )\n" +
                    "         printf(\"%d\\n\", array[c]);\n" +
                    "   }\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Merge two arrays", "#include <stdio.h>\n" +
                    " \n" +
                    "void merge(int [], int, int [], int, int []);\n" +
                    " \n" +
                    "int main() {\n" +
                    "  int a[100], b[100], m, n, c, sorted[200];\n" +
                    " \n" +
                    "  printf(\"Input number of elements in first array\\n\");\n" +
                    "  scanf(\"%d\", &m);\n" +
                    " \n" +
                    "  printf(\"Input %d integers\\n\", m);\n" +
                    "  for (c = 0; c < m; c++) {\n" +
                    "    scanf(\"%d\", &a[c]);\n" +
                    "  }\n" +
                    " \n" +
                    "  printf(\"Input number of elements in second array\\n\");\n" +
                    "  scanf(\"%d\", &n);\n" +
                    " \n" +
                    "  printf(\"Input %d integers\\n\", n);\n" +
                    "  for (c = 0; c < n; c++) {\n" +
                    "    scanf(\"%d\", &b[c]);\n" +
                    "  }\n" +
                    " \n" +
                    "  merge(a, m, b, n, sorted);\n" +
                    " \n" +
                    "  printf(\"Sorted array:\\n\");\n" +
                    " \n" +
                    "  for (c = 0; c < m + n; c++) {\n" +
                    "    printf(\"%d\\n\", sorted[c]);\n" +
                    "  }\n" +
                    " \n" +
                    "  return 0;\n" +
                    "}\n" +
                    " \n" +
                    "void merge(int a[], int m, int b[], int n, int sorted[]) {\n" +
                    "  int i, j, k;\n" +
                    " \n" +
                    "  j = k = 0;\n" +
                    " \n" +
                    "  for (i = 0; i < m + n;) {\n" +
                    "    if (j < m && k < n) {\n" +
                    "      if (a[j] < b[k]) {\n" +
                    "        sorted[i] = a[j];\n" +
                    "        j++;\n" +
                    "      }\n" +
                    "      else {\n" +
                    "        sorted[i] = b[k];\n" +
                    "        k++;\n" +
                    "      }\n" +
                    "      i++;\n" +
                    "    }\n" +
                    "    else if (j == m) {\n" +
                    "      for (; i < m + n;) {\n" +
                    "        sorted[i] = b[k];\n" +
                    "        k++;\n" +
                    "        i++;\n" +
                    "      }\n" +
                    "    }\n" +
                    "    else {\n" +
                    "      for (; i < m + n;) {\n" +
                    "        sorted[i] = a[j];\n" +
                    "        j++;\n" +
                    "        i++;\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Bubble sort", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "  int array[100], n, c, d, swap;\n" +
                    " \n" +
                    "  printf(\"Enter number of elements\\n\");\n" +
                    "  scanf(\"%d\", &n);\n" +
                    " \n" +
                    "  printf(\"Enter %d integers\\n\", n);\n" +
                    " \n" +
                    "  for (c = 0; c < n; c++)\n" +
                    "    scanf(\"%d\", &array[c]);\n" +
                    " \n" +
                    "  for (c = 0 ; c < ( n - 1 ); c++)\n" +
                    "  {\n" +
                    "    for (d = 0 ; d < n - c - 1; d++)\n" +
                    "    {\n" +
                    "      if (array[d] > array[d+1]) /* For decreasing order use < */\n" +
                    "      {\n" +
                    "        swap       = array[d];\n" +
                    "        array[d]   = array[d+1];\n" +
                    "        array[d+1] = swap;\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    " \n" +
                    "  printf(\"Sorted list in ascending order:\\n\");\n" +
                    " \n" +
                    "  for ( c = 0 ; c < n ; c++ )\n" +
                    "     printf(\"%d\\n\", array[c]);\n" +
                    " \n" +
                    "  return 0;\n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Insertion sort", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "  int n, array[1000], c, d, t;\n" +
                    " \n" +
                    "  printf(\"Enter number of elements\\n\");\n" +
                    "  scanf(\"%d\", &n);\n" +
                    " \n" +
                    "  printf(\"Enter %d integers\\n\", n);\n" +
                    " \n" +
                    "  for (c = 0; c < n; c++) {\n" +
                    "    scanf(\"%d\", &array[c]);\n" +
                    "  }\n" +
                    " \n" +
                    "  for (c = 1 ; c <= n - 1; c++) {\n" +
                    "    d = c;\n" +
                    " \n" +
                    "    while ( d > 0 && array[d] < array[d-1]) {\n" +
                    "      t          = array[d];\n" +
                    "      array[d]   = array[d-1];\n" +
                    "      array[d-1] = t;\n" +
                    " \n" +
                    "      d--;\n" +
                    "    }\n" +
                    "  }\n" +
                    " \n" +
                    "  printf(\"Sorted list in ascending order:\\n\");\n" +
                    " \n" +
                    "  for (c = 0; c <= n - 1; c++) {\n" +
                    "    printf(\"%d\\n\", array[c]);\n" +
                    "  }\n" +
                    " \n" +
                    "  return 0;\n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Selection sort", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int array[100], n, c, d, position, swap;\n" +
                    " \n" +
                    "   printf(\"Enter number of elements\\n\");\n" +
                    "   scanf(\"%d\", &n);\n" +
                    " \n" +
                    "   printf(\"Enter %d integers\\n\", n);\n" +
                    " \n" +
                    "   for ( c = 0 ; c < n ; c++ )\n" +
                    "      scanf(\"%d\", &array[c]);\n" +
                    " \n" +
                    "   for ( c = 0 ; c < ( n - 1 ) ; c++ )\n" +
                    "   {\n" +
                    "      position = c;\n" +
                    " \n" +
                    "      for ( d = c + 1 ; d < n ; d++ )\n" +
                    "      {\n" +
                    "         if ( array[position] > array[d] )\n" +
                    "            position = d;\n" +
                    "      }\n" +
                    "      if ( position != c )\n" +
                    "      {\n" +
                    "         swap = array[c];\n" +
                    "         array[c] = array[position];\n" +
                    "         array[position] = swap;\n" +
                    "      }\n" +
                    "   }\n" +
                    " \n" +
                    "   printf(\"Sorted list in ascending order:\\n\");\n" +
                    " \n" +
                    "   for ( c = 0 ; c < n ; c++ )\n" +
                    "      printf(\"%d\\n\", array[c]);\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Add two matrix", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int m, n, c, d, first[10][10], second[10][10], sum[10][10];\n" +
                    " \n" +
                    "   printf(\"Enter the number of rows and columns of matrix\\n\");\n" +
                    "   scanf(\"%d%d\", &m, &n);\n" +
                    "   printf(\"Enter the elements of first matrix\\n\");\n" +
                    " \n" +
                    "   for (c = 0; c < m; c++)\n" +
                    "      for (d = 0; d < n; d++)\n" +
                    "         scanf(\"%d\", &first[c][d]);\n" +
                    " \n" +
                    "   printf(\"Enter the elements of second matrix\\n\");\n" +
                    " \n" +
                    "   for (c = 0; c < m; c++)\n" +
                    "      for (d = 0 ; d < n; d++)\n" +
                    "            scanf(\"%d\", &second[c][d]);\n" +
                    " \n" +
                    "   printf(\"Sum of entered matrices:-\\n\");\n" +
                    " \n" +
                    "   for (c = 0; c < m; c++) {\n" +
                    "      for (d = 0 ; d < n; d++) {\n" +
                    "         sum[c][d] = first[c][d] + second[c][d];\n" +
                    "         printf(\"%d\\t\", sum[c][d]);\n" +
                    "      }\n" +
                    "      printf(\"\\n\");\n" +
                    "   }\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Transpose a matrix", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   int m, n, c, d, matrix[10][10], transpose[10][10];\n" +
                    " \n" +
                    "   printf(\"Enter the number of rows and columns of matrix\\n\");\n" +
                    "   scanf(\"%d%d\", &m, &n);\n" +
                    " \n" +
                    "   printf(\"Enter the elements of matrix\\n\");\n" +
                    " \n" +
                    "   for (c = 0; c < m; c++)\n" +
                    "      for(d = 0; d < n; d++)\n" +
                    "         scanf(\"%d\",&matrix[c][d]);\n" +
                    " \n" +
                    "   for (c = 0; c < m; c++)\n" +
                    "      for( d = 0 ; d < n ; d++ )\n" +
                    "         transpose[d][c] = matrix[c][d];\n" +
                    " \n" +
                    "   printf(\"Transpose of entered matrix :-\\n\");\n" +
                    " \n" +
                    "   for (c = 0; c < n; c++) {\n" +
                    "      for (d = 0; d < m; d++)\n" +
                    "         printf(\"%d\\t\",transpose[c][d]);\n" +
                    "      printf(\"\\n\");\n" +
                    "   }\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "ADA");
            putData(sqLiteDatabase, "Matrix multiplication", "#include <stdio.h>\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "  int m, n, p, q, c, d, k, sum = 0;\n" +
                    "  int first[10][10], second[10][10], multiply[10][10];\n" +
                    " \n" +
                    "  printf(\"Enter the number of rows and columns of first matrix\\n\");\n" +
                    "  scanf(\"%d%d\", &m, &n);\n" +
                    "  printf(\"Enter the elements of first matrix\\n\");\n" +
                    " \n" +
                    "  for (c = 0; c < m; c++)\n" +
                    "    for (d = 0; d < n; d++)\n" +
                    "      scanf(\"%d\", &first[c][d]);\n" +
                    " \n" +
                    "  printf(\"Enter the number of rows and columns of second matrix\\n\");\n" +
                    "  scanf(\"%d%d\", &p, &q);\n" +
                    " \n" +
                    "  if (n != p)\n" +
                    "    printf(\"Matrices with entered orders can't be multiplied with each other.\\n\");\n" +
                    "  else\n" +
                    "  {\n" +
                    "    printf(\"Enter the elements of second matrix\\n\");\n" +
                    " \n" +
                    "    for (c = 0; c < p; c++)\n" +
                    "      for (d = 0; d < q; d++)\n" +
                    "        scanf(\"%d\", &second[c][d]);\n" +
                    " \n" +
                    "    for (c = 0; c < m; c++) {\n" +
                    "      for (d = 0; d < q; d++) {\n" +
                    "        for (k = 0; k < p; k++) {\n" +
                    "          sum = sum + first[c][k]*second[k][d];\n" +
                    "        }\n" +
                    " \n" +
                    "        multiply[c][d] = sum;\n" +
                    "        sum = 0;\n" +
                    "      }\n" +
                    "    }\n" +
                    " \n" +
                    "    printf(\"Product of entered matrices:-\\n\");\n" +
                    " \n" +
                    "    for (c = 0; c < m; c++) {\n" +
                    "      for (d = 0; d < q; d++)\n" +
                    "        printf(\"%d\\t\", multiply[c][d]);\n" +
                    " \n" +
                    "      printf(\"\\n\");\n" +
                    "    }\n" +
                    "  }\n" +
                    " \n" +
                    "  return 0;\n" +
                    "}", "ADA");

            //CPP PROGRAMS
            putData(sqLiteDatabase, "Addition of two numbers using class", "#include <iostream>\n" +
                    " \n" +
                    "using namespace std;\n" +
                    " \n" +
                    "class Mathematics {\n" +
                    "  int x, y;\n" +
                    " \n" +
                    "public:\n" +
                    "  void input() {\n" +
                    "    cout << \"Input two inetegers\\n\";\n" +
                    "    cin >> x >> y;\n" +
                    "  }\n" +
                    " \n" +
                    "  void add() {\n" +
                    "    cout << \"Result = \" << x + y;\n" +
                    "  }\n" +
                    " \n" +
                    "};\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "   Mathematics m; // Creating object of class\n" +
                    " \n" +
                    "   m.input();\n" +
                    "   m.add();\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "CPP");
            putData(sqLiteDatabase, "C++ program to check whether a number is not a perfect number or not", "#include<iostream>\n" +
                    "#include<iomanip>\n" +
                    "int main(){\n" +
                    "  int n,i=1,sum=0;\n" +
                    "\n" +
                    "  cout<<\"Enter a number: \";\n" +
                    "  scanf(\"%d\",&n);\n" +
                    "\n" +
                    "  while(i<n){\n" +
                    "         if(n%i==0)\n" +
                    "               sum=sum+i;\n" +
                    "              i++;\n" +
                    "  }\n" +
                    "  if(sum==n)\n" +
                    "         cout << i  <<  \" is a perfect number\";\n" +
                    "  else\n" +
                    "         cout << i << \" is not a perfect number\";\n" +
                    "\n" +
                    "  return 0;\n" +
                    "}\n", "CPP");
            putData(sqLiteDatabase, "Check the given number is palindrome number or not", "#include<iostream>\n" +
                    "int main(){\n" +
                    "    int num,r,sum=0,temp;\n" +
                    "\n" +
                    "    cout << \"Enter a number: \";\n" +
                    "    cin >> num;\n" +
                    "\n" +
                    "    for(temp=num;num!=0;num=num/10){\n" +
                    "         r=num%10;\n" +
                    "         sum=sum*10+r;\n" +
                    "    }\n" +
                    "    if(temp==sum)\n" +
                    "         cout << temp << \" is a palindrome\";\n" +
                    "    else\n" +
                    "         cout << \" is not a palindrome\";\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}", "CPP");
            putData(sqLiteDatabase, "\n" +
                    "To check given number is odd or even", "#include<iostream>\n" +
                    "\n" +
                    "int main(){\n" +
                    "\n" +
                    "    int number;\n" +
                    "    int min,max;\n" +
                    " \n" +
                    "    cout << \"Enter the minimum range: \";\n" +
                    "    cin >> min;\n" +
                    "\n" +
                    "   cout << \"Enter the maximum range: \";\n" +
                    "    cin >> max;\n" +
                    "\n" +
                    "    cout << \"Odd numbers in given range are: \";\n" +
                    "    for(number = min;number <= max; number++)\n" +
                    "\n" +
                    "         if(number % 2 !=0)\n" +
                    "             cout << number;\n" +
                    "\n" +
                    "    printf(\"\\nEven numbers in given range are: \");\n" +
                    "    for(number = min;number <= max; number++)\n" +
                    "\n" +
                    "         if(number % 2 ==0)\n" +
                    "             cout << number << \" \";\n" +
                    " \n" +
                    "    return 0;\n" +
                    "}", "CPP");
            putData(sqLiteDatabase, "\n" +
                    "Check given number is prime number or not", "#include<iostream>\n" +
                    "#include<iomanip>\n" +
                    "\n" +
                    "int main(){\n" +
                    "    int num,i,count;\n" +
                    " \n" +
                    "    for(num = 1;num<=100;num++){\n" +
                    "         count = 0;\n" +
                    "\n" +
                    "         for(i=2;i<=num/2;i++){\n" +
                    "             if(num%i==0){\n" +
                    "                 count++;\n" +
                    "                 break;\n" +
                    "             }\n" +
                    "        }\n" +
                    "       \n" +
                    "         if(count==0 && num!= 1)\n" +
                    "             cout <<  num  << setw(3);\n" +
                    "    }\n" +
                    " \n" +
                    "   return 0;\n" +
                    "}", "CPP");
            putData(sqLiteDatabase, "Program to demonstrate friend Class", "#include <iostream>\n" +
                    "class A {\n" +
                    "private:\n" +
                    "    int a;\n" +
                    "public:\n" +
                    "    A() { a=0; }\n" +
                    "    friend class B;     // Friend Class\n" +
                    "};\n" +
                    " \n" +
                    "class B {\n" +
                    "private:\n" +
                    "    int b;\n" +
                    "public:\n" +
                    "    void showA(A& x) {\n" +
                    "        // Since B is friend of A, it can access\n" +
                    "        // private members of A\n" +
                    "        std::cout << \"A::a=\" << x.a;\n" +
                    "    }\n" +
                    "};\n" +
                    " \n" +
                    "int main() {\n" +
                    "   A a;\n" +
                    "   B b;\n" +
                    "   b.showA(a);\n" +
                    "   return 0;\n" +
                    "}", "CPP");
            putData(sqLiteDatabase, "To implement  runtime polymorphism", "#include<iostream>\n" +
                    "using namespace std;\n" +
                    "  \n" +
                    "class Base\n" +
                    "{\n" +
                    "public:\n" +
                    "    virtual void show() { cout<<\" In Base \\n\"; }\n" +
                    "};\n" +
                    "  \n" +
                    "class Derived: public Base\n" +
                    "{\n" +
                    "public:\n" +
                    "    void show() { cout<<\"In Derived \\n\"; }\n" +
                    "};\n" +
                    "  \n" +
                    "int main(void)\n" +
                    "{\n" +
                    "    Base *bp = new Derived;\n" +
                    "    bp->show();  // RUN-TIME POLYMORPHISM\n" +
                    "    return 0;\n" +
                    "}", "CPP");
            putData(sqLiteDatabase, "To implement multiple inheritance", "#include<iostream>\n" +
                    "using namespace std;\n" +
                    " \n" +
                    "class A\n" +
                    "{\n" +
                    "public:\n" +
                    "  A()  { cout << \"A's constructor called\" << endl; }\n" +
                    "};\n" +
                    " \n" +
                    "class B\n" +
                    "{\n" +
                    "public:\n" +
                    "  B()  { cout << \"B's constructor called\" << endl; }\n" +
                    "};\n" +
                    " \n" +
                    "class C: public B, public A  \n" +
                    "{\n" +
                    "public:\n" +
                    "  C()  { cout << \"C's constructor called\" << endl; }\n" +
                    "};\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "    C c;\n" +
                    "    return 0;\n" +
                    "}", "CPP");
            putData(sqLiteDatabase, "To demonstrate constructors in C++", "#include<iostream>\n" +
                    "using namespace std;\n" +
                    " \n" +
                    "class Point\n" +
                    "{\n" +
                    "private:\n" +
                    "    int x, y;\n" +
                    "public:\n" +
                    "    /***Constructor****/\n" +
                    "    Point(int x1, int y1) { x = x1; y = y1; }\n" +
                    " \n" +
                    "    int getX()            {  return x; }\n" +
                    "    int getY()            {  return y; }\n" +
                    "};\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "    Point p1(10, 15); // constructor is called here\n" +
                    " \n" +
                    "    // Let us access values assigned by constructor\n" +
                    "    cout << \"p1.x = \" << p1.getX() << \", p1.y = \" << p1.getY();\n" +
                    " \n" +
                    "    return 0;\n" +
                    "}", "CPP");
            putData(sqLiteDatabase, "To demonstrate copy constructors in C++", "#include<iostream>\n" +
                    "using namespace std;\n" +
                    " \n" +
                    "class Point\n" +
                    "{\n" +
                    "private:\n" +
                    "    int x, y;\n" +
                    "public:\n" +
                    "    Point(int x1, int y1) { x = x1; y = y1; }\n" +
                    " \n" +
                    "    // Copy constructor\n" +
                    "    Point(const Point &p2) {x = p2.x; y = p2.y; }\n" +
                    " \n" +
                    "    int getX()            {  return x; }\n" +
                    "    int getY()            {  return y; }\n" +
                    "};\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "    Point p1(10, 15); // Normal constructor is called here\n" +
                    "    Point p2 = p1; // Copy constructor is called here\n" +
                    " \n" +
                    "    // Let us access values assigned by constructors\n" +
                    "    cout << \"p1.x = \" << p1.getX() << \", p1.y = \" << p1.getY();\n" +
                    "    cout << \"\\np2.x = \" << p2.getX() << \", p2.y = \" << p2.getY();\n" +
                    " \n" +
                    "    return 0;\n" +
                    "}", "CPP");
            putData(sqLiteDatabase, "To demonstrate destructors in C++", "class String\n" +
                    "{\n" +
                    "private:\n" +
                    "    char *s;\n" +
                    "    int size;\n" +
                    "public:\n" +
                    "    String(char *); // constructor\n" +
                    "    ~String();      // destructor\n" +
                    "};\n" +
                    "  \n" +
                    "String::String(char *c)\n" +
                    "{\n" +
                    "    size = strlen(c);\n" +
                    "    s = new char[size+1];\n" +
                    "    strcpy(s,c);\n" +
                    "}\n" +
                    "  \n" +
                    "String::~String()\n" +
                    "{\n" +
                    "    delete []s;\n" +
                    "}", "CPP");
            putData(sqLiteDatabase, "To show declaration and function call using function pointer", "#include <stdio.h>\n" +
                    "// A normal function with an int parameter\n" +
                    "// and void return type\n" +
                    "void fun(int a)\n" +
                    "{\n" +
                    "    printf(\"Value of a is %d\\n\", a);\n" +
                    "}\n" +
                    " \n" +
                    "int main()\n" +
                    "{\n" +
                    "    // fun_ptr is a pointer to function fun() \n" +
                    "    void (*fun_ptr)(int) = &fun;\n" +
                    " \n" +
                    "    /* The above line is equivalent of following two\n" +
                    "       void (*fun_ptr)(int);\n" +
                    "       fun_ptr = &fun; \n" +
                    "    */\n" +
                    " \n" +
                    "    // Invoking fun() using fun_ptr\n" +
                    "    (*fun_ptr)(10);\n" +
                    " \n" +
                    "    return 0;\n" +
                    "}", "CPP");
            putData(sqLiteDatabase, "To demonstrate function overloading", "#include <iostream>\n" +
                    "using namespace std;\n" +
                    " \n" +
                    "void print(int i) {\n" +
                    "  cout << \" Here is int \" << i << endl;\n" +
                    "}\n" +
                    "void print(double  f) {\n" +
                    "  cout << \" Here is float \" << f << endl;\n" +
                    "}\n" +
                    "void print(char* c) {\n" +
                    "  cout << \" Here is char* \" << c << endl;\n" +
                    "}\n" +
                    " \n" +
                    "int main() {\n" +
                    "  print(10);\n" +
                    "  print(10.10);\n" +
                    "  print(\"ten\");\n" +
                    "  return 0;\n" +
                    "}", "CPP");

          //  putData(sqLiteDatabase, "aaa", "aaa", "CPP");


            //JAVA PROGRAMS
            putData(sqLiteDatabase, "Simple java I/O program.", "import java.util.Scanner;\n" +
                    "\n" +
                    "class calc{\n" +
                    "public static void main(String args[]){\n" +
                    "Scanner comp = new Scanner(system.in);\n" +
                    "double fnum,snum,answer;\n" +
                    "System.out.println(\"enter first num:\");\n" +
                    "fnum=comp.nextDouble();\n" +
                    "System.out.println(\"enter second number:\");\n" +
                    "snum=comp.nextDouble();\n" +
                    "answer=fnum+snum;\n" +
                    "System.out.println(answer);\n" +
                    "}}", "JAVA");
            putData(sqLiteDatabase, "To demonstrate use of constructors.", "import java.util.*;\n" +
                    "import java.io.*;\n" +
                    "class construct\n" +
                    "{\n" +
                    "int a,b,c;\n" +
                    "construct()\n" +
                    "{\n" +
                    "a=0;\n" +
                    "b=0;\n" +
                    "c=0;\n" +
                    "}\n" +
                    "construct(int a,int b,int c)\n" +
                    "{\n" +
                    "this.a=a;\n" +
                    "this.b=b;\n" +
                    "this.c=c;\n" +
                    "}\n" +
                    "void show()\n" +
                    "{\n" +
                    "System.out.println(\"a = \"+a+\"\\nb = \"+b+\"\\nc = \"+c);\n" +
                    "}\n" +
                    "}\n" +
                    "class constructDemo\n" +
                    "{\n" +
                    "public static void main(String args[])\n" +
                    "{\n" +
                    "Scanner scan=new Scanner(System.in);\n" +
                    "construct con1=new construct();\n" +
                    "construct con2=new construct(2,4,6);\n" +
                    "System.out.println(\"Default Constructor\\n\");\n" +
                    "con1.show();\n" +
                    "System.out.println(\"Parameterized Constructor\\n\");\n" +
                    "con2.show();\n" +
                    "}\n" +
                    "}", "JAVA");
            putData(sqLiteDatabase, "Calculate area of circle(Simple java example)", "import java.io.BufferedReader;\n" +
                    "import java.io.IOException;\n" +
                    "import java.io.InputStreamReader;\n" +
                    " \n" +
                    "public class CalculateCircleAreaExample {\n" +
                    " \n" +
                    "        public static void main(String[] args) {\n" +
                    "               \n" +
                    "                int radius = 0;\n" +
                    "                System.out.println(\"Please enter radius of a circle\");\n" +
                    "               \n" +
                    "                try\n" +
                    "                {\n" +
                    "                        //get the radius from console\n" +
                    "                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));\n" +
                    "                        radius = Integer.parseInt(br.readLine());\n" +
                    "                }\n" +
                    "                catch(NumberFormatException ne)\n" +
                    "                {\n" +
                    "                        System.out.println(\"Invalid radius value\" + ne);\n" +
                    "                        System.exit(0);\n" +
                    "                }\n" +
                    "                catch(IOException ioe)\n" +
                    "                {\n" +
                    "                        System.out.println(\"IO Error :\" + ioe);\n" +
                    "                        System.exit(0);\n" +
                    "                }\n" +
                    "               \n" +
                    "                /*\n" +
                    "                 * Area of a circle is\n" +
                    "                 * pi * r * r\n" +
                    "                 * where r is a radius of a circle.\n" +
                    "                 */\n" +
                    "               \n" +
                    "                double area = Math.PI * radius * radius;\n" +
                    "               \n" +
                    "                System.out.println(\"Area of a circle is \" + area);\n" +
                    "        }\n" +
                    "}", "JAVA");
            putData(sqLiteDatabase, "To find largest of 3 numbers.", "import java.util.Scanner;\n" +
                    "class compare\n" +
                    "{\n" +
                    "public static void main(String args[])\n" +
                    "{\n" +
                    "float x,y,z;\n" +
                    "System.out.println(\"enter the three integers\");\n" +
                    "Scanner comp= new Scanner(System.in);\n" +
                    "\n" +
                    "x=comp.nextFloat();\n" +
                    "y=comp.nextFloat();\n" +
                    "z=comp.nextFloat();\n" +
                    "\n" +
                    "if(x>y && x>z)\n" +
                    "System.out.println(\"x is largest\");\n" +
                    "else if(y>x && y>z)\n" +
                    "System.out.println(\"y is largest\");\n" +
                    "else if(z>x && z>y)\n" +
                    "System.out.println(\"z is largest\");\n" +
                    "else\n" +
                    "System.out.println(\"entered numbers are not distinct\");\n" +
                    "}}\n", "JAVA");

            putData(sqLiteDatabase, "To check whether a string is palindrome orr not.", "import java.util.*;\n" +
                    "\n" +
                    "class palindrome\n" +
                    "{\n" +
                    "public static void main(String args[])\n" +
                    "{\n" +
                    "String orignal,reverse=\"\";\n" +
                    "Scanner in=new Scanner(System.in);\n" +
                    "\n" +
                    "System.out.println(\"enter the string to check whether its palindrome\");\n" +
                    "orignal=in.nextLine();\n" +
                    "\n" +
                    "int length=orignal.length();\n" +
                    "\n" +
                    "for(int i=length-1;i>=0;i--)\n" +
                    "reverse=reverse+orignal.charAt(i);\n" +
                    "\n" +
                    "if(orignal.equals(reverse))\n" +
                    "System.out.println(\"entered string is palindrome\");\n" +
                    "else\n" +
                    "System.out.println(\"entered string is not a pallindrome\");\n" +
                    "}}", "JAVA");
            putData(sqLiteDatabase, "To implement nested classes.", "class nested\n" +
                    "{\n" +
                    "int a,b;\n" +
                    "void show()\n" +
                    "{\n" +
                    "a=0;\n" +
                    "b=0;\n" +
                    "System.out.println(\"a = \"+a+\"\\nb = \"+b);\n" +
                    "}\n" +
                    "class nested1 \n" +
                    "{\n" +
                    "public static void main(String args[])\n" +
                    "{\n" +
                    "nested n=new nested();\n" +
                    "n.show();\n" +
                    "} \n" +
                    "}\n" +
                    "}", "JAVA");
            putData(sqLiteDatabase, "To sort given list of name in ascending order with string class.", "import java.util.*;\n" +
                    "import java.io.*;\n" +
                    "\n" +
                    "class sortStrings\n" +
                    "{\n" +
                    "public static void main(String args[])\n" +
                    "{\n" +
                    "System.out.println(\"Enter the number of names to sort : \");\n" +
                    "Scanner scan=new Scanner(System.in);\n" +
                    "int num;\n" +
                    "num=scan.nextInt();\n" +
                    "String names[]=new String[num];\n" +
                    "for(int i=1;i<=num;i++)\n" +
                    "{\n" +
                    "System.out.println(\"enter name \"+i+\" : \");\n" +
                    "names[i-1]=scan.next();\n" +
                    "}\n" +
                    "for(int i=0;i<names.length;i++)\n" +
                    "{\n" +
                    "for(int j=i+1;j<names.length;j++)\n" +
                    "{\n" +
                    "if(names[j].compareTo(names[i])<0)\n" +
                    "{\n" +
                    "String t=names[i];\n" +
                    "names[i]=names[j];\n" +
                    "names[j]=t;\n" +
                    "}\n" +
                    "}\n" +
                    "}\n" +
                    "System.out.print(\"\\n\");\n" +
                    "for(int i=0;i<names.length;i++)\n" +
                    "{\n" +
                    "System.out.print(names[i]+\" \");\n" +
                    "}\n" +
                    "}\n" +
                    "}", "JAVA");
            putData(sqLiteDatabase, "To demonstrate use of static and final keywords.", "import java.util.*;\n" +
                    "import java.io.*;\n" +
                    "\n" +
                    "class finalStatic\n" +
                    "{\n" +
                    "static double ar;\n" +
                    "static final double pi=3.14;\n" +
                    "static void area(double r)\n" +
                    "{\n" +
                    "ar=pi*r*r;\n" +
                    "}\n" +
                    "static void show()\n" +
                    "{\n" +
                    "System.out.println(\"Area: \"+ar);\n" +
                    "}\n" +
                    "}\n" +
                    "\n" +
                    "class finalStaticDemo\n" +
                    "{\n" +
                    "public static void main(String args[])\n" +
                    "{\n" +
                    "double r;\n" +
                    "finalStatic fs=new finalStatic();\n" +
                    "Scanner scan=new Scanner(System.in);\n" +
                    "System.out.println(\"enter the radius: \");\n" +
                    "r=scan.nextInt();\n" +
                    "fs.area(r);\n" +
                    "fs.show();\n" +
                    "}\n" +
                    "}", "JAVA");

            putData(sqLiteDatabase, "To swap 2 numbers.", "import java.util.*;\n" +
                    "import java.io.*;\n" +
                    "\n" +
                    "class Swapper\n" +
                    "{\n" +
                    "int x;\n" +
                    "int y;\n" +
                    "Swapper(int a,int b)\n" +
                    "{\n" +
                    "x=a;\n" +
                    "y=b;\n" +
                    "}\n" +
                    "void  getx()\n" +
                    "{\n" +
                    "\tSystem.out.println(\"Value of x:\"+x);\n" +
                    "}\n" +
                    "void gety()\n" +
                    "{\n" +
                    "\tSystem.out.println(\"Value of y:\"+y);\n" +
                    "}\n" +
                    "void swap()\n" +
                    "{\n" +
                    "int temp;\n" +
                    "temp=x;\n" +
                    "x=y;\n" +
                    "y=temp;\n" +
                    "}\n" +
                    "}\n" +
                    "class SwapperDemo\n" +
                    "{\n" +
                    "public static void main(String args[])\n" +
                    "{\tint a,b;\n" +
                    "\tScanner scan=new Scanner(System.in);\n" +
                    "\tSystem.out.println(\"Enter the first number\");\n" +
                    "\ta=scan.nextInt();\n" +
                    "\tSystem.out.println(\"Enter the Second Number\");\n" +
                    "\tb=scan.nextInt();\n" +
                    "\tSwapper swapVar=new Swapper(a,b);\n" +
                    "\tswapVar.swap();\n" +
                    "\tswapVar.getx();\n" +
                    "\tswapVar.gety();\n" +
                    "\t\n" +
                    "}\n" +
                    "}", "JAVA");
            putData(sqLiteDatabase, "To write an applet that displays a simple message.", "import java.applet.*;\n" +
                    "import java.awt.*;\n" +
                    "\n" +
                    "/*\n" +
                    "<applet code=\"Simplemsg.class\" width=300 \n" +
                    "height=80>\n" +
                    "\n" +
                    "</applet>\n" +
                    "*/\n" +
                    "public class Simplemsg extends Applet\n" +
                    "{\n" +
                    "String msg;\n" +
                    "public void init()\n" +
                    "{\n" +
                    "msg=\"Simple\";\n" +
                    "}\n" +
                    "public void start()\n" +
                    "{\n" +
                    "msg+=\" Java\";\n" +
                    "}\n" +
                    "public void paint(Graphics g)\n" +
                    "{\n" +
                    "msg+=\" Program\";\n" +
                    "g.drawString(msg,10,30);\n" +
                    "}\n" +
                    "} ", "JAVA");
            putData(sqLiteDatabase, "To implement abstract classes.", "import java.util.*;\n" +
                    "import java.io.*;\n" +
                    "\n" +
                    "abstract class Shape\n" +
                    "{\n" +
                    "abstract int numberOfSides();\n" +
                    "}\n" +
                    "\n" +
                    "class trapezoid extends Shape\n" +
                    "{ \n" +
                    "int numberOfSides()\n" +
                    "{\n" +
                    "System.out.print(\"\\nTrapezoid : \");\n" +
                    "return 4;\n" +
                    "}\n" +
                    "}\n" +
                    "class triangle extends Shape\n" +
                    "{\n" +
                    "int numberOfSides()\n" +
                    "{\n" +
                    "System.out.print(\"\\nTriangle : \");\n" +
                    "return 3;\n" +
                    "}\n" +
                    "}\n" +
                    "class rectangle extends Shape\n" +
                    "{\n" +
                    "int numberOfSides()\n" +
                    "{\n" +
                    "System.out.print(\"\\nRectangle : \");\n" +
                    "return 4;\n" +
                    "}\n" +
                    "}\n" +
                    "\n" +
                    " class ShapeDemo\n" +
                    "{\n" +
                    "public static void main(String args[])\n" +
                    "{\n" +
                    "Shape[] s=new Shape[3];\n" +
                    "trapezoid t=new trapezoid();\n" +
                    "triangle tr=new triangle();\n" +
                    "rectangle r=new rectangle();\n" +
                    "s[0]=t;\n" +
                    "s[1]=tr;\n" +
                    "s[2]=r;\n" +
                    "for(int i=0;i<s.length;i++)\n" +
                    "{\n" +
                    "System.out.print(s[i].numberOfSides()+\"\\n\");\n" +
                    "}\n" +
                    "}\n" +
                    "}", "JAVA");
            putData(sqLiteDatabase, "To implement interfaces.", "import java.util.*;\n" +
                    "import java.io.*;\n" +
                    "\n" +
                    "interface areaInterface\n" +
                    "{\n" +
                    "void area();\n" +
                    "}\n" +
                    "\n" +
                    "class rect implements areaInterface\n" +
                    "{\n" +
                    "int a,b,ar;\n" +
                    "public void area()\n" +
                    "{\n" +
                    "Scanner scan=new Scanner(System.in);\n" +
                    "System.out.println(\"Enter the length: \");\n" +
                    "a=scan.nextInt();\n" +
                    "System.out.println(\"Enter the breadth: \");\n" +
                    "b=scan.nextInt();\n" +
                    "ar=a*b;\n" +
                    "System.out.println(\"Area :\"+ar);\n" +
                    "}\n" +
                    "}\n" +
                    "\n" +
                    "class circl implements areaInterface\n" +
                    "{\n" +
                    "double r,ar;\n" +
                    "public void area()\n" +
                    "{\n" +
                    "Scanner scan=new Scanner(System.in);\n" +
                    "System.out.println(\"Enter the radius: \");\n" +
                    "r=scan.nextInt();\n" +
                    "ar=3.14*r*r;\n" +
                    "System.out.println(\"Area :\"+ar);\n" +
                    "}\n" +
                    "}\n" +
                    "\n" +
                    "class sphere implements areaInterface\n" +
                    "{\n" +
                    "double r,ar;\n" +
                    "public void area()\n" +
                    "{\n" +
                    "Scanner scan=new Scanner(System.in);\n" +
                    "System.out.println(\"Enter the radius: \");\n" +
                    "r=scan.nextInt();\n" +
                    "ar=4*3.14*r*r;\n" +
                    "System.out.println(\"Area :\"+ar);\n" +
                    "}\n" +
                    "}\n" +
                    "\n" +
                    "class areaDemo \n" +
                    "{\n" +
                    "public static void main(String args[])\n" +
                    "{\n" +
                    "System.out.println(\"---MENU---\");\n" +
                    "System.out.println(\"1.Rectangle\");\n" +
                    "System.out.println(\"2.Circle \");\n" +
                    "System.out.println(\"3.Sphere\");\n" +
                    "Scanner scan=new Scanner(System.in);\n" +
                    "int ch;\n" +
                    "ch=scan.nextInt();\n" +
                    "switch(ch)\n" +
                    "{\n" +
                    "case 1: rect r=new rect();\n" +
                    "\tr.area();\n" +
                    "break;\n" +
                    "case 2: circl c=new circl();\n" +
                    "\tc.area();\n" +
                    "break;\n" +
                    "case 3: sphere s=new sphere();\n" +
                    "\ts.area();\n" +
                    "break;\n" +
                    "}\n" +
                    "}\n" +
                    "}", "JAVA");

            putData(sqLiteDatabase, "To implement Producer-Consumer problem using the concept of Inter Thread Communication.", "import java.io.*;\n" +
                    "import java.util.*;\n" +
                    "\n" +
                    "class prodConsum\n" +
                    "{\n" +
                    "\tint n;\n" +
                    "\tboolean isValueSet=false;\n" +
                    "\tsynchronized int get()\n" +
                    "\t{\n" +
                    "\t\twhile(!isValueSet)\n" +
                    "\t\t{\n" +
                    "\t\t\ttry\n" +
                    "\t\t\t{\n" +
                    "\t\t\t\twait();\n" +
                    "\t\t\t}\n" +
                    "\t\t\tcatch(InterruptedException ie)\n" +
                    "\t\t\t{\n" +
                    "\t\t\t\tSystem.out.println(\"Interrupted Exception Generated\");\n" +
                    "\t\t\t}\n" +
                    "\t\t\t\n" +
                    "\t\t}\n" +
                    "\t\tSystem.out.println(\"Got: \"+n);\n" +
                    "\t\tisValueSet=false;\n" +
                    "\t\tnotify();\n" +
                    "\t\treturn n;\n" +
                    "\t}\n" +
                    "\tsynchronized void put(int n)\n" +
                    "\t{\n" +
                    "\t\twhile(isValueSet)\n" +
                    "\t\t{\n" +
                    "\t\t\ttry\n" +
                    "\t\t\t{\n" +
                    "\t\t\t\twait();\n" +
                    "\t\t\t}\n" +
                    "\t\t\tcatch(InterruptedException ie)\n" +
                    "\t\t\t{\n" +
                    "\t\t\t\tSystem.out.println(\"Interrupted Exception Generated\");\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "\t\tSystem.out.println(\"Put: \"+n);\n" +
                    "\t\tisValueSet=true;\n" +
                    "\t\tthis.n=n;\n" +
                    "\t\tnotify();\n" +
                    "\t}\n" +
                    "\n" +
                    "}\n" +
                    "class producer implements Runnable\n" +
                    "{\n" +
                    "\tprodConsum pc;\n" +
                    "\tint i=1;\n" +
                    "\tproducer(prodConsum pc)\n" +
                    "\t{\n" +
                    "\t\tthis.pc=pc;\n" +
                    "\t\tnew Thread(this,\"Producer\").start();\n" +
                    "\t}\n" +
                    "\tpublic void run()\n" +
                    "\t{\n" +
                    "\t\twhile(true)\n" +
                    "\t\t{\n" +
                    "\t\t\tpc.put(i++);\n" +
                    "\t\t}\n" +
                    "\t}\n" +
                    "\t\t\n" +
                    "}\n" +
                    "class consumer implements Runnable\n" +
                    "{\n" +
                    "\tprodConsum pc;\n" +
                    "\tconsumer(prodConsum pc)\n" +
                    "\t{\n" +
                    "\t\tthis.pc=pc;\n" +
                    "\t\tnew Thread(this,\"Consumer\").start();\n" +
                    "\t}\n" +
                    "\tpublic void run()\n" +
                    "\t{\n" +
                    "\t\twhile(true)\n" +
                    "\t\t{\n" +
                    "\t\t\tpc.get();\n" +
                    "\t\t}\n" +
                    "\t}\n" +
                    "}\n" +
                    "class PCDemo \n" +
                    "{\n" +
                    "\tpublic static void main(String args[])\n" +
                    "\t{\n" +
                    "\t\tprodConsum pc;\n" +
                    "\t\tpc=new prodConsum();\n" +
                    "\t\tnew producer(pc);\n" +
                    "\t\tnew consumer(pc);\n" +
                    "\t\tSystem.out.println(\"Press Control-C to Stop\");\n" +
                    "\t}\n" +
                    "}", "JAVA");
            putData(sqLiteDatabase, "To implement a GUI based calculator application.", "import java.awt.*;\n" +
                    "import java.awt.event.*;\n" +
                    "import java.util.*;\n" +
                    "import java.io.*;\n" +
                    "import java.applet.*;\n" +
                    "\n" +
                    "class calculator implements ActionListener\n" +
                    "{\t\n" +
                    "\tFrame f;\n" +
                    "\tString msg;\n" +
                    "\tButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;\n" +
                    "\tButton btnMultiply,btnPlus,btnDivide,btnMinus,btnEqual,btnClear;\n" +
                    "\tLabel lbl;\n" +
                    "\tdouble a,b,result;\n" +
                    "\tint operator;\n" +
                    "\tcalculator()\n" +
                    "\t{\n" +
                    "\t\tf=new Frame();\n" +
                    "\t\tPanel p1=new Panel();\n" +
                    "\t\tPanel p2=new Panel();\n" +
                    "\t\tlbl=new Label(\"0\",Label.LEFT);\n" +
                    "\t\tp1.add(lbl);\n" +
                    "\t\tp1.setLayout(new FlowLayout());\n" +
                    "\t\tp1.setSize(new Dimension(350,100));\n" +
                    "\t\tp2.setLayout(new GridLayout(5,4));\n" +
                    "\t\tbtn1=new Button(\"1\");\n" +
                    "\t\tbtn2=new Button(\"2\");\n" +
                    "\t\tbtn3=new Button(\"3\");\n" +
                    "\t\tbtn4=new Button(\"4\");\n" +
                    "\t\tbtn5=new Button(\"5\");\n" +
                    "\t\tbtn6=new Button(\"6\");\n" +
                    "\t\tbtn7=new Button(\"7\");\n" +
                    "\t\tbtn8=new Button(\"8\");\n" +
                    "\t\tbtn9=new Button(\"9\");\n" +
                    "\t\tbtn0=new Button(\"0\");\n" +
                    "\t\tbtnMultiply=new Button(\"X\");\n" +
                    "\t\tbtnDivide=new Button(\"/\");\n" +
                    "\t\tbtnPlus=new Button(\"+\");\n" +
                    "\t\tbtnMinus=new Button(\"-\");\n" +
                    "\t\tbtnClear=new Button(\"AC\");\n" +
                    "\t\tbtnEqual=new Button(\"=\");\n" +
                    "\t\tp2.add(btnClear);\n" +
                    "\t\tp2.add(btnDivide);\n" +
                    "\t\tp2.add(btnMultiply);\n" +
                    "\t\tp2.add(btnPlus);\n" +
                    "\t\tp2.add(btn7);\n" +
                    "\t\tp2.add(btn8);\n" +
                    "\t\tp2.add(btn9);\n" +
                    "\t\tp2.add(btnMinus);\n" +
                    "\t\tp2.add(btn4);\n" +
                    "\t\tp2.add(btn5);\n" +
                    "\t\tp2.add(btn6);\n" +
                    "\t\tp2.add(btnEqual);\n" +
                    "\t\tp2.add(btn1);\n" +
                    "\t\tp2.add(btn2);\n" +
                    "\t\tp2.add(btn3);\n" +
                    "\t\tp2.add(btn0);\n" +
                    "\t\tbtnClear.addActionListener(this);\n" +
                    "\t\tbtnDivide.addActionListener(this);\n" +
                    "\t\tbtnMultiply.addActionListener(this);\n" +
                    "\t\tbtnPlus.addActionListener(this);\n" +
                    "\t\tbtn7.addActionListener(this);\n" +
                    "\t\tbtn8.addActionListener(this);\n" +
                    "\t\tbtn9.addActionListener(this);\n" +
                    "\t\tbtnMinus.addActionListener(this);\n" +
                    "\t\tbtn4.addActionListener(this);\n" +
                    "\t\tbtn5.addActionListener(this);\n" +
                    "\t\tbtn6.addActionListener(this);\n" +
                    "\t\tbtnEqual.addActionListener(this);\n" +
                    "\t\tbtn1.addActionListener(this);\n" +
                    "\t\tbtn2.addActionListener(this);\n" +
                    "\t\tbtn3.addActionListener(this);\n" +
                    "\t\tbtn0.addActionListener(this);\n" +
                    "\t\tf.add(\"North\",p1);\n" +
                    "\t\tf.add(p2);\n" +
                    "\t\tf.setSize(new Dimension(350,500));\n" +
                    "\t\tf.addWindowListener(new MyWindowAdapter());\n" +
                    "\t\tf.setTitle(\"Calculator\");\n" +
                    "\t\t\tf.setVisible(true);\n" +
                    "\t}\n" +
                    "\tpublic void actionPerformed(ActionEvent ae)\n" +
                    "\t{\t\n" +
                    "\t\tif(ae.getActionCommand().equals(\"AC\"))\n" +
                    "\t\t{\n" +
                    "\t\t\tlbl.setText(\"0\");\n" +
                    "\t\t\toperator=0;\n" +
                    "\t\t}\n" +
                    "\t\telse if(ae.getSource()==btnPlus)\n" +
                    "        \t{\n" +
                    "            \t\ta=Double.parseDouble(lbl.getText());\n" +
                    "            \t\toperator=1;\n" +
                    "            \t\tlbl.setText(\"0\");\n" +
                    "        \t} \n" +
                    "        \telse if(ae.getSource()==btnMinus)\n" +
                    "        \t{\n" +
                    "            \t\ta=Double.parseDouble(lbl.getText());\n" +
                    "            \t\toperator=2;\n" +
                    "            \t\tlbl.setText(\"0\");\n" +
                    "        \t}\n" +
                    "        \telse if(ae.getSource()==btnMultiply)\n" +
                    "        \t{\n" +
                    "            \t\ta=Double.parseDouble(lbl.getText());\n" +
                    "            \t\toperator=3;\n" +
                    "         \t\tlbl.setText(\"0\");\n" +
                    "        \t}\n" +
                    "        \n" +
                    "        \telse if(ae.getSource()==btnDivide)\n" +
                    "        \t{\n" +
                    "            \t\ta=Double.parseDouble(lbl.getText());\n" +
                    "            \t\toperator=4;\n" +
                    "            \t\tlbl.setText(\"0\");\n" +
                    "        \t}\n" +
                    "        \n" +
                    "       \t \telse if(ae.getSource()==btnEqual)\n" +
                    "        \t{\n" +
                    "            \t\tb=Double.parseDouble(lbl.getText());\n" +
                    "        \n" +
                    "            \t\tswitch(operator)\n" +
                    "            \t\t{\n" +
                    "                \t\tcase 1: result=a+b;\n" +
                    "       \t\t             \tbreak;\n" +
                    "        \n" +
                    "        \t\t        case 2: result=a-b;\n" +
                    "                    \t\tbreak;\n" +
                    "        \n" +
                    "        \t\t        case 3: result=a*b;\n" +
                    "                    \t\tbreak;\n" +
                    "        \n" +
                    "         \t\t       \tcase 4: result=a/b;\n" +
                    "                    \t\tbreak;\n" +
                    "        \n" +
                    "                \t\tdefault: result=0;\n" +
                    "        \t    \t}\n" +
                    "        \n" +
                    "         \t\tlbl.setText(\"\"+result);\n" +
                    "        \t}\n" +
                    "\t\telse\n" +
                    "\t\t{\t\n" +
                    "\t\t\tlbl.setText(lbl.getText()+ae.getActionCommand());\n" +
                    "\t\t}\n" +
                    "\t}\n" +
                    "\tpublic static void main(String args[])\n" +
                    "\t{\n" +
                    "\t\tnew calculator();\n" +
                    "\t\t\n" +
                    "\t}\n" +
                    "\t\n" +
                    "} \t\n" +
                    "class MyWindowAdapter extends WindowAdapter\n" +
                    "{\n" +
                    "\tpublic void windowClosing(WindowEvent we)\n" +
                    "\t{\n" +
                    "\t\tSystem.exit(0);\t\n" +
                    "\t}\n" +
                    "}\n", "JAVA");
                putData(sqLiteDatabase, "To implement Task Scheduling problem", "#include<conio.h>\n" +
                        "#include<iostream.h>\n" +
                        "#include<time.h>\n" +
                        "#include<stdlib.h>\n" +
                        "#include<dos.h>\n" +
                        "\n" +
                        "struct task\n" +
                        "{\n" +
                        " int no,p,d;\n" +
                        "};\n" +
                        "\n" +
                        "void sort(task M[],int n)\n" +
                        "{\n" +
                        "\n" +
                        " int i,j;\n" +
                        " task temp;\n" +
                        " for(i=1;i<=n;i++)\n" +
                        " {\n" +
                        "  for(j=i+1;j<=n;j++)\n" +
                        "  {\n" +
                        "   if(M[i].p<M[j].p)\n" +
                        "   {\n" +
                        "    temp=M[i];\n" +
                        "    M[i]=M[j];\n" +
                        "    M[j]=temp;\n" +
                        "   }\n" +
                        "  }\n" +
                        " }\n" +
                        "}\n" +
                        "\n" +
                        "void taskscheduling(task A[],int n)\n" +
                        "{\n" +
                        " int slot[20],result[20],extra[20];\n" +
                        " int i,j,penalty=0,flag=0,x=0,y=0,z=0;\n" +
                        " for(i=1;i<=n;i++)\n" +
                        " slot[i]=-1;\n" +
                        " for(i=1;i<=n;i++)\n" +
                        " {\n" +
                        "  if(slot[A[i].d]==-1)\n" +
                        "  {\n" +
                        "   slot[A[i].d]=1;\n" +
                        "   result[++x]=A[i].no;\n" +
                        "  }\n" +
                        "  else\n" +
                        "  {\n" +
                        "   z=A[i].d;\n" +
                        "   flag=1;\n" +
                        "   while(z>0)\n" +
                        "   {\n" +
                        "    if(slot[z]==-1)\n" +
                        "    {\n" +
                        "     flag=0;\n" +
                        "     slot[z]=1;\n" +
                        "     result[++x]=A[i].no;\n" +
                        "     break;\n" +
                        "    }\n" +
                        "    z--;\n" +
                        "   }\n" +
                        "   if(flag==1)\n" +
                        "   {\n" +
                        "    extra[++y]=A[i].no;\n" +
                        "    penalty+=A[i].p;\n" +
                        "   }\n" +
                        "  }\n" +
                        " }\n" +
                        " for(i=1;i<=x;i++)\n" +
                        " {\n" +
                        "  for(j=i+1;j<=x;j++)\n" +
                        "  {\n" +
                        "   if(A[result[i]].d>A[result[j]].d)\n" +
                        "   {\n" +
                        "    int temp=result[i];\n" +
                        "    result[i]=result[j];\n" +
                        "    result[j]=temp;\n" +
                        "   }\n" +
                        "  }\n" +
                        " }\n" +
                        " cout<<\"\\n Scheduled tasks are : \\n\";\n" +
                        " for(i=1;i<=x;i++)\n" +
                        " cout<<\" A\"<<result[i];\n" +
                        " for(i=1;i<=y;i++)\n" +
                        " cout<<\" A\"<<extra[i];\n" +
                        " cout<<\"\\n Total penalty : \"<<penalty;\n" +
                        "}\n" +
                        "\n" +
                        "void main()\n" +
                        "{\n" +
                        " clrscr();\n" +
                        " clock_t end,start;\n" +
                        " float time;\n" +
                        " int i,B[20],n;\n" +
                        " task A[20];\n" +
                        " cout<<\"\\n Enter number of tasks : \";\n" +
                        " cin>>n;\n" +
                        " cout<<\"\\n Enter deadlines : \";\n" +
                        " for(i=1;i<=n;i++)\n" +
                        " cin>>A[i].d;\n" +
                        " cout<<\"\\n Enter penalties : \";\n" +
                        " for(i=1;i<=n;i++)\n" +
                        " cin>>A[i].p;\n" +
                        " for(i=1;i<=n;i++)\n" +
                        " A[i].no=i;\n" +
                        " start=clock();\n" +
                        " delay(100);\n" +
                        " sort(A,n);\n" +
                        " taskscheduling(A,n);\n" +
                        " end=clock();\n" +
                        " time=(end-start)/CLK_TCK;\n" +
                        " cout<<\"\\n\\n Time taken : \"<<time;\n" +
                        " getch();\n" +
                        "}", "ADA");

                putData(sqLiteDatabase, "To implement naive string matching", "#include<conio.h>\n" +
                        "#include<iostream.h>\n" +
                        "#include<time.h>\n" +
                        "#include<dos.h>\n" +
                        "#include<stdio.h>\n" +
                        "\n" +
                        "void naivestring(char T[],char P[],int m,int n)\n" +
                        "{\n" +
                        " for(int s=0;s<=(n-m);s++)\n" +
                        " {\n" +
                        "  for(int i=1;i<m;i++)\n" +
                        "  {\n" +
                        "   if(T[s+i]!=P[i])\n" +
                        "   {\n" +
                        "    break;\n" +
                        "   }\n" +
                        "  }\n" +
                        "  if(i==m)\n" +
                        "  cout<<\"\\n Pattern occurs with shift : \"<<s;\n" +
                        " }\n" +
                        "}\n" +
                        "\n" +
                        "void main()\n" +
                        "{\n" +
                        " clrscr();\n" +
                        " clock_t end,start;\n" +
                        " float time;\n" +
                        " int m,n;\n" +
                        " char P[10],T[20];\n" +
                        " cout<<\"\\n Enter length of text : \";\n" +
                        " cin>>n;\n" +
                        " cout<<\"\\n Enter text : \" ;\n" +
                        " for(int i=1;i<=n;i++)\n" +
                        " cin>>T[i];\n" +
                        " cout<<\"\\n Enter length of pattern : \";\n" +
                        " cin>>m;\n" +
                        " cout<<\"\\n Enter pattern : \" ;\n" +
                        " for(i=1;i<=m;i++)\n" +
                        " cin>>P[i];\n" +
                        " start=clock();\n" +
                        " delay(100);\n" +
                        " naivestring(T,P,m,n);\n" +
                        " end=clock();\n" +
                        " time=(end-start)/CLK_TCK;\n" +
                        " cout<<\"\\n\\n Time taken : \"<<time;\n" +
                        " getch();\n" +
                        "}\n" +
                        "\n", "ADA");
                putData(sqLiteDatabase, "To implement Rabin-Karp string matching", "#include<conio.h>\n" +
                        "#include<iostream.h>\n" +
                        "#include<time.h>\n" +
                        "#include<dos.h>\n" +
                        "#include<stdio.h>\n" +
                        "#include<math.h>\n" +
                        "#include<string.h>\n" +
                        "\n" +
                        "void rabinkarp(char T[],char P[],int d,int q)\n" +
                        "{\n" +
                        " int h=1,i,n,m;\n" +
                        " n=strlen(T);\n" +
                        " m=strlen(P);\n" +
                        " for(i=0;i<m-1;i++)\n" +
                        " h=(d*h)%q;\n" +
                        " int p=0,t=0;\n" +
                        " for(i=0;i<m;i++)\n" +
                        " {\n" +
                        "  p=(d*p+P[i])%q;\n" +
                        "  t=(d*t+T[i])%q;\n" +
                        " }\n" +
                        "\n" +
                        " for(int s=0;s<=(n-m);s++)\n" +
                        " {\n" +
                        "  if(t==p)\n" +
                        "  {\n" +
                        "   for(i=0;i<m;i++)\n" +
                        "   {\n" +
                        "    if(T[s+i]!=P[i])\n" +
                        "    {\n" +
                        "     break;\n" +
                        "    }\n" +
                        "   }\n" +
                        "   if(i==m)\n" +
                        "   cout<<\"\\n Pattern occurs with shift : \"<<s;\n" +
                        "  }\n" +
                        "  if(s<(n-m))\n" +
                        "  {\n" +
                        "   t=(d*(t-T[s]*h)+T[s+m])%q;\n" +
                        "   if(t<0)\n" +
                        "   t=t+q;\n" +
                        "  }\n" +
                        " }\n" +
                        "}\n" +
                        "\n" +
                        "void main()\n" +
                        "{\n" +
                        " clrscr();\n" +
                        " clock_t end,start;\n" +
                        " float time;\n" +
                        " int m,n,q,d;\n" +
                        " char P[10],T[20];\n" +
                        " cout<<\"\\n Enter text : \" ;\n" +
                        " gets(T);\n" +
                        " cout<<\"\\n Enter pattern : \" ;\n" +
                        " gets(P);\n" +
                        " cout<<\"\\n Enter the values of q and d : \";\n" +
                        " cin>>q>>d;\n" +
                        " start=clock();\n" +
                        " delay(100);\n" +
                        " rabinkarp(T,P,d,q);\n" +
                        " end=clock();\n" +
                        " time=(end-start)/CLK_TCK;\n" +
                        " cout<<\"\\n\\n Time taken : \"<<time;\n" +
                        " getch();\n" +
                        "}\n" +
                        "\n", "ADA");
                putData(sqLiteDatabase, "To implement KMP string matching", "#include<conio.h>\n" +
                        "#include<iostream.h>\n" +
                        "#include<time.h>\n" +
                        "#include<dos.h>\n" +
                        "#include<stdio.h>\n" +
                        "#include<math.h>\n" +
                        "#include<string.h>\n" +
                        "\n" +
                        "void comp_prefix(int P[],int m,int pi[])\n" +
                        "{\n" +
                        " pi[1]=0;\n" +
                        " int k=0;\n" +
                        " for(int q=2;q<=m;q++)\n" +
                        " {\n" +
                        "  while((k>0)&&(P[k+1]!=P[q]))\n" +
                        "  k=pi[k];\n" +
                        "  if(P[k+1]==P[q])\n" +
                        "  k=k+1;\n" +
                        "  pi[q]=k;\n" +
                        " }\n" +
                        "}\n" +
                        "\n" +
                        "void kmp(char T[],char P[],int n,int m,int pi[])\n" +
                        "{\n" +
                        " int q=0;\n" +
                        " for(int i=1;i<=n;i++)\n" +
                        " {\n" +
                        "  while((q>0)&&(P[q+1]!=T[i]))\n" +
                        "  q=pi[q];\n" +
                        "  if(P[q+1]==T[i])\n" +
                        "  q++;\n" +
                        "  if(q==m)\n" +
                        "  {\n" +
                        "   cout<<\"\\n Pattern occurs with shift : \"<<i-m;\n" +
                        "   q=pi[q];\n" +
                        "  }\n" +
                        " }\n" +
                        "}\n" +
                        "\n" +
                        "void main()\n" +
                        "{\n" +
                        " clrscr();\n" +
                        " clock_t end,start;\n" +
                        " float time;\n" +
                        " int m,n;\n" +
                        " char P[10],T[20];\n" +
                        " int pi[10];\n" +
                        " cout<<\"\\n Enter length of text : \";\n" +
                        " cin>>n;\n" +
                        " cout<<\"\\n Enter text : \" ;\n" +
                        " for(int i=1;i<=n;i++)\n" +
                        " cin>>T[i];\n" +
                        " cout<<\"\\n Enter length of pattern : \";\n" +
                        " cin>>m;\n" +
                        " cout<<\"\\n Enter pattern : \" ;\n" +
                        " for(i=1;i<=m;i++)\n" +
                        " cin>>P[i];\n" +
                        " start=clock();\n" +
                        " delay(100);\n" +
                        " kmp(T,P,n,m,pi);\n" +
                        " end=clock();\n" +
                        " time=(end-start)/CLK_TCK;\n" +
                        " cout<<\"\\n\\n Time taken : \"<<time;\n" +
                        " getch();\n" +
                        "}\n" +
                        "\n", "ADA");
                //putData(sqLiteDatabase, "aaa", "aaa", "ADA");


            return null;
        }
    }

}
