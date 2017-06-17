package com.user_id;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login,signin;
    EditText e1,e2;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
             SQLiteDatabase db=openOrCreateDatabase("data",MODE_PRIVATE,null);
        db.execSQL("create table if not exists data(Username varchar,Password varchar)");
        e1=(EditText)findViewById(R.id.editTextuser);
        e2=(EditText)findViewById(R.id.editTextpassword);
        signin=(Button)findViewById(R.id.button2);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String str=e1.getText().toString();
                String strpass=e2.getText().toString();
                Toast.makeText(MainActivity.this,str+" "+strpass, Toast.LENGTH_SHORT).show();
                SQLiteDatabase db=openOrCreateDatabase("data",MODE_PRIVATE,null);
                db.execSQL("create table if not exists data(Username varchar,Password varchar)");
                db.execSQL("Insert into data(Username,Password)values('"+str+"','"+strpass+"')");
                Toast.makeText(MainActivity.this,"Successfully inserted", Toast.LENGTH_SHORT).show();
            }
        });
        login=(Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = openOrCreateDatabase("data", MODE_PRIVATE, null);
                db.execSQL("create table if not exists data(Username varchar,Password varchar)");
                Cursor resultSet = db.rawQuery("Select * from data", null);
             //   resultSet.moveToNext();
                while (resultSet.moveToNext()) {

                    flag=0;
                    String username = resultSet.getString(0);
                    String password = resultSet.getString(1);
                    if (username.equals(e1.getText().toString()) && password.equals(e2.getText().toString())) {
                        Intent i = new Intent(MainActivity.this, Second.class);
                        startActivity(i);
                        break;
                    } else {
                        flag=1;
                    }
                }
                if(flag==1) {
                    Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
