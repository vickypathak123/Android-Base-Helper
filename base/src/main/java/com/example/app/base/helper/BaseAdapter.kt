package com.example.app.base.helper

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

@Suppress("unused")
abstract class BaseAdapter<T>(var mList: MutableList<T>): RecyclerView.Adapter<BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return onCreateHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        if (position >= 0) {
            onBindHolder(holder, position)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    abstract fun onCreateHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*>

    abstract fun onBindHolder(holder: BaseViewHolder<*>, position: Int)

    @SuppressLint("NotifyDataSetChanged")
    open fun addAllItems(mLists: Collection<T>) {
        mList.removeAll(mList)
        mList.clear()
        mList.addAll(mLists)
        notifyDataSetChanged()
    }

    open fun addItem(mLists: T) {
        mList.add(mLists)
        notifyItemInserted(mList.size)
    }

    open fun removeItem(position: Int) {
        mList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, itemCount)
    }

    @SuppressLint("NotifyDataSetChanged")
    open fun clearList() {
        mList.clear()
        notifyDataSetChanged()
    }
}