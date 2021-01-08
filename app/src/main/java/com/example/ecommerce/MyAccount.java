package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyAccount extends AppCompatActivity {
    private String message;
    private EditText username, telephone, password;
    private Button update;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        Intent intent = getIntent();
        message = intent.getStringExtra("USERNAME");
        System.out.println("DOne");
        username = (EditText) findViewById(R.id.username);
        telephone = (EditText) findViewById(R.id.telephonenum);
        password = (EditText) findViewById(R.id.password);
        update = (Button)findViewById(R.id.createAdd);


        user = new User(this, "", null,1);
        String mydetails[] =user.getMyDetails(message);
        String username1 = mydetails[0];
        String password1 = mydetails[1];
        String telephone1 = mydetails[2];

        username.setText(username1);
        telephone.setText(telephone1);
        password.setText(password1);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetails();
            }
        });
    }

    private void updateDetails() {
        try {
            user.updateDetails(username.getText().toString(), password.getText().toString(),telephone.getText().toString());
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Toast.makeText(this, "Updated" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
