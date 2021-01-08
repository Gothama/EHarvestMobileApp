package com.example.ecommerce;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class User extends SQLiteOpenHelper {

    public User(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Agriculture.db", factory, version);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    private String username;
    private String password;
    private String telephoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public void createAccount(){
        ContentValues contentValues = new ContentValues();
        contentValues.put("USERNAME", username);
        contentValues.put("PASSWORD", password);
        contentValues.put("TELEPHONENUM", telephoneNumber);
        contentValues.put("NAME", name);
        this.getWritableDatabase().insertOrThrow("USER","",contentValues);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER(USERNAME TEXT PRIMARY KEY, NAME TEXT, PASSWORD TEXT UNIQUE, TELEPHONENUM TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(db);
    }
    public int login(){
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "SELECT * FROM USER WHERE USERNAME = '" + username + "' AND PASSWORD = '" + password + "'";
            int rec = db.rawQuery(sql, null).getCount();
            db.close();
            return rec;
    }

    public String[] getMyDetails(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM USER WHERE USERNAME = '" + username + "'";
        Cursor result = db.rawQuery(sql, null);
        result.moveToFirst();
        String array[] = {result.getString(0), result.getString(1), result.getString(2)};
        return array;

    }
    public void updateDetails(String username, String password , String telephoneNum){
        SQLiteDatabase db = this.getWritableDatabase();
        String strSQL = "UPDATE USER SET PASSWORD = '" + password + "'AND TELEPHONENUM = '" + telephoneNum + "' WHERE USERNAME = '"+ username + "'";
        db.execSQL(strSQL);
    }
}
