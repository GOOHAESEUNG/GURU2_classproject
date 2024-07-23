package com.example.mygallery

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private val items = ArrayList<Fragment>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }

    fun updateFragments(items: List<Fragment>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}
