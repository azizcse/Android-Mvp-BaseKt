package com.core.kbasekit.util.lib;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 1/4/2018 at 7:01 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 1/4/2018.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/
public class BusProvider {
    private static final Bus mBus = new Bus(ThreadEnforcer.ANY);

    public static Bus getBus(){
        return mBus;
    }
}
