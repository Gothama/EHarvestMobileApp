package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MyAdds extends AppCompatActivity {
    private String message;

    Advertisement advertisement;
    ArrayList<String> addDescription, telephoneNum, heading, address,type,addID;
    AddAdapter addAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        message = intent.getStringExtra("USERNAME");
        setContentView(R.layout.activity_my_adds);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        advertisement = new Advertisement(this, "",null,1);
        addDescription = new ArrayList<>();
        telephoneNum = new ArrayList<>();
        heading = new ArrayList<>();
        address = new ArrayList<>();
        type = new ArrayList<>();
        addID = new ArrayList<>();

        storeDataInArrays();

        addAdapter = new AddAdapter(MyAdds.this,this, addDescription, telephoneNum, heading,
                address, type,message,addID);
        recyclerView.setAdapter(addAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MyAdds.this));
    }

    private void storeDataInArrays() {
        Cursor cursor = advertisement.getMyAdvertisments(message);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();

        } else {
            while (cursor.moveToNext()) {
                System.out.println(cursor.getString(0));
                addDescription.add(cursor.getString(2));
                telephoneNum.add(cursor.getString(4));
                heading.add(cursor.getString(3));
                address.add(cursor.getString(5));
                type.add(cursor.getString(6));

                addID.add(cursor.getString(0));
            }
        }
    }}
