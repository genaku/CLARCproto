package com.example.genakuchergin.clarcproto.interactors

import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IProgressInteractor
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IProgressUseCase
import org.jetbrains.anko.doAsync

class ProgressInteractor(private val useCase: IProgressUseCase) : IProgressInteractor {
    override fun pullToRefresh() {
        doAsync {
            useCase.forceRefresh()
        }
    }
}