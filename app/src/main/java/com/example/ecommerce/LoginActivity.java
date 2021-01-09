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

        username = (EditText) findViewById(R.id.username);
        telephone = (EditText) findViewById(R.id.telephonenum);
        password = (EditText) findViewById(R.id.password1);
        name = (EditText) findViewById(R.id.uname);
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
            String name1 = name.getText().toString();
            String phone = telephone.getText().toString();
            String password1 = password.getText().toString();
            String username1 = username.getText().toString();
        String MobilePattern = "[0-9]{10}";


            if(TextUtils.isEmpty(name1) || (name1.toCharArray().length<5) || !isNameValid(name1)) {
                Toast.makeText(this, "Please enter a valid name with minimum 5 letters", Toast.LENGTH_SHORT).show();
            }
            else if(!telephone.getText().toString().matches(MobilePattern)){
                Toast.makeText(this, "Please a valid phone number", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(password1) || (password1.toCharArray().length<5)){
                Toast.makeText(this, "Please enter a valid password of minimum 5 characters", Toast.LENGTH_SHORT).show();
            }
            else if(TextUtils.isEmpty(username1) || (username1.toCharArray().length<5) ){
                Toast.makeText(this, "Please enter a valid username of minimum 5 characters", Toast.LENGTH_SHORT).show();
            }
            else{

                try{
                    user.setPassword(password1);
                    user.setTelephoneNumber(phone);
                    user.setUsername(username1);
                    user.setName(name1);
                    user.createAccount();
                    Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(this,e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }


            }
    }

    private boolean isNameValid(String name) {
        boolean valid = true;
        String regex = "[a-zA-Z ]+";

        if (!name.matches(regex)) {
            valid = false;
        }
        return valid;
    }

    private boolean isPhoneNumberValid(String phone) {
        boolean valid = true;
        String regex = "[0-9]{10}";

        if (!phone.matches(regex)) {
            valid = false;
        }
        return valid;
    }
}
