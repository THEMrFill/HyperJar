package com.hyperjar.philip.arnold.mainscreen

import androidx.fragment.app.Fragment

interface MainActivityInterface {
    fun PushToFragment(fragment: Fragment, addToStack: Boolean = false)
    fun SetToolbarTitle(title: String)
}