package com.mantra.checkin.DBHandlers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.mantra.checkin.DB.DbHelper;
import com.mantra.checkin.DB.DbTableStrings;
import com.mantra.checkin.Models.UserInfo;

/**
 * Created by adithyar on 9/21/2016.
 */
public class UserInfoDBHandler {

    private static DbHelper dbHelper;
    private static SQLiteDatabase db;

    public static void InsertUserDetails(Context context, UserInfo userinfo){
        try{
            ContentValues contentValues = new ContentValues();
            contentValues.put(DbTableStrings.USERNAME,userinfo.UserName);
            contentValues.put(DbTableStrings.USEREMAIL,userinfo.UserEmail);
            contentValues.put(DbTableStrings.USERPHOTO,userinfo.UserPhoto);
            contentValues.put(DbTableStrings.FIRSTNAME,userinfo.FirstName);
            contentValues.put(DbTableStrings.LASTNAME,userinfo.LastName);
            contentValues.put(DbTableStrings.USERID,userinfo.UserID);

            dbHelper = new DbHelper(context);
            db = dbHelper.getWritableDatabase();
            db.insert(DbTableStrings.TABLE_NAME_USER_INFO,null,contentValues);
        }
        catch (Exception e)
        {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean CheckIfUserExistsInDB(Context context){

        try {
            dbHelper = new DbHelper(context);
            db = dbHelper.getWritableDatabase();

            Cursor c = db.rawQuery("Select * from " + DbTableStrings.TABLE_NAME_USER_INFO, null);
            if (c.moveToFirst()) {
                return true;
            }
            else{
                return false;
            }

        }
        catch(Exception e){
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
