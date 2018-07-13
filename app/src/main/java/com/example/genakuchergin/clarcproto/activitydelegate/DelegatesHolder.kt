package com.example.genakuchergin.clarcproto.activitydelegate

import android.support.v7.app.AppCompatActivity
import com.example.genakuchergin.clarcproto.activitydelegate.interfaces.IActivityDelegate
import com.example.genakuchergin.clarcproto.activitydelegate.interfaces.IActivityDelegatesHolder

class DelegatesHolder
private constructor(private val delegates: HashSet<IActivityDelegate>) : IActivityDelegatesHolder {

    override fun setup(activity: AppCompatActivity) = delegates.forEach {
        it.onSetupView(activity)
    }

    class Builder {
        private val mDelegates = HashSet<IActivityDelegate>()

        fun add(delegate: IActivityDelegate) = this.apply {
            mDelegates.add(delegate)
        }

        fun build(): DelegatesHolder =
                DelegatesHolder(mDelegates)
    }

}
