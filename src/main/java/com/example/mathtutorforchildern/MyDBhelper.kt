package com.example.mathtutorforchildern

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBhelper(context: Context) : SQLiteOpenHelper(context, "USERDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE USER (USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME, PWD TEXT)")
        db?.execSQL("INSERT INTO USER (USERNAME, PWD) VALUES ('DMU','pcs')")
        db?.execSQL("INSERT INTO USER (USERNAME, PWD) VALUES ('P2534239@my365.dmu.ac.uk','Kasam Ali')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}


