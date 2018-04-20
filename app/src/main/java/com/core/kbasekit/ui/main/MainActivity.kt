package com.core.kbasekit.ui.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.core.kbasekit.R
import com.core.kbasekit.data.db.user.User
import com.core.kbasekit.event.BaseEvent
import com.core.kbasekit.ui.base.BaseActivity
import com.core.kbasekit.util.helper.ItemDecorationUtil
import com.core.kbasekit.util.helper.Toaster
import com.core.kbasekit.util.helper.ViewUtil
import com.core.kbasekit.util.lib.BusProvider
import com.squareup.otto.Subscribe

/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/2/2018 at 1:19 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Imran Hossain on 4/20/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

class MainActivity : BaseActivity<MainMvpView, MainPresenter>(), MainMvpView {

    lateinit var insertButton: Button
    lateinit var eventBusButton: Button
    lateinit var deleteButton: Button
    lateinit var recyclerView: RecyclerView
    lateinit var mainAdapter: MainAdapter

    override fun getPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override val getLayoutId: Int
        get() = R.layout.activity_main

    override val getToolbarId: Int
        get() = -1

    override val getMvpView: MainMvpView
        get() = this

    override fun startUi() {
        insertButton.setOnClickListener(this)
        eventBusButton.setOnClickListener(this)
        deleteButton.setOnClickListener(this)

        mainAdapter.notifyDataSetChanged()
    }

    override fun initView() {
        insertButton = findViewById(R.id.insert_button)
        eventBusButton = findViewById(R.id.event_bus)
        deleteButton = findViewById(R.id.delete)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(ItemDecorationUtil(ViewUtil.dpToPx( 6)))

        mainAdapter = MainAdapter(this)
        recyclerView.adapter = mainAdapter
    }

    override val getMenuId: Int
        get() = -1

    override fun onClick(v: View?) {
        if (v?.id == R.id.insert_button) {
            presenter?.insertUser()
            //showAlert()
        } else if (v?.id == R.id.event_bus) {
            var event = BaseEvent()
            event.name = "Event message"
            BusProvider.getBus().post(event)
        } else if (v?.id == R.id.delete) {
            deleteUser()
        }
    }

    private fun deleteUser() {
        var users = mainAdapter.getItems()
        presenter?.deleteUsers(users)
    }

    override fun onUserFound(users: List<User>) {
        // Toast.makeText(this,"User List = ${users.size}",Toast.LENGTH_LONG).show()
        mainAdapter.clear()
        mainAdapter.addItems(users)
    }

    override fun onDbPrepare() {
        presenter?.getUsers()
    }

    override fun onResume() {
        super.onResume()
        BusProvider.getBus().register(this)
    }

    override fun onPause() {
        super.onPause()
        BusProvider.getBus().unregister(this)
    }

    /**
     * Event bus event receiver method
     */
    @Subscribe
    fun receiveEventMessage(baseEvent: BaseEvent) {
        Toaster.showLong("Name = "+baseEvent.name)
    }

    @Subscribe
    fun receiveEventMessage2(baseEvent: BaseEvent) {
        Toaster.showLong("Name 2 = "+baseEvent.name)
    }

    /**
     * Broadcast receiver
     */
    var broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

        }
    }

}