package com.example.genakuchergin.clarcproto.interactors

import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IMainInteractor
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IMainUseCase
import org.jetbrains.anko.doAsync

class MainInteractor(private val useCase: IMainUseCase) : IMainInteractor {
    override fun showData() {
        doAsync {
            useCase.showData()
        }
    }
}