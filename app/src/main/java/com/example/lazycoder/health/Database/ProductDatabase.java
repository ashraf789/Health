package com.example.lazycoder.health.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lazycoder.health.ModelClass.Item;
import com.example.lazycoder.health.ModelClass.ProductModel;
import com.example.lazycoder.health.ModelClass.RecommendedProduct;

import java.util.ArrayList;

/**
 * Created by lazycoder on 2/9/18.
 */

public class ProductDatabase {
    public String TAG = "ProductDatabase";
    private DBHelper dbHelper;
    private SQLiteDatabase database;


    public ProductDatabase(Context context) {
        dbHelper = new DBHelper(context);
    }

    private void Open(){
        database = dbHelper.getWritableDatabase();
    }
    private void Close(){
        database.close();
    }


    public boolean insertProduct(ProductModel product){
        this.Open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.COL_PRODUCT_CODE,product.getProductCode());
        contentValues.put(dbHelper.COL_PRODUCT_TITLE,product.getTitle());
        contentValues.put(dbHelper.COL_PRODUCT_SHORT_DESCRIPTION,product.getShortDescription());
        contentValues.put(dbHelper.COL_PRODUCT_FULL_DESCRIPTION,product.getShortDescription());
        contentValues.put(dbHelper.COL_PRODUCT_IMAGE_URL,product.getImageUrl());
        contentValues.put(dbHelper.COL_PRODUCT_STATE,product.getState());
        contentValues.put(dbHelper.COL_PRODUCT_CATEGORY,product.getCategory().toLowerCase());
        contentValues.put(dbHelper.COL_PRODUCT_SHOP_NAME,product.getShopName());
        contentValues.put(dbHelper.COL_PRODUCT_ADDRESS,product.getAddress());
        contentValues.put(dbHelper.COL_PRODUCT_POST_CODE,product.getPostCode());
        contentValues.put(dbHelper.COL_PRODUCT_PHONE,product.getPhone());

        long id = database.insert(dbHelper.TABLE_NAME_PRODUCT,null,contentValues);

        this.Close();
        if(id > 0){
            Log.d(TAG, "Product: ------------ new Product details inserted");
            return true;
        }else {
            Log.d(TAG, "Product: ------------ new Product details inserted failed");
            return false;
        }
    }

    public ArrayList<Item> getAllProduct(String category) {
        this.Open();
        ArrayList<Item> products= new ArrayList<>();
        try {
            Cursor cursor = database.query(dbHelper.TABLE_NAME_PRODUCT, null, dbHelper.COL_PRODUCT_CATEGORY+"=?", new String[]{category}, null, null, null);

            cursor.moveToFirst();
            int totalProduct = cursor.getCount();

            for (int i = 0; i < totalProduct; i++){
                products.add(new Item(
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_TITLE)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_SHORT_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_STATE)),
                        Integer.valueOf(cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_IMAGE_URL))),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_CODE))));
                cursor.moveToNext();
            }

            cursor.close();
            this.Close();
            if (totalProduct > 0) {
                return products;
            } else {
                return null;
            }
        } catch (Exception e) {
            Log.d(TAG, "getProducts: "+e);
            return null;
        }
    }


    public ArrayList<RecommendedProduct> getAllProductRecommendedFormat(String category) {
        this.Open();
        ArrayList<RecommendedProduct> products= new ArrayList<>();
        try {
            Cursor cursor = database.query(dbHelper.TABLE_NAME_PRODUCT, null, dbHelper.COL_PRODUCT_CATEGORY+"=?", new String[]{category}, null, null, null);

            cursor.moveToFirst();
            int totalProduct = cursor.getCount();

            Log.d(TAG, "getProduct "+totalProduct);

            for (int i = 0; i < totalProduct; i++){
                products.add(new RecommendedProduct(
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_TITLE)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_SHORT_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_STATE)),
                        Integer.valueOf(cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_IMAGE_URL))),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_CODE))

                ));

                cursor.moveToNext();
            }

            cursor.close();
            this.Close();
            if (totalProduct > 0) {
                return products;
            } else {
                return null;
            }
        } catch (Exception e) {
            Log.d(TAG, "getProducts: "+e);
            return null;
        }
    }

    public ProductModel getProduct(String productCode) {
        this.Open();
        ProductModel product= new ProductModel();
        try {
            Cursor cursor = database.query(dbHelper.TABLE_NAME_PRODUCT, null, dbHelper.COL_PRODUCT_CODE+"=?", new String[]{productCode}, null, null, null);

            cursor.moveToFirst();
            int count = cursor.getCount();

            if (count > 0){
                product = new ProductModel(
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_CODE)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_TITLE)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_SHORT_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_FULL_DESCRIPTION)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_IMAGE_URL)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_STATE)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_CATEGORY)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_SHOP_NAME)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_ADDRESS)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_POST_CODE)),
                        cursor.getString(cursor.getColumnIndex(dbHelper.COL_PRODUCT_PHONE))
                );
                cursor.moveToNext();
            }
            cursor.close();
            this.Close();

            return product;
        } catch (Exception e) {
            Log.d(TAG, "getProducts: "+e);
            return null;
        }
    }

    public boolean haveAnyData(){
        this.Open();
        try {
            Cursor cursor = database.query(dbHelper.TABLE_NAME_PRODUCT, null, null, null, null, null, null);
            cursor.moveToFirst();

            int temp = cursor.getCount();

            cursor.close();
            this.Close();

            if (temp>0){
                return true;
            }else return false;
        }catch (Exception e){
            Log.d(TAG, "haveAnyData: "+e);
            return false;
        }

    }
}
