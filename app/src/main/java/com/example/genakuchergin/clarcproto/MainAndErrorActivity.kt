package com.example.genakuchergin.clarcproto

import com.example.genakuchergin.clarcproto.viewmodel.ErrorViewModel
import com.example.genakuchergin.clarcproto.viewmodel.MainViewModelForCaseWithError
import org.jetbrains.anko.toast

class MainAndErrorActivity: MainActivity() {

    override fun setupViewModels() {
        val errorViewModel = getViewModel {
            ErrorViewModel(application)
        }.apply {
            showErrorEvent.setObserver(this@MainAndErrorActivity, { value ->
                showError(value)
            })
        }
        val mainViewModel = getViewModel {
            MainViewModelForCaseWithError(application, errorViewModel)
        }.apply {
            someData.setObserver(this@MainAndErrorActivity, { value ->
                updateData(value)
            })
        }
        mInteractor = mainViewModel.interactor
    }

    private fun showError(error: String?) {
        error?.apply {
            toast(error)
        }
    }

}
