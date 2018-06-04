package com.example.genakuchergin.clarcproto

import android.view.View
import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IProgressInteractor
import com.example.genakuchergin.clarcproto.viewmodel.MainViewModelForCaseWithProgress
import com.example.genakuchergin.clarcproto.viewmodel.ProgressViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainAndProgressActivity : MainActivity() {

    private var mProgressInteractor: IProgressInteractor? = null

    override fun setupViewModels() {
        val progressViewModel = getViewModel {
            ProgressViewModel(application)
        }.apply {
            loadingProgress.setObserver(this@MainAndProgressActivity, { value -> updateProgress(value) })
            hideProgressEvent.setObserver(this@MainAndProgressActivity, { value -> hideProgress(value) })
        }
        mProgressInteractor = progressViewModel.interactor
        val mainViewModel = getViewModel {
            MainViewModelForCaseWithProgress(application, progressViewModel)
        }.apply {
            someData.setObserver(this@MainAndProgressActivity, { value ->
                updateData(value)
            })
        }
        mInteractor = mainViewModel.interactor
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

    override fun setupIU() {
        super.setupIU()
        btnPullRefresh.setOnClickListener {
            mProgressInteractor?.pullToRefresh()
        }
    }

}
