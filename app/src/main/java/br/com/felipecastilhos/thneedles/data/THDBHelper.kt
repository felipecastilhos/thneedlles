package br.com.felipecastilhos.thneedles.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class THDBHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "mydb") {

    companion object {
        private var instance: THDBHelper? = null

        @Synchronized
        fun getInstance(ctx: Context) : THDBHelper {
            if(instance == null) {
                instance = THDBHelper(ctx)
            }

            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(NeedleTable.TABLE_NAME, true,
                NeedleTable.ID to INTEGER + PRIMARY_KEY,
                NeedleTable.NAME to TEXT,
                NeedleTable.SIZE to INTEGER,
                NeedleTable.QUANTITY to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }


    val Context.database: THDBHelper
    get() = getInstance(applicationContext)

}