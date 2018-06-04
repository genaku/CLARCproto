package com.example.genakuchergin.clarcproto.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.example.genakuchergin.clarcproto.domain.usecases.MainUseCase
import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IMainInteractor
import com.example.genakuchergin.clarcproto.interactors.MainInteractor
import com.example.genakuchergin.clarcproto.presenters.MainPresenter
import com.example.genakuchergin.clarcproto.presenters.interfaces.IMainViewModel

class MainViewModel(val app: Application) : AndroidViewModel(app), IMainViewModel {

    // OBSERVABLES
    val someData = MutableLiveData<String>()
    // OBSERVABLES

    override val interactor: IMainInteractor

    init {
        val presenter = MainPresenter(this)
        val useCase = MainUseCase(presenter)
        interactor = MainInteractor(useCase)
    }

    override fun showData(data: String) {
        someData.postValue(data)
    }

}