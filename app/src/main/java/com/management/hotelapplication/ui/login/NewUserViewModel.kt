package com.management.hotelapplication.ui.login

import androidx.lifecycle.ViewModel
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.table.UserLogin

class NewUserViewModel:ViewModel() {

    fun updateUserDetails(data:UserLogin,db:AppDatabase)
    {
        db.newUserDao().insertNewUser(data)
    }

}
