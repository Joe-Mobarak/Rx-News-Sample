package com.technology.joe.inmobileschallenge.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import com.technology.joe.inmobileschallenge.R
import com.technology.joe.inmobileschallenge.model.Article
import kotlinx.android.synthetic.main.fragment_news_details.*
import com.technology.joe.inmobileschallenge.util.Utils

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
        loadDetails()
    }

    private fun loadDetails() {
        title_text.text = article.title
        description_text.text = article.description
        content_text.text = article.content
        if (!TextUtils.isEmpty(article.urlToImage))
        Picasso.get().load(article.urlToImage).into(news_image)
        Utils.formatISODate(article.publishedAt)?.let {
            val authorDetails=article.author+" at : "+it.second+" on : "+it.first
            author_details.text=authorDetails
        }
    }
}
