package com.example.genakuchergin.clarcproto.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IMainInteractor
import com.example.genakuchergin.clarcproto.domain.usecases.MainAndProgressUseCase
import com.example.genakuchergin.clarcproto.interactors.MainInteractor
import com.example.genakuchergin.clarcproto.presenters.MainPresenter
import com.example.genakuchergin.clarcproto.presenters.interfaces.IMainViewModel
import com.example.genakuchergin.clarcproto.presenters.interfaces.IProgressViewModel

class MainViewModelForCaseWithProgress(val app: Application, progressViewModel: IProgressViewModel) : AndroidViewModel(app), IMainViewModel {

    override val interactor: IMainInteractor

    // OBSERVABLES
    val someData = MutableLiveData<String>()
    // OBSERVABLES

    init {
        val presenter = MainPresenter(this)
        val useCase = MainAndProgressUseCase(presenter, progressViewModel.useCase)
        interactor = MainInteractor(useCase)
    }

    override fun showData(data: String) {
        someData.postValue(data)
    }

}