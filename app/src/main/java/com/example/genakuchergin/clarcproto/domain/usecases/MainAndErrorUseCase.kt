package com.example.genakuchergin.clarcproto.domain.usecases

import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IErrorUseCase
import com.example.genakuchergin.clarcproto.domain.interfaces.presenters.IMainPresenter
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IMainUseCase

class MainAndErrorUseCase(
        private val presenter: IMainPresenter,
        private val errorUseCase: IErrorUseCase
) : IMainUseCase {

    private var mCount = 0

    override fun showData() {
        mCount++
        presenter.showData("Test data $mCount")
        if (mCount % 2 == 0) {
            errorUseCase.showError("error")
        }
    }

}