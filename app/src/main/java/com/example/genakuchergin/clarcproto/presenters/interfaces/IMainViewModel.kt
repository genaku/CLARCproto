package com.example.genakuchergin.clarcproto.presenters.interfaces

import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IMainInteractor

interface IMainViewModel {
    val interactor: IMainInteractor
    fun showData(data: String)
}