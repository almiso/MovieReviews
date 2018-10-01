package org.almiso.nyt.moview.reviews.businesslayer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import org.almiso.nyt.moview.reviews.businesslayer.di.DaggerDependenciesInjector
import org.almiso.nyt.moview.reviews.businesslayer.di.DependenciesFactory
import org.almiso.nyt.moview.reviews.businesslayer.di.DependenciesInjector
import org.almiso.nyt.moview.reviews.presentationlayer.presenters.AbstractPresenter

abstract class AbstractFragment<T : AbstractPresenter> : Fragment() {
    /*
     * Fields
     */
    protected lateinit var mPresenter: T
    protected lateinit var mInjector: DependenciesInjector


    /*
     * Overrides
     */
    override fun onStart() {
        super.onStart()

        presenter().start()
    }

    override fun onStop() {
        super.onStop()

        presenter().stop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mInjector = DaggerDependenciesInjector.builder().dependenciesFactory(DependenciesFactory()).build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter().setView()
    }


    /*
     * Protected methods
     */
    protected fun setPresenter(presenter: T) {
        mPresenter = presenter
    }

    protected fun injector() = mInjector

    protected open fun presenter() = mPresenter
}
