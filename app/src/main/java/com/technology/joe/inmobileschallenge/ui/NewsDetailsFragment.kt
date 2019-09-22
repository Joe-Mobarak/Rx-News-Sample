package com.technology.joe.inmobileschallenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.technology.joe.inmobileschallenge.R
import data.model.Article

class NewsDetailsFragment : Fragment() {

    private lateinit var article: Article

    companion object {
        fun newInstance(article: Article) = NewsDetailsFragment().putArgs {
            putSerializable("storeDetail", article)
        }

        private inline fun <FRAGMENT : Fragment> FRAGMENT.putArgs(argsBuilder: Bundle.() -> Unit): FRAGMENT =
            this.apply { arguments = Bundle().apply(argsBuilder) }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        article = (arguments?.getSerializable("storeDetail") as? Article)!!
    }

}
