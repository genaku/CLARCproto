package com.example.genakuchergin.clarcproto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.genakuchergin.clarcproto.domain.interfaces.interactors.IMainInteractor
import com.example.genakuchergin.clarcproto.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    protected var mInteractor: IMainInteractor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModels()
        setupIU()
    }

    protected open fun setupViewModels() {
        val mainViewModel = getViewModel {
            MainViewModel(application)
        }.apply {
            someData.setObserver(this@MainActivity, { value ->
                updateData(value)
            })
        }
        mInteractor = mainViewModel.interactor
    }

    protected fun updateData(value: String?) {
        value?.apply {
            tvText.text = value
        }
    }

    protected open fun setupIU() {
        btnMain.setOnClickListener{
            mInteractor?.showData()
        }
    }

}
