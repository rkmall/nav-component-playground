package com.rm.android_navigation.utils

import androidx.appcompat.app.AppCompatActivity


fun hideToolBar(activity: AppCompatActivity) {
    activity.supportActionBar?.hide()
}

fun hideActionBar(activity: AppCompatActivity) {
    activity.actionBar?.hide()
}