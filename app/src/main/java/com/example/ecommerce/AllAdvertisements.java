package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class AllAdvertisements extends AppCompatActivity {

    Advertisement advertisement;
    ArrayList<String> addDescription, telephoneNum, heading, address,type,username,addID;
    AddAdapter addAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_advertisements);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        advertisement = new Advertisement(this, "",null,1);
        addDescription = new ArrayList<>();
        telephoneNum = new ArrayList<>();
        heading = new ArrayList<>();
        address = new ArrayList<>();
        type = new ArrayList<>();
        username = new ArrayList<>();
        addID = new ArrayList<>();
        storeDataInArrays();

        addAdapter = new AddAdapter(AllAdvertisements.this,this, addDescription, telephoneNum, heading,
                address, type,username,addID);
        recyclerView.setAdapter(addAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AllAdvertisements.this));


    }

    private void storeDataInArrays() {
        Cursor cursor = advertisement.getAllAdvertisment();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();

        }else{
            while (cursor.moveToNext()){
                System.out.println(cursor.getString(0));
                addDescription.add(cursor.getString(2));
                telephoneNum.add(cursor.getString(4));
                heading.add(cursor.getString(3));
                address.add(cursor.getString(5));
                type.add(cursor.getString(6));
                username.add(cursor.getString(1));
                addID.add(cursor.getString(0));
            }

        }
    }
}
