package com.hyperjar.philip.arnold.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hyperjar.philip.arnold.data.ItemData

object LoadData {
    fun GetData(context: Context): ItemData {
        val json = FileReader.ReadFromAssets(context.getAssets(), "raw_json.json")
        val token = object : TypeToken<ItemData>() {}.type
        var items: ItemData = Gson().fromJson(json, token)
        return items
    }
}