package com.example.genakuchergin.clarcproto.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.genakuchergin.clarcproto.SingleLiveEvent
import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IProgressInteractor
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IProgressUseCase
import com.example.genakuchergin.clarcproto.domain.usecases.ProgressUseCase
import com.example.genakuchergin.clarcproto.interactors.ProgressInteractor
import com.example.genakuchergin.clarcproto.presenters.ProgressPresenter
import com.example.genakuchergin.clarcproto.presenters.interfaces.IProgressViewModel

class ProgressViewModel(val app: Application) : AndroidViewModel(app), IProgressViewModel {

    // OBSERVABLES
    val loadingProgress = MutableLiveData<Int>()
    val hideProgressEvent = SingleLiveEvent<Boolean>()
    // OBSERVABLES

    override val useCase: IProgressUseCase
    override val interactor: IProgressInteractor

    init {
        val presenter = ProgressPresenter(this)
        useCase = ProgressUseCase(presenter)
        interactor = ProgressInteractor(useCase)
    }

    override fun updateProgress(data: Int) =
            loadingProgress.postValue(data)

    override fun hideProgress() =
            hideProgressEvent.postValue(true)

}