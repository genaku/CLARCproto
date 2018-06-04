package com.example.genakuchergin.clarcproto.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.genakuchergin.clarcproto.domain.usecases.MainAndErrorUseCase
import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IMainInteractor
import com.example.genakuchergin.clarcproto.interactors.MainInteractor
import com.example.genakuchergin.clarcproto.presenters.MainPresenter
import com.example.genakuchergin.clarcproto.presenters.interfaces.IMainViewModel

class MainViewModelForCaseWithError(val app: Application, errorViewModel: ErrorViewModel) : AndroidViewModel(app), IMainViewModel {

    // OBSERVABLES
    val someData = MutableLiveData<String>()
    // OBSERVABLES

    override val interactor: IMainInteractor

    init {
        val presenter = MainPresenter(this)
        val useCase = MainAndErrorUseCase(presenter, errorViewModel.useCase)
        interactor = MainInteractor(useCase)
    }

    override fun showData(data: String) {
        someData.postValue(data)
    }

}