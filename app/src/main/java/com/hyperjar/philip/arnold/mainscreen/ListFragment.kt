package com.hyperjar.philip.arnold.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.hyperjar.philip.arnold.data.ItemData
import com.hyperjar.philip.arnold.mainscreen.recycler.ListAdapter
import com.hyperjar.philip.arnold.utils.FileReader
import kotlinx.android.synthetic.main.fragment_list.*
import com.google.gson.reflect.TypeToken
import com.hyperjar.philip.arnold.R
import com.hyperjar.philip.arnold.utils.LoadData

class ListFragment(val mainActivityInterface: MainActivityInterface): Fragment() {
    companion object {
        fun newInstance(mainActivityInterface: MainActivityInterface): ListFragment {
            return ListFragment(mainActivityInterface)
        }
    }

    var items: ItemData? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler.layoutManager = LinearLayoutManager(context)

        LoadDataFromAssets()
    }

    fun LoadDataFromAssets() {
        items = LoadData.GetData(context!!)
        mainActivityInterface.SetToolbarTitle(String.format("%s %s", items?.legalProfile?.givenName, items?.legalProfile?.familyName))
        recycler.adapter = ListAdapter(items!!, mainActivityInterface)
    }
}