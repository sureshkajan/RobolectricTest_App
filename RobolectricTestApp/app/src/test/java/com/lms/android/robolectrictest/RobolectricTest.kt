package com.lms.android.robolectrictest

import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RobolectricTest {

    @Test
    fun check_second_activity_text() {
        val activity = Robolectric.buildActivity(SecondActivity::class.java).create().get()
        val textView : TextView = activity.findViewById<TextView>(R.id.textView)
        assertEquals("Hello world!", textView.text)
    }

    @Test
    fun check_first_fragment_text(){
        val fragment = FirstFragment()
        val activity = Robolectric.buildActivity(
            MainActivity::class.java
        )
            .create()
            .start()
            .resume()
            .get()

        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment, null)
        fragmentTransaction.commit()

        val textView : TextView = activity.findViewById<TextView>(R.id.textview_first)
        assertEquals("Hello first fragment", textView.text)
    }
}