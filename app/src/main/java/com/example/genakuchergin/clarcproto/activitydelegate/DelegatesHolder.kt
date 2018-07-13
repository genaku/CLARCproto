package com.example.genakuchergin.clarcproto.activitydelegate

import android.support.v7.app.AppCompatActivity
import android.util.SparseArray
import com.example.genakuchergin.clarcproto.activitydelegate.interfaces.IActivityDelegate
import com.example.genakuchergin.clarcproto.activitydelegate.interfaces.IActivityDelegatesHolder
import org.jetbrains.anko.collections.forEach

class DelegatesHolder
private constructor(private val delegates: SparseArray<IActivityDelegate>) : IActivityDelegatesHolder {

    override fun onSetupView(type: ActivityDelegateType, activity: AppCompatActivity) =
            delegates.get(type.ordinal).onSetupView(activity)

    override fun forEach(action: (IActivityDelegate) -> Unit) =
            delegates.forEach { _, it -> action(it) }

    class Builder {
        private val mDelegates = SparseArray<IActivityDelegate>()

        fun add(type: ActivityDelegateType, delegate: IActivityDelegate) = this.apply {
            mDelegates.put(type.ordinal, delegate)
        }

        fun build(): DelegatesHolder =
                DelegatesHolder(mDelegates)
    }

}
