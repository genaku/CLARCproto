package com.example.genakuchergin.clarcproto.domain.interfaces.presenters

interface IProgressPresenter {
    fun updateProgress(data: Int)
    fun hideProgress()
}