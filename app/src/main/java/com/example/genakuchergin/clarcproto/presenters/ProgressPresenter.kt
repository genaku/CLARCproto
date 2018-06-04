package com.example.genakuchergin.clarcproto.presenters

import com.example.genakuchergin.clarcproto.domain.interfaces.presenters.IProgressPresenter
import com.example.genakuchergin.clarcproto.presenters.interfaces.IProgressViewModel

class ProgressPresenter(private val viewModel: IProgressViewModel) : IProgressPresenter {

    override fun updateProgress(data: Int) =
            viewModel.updateProgress(data)

    override fun hideProgress() =
            viewModel.hideProgress()

}