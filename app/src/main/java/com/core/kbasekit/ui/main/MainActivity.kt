package com.core.kbasekit.ui.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import com.core.kbasekit.R
import com.core.kbasekit.data.db.user.User
import com.core.kbasekit.data.model.BaseEvent
import com.core.kbasekit.databinding.ActivityMainBinding
import com.core.kbasekit.ui.anko.AnkoActivity
import com.core.kbasekit.ui.base.BaseActivity
import com.core.kbasekit.ui.base.ItemClickListener
import com.core.kbasekit.util.helper.DialogUtil
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
*  * Last edited by : Md. Imran Hossain on 4/23/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

class MainActivity : BaseActivity<MainMvpView, MainPresenter>(), MainMvpView,
        ItemClickListener<User>, DialogUtil.DialogListener {

    lateinit var recyclerView: RecyclerView
    lateinit var mainAdapter: MainAdapter
    lateinit var mBinding: ActivityMainBinding

    override fun getPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override val getLayoutId: Int
        get() = R.layout.activity_main

    override val getToolbarId: Int
        get() = R.id.toolbar

    override fun startUi() {

        mBinding = getViewDataBinding() as ActivityMainBinding
        setClickListener(mBinding.insertButton, mBinding.eventBus, mBinding.delete)

        mainAdapter.notifyDataSetChanged()
    }

    override fun initView() {
        supportActionBar!!.setIcon(R.drawable.ic_menu)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(ItemDecorationUtil(ViewUtil.dpToPx(4)))

        mainAdapter = MainAdapter(this)
        mainAdapter.setClickLisener(this)
        recyclerView.adapter = mainAdapter
    }

    override fun stoptUi() {
        
    }

    override val getMenuId: Int
        get() = R.menu.main_menu

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.insert_button -> {
                presenter?.insertUser()
            }
            R.id.event_bus -> {
                var event = BaseEvent()
                event.name = "Event message"
                BusProvider.getBus().post(event)
            }
            R.id.delete -> {
                DialogUtil.show(this, "Delete", "Are you sure to delete all user?",
                        "Delete", "No", this, 1)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_settings -> {
                //Toaster.showShort("click : " + item.title)
                startActivity(Intent(this, AnkoActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        var users = mainAdapter.getItems()
        presenter?.deleteUsers(users)
    }

    override fun onUserFound(users: List<User>) {
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
        Toaster.showLong("Name = " + baseEvent.name)
    }

    @Subscribe
    fun receiveEventMessage2(baseEvent: BaseEvent) {
        Toaster.showLong("Name 2 = " + baseEvent.name)
    }

    /**
     * Broadcast receiver
     */
    var broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {

        }
    }

    override fun onClickPositive(flag: Int) {
        when (flag) {
            1 -> deleteUser()
        }
    }

    override fun onCancel() {

    }

    override fun onClickNegative(flag: Int) {
    }

    override fun onItemClick(view: View, item: User) {
        Toaster.showShort(item.name)
    }
}