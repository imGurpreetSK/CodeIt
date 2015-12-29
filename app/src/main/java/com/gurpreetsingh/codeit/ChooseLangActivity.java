package com.gurpreetsingh.codeit;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ShareActionProvider;


public class ChooseLangActivity extends Activity {

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_lang);
        LinearLayout ll = (LinearLayout)findViewById(R.id.LLayoutMain);
        ll.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

    public void showCProgList(View view){
        Intent intent = new Intent(ChooseLangActivity.this, CProgList.class);
        startActivity(intent);
    }

    public void showCppProgList(View view){
        Intent intent = new Intent(ChooseLangActivity.this, CppProgList.class);
        startActivity(intent);
    }

    public void showJavaProgList(View view){
        Intent intent = new Intent(ChooseLangActivity.this, JavaProgList.class);
        startActivity(intent);
    }

    public void showAnyProgList(View view){
        Intent intent = new Intent(ChooseLangActivity.this, AdaProgList.class);
        startActivity(intent);
    }

    public void shareWithFriends(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "Get this app for free! Visit Gooogle Play now! [LINK]");
        Intent chooseAlways = Intent.createChooser(intent, "Share via");
        startActivity(chooseAlways);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_lang, menu);
        MenuItem menuItem = menu.findItem(R.id.shareButton);
        shareActionProvider = (ShareActionProvider)menuItem.getActionProvider();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "From ChooseLangActivity");
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
            Intent intent = new Intent(ChooseLangActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
