package com.technology.joe.inmobileschallenge.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.technology.joe.inmobileschallenge.R
import com.technology.joe.inmobileschallenge.ui.dialog.ConfirmExitDialog
import com.technology.joe.inmobileschallenge.ui.fragment.NewsDetailsFragment
import com.technology.joe.inmobileschallenge.ui.fragment.NewsListFragment
import data.model.Article
import kotlinx.android.synthetic.main.activity_main.*

class NewsActivity : AppCompatActivity(), ConfirmExitDialog.IConfirmExit {

    override fun onExitBroadcastConfirmed() {
        finish()
    }

    private val newsFragment = NewsListFragment()

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
        val confirmExitFragment =
            ConfirmExitDialog()
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
