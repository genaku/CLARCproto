package com.example.genakuchergin.clarcproto.activitydelegate

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import com.example.genakuchergin.clarcproto.activitydelegate.interfaces.IActivityDelegatesHolder

abstract class CompositeActivity(
        @get:LayoutRes
        private val layoutResId: Int
) : AppCompatActivity() {

    abstract fun createDelegatesHolder(): IActivityDelegatesHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        val delegatesHolder = createDelegatesHolder()
        delegatesHolder.forEach {
            it.onSetupView(this)
        }
    }

    protected fun <TValue> LiveData<TValue>.observeWith(action: (TValue) -> Unit) {
        this.observe(this@CompositeActivity, Observer<TValue> {
            it?.apply(action)
        })
    }

    protected fun <TValue> LiveData<TValue>.observeNullable(action: (TValue?) -> Unit) {
        this.observe(this@CompositeActivity, Observer<TValue> {
            action(it)
        })
    }

}