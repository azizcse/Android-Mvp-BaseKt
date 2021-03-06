package com.core.kbasekit.ui.base


/*
*  ****************************************************************************
*  * Created by : Md. Azizul Islam on 12/14/2017 at 6:53 PM.
*  * Email : azizul@w3engineers.com
*  * 
*  * Last edited by : Md. Azizul Islam on 12/14/2017.
*  * 
*  * Last Reviewed by : <Reviewer Name> on <mm/dd/yy>  
*  ****************************************************************************
*/

interface Presenter<V : MvpView> {
    fun onAttached(mvpView: V)
    fun onDetached();
}