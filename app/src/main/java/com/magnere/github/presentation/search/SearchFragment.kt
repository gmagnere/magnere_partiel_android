package com.magnere.github.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.magnere.github.MainActivity
import com.magnere.github.R
import com.magnere.github.UserShortAdapter

class SearchFragment : Fragment(), UserShortAdapter.OnUserClickListener {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: UserShortAdapter

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText = view.findViewById(R.id.fragment_search_edittext)
        button = view.findViewById(R.id.fragment_search_button)
        recyclerView = view.findViewById(R.id.fragment_search_recyclerview)

        adapter = UserShortAdapter(requireContext(), this)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        button.setOnClickListener {
            viewModel.searchUser(editText.text.toString())
        }

        viewModel.state.observe(viewLifecycleOwner, ::onStateChanged)
    }

    private fun onStateChanged(state: SearchState) {
        when (state) {
            is SearchState.Loading -> {
                adapter.setUsers(null)
            }
            is SearchState.Success -> {
                adapter.setUsers(state.userShort)
            }
            is SearchState.Error -> {
                adapter.setUsers(null)

                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onUserClicked(id: String) {
        (activity as MainActivity).displayUserDetail(id)
    }
}