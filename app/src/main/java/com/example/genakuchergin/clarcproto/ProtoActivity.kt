package com.example.genakuchergin.clarcproto

import android.os.Bundle
import com.example.genakuchergin.clarcproto.activitydelegate.*
import com.example.genakuchergin.clarcproto.activitydelegate.delegates.ErrorActivityDelegate
import com.example.genakuchergin.clarcproto.activitydelegate.delegates.ProgressActivityDelegate
import com.example.genakuchergin.clarcproto.activitydelegate.interfaces.IActivityDelegatesHolder
import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IMainInteractor
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IErrorUseCase
import com.example.genakuchergin.clarcproto.domain.interfaces.usecases.IProgressUseCase
import com.example.genakuchergin.clarcproto.viewmodel.CompositeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class ProtoActivity : CompositeActivity(R.layout.activity_main) {

    private lateinit var mInteractor: IMainInteractor

    private lateinit var mErrorActivityDelegate: ErrorActivityDelegate
    private lateinit var mProgressActivityDelegate: ProgressActivityDelegate

    private val errorUseCase: IErrorUseCase
        get() = mErrorActivityDelegate.useCase

    private val progressUseCase: IProgressUseCase
        get() = mProgressActivityDelegate.useCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainViewModel = getViewModel {
            CompositeViewModel(
                    application,
                    errorUseCase,
                    progressUseCase
            )
        }.apply {
            someData.observeWith(::updateData)
        }
        mInteractor = mainViewModel.interactor
        setupIU()
    }

    override fun createDelegatesHolder(): IActivityDelegatesHolder {
        mErrorActivityDelegate = ErrorActivityDelegate(application)
        mProgressActivityDelegate = ProgressActivityDelegate(application)
        return DelegatesHolder.Builder()
                .add(mErrorActivityDelegate)
                .add(mProgressActivityDelegate)
                .build()
    }

    private fun updateData(value: String) {
        tvText.text = value
    }

    private fun setupIU() {
        btnMain.setOnClickListener {
            mInteractor.showData()
        }
    }

}