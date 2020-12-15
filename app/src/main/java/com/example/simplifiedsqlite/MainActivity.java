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

    }
}