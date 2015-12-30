package com.gurpreetsingh.codeit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /**
         * CodeIt is a simple android app created to help CS/IT students with basic programs and concepts.
         It uses a SQLite database to store questions and code for three(3) different languages and basic algorithms implemented in C.
         The app features a clean UI with options to share the content with friends via email, bluetooth, etc.

         It requires no special permissions from the user.

         NOTE: The app is a test application to understand basics of android and the content is reliable to best of my knowledge.
         Any feedback is welcome.
         */

        //Thread for splash screen
        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(1000);
                }catch(Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(MainActivity.this,ChooseLangActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}
