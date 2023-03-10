package com.management.hotelapplication.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.table.UserLogin

class UserloginViewModel:ViewModel() {

    val liveDataLogin= MutableLiveData<Boolean>()


    fun checkValidcreds(data: UserLogin,db: AppDatabase)
    {


        val userData=db.userloginDao().getLoginDetails(data.username,data.password)

        if (data.username==userData.username && data.password==userData.password)
        {

            liveDataLogin.value = true
        }
       else
        {
            liveDataLogin.value=false
        }
    }


    }














