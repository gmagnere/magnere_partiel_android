package com.magnere.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.magnere.github.presentation.directory.DirectoryFragment
import com.magnere.github.presentation.search.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.activity_main_container_1, SearchFragment.newInstance())
            }
        }
    }

    fun displayUserDetail(id: String) {
        if (findViewById<FragmentContainerView>(R.id.activity_main_container_2) != null) {
            supportFragmentManager.commit {
                add(R.id.activity_main_container_2, DirectoryFragment.newInstance(id))
            }
        } else {
            supportFragmentManager.commit {
                replace(R.id.activity_main_container_1, DirectoryFragment.newInstance(id))
                addToBackStack(null)
            }
        }
    }
}