package com.example.testtaskbooksearch

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskbooksearch.adapter.SearchAdapter
import com.example.testtaskbooksearch.search_books.SearchApp
import com.example.testtaskbooksearch.search_books.SearchListViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchFragment : Fragment(R.layout.fragment_search) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchListViewModel = ViewModelProvider(this)[SearchListViewModel::class.java]
        val editText = view.findViewById<EditText>(R.id.editText)
        val recyclerViewSearch = view.findViewById<RecyclerView>(R.id.recyclerSearch)
        recyclerViewSearch.layoutManager = LinearLayoutManager(activity)

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            @SuppressLint("CheckResult")
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchListViewModel.fetchSearchList((requireActivity().application as SearchApp).searchApi, title = s.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        recyclerViewSearch?.adapter = SearchAdapter(ArrayList(it.items))
                    }, { error ->
                        Log.e(SearchFragment::class.simpleName, "Error", error)
                    })
            }

        })

        }
    }


