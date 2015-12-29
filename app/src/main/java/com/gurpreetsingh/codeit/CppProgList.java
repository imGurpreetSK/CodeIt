package com.gurpreetsingh.codeit;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class CppProgList extends ListActivity {

    private SQLiteDatabase db;
    private SQLiteOpenHelper database;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_c_prog_list);
        ActionBar actionBar = getActionBar();
        if(actionBar!=null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        ListView lv = getListView();
        lv.setBackgroundColor(Color.parseColor("#FFFFFF"));
        try {
            database = new QuesDatabase(this);
/*            Toast t1 = Toast.makeText(this, "database reference created", Toast.LENGTH_SHORT);
            t1.show();  */
            db = database.getReadableDatabase();
/*            Toast t2 = Toast.makeText(this, "Database successfully created", Toast.LENGTH_SHORT);
            t2.show();
*/
            cursor = db.query("QUESTIONS_LIST",
                    new String[]{"_id", "QUESTION", "SUBJECT"},
                    "SUBJECT = ?", new String[]{"CPP"}, null, null, null);

            CursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_2,
                    cursor,
                    new String[]{"QUESTION"},
                    new int[]{android.R.id.text2},
                    0);

//             String[] hello = {"A","B","C","D","E","F","G","H","I","J","K","L","M"};
//             ArrayAdapter<List> listAdapter = new ArrayAdapter<List>(this, android.R.layout.simple_list_item_1, List.ques);

            lv.setAdapter(listAdapter);

        }catch (SQLiteException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(CppProgList.this, ShowProg.class);
        intent.putExtra("progPosition", position);
        intent.putExtra("Language", "CPP");
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar i\f it is present.
        getMenuInflater().inflate(R.menu.menu_c_prog_list, menu);
        MenuItem menuItem = menu.findItem(R.id.shareButton);
        ShareActionProvider shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Share with friends");
        intent.setType("text/*");
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
            Intent intent = new Intent(CppProgList.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
