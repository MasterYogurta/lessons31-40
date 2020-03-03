package goncharuk.lessons31_40.lesson35

import android.content.ContentValues
import android.content.Context
import android.util.Log
import goncharuk.lessons31_40.common.Constants
import goncharuk.lessons31_40.lesson34.Lesson34DataBase

class Lesson35DataBase(context: Context) {

    private val dataBase34 = Lesson34DataBase(context)

    fun addUser(name: String, email: String) = dataBase34.addUser(name, email)

    fun readTable() = dataBase34.readTable()

    fun clearTable() = dataBase34.clearTable()

    fun updateUser(id: String, name: String, email: String) {
        Log.d(Constants.Debug.LOG_TAG, " *** Update user [${id}] *** ")
        val dataBaseHelper = dataBase34.writableDatabase
        val content = ContentValues().apply {
            put("name", name)
            put("email", email)
        }
        val params = Array(1) { id }
        val rowId = dataBaseHelper.update(Constants.Lesson34.DB_NAME, content, "id = ?", params)
        Log.d(Constants.Debug.LOG_TAG, " *** Row updated in Data Base : [$rowId] *** ")
        dataBaseHelper.close()
    }

    fun deleteUser(id: String) {
        val dataBaseHelper = dataBase34.writableDatabase
        Log.d(Constants.Debug.LOG_TAG, " *** Delete user [${id}] *** ")
        val rowId = dataBaseHelper.delete(Constants.Lesson34.DB_NAME, "id = $id", null)
        Log.d(Constants.Debug.LOG_TAG, " *** Row deleted in Data Base : [$rowId] *** ")
        dataBaseHelper.close()
    }
}