package com.example.genakuchergin.clarcproto

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IProgressInteractor
import com.example.genakuchergin.clarcproto.domain.usecases.MainAndErrorAndProgressUseCase
import com.example.genakuchergin.clarcproto.viewmodel.ErrorViewModel
import com.example.genakuchergin.clarcproto.viewmodel.MainViewModelForCaseWithErrorAndProgress
import com.example.genakuchergin.clarcproto.viewmodel.MainViewModelForCaseWithProgress
import com.example.genakuchergin.clarcproto.viewmodel.ProgressViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainAndErrorAndProgressActivity: MainActivity() {

    private var mProgressInteractor: IProgressInteractor? = null

    override fun setupViewModels() {
        val errorViewModel = getViewModel {
            ErrorViewModel(application)
        }.apply {
            showErrorEvent.setObserver(this@MainAndErrorAndProgressActivity, { value ->
                showError(value)
            })
        }
        val progressViewModel = getViewModel {
            ProgressViewModel(application)
        }.apply {
            loadingProgress.setObserver(this@MainAndErrorAndProgressActivity, { value -> updateProgress(value) })
            hideProgressEvent.setObserver(this@MainAndErrorAndProgressActivity, { value -> hideProgress(value) })
        }
        mProgressInteractor = progressViewModel.interactor
        val mainViewModel = getViewModel {
            MainViewModelForCaseWithErrorAndProgress(application, errorViewModel, progressViewModel)
        }.apply {
            someData.setObserver(this@MainAndErrorAndProgressActivity, { value ->
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

    private fun showError(error: String?) {
        error?.apply {
            toast(error)
        }
    }


}
