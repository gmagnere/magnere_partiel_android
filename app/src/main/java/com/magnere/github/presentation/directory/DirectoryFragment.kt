package com.magnere.github.presentation.directory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.magnere.github.R
import com.magnere.github.domain.model.UserDetail

class DirectoryFragment : Fragment() {

    companion object {
        private const val KEY_ID = "key_id"

        fun newInstance(id: String): DirectoryFragment {
            val bundle = Bundle()
            bundle.putString(KEY_ID, id)

            val fragment = DirectoryFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

    private lateinit var number: TextView
    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var langage: TextView
    private lateinit var forks: TextView
    private lateinit var watchers: TextView
    private lateinit var licence: TextView

    private val viewModel: DirectoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_directory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        number = view.findViewById(R.id.fragment_directory_number)
        name = view.findViewById(R.id.fragment_directory_name)
        description = view.findViewById(R.id.fragment_directory_description)
        langage = view.findViewById(R.id.fragment_directory_langage)
        forks = view.findViewById(R.id.fragment_directory_forks)
        watchers = view.findViewById(R.id.fragment_directory_watchers)
        licence = view.findViewById(R.id.fragment_directory_licence)

        viewModel.data.observe(viewLifecycleOwner, ::onStateChanged)

        arguments?.getString(KEY_ID)?.let {
            viewModel.getUserDetail(it)
        }
    }

    private fun onStateChanged(userDetail: UserDetail) {
        name.text = userDetail.login
        description.text = userDetail.description
        langage.text = userDetail.langage
        forks.text = userDetail.forks
        watchers.text = userDetail.watchers
        licence.text = userDetail.licence
        number.text = userDetail.total_count

    }
}