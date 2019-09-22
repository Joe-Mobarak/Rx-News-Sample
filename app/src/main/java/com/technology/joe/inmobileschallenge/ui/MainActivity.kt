package com.technology.joe.inmobileschallenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.technology.joe.inmobileschallenge.R
import data.model.Article

class MainActivity : AppCompatActivity() {

    enum class FragmentTypes {
        NEWS,
        NEWS_DETAILS
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(FragmentTypes.NEWS, null)

    }

    fun addFragment(type: FragmentTypes, article: Article?) {
        if (type == FragmentTypes.NEWS) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    NewsFragment()
                )
                .addToBackStack("ss")
                .commit()
        } else {
            article?.let {
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        NewsDetailsFragment.newInstance(it)
                    )
                    .addToBackStack("ss")
                    .commit()

            }
        }
    }
}
