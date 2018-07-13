package com.example.genakuchergin.clarcproto.activitydelegate.delegates

import android.app.Application
import android.support.v7.app.AppCompatActivity
import com.example.genakuchergin.clarcproto.activitydelegate.interfaces.IActivityDelegate
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IErrorUseCase
import com.example.genakuchergin.clarcproto.getViewModel
import com.example.genakuchergin.clarcproto.setObserver
import com.example.genakuchergin.clarcproto.viewmodel.ErrorViewModel
import org.jetbrains.anko.toast

class ErrorActivityDelegate(private val application: Application) : IActivityDelegate {

    private lateinit var mActivity: AppCompatActivity
    private lateinit var mUseCase: IErrorUseCase

    val useCase
        get() = mUseCase

    override fun onSetupView(activity: AppCompatActivity) {
        mActivity = activity
        val viewModel = activity.getViewModel {
            ErrorViewModel(application)
        }.apply {
            showErrorEvent.setObserver(activity) { value ->
                showError(value)
            }
        }
        mUseCase = viewModel.useCase
    }

    private fun showError(error: String?) {
        error?.apply {
            mActivity.toast(error)
        }
    }

}