package com.technology.joe.inmobileschallenge.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.technology.joe.inmobileschallenge.R
import data.model.Article
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ConfirmExitFragment.IConfirmExit {

    override fun onExitBroadcastConfirmed() {
        finish()
    }

    private val newsFragment = NewsFragment()

    enum class FragmentTypes {
        NEWS,
        NEWS_DETAILS
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolBar)
        addFragment(FragmentTypes.NEWS, null)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val confirmExitFragment = ConfirmExitFragment()
        confirmExitFragment.show(supportFragmentManager, "ss")
        confirmExitFragment.setCallback(this)
        return super.onOptionsItemSelected(item)
    }

    fun addFragment(type: FragmentTypes, article: Article?) {
        if (type == FragmentTypes.NEWS) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    newsFragment
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

    override fun onBackPressed() {
        super.onBackPressed()
        if (!newsFragment.isVisible)
            finish()
    }
}
