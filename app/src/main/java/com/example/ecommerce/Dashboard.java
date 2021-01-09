package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent intent = getIntent();
        message = intent.getStringExtra("USERNAME");
    }

    public void allAdvsertisements(View view) {
        Intent intent = new Intent(Dashboard.this , AllAdvertisements.class);
        startActivity(intent);
    }
    public void addAdvsertisements(View view) {
        Intent intent = new Intent(Dashboard.this , AddAdvertisement.class);
        intent.putExtra("USERNAME",message);
        startActivity(intent);
    }
    public void myAccount(View view) {
        Intent intent = new Intent(Dashboard.this , MyAccount.class);
        intent.putExtra("USERNAME",message);
        startActivity(intent);
    }
    public void settings(View view) {
        Intent intent = new Intent(Dashboard.this , Settings.class);
        startActivity(intent);
    }

    public void MyAdds(View view) {
        Intent intent = new Intent(Dashboard.this , MyAdds.class);
        intent.putExtra("USERNAME",message);
        startActivity(intent);
    }
}
