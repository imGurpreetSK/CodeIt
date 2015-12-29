package com.gurpreetsingh.codeit;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;


public class ShowProg extends Activity {

    SQLiteDatabase db;
    Cursor cursor;

    int id;
    private ShareActionProvider shareActionProvider;
    String question, text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_prog);
        TextView ques = (TextView)findViewById(R.id.QuesTV);
        TextView body = (TextView)findViewById(R.id.BodyTV);
        ScrollView ll = (ScrollView)findViewById(R.id.LLayout);
        ll.setBackgroundColor(Color.parseColor("#FFFFFF"));
        Intent intent = getIntent();
        try {
            id = (Integer) getIntent().getExtras().get("progPosition");
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        try {
            //Create cursor
            SQLiteOpenHelper QuesDatabase = new QuesDatabase(this);
            db = QuesDatabase.getReadableDatabase();
            String language = intent.getStringExtra("Language") ;
            cursor = db.query("QUESTIONS_LIST", new String[]{"QUESTION", "ANSWER", "SUBJECT"}, "SUBJECT = ?", new String[]{language}
                    , null, null, null);
            //Move cursor to required position
            if (cursor.moveToFirst()) {
                cursor.move(id);
                question = cursor.getString(0);
                text = cursor.getString(1);
                ques.setText(question);
                body.setText(text);
            }
            cursor.close();
            db.close();
        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Cannot reach the Database", Toast.LENGTH_SHORT);
            toast.show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_prog, menu);
        MenuItem menuItem = menu.findItem(R.id.shareButton);
        shareActionProvider = (ShareActionProvider)menuItem.getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
//        intent.putExtra(Intent.EXTRA_TEXT, question);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(ShowProg.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
