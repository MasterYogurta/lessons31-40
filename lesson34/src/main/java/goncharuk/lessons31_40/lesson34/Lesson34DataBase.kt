package goncharuk.lessons31_40.lesson34

import android.content.ContentValues
import android.content.Context
import android.util.Log
import goncharuk.lessons31_40.common.Constants

class Lesson34DataBase(context: Context) : DataBaseHelper(
        context = context,
        dbTitle = "Lesson34 DataBase",
        dbVersion = 1
) {

    fun addUser(name: String, email: String) {
        Log.d(Constants.Debug.LOG_TAG, " *** Add user to table: [$name : $email] *** ")
        val content = ContentValues()
        val dataBaseHelper = this.writableDatabase

        content.put("name", name)
        content.put("email", email)

        val rowId = dataBaseHelper.insert(Constants.Lesson34.DB_NAME, null, content)

        Log.d(Constants.Debug.LOG_TAG, "Row inserted in Data Base : [$rowId]")
        dataBaseHelper.close()
    }

    fun readTable() {
        Log.d(Constants.Debug.LOG_TAG, " *** Read in Data Base Table  *** ")
        val dataBaseHelper = this.writableDatabase
        val cursor = dataBaseHelper.query(Constants.Lesson34.DB_NAME, null, null, null, null, null, null, null)

        if (cursor.moveToFirst()) {
            val idIndex = cursor.getColumnIndex("id")
            val nameIndex = cursor.getColumnIndex("name")
            val emailIndex = cursor.getColumnIndex("email")

            do {
                val id = cursor.getInt(idIndex)
                val name = cursor.getString(nameIndex)
                val email = cursor.getString(emailIndex)
                Log.d(Constants.Debug.LOG_TAG, " > [$id] : $name ~ $email")
            } while (cursor.moveToNext())
        } else {
            Log.d(Constants.Debug.LOG_TAG, "Data Base have 0 rows")
        }
        cursor.close()
        dataBaseHelper.close()
    }

    fun clearTable() {
        val dataBaseHelper = this.writableDatabase
        Log.d(Constants.Debug.LOG_TAG, " *** Clear Data Base Table *** ")
        dataBaseHelper.delete(Constants.Lesson34.DB_NAME, null, null).let { clearCount ->
            Log.d(Constants.Debug.LOG_TAG, "Rows was deleted : [$clearCount]")
        }
        dataBaseHelper.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE NAME = '" + Constants.Lesson34.DB_NAME + "'")
        dataBaseHelper.close()
    }
}