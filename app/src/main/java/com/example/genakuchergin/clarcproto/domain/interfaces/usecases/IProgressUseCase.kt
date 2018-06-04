package com.example.genakuchergin.clarcproto.domain.interfaces.usecases

interface IProgressUseCase {
    fun forceRefresh()
    fun showProgress(value: Int)
    fun hideProgress()
}