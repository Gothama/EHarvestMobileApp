package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText username, telephone, password, name;
    private Button makeAccount;
    private ProgressDialog loadingBar;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.description);
        telephone = (EditText) findViewById(R.id.address);
        password = (EditText) findViewById(R.id.telephonenum);
        name = (EditText) findViewById(R.id.description);
        loadingBar = new ProgressDialog(this);

        makeAccount = (Button)findViewById(R.id.createAdd);
        user = new User(this, "", null,1);
        makeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }
    public void createAccount(){
            String name = username.getText().toString();
            String phone = telephone.getText().toString();
            String password1 = password.getText().toString();
            String username1 = username.getText().toString();


            if(TextUtils.isEmpty(name)){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(phone)){
                Toast.makeText(this, "Please enter your phone", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(password1)){
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(username1)){
                Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show();
            }
            else{
                /*loadingBar.setTitle("Create Account");
                loadingBar.setMessage("Please Wait we are processing");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();*/

                try{
                    user.setPassword(password1);
                    user.setTelephoneNumber(phone);
                    user.setUsername(username1);
                    user.setName(name);
                    user.createAccount();
                    Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(this,e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }


            }
    }
}
