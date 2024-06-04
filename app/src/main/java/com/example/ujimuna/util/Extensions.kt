package com.example.ujimuna.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()

fun Fragment.addFragment(fragment: Fragment, frameId: Int) {
    fragmentManager?.inTransaction { add(frameId, fragment) }
}

fun Fragment.replaceFragment(fragment: Fragment, frameId: Int) {
    fragmentManager?.inTransaction { replace(frameId, fragment) }
}