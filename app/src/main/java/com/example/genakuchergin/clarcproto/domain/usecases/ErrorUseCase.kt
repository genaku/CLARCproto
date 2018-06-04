package com.example.genakuchergin.clarcproto.domain.usecases

import com.example.genakuchergin.clarcproto.domain.interfaces.presenters.IErrorPresenter
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IErrorUseCase

class ErrorUseCase(private val presenter: IErrorPresenter): IErrorUseCase {

    private var mCount = 0

    override fun showError(error: String) {
        mCount++
        presenter.showError("$error $mCount")
    }
}