package com.example.genakuchergin.clarcproto.domain.usecases

import com.example.genakuchergin.clarcproto.domain.interfaces.presenters.IMainPresenter
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IMainUseCase

class MainUseCase(private val presenter: IMainPresenter): IMainUseCase {

    private var mCount = 0

    override fun showData() {
        mCount++
        presenter.showData("Test data $mCount")
    }

}