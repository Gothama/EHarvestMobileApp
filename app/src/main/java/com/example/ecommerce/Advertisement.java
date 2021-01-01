package com.example.ecommerce;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Advertisement extends SQLiteOpenHelper {

    private String addDescription, telephoneNum, heading, address, text, username;

    public Advertisement(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Agriculture.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ADVERTISEMENT (ADDID INT PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, ADDDESCRIPTION TEXT, HEADING TEXT, TELEPHONENUM TEXT,ADDRESS TEXT, TYPE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ADVERTISEMENT");
        onCreate(db);
    }

    public void addAdvertisment(){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ADDDESCRIPTION", addDescription);
        contentValues.put("HEADING", heading);
        contentValues.put("TELEPHONENUM", telephoneNum);
        contentValues.put("ADDRESS", address);
        contentValues.put("USERNAME", username);
        this.getWritableDatabase().insertOrThrow("ADVERTISEMENT","",contentValues);
    }

    public boolean removeAddverstisement(int addId){
        try{
            this.getWritableDatabase().delete("ADVERTISEMENT","ADDID='"+addId+"'", null);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void getAllAdvertisment(String category){

    }
    public void  getAllAdvertisment(){

    }
    public void getMyAdvertisments(String username){

    }

}
