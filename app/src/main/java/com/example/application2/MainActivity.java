package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     String authority = "com.example.application1";
     Uri content_uri = Uri.parse("content://"+authority+"/emp");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void load_data(View view){
        Cursor cr = getContentResolver().query(content_uri , null,null,null,"_id");
        StringBuilder stringBuilder = new StringBuilder();
        while(cr.moveToNext()){
            int id = cr.getInt(0);
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            stringBuilder.append(id+" "+s1+" "+s2+"\n");
        }
        Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
    }
}