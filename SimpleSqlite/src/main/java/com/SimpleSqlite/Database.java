package com.SimpleSqlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.SimpleSqlite.modelClasses.TableRowModel;
import com.SimpleSqlite.modelClasses.Types;

import java.util.ArrayList;
import java.util.HashMap;

public class Database extends SQLiteOpenHelper {


    private String TABLE_NAME = "MYT";
    private String DATABASE_NAME;





    public Database(Context context, String databaseName) {
        super(context, databaseName, null, 1);
        DATABASE_NAME = databaseName;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    public void createTable(String tableName, ArrayList<TableRowModel> models ){
        TABLE_NAME = tableName;
        try {
            SQLiteDatabase db =this.getWritableDatabase();
            StringBuilder createTable = new StringBuilder("create table " + tableName + "(ID INTEGER PRIMARY KEY, name TEXT");
            createTable = new StringBuilder(createTable.toString().replace(",)", ""));



            for (int i = 0; i < models.size(); i++) {
                if (models.get(i).getType() == new Types().getString()) {
                    createTable.append(",").append(models.get(i).getName()).append(" TEXT");
                }else{
                    createTable.append(",").append(models.get(i).getName()).append(" INTEGER");
                }
            }
            createTable.append(")");

            db.execSQL(createTable.toString());
        }catch (Exception e){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

    }
    public void clearTable(String tableName){
        TABLE_NAME = tableName;
        try {
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
            String deleteTable= "DELETE FROM "+tableName;
            sqLiteDatabase.execSQL(deleteTable);
        }catch (Exception e){
            Log.e("Simplified SQlite", "deleteTable: ",e);
        }
    }


     public void insertData(String tableName,ArrayList<InsertData> models){
        TABLE_NAME = tableName;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        for (int i = 0; i < models.size(); i++) {
            try {
                if (models.get(i).getStringValue() == null) {
                    cv.put(models.get(i).getName(), models.get(i).getIntegerValue());
                } else {
                    cv.put(models.get(i).getName(), models.get(i).getStringValue());
                }
            }catch (Exception e) {
                Log.e("SQlite database", "insertData: ", e);
            }
        }

        db.insert(tableName,null,cv);
    }
    public HashMap getColumnWithId(String id, String tableName){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tableName+" WHERE " + "ID" + " = " + id, null);
        cursor.moveToFirst();
        HashMap map = new HashMap();
        String[] columns = cursor.getColumnNames();
        for (int i = 0; i < columns.length; i++) {
            map.put(columns[i],cursor.getString(cursor.getColumnIndex(columns[i])));
            Log.e("TAG", "getColumnWithId: "+cursor.getString(cursor.getColumnIndex(columns[i])) );
        }
        return map;
    }
    public ArrayList<HashMap> queryAllItemsInTable(String tableName){
        TABLE_NAME = tableName;

        ArrayList<HashMap> arrayList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor  cursor = db.rawQuery("select * from "+tableName,null);
        String[] columns = cursor.getColumnNames();
        int indexCount = cursor.getColumnCount();
        for (int i = 1; i <= indexCount; i++) {
            HashMap map = new HashMap();
            for (int j = 0; j < columns.length; j++) {
                map.put(columns[j],cursor.getString(j));
            }
           arrayList.add(map);
        }

        return arrayList;
    }
}
