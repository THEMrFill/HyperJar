package com.hyperjar.philip.arnold.utils

import android.content.res.AssetManager
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object FileReader {
    fun ReadFromAssets(assets: AssetManager, fileName: String): String {
        var string: String = ""
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(
                        InputStreamReader(assets.open(fileName), "UTF-8")
            );

            // do reading, usually loop until end of file reading
            while (true) {
                val mLine = reader.readLine()
                if (mLine == null) {
                    break
                }
                string += mLine
            }
        } catch (e: IOException) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (e: IOException) {
                    //log the exception
                }
            }
        }
        return string
    }
}