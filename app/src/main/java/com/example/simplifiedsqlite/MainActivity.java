package com.example.simplifiedsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.SimpleSqlite.Database;
import com.SimpleSqlite.InsertData;
import com.SimpleSqlite.modelClasses.TableRowModel;
import com.SimpleSqlite.modelClasses.Types;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String DB_NAME = "MYDATABASENAME";
        String TABLE_NAME = "THTABLEOF";

        String ca,cb,c3;

        ca="name";
        cb = "hello";
        c3 = "hoooo";

        Database database = new Database(this,DB_NAME);
        ArrayList<HashMap> maps = database.queryAllItemsInTable(TABLE_NAME);

        for (int i = 0; i < maps.size(); i++) {
            HashMap map = maps.get(i);
            Log.e("TAG", "onCreate: "+map.get(ca));
        }

    }
}