package com.example.genakuchergin.clarcproto.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.genakuchergin.clarcproto.SingleLiveEvent
import com.example.genakuchergin.clarcproto.domain.usecases.ErrorUseCase
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IErrorUseCase
import com.example.genakuchergin.clarcproto.presenters.ErrorPresenter
import com.example.genakuchergin.clarcproto.presenters.interfaces.IErrorViewModel

class ErrorViewModel(val app: Application) : AndroidViewModel(app), IErrorViewModel {

    // OBSERVABLES
    val showErrorEvent = SingleLiveEvent<String>()
    // OBSERVABLES

    val useCase: IErrorUseCase

    init {
        val presenter = ErrorPresenter(this)
        useCase = ErrorUseCase(presenter)
    }

    override fun showError(error: String) =
            showErrorEvent.postValue(error)

}