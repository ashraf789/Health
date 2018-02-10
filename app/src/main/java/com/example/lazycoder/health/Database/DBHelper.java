package com.example.lazycoder.health.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lazycoder on 2/9/18.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "health";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME_PRODUCT = "product";
    public static final String COL_PRODUCT_ID = "id";
    public static final String COL_PRODUCT_CODE = "productCode";
    public static final String COL_PRODUCT_TITLE = "title";
    public static final String COL_PRODUCT_SHORT_DESCRIPTION = "shortDescription";
    public static final String COL_PRODUCT_FULL_DESCRIPTION = "fullDescription";
    public static final String COL_PRODUCT_IMAGE_URL = "image";
    public static final String COL_PRODUCT_STATE = "state";
    public static final String COL_PRODUCT_CATEGORY = "category";
    public static final String COL_PRODUCT_SHOP_NAME = "shopName";
    public static final String COL_PRODUCT_ADDRESS = "address";
    public static final String COL_PRODUCT_POST_CODE = "post";
    public static final String COL_PRODUCT_PHONE = "phone";


    public static final String PRODUCT_TABLE_QUERY = "Create Table "
            +TABLE_NAME_PRODUCT+" ( "
            +COL_PRODUCT_ID+" Integer primary key autoincrement, "
            +COL_PRODUCT_CODE+" Text not null, "
            +COL_PRODUCT_TITLE+" Text not null, "
            + COL_PRODUCT_SHORT_DESCRIPTION +" Text not null, "
            + COL_PRODUCT_FULL_DESCRIPTION +" Text not null, "
            +COL_PRODUCT_IMAGE_URL+" Text, "
            +COL_PRODUCT_STATE+" Text, "
            +COL_PRODUCT_CATEGORY+" Text not null, "
            +COL_PRODUCT_SHOP_NAME+" Text, "
            +COL_PRODUCT_ADDRESS+" Text not null, "
            +COL_PRODUCT_POST_CODE+" Text not null, "
            +COL_PRODUCT_PHONE+" Text);";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PRODUCT_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists '" + PRODUCT_TABLE_QUERY + "'");

        onCreate(db);
    }
}
