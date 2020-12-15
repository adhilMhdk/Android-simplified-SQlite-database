package com.example.simplifiedsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.simplifiedsqlite.modelClasses.TableRowModel;
import com.example.simplifiedsqlite.modelClasses.Types;

import java.util.ArrayList;
import java.util.HashMap;


public class Database extends SQLiteOpenHelper {



    private String DATABASE_NAME;





    public Database(Context context, String databaseName) {
        super(context, databaseName, null, 1);
        DATABASE_NAME = databaseName;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    public void createTable(String tableName, ArrayList<TableRowModel> models ){
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

    }
}
