package com.example.genakuchergin.clarcproto.presenters

import com.example.genakuchergin.clarcproto.domain.interfaces.presenters.IErrorPresenter
import com.example.genakuchergin.clarcproto.presenters.interfaces.IErrorViewModel

class ErrorPresenter(private val viewModel: IErrorViewModel): IErrorPresenter {
    override fun showError(error: String) {
        viewModel.showError(error)
    }
}