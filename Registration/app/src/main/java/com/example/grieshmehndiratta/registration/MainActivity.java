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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText=findViewById(R.id.editText);
                String Name;
                Name=String.valueOf(editText.getText());

                EditText editText1=findViewById(R.id.editText3);
                String Uni_Name;
                Uni_Name=String.valueOf(editText1.getText());

                EditText editText2=findViewById(R.id.editText6);
                int Year;
                Year=Integer.parseInt(editText2.getText().toString());

                EditText editText3=findViewById(R.id.editText4);
                String Password;
                Password=String.valueOf(editText3.getText());

                EditText editText4=findViewById(R.id.editText7);
                String RPassword;
                RPassword=String.valueOf(editText4.getText());


                if((Name.equals(null)||Name.equals(""))||(Uni_Name.equals(null)||Uni_Name.equals("")))
                {
                    Toast.makeText( MainActivity.this, "Invalid Username Or University Name",Toast.LENGTH_SHORT).show();
                }
                else if(Year<1000||Year>2018)
                {
                    Toast.makeText( MainActivity.this,  "Enter Valid Year",Toast.LENGTH_SHORT).show();
                }

                else if(Password.equals(null)||Password.equals(""))
                {
                    Toast.makeText( MainActivity.this, "No Password",Toast.LENGTH_SHORT).show();
                }

                else if(!Password.equals(RPassword))
                {
                    Toast.makeText( MainActivity.this, "Password Not Same",Toast.LENGTH_SHORT).show();
                }

                else
                {

                    Toast.makeText( MainActivity.this, "Registered Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent( MainActivity.this,Login.class);
                    intent.putExtra("Name",Name);
                    intent.putExtra("Password",Password);

                    SharedPreferences sharedPreferences=getSharedPreferences("com.example.grieshmehndiratta.registration", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("Name",Name);
                    editor.putString("Password",Password);

                    editor.apply();

                    startActivity(intent);
                }
            }
        });

        Button button1 =findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( MainActivity.this,Login.class);
                startActivity(intent);
            }
        });

    }
}
