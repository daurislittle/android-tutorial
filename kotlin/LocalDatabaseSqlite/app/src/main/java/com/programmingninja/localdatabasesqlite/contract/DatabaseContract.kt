package com.programmingninja.localdatabasesqlite.contract

import android.provider.BaseColumns

object DatabaseContract {

    //
    class CommitUserContent : BaseColumns {
        companion object {
            val TABLE_NAME = "users" //TABLE NAME
            val COLUMN_FIRST_NAME = "firstname" //column field
            val COLUMN_LAST_NAME = "lastname" //column field
            val COLUMN_USER_ID = "userid" //column field
            val COLUMN_PASSWORD = "password" //column field
            val COLUMN_DATE_CREATED = "date-created" //column field
        }
    }
}