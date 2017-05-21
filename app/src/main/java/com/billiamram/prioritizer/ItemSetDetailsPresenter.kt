package com.billiamram.prioritizer

import com.billiamram.prioritizer.domain.Item
import com.billiamram.prioritizer.domain.ItemSet
import com.billiamram.prioritizer.domain.ItemSetRepository

class ItemSetDetailsPresenter(private val itemSetRepository: ItemSetRepository) {

    private var mView: View? = null
    private var mItemSet: ItemSet? = null

    fun viewLoaded(view: View, itemSetId: String) {
        mView = view
        mItemSet = itemSetRepository.findById(itemSetId)
        mItemSet?.let {
            mView?.showItemSetName(it.name)
            mView?.showItems(it.items)
        }
    }

    fun viewUnloaded(view: View) {
        if (mView === view) mView = null
    }

    interface View {
        fun showItemSetName(name: String)

        fun showItems(items: Set<Item>)
    }
}
