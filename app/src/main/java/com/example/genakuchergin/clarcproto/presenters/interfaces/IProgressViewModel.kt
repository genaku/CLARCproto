package com.example.genakuchergin.clarcproto.presenters.interfaces

import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IProgressInteractor
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IProgressUseCase

interface IProgressViewModel {
    val useCase: IProgressUseCase
    val interactor: IProgressInteractor

    fun updateProgress(data: Int)
    fun hideProgress()
}