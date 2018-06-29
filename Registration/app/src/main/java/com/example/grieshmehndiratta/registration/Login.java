package com.example.grieshmehndiratta.registration;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    public static  final  String DEFAULT="N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button1=findViewById(R.id.button2);

        SharedPreferences sharedPreferences=getSharedPreferences("com.example.grieshmehndiratta.registration", Context.MODE_PRIVATE);
        final String Name=sharedPreferences.getString("Name",DEFAULT);
        final String RPassWord=sharedPreferences.getString("Password",DEFAULT);

        if(Name.equals(DEFAULT) ||RPassWord.equals(DEFAULT))
        {
            Toast.makeText(Login.this,"Not FOUND",Toast.LENGTH_SHORT).show();
        }

        else
        {
            EditText editText1=findViewById(R.id.editText2);

            editText1.setText(Name);


            EditText editText3=findViewById(R.id.editText5);

            editText3.setText(RPassWord);

        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=getIntent();
              /*  String Name=intent.getStringExtra("Name");
                String Pass=intent.getStringExtra("Password");*/

                EditText editText1=findViewById(R.id.editText2);
                String Username;
                Username=String.valueOf(editText1.getText());

                EditText editText3=findViewById(R.id.editText5);
                String Password;
                Password=String.valueOf(editText3.getText());


                if(Name.equals(Username)&&RPassWord.equals(Password))
                {
                    Toast.makeText(Login.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText( Login.this ,"Username Or Password Not Match",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
