package com.example.genakuchergin.clarcproto.presenters

import com.example.genakuchergin.clarcproto.domain.interfaces.presenters.IMainPresenter
import com.example.genakuchergin.clarcproto.presenters.interfaces.IMainViewModel

class MainPresenter(private val viewModel: IMainViewModel): IMainPresenter {
    override fun showData(data: String) {
        viewModel.showData(data)
    }
}