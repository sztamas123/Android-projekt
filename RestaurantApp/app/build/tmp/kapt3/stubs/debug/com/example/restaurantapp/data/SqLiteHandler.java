package com.example.restaurantapp.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/restaurantapp/data/SqLiteHandler;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "COLUMN_PROFILE_ADDRESS", "", "COLUMN_PROFILE_EMAIL", "COLUMN_PROFILE_IMAGE", "COLUMN_PROFILE_NAME", "COLUMN_PROFILE_PHONE_NUMBER", "CREATE_PROFILE_TABLE", "TABLE_PROFILE", "addProfile", "", "profile", "Lcom/example/restaurantapp/model/Profile;", "getProfile", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "updateProfile", "app_debug"})
public final class SqLiteHandler extends android.database.sqlite.SQLiteOpenHelper {
    private final java.lang.String TABLE_PROFILE = "profile";
    private final java.lang.String COLUMN_PROFILE_NAME = "name";
    private final java.lang.String COLUMN_PROFILE_PHONE_NUMBER = "phoneNumber";
    private final java.lang.String COLUMN_PROFILE_ADDRESS = "address";
    private final java.lang.String COLUMN_PROFILE_IMAGE = "image";
    private final java.lang.String COLUMN_PROFILE_EMAIL = "email";
    private final java.lang.String CREATE_PROFILE_TABLE = "CREATE TABLE profile ( name TEXT , phoneNumber TEXT , address TEXT , image TEXT , email TEXT  ) ";
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    public final void addProfile(@org.jetbrains.annotations.NotNull()
    com.example.restaurantapp.model.Profile profile) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.restaurantapp.model.Profile getProfile() {
        return null;
    }
    
    public final void updateProfile(@org.jetbrains.annotations.NotNull()
    com.example.restaurantapp.model.Profile profile) {
    }
    
    public SqLiteHandler(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null, null, null, 0);
    }
}