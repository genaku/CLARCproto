package com.example.genakuchergin.clarcproto.activitydelegate.delegates

import android.app.Application
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.genakuchergin.clarcproto.R
import com.example.genakuchergin.clarcproto.activitydelegate.interfaces.IActivityDelegate
import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IProgressInteractor
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IProgressUseCase
import com.example.genakuchergin.clarcproto.getViewModel
import com.example.genakuchergin.clarcproto.setObserver
import com.example.genakuchergin.clarcproto.viewmodel.ProgressViewModel

class ProgressActivityDelegate(private val application: Application) : IActivityDelegate {

    private var mProgressInteractor: IProgressInteractor? = null
    private lateinit var mUseCase: IProgressUseCase

    private lateinit var tvProgress: TextView
    private lateinit var btnPullRefresh: Button

    val useCase
        get() = mUseCase

    override fun onSetupView(activity: AppCompatActivity) {
        tvProgress = activity.findViewById(R.id.tvProgress)
        btnPullRefresh = activity.findViewById(R.id.btnPullRefresh)
        val progressViewModel = activity.getViewModel {
            ProgressViewModel(application)
        }.apply {
            loadingProgress.setObserver(activity) { value -> updateProgress(value) }
            hideProgressEvent.setObserver(activity) { value -> hideProgress(value) }
        }
        mUseCase = progressViewModel.useCase
        mProgressInteractor = progressViewModel.interactor
        setupIU()
    }

    private fun updateProgress(value: Int?) {
        value?.apply {
            if (tvProgress.visibility != View.VISIBLE) {
                tvProgress.visibility = View.VISIBLE
            }
            tvProgress.text = "Progress: $value"
        }
    }

    private fun hideProgress(value: Boolean?) {
        if (value == true) {
            tvProgress.visibility = View.GONE
        }
    }

    private fun setupIU() {
        btnPullRefresh.setOnClickListener {
            mProgressInteractor?.pullToRefresh()
        }
    }

}