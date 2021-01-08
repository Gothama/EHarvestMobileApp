package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class productDisplay extends AppCompatActivity {
    private String addID, addDescription, telephoneNum, heading, address, type, username;
    TextView textView1, textView2, textView3, textView4, textView5;
    Button callSeller,sendSMS;
    private Advertisement advertisement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        addID = intent.getStringExtra("ADDID");
        addDescription = intent.getStringExtra("DESCRIPTION");
        telephoneNum = intent.getStringExtra("TELEPHONENUM");
        heading = intent.getStringExtra("HEADING");
        address = intent.getStringExtra("ADDRESS");
        type = intent.getStringExtra("TYPE");
        username = intent.getStringExtra("USERNAME");
        setContentView(R.layout.activity_product_display);

        textView1 = (TextView) findViewById(R.id.heading);
        textView2 = (TextView) findViewById(R.id.description);
        textView3 = (TextView) findViewById(R.id.type);
        textView4 = (TextView) findViewById(R.id.address);
        textView5 = (TextView) findViewById(R.id.telephonenum);
        callSeller = (Button) findViewById(R.id.callSeller);
        sendSMS = (Button) findViewById(R.id.sendSMS);

        textView1.setText(heading);
        textView2.setText(addDescription);
        textView3.setText(type);
        textView5.setText(telephoneNum);
        textView4.setText(address);
        callSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call(telephoneNum);
            }
        });
        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(telephoneNum);
            }
        });

    }

    private void send(String telephoneNum) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + telephoneNum));
        System.out.println("Call Started");
        startActivity(intent);
    }

    private void call(String telephoneNum) {
System.out.println("Call Started");
      Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + telephoneNum));

        System.out.println("Call Started");
        startActivity(intent);
    }
    }

