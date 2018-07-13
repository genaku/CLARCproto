package com.example.genakuchergin.clarcproto.domain.usecases

import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IErrorUseCase
import com.example.genakuchergin.clarcproto.domain.interfaces.presenters.IMainPresenter
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IMainUseCase
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IProgressUseCase

class CompositeUseCase(
        private val presenter: IMainPresenter,
        private val errorUseCase: IErrorUseCase,
        private val progressUseCase: IProgressUseCase
): IMainUseCase {

    private var mCount = 0

    override fun showData() {
        for (i in 0..100 step 10) {
            progressUseCase.showProgress(i)
            Thread.sleep(100)
        }
        mCount++
        presenter.showData("Test data $mCount")
        progressUseCase.hideProgress()
        if (mCount % 2 == 0) {
            errorUseCase.showError("error")
        }
    }

}