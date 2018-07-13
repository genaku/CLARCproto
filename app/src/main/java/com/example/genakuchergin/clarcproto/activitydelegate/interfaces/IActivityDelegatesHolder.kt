package com.example.genakuchergin.clarcproto.activitydelegate.interfaces

import android.support.v7.app.AppCompatActivity
import com.example.genakuchergin.clarcproto.activitydelegate.ActivityDelegateType

interface IActivityDelegatesHolder {
    fun onSetupView(type: ActivityDelegateType, activity: AppCompatActivity)
    fun forEach(action: (IActivityDelegate) -> Unit)
}