package goncharuk.lessons31_40.lesson34

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import goncharuk.lessons31_40.common.Constants

abstract class DataBaseHelper(
    context: Context,
    dbTitle: String,
    dbVersion: Int
) : SQLiteOpenHelper(context, dbTitle, null, dbVersion) {

    override fun onCreate(db: SQLiteDatabase?) {
        val mDb = db ?: return
        Log.d(Constants.Debug.LOG_TAG, "$this - onCreate")
        mDb.execSQL(
            "create table ${Constants.Lesson34.DB_NAME} (" +
                    "id integer primary key autoincrement," +
                    "name text," +
                    "email text" +
                    ");"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, versionPrev: Int, versionCur: Int) {}
}