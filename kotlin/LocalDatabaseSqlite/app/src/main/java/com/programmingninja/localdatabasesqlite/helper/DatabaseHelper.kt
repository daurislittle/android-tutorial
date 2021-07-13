package com.programmingninja.localdatabasesqlite.helper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import com.programmingninja.localdatabasesqlite.contract.DatabaseContract
import com.programmingninja.localdatabasesqlite.model.UserModel


class DatabaseHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_SQL_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DELETE_SQL_ENTRIES)
        onCreate(db)
    }
    @Throws(SQLiteConstraintException::class)
    fun insertRecord(user: UserModel): Boolean {

        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun deleteRecord(userid: String): Boolean {

        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun showRecord(userid: String): ArrayList<UserModel> {
        val user = ArrayList<UserModel>()

        return user
    }

    @Throws(SQLiteConstraintException::class)
    fun showRecords(): ArrayList<UserModel> {
        val user = ArrayList<UserModel>()

        return user
    }

    companion object {
        val DATABASE_NAME = "LocalDBSqlite"
        val DATABASE_VERSION = 1

        private val CREATE_SQL_TABLE = "" +
                "CREATE TABLE " + DatabaseContract.CommitUserContent.TABLE_NAME + " (" +
                DatabaseContract.CommitUserContent.COLUMN_FIRST_NAME + "TEXT, " +
                DatabaseContract.CommitUserContent.COLUMN_LAST_NAME + "TEXT," +
                DatabaseContract.CommitUserContent.COLUMN_USER_ID + "TEXT," +
                DatabaseContract.CommitUserContent.COLUMN_PASSWORD + "TEXT," +
                DatabaseContract.CommitUserContent.COLUMN_DATE_CREATED + "TEXT)"

        private val DELETE_SQL_ENTRIES = "DROP TABLE IF EXISTS " + DatabaseContract.CommitUserContent.TABLE_NAME

    }
}