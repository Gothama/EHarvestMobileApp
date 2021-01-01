package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signin extends AppCompatActivity {
    private Button signIn;
    private EditText username, password;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        signIn = (Button)findViewById(R.id.signin);
        user = new User(this, "", null,1);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInAccount();
            }
        });
    }

    public void signInAccount(){
        String name = username.getText().toString();

        String password1 = password.getText().toString();



        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(password1)){
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
        }

        else{
                /*loadingBar.setTitle("Create Account");
                loadingBar.setMessage("Please Wait we are processing");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();*/

            try{
                user.setPassword(password1);

                user.setUsername(name);

                int k = user.login();
                if(k == 1){
                   Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signin.this , Dashboard.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "Unsuccessfully", Toast.LENGTH_SHORT).show();
                }

            }
            catch (Exception e){
                Toast.makeText(this,e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }


        }
    }
}
