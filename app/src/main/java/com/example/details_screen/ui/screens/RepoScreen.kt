package com.example.details_screen.ui.screens

import androidx.annotation.StringRes
import com.example.details_screen.R

enum class RepoScreen(@StringRes val title: Int) {
    HOME(title = R.string.home),
    DETAILS(title = R.string.details)
}