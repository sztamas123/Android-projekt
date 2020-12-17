package com.example.restaurantapp.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.restaurantapp.model.Profile

private const val DATABASE_NAME = "ProfileDB.db"

class SqLiteHandler(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1){

    private val TABLE_PROFILE = "profile"

    private val COLUMN_PROFILE_NAME = "name"
    private val COLUMN_PROFILE_PHONE_NUMBER = "phoneNumber"
    private val COLUMN_PROFILE_ADDRESS = "address"
    private val COLUMN_PROFILE_IMAGE = "image"
    private val COLUMN_PROFILE_EMAIL = "email"

    private val CREATE_PROFILE_TABLE = "CREATE TABLE " + TABLE_PROFILE + " ( " + COLUMN_PROFILE_NAME + " TEXT , " + COLUMN_PROFILE_PHONE_NUMBER + " TEXT , " +
            COLUMN_PROFILE_ADDRESS + " TEXT , " + COLUMN_PROFILE_IMAGE + " TEXT , " + COLUMN_PROFILE_EMAIL + " TEXT " + " ) "


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_PROFILE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PROFILE");
        onCreate(db);
    }

    fun addProfile(profile: Profile){
        val database = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_PROFILE_NAME, profile.name)
        values.put(COLUMN_PROFILE_PHONE_NUMBER, profile.phoneNumber)
        values.put(COLUMN_PROFILE_ADDRESS, profile.address)
        values.put(COLUMN_PROFILE_IMAGE, profile.image)
        values.put(COLUMN_PROFILE_EMAIL, profile.email)
        database.insert(TABLE_PROFILE, null, values)
        database.close()
    }

    fun getProfile() : Profile?{
        val database = this.readableDatabase
        val cursor: Cursor = database.rawQuery("SELECT * FROM $TABLE_PROFILE", null)
        if (cursor.moveToFirst()) {
            return Profile(
                cursor.getString(0), cursor.getString(3), cursor.getString(2),
                cursor.getString(1), cursor.getString(4)
            )
        }
        return null
    }

    fun updateProfile(profile: Profile){
        val database = this.writableDatabase
        database.execSQL(
            "UPDATE $TABLE_PROFILE SET $COLUMN_PROFILE_NAME = '" + profile.name + "' , $COLUMN_PROFILE_PHONE_NUMBER = '" + profile.phoneNumber +
                    "' , $COLUMN_PROFILE_ADDRESS = '" + profile.address + "' , $COLUMN_PROFILE_EMAIL = '" + profile.email + "' , $COLUMN_PROFILE_IMAGE = '" + profile.image + "'"
        )
        database.close()
    }

}