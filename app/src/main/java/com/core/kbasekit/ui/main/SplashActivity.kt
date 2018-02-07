package com.core.kbasekit.ui.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.core.kbasekit.R
import com.core.kbasekit.data.db.user.User
import com.core.kbasekit.event.BaseEvent
import com.core.kbasekit.ui.base.BaseActivity
import com.core.kbasekit.util.lib.BusProvider
import com.squareup.otto.Subscribe


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/2/2018 at 1:19 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/2/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

class SplashActivity : BaseActivity<MainMvpView, MainPresenter>(), MainMvpView {

    lateinit var button : Button
    lateinit var recyclerView : RecyclerView
    lateinit var mainAdapter : MainAdapter

    override fun getPresenter(): MainPresenter {
        return MainPresenter(this)
    }
    override val getLayoutId: Int
        get() = R.layout.activity_main

    override val getMvpView: MainMvpView
        get() = this


    override fun startUi() {
        button = findViewById(R.id.hello_text)
        recyclerView = findViewById(R.id.recyclerView)
        mainAdapter = MainAdapter(this)
        button.setOnClickListener(this)
        initRecyclerView()
    }


    private fun initRecyclerView(){
        recyclerView.adapter = mainAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override val getMenuId: Int
        get() = -1


    override fun onClick(v: View?) {
        //presenter?.insertUser()
        var event = BaseEvent()
        event.name = "Faisal"

        BusProvider.getBus().post(event)
    }

    override fun showLog(users : List<User>) {
        Toast.makeText(this,"User List = ${users.size}",Toast.LENGTH_LONG).show()
    }

    override fun finish() {
        presenter?.getUsers()
    }

    var broadcastReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {

        }
    }

    override fun onResume() {
        super.onResume()
        BusProvider.getBus().register(this)
    }

    override fun onPause() {
        super.onPause()
        BusProvider.getBus().unregister(this)
    }

    @Subscribe
    fun receiveMessage(baseEvent : BaseEvent){
        Toast.makeText(this,"Name = "+baseEvent.name,Toast.LENGTH_LONG).show()
    }

}