package com.example.genakuchergin.clarcproto.domain.usecases

import com.example.genakuchergin.clarcproto.domain.interfaces.presenters.IProgressPresenter
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IProgressUseCase

class ProgressUseCase(private val presenter: IProgressPresenter): IProgressUseCase {
    override fun forceRefresh() {
        for (i in 0..100 step 10) {
            presenter.updateProgress(i)
            Thread.sleep(100)
        }
        presenter.hideProgress()
    }
    override fun showProgress(value: Int) {
        presenter.updateProgress(value)
    }
    override fun hideProgress() {
        presenter.hideProgress()
    }
}