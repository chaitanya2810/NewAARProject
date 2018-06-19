package com.example.loginlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText user,password;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        user = (EditText)findViewById(R.id.usernameText);
        password = (EditText)findViewById(R.id.passwordText);
        signin = (Button)findViewById(R.id.signInButton);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = user.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(userName.equals("root") && pass.equals("root")){
                    //    Toast.makeText(getApplicationContext(),"Successfull", Toast.LENGTH_SHORT).show();
                    Intent data = new Intent();
                    String text = "Correct";
                    //data.setData(Uri.parse(text));
                    data.putExtra("Message",text);
                    setResult(100, data);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Un-Successfull attempt", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
