package com.billiamram.prioritizer

import com.billiamram.prioritizer.domain.ItemSet
import com.billiamram.prioritizer.domain.ItemSetRepository

class ItemSetListPresenter(private val itemSetRepository: ItemSetRepository) {
    private var mView: View? = null
    private var itemSets: List<ItemSet>? = null

    fun viewLoaded(view: View) {
        mView = view
        itemSets = itemSetRepository.findAll()
        itemSets?.let { mView?.showItemSets(it) }
    }

    fun viewUnloaded(view: View) {
        if (mView === view) mView = null
    }

    fun itemSetSelected(index: Int) {
        itemSets?.let { mView?.navigateToItemSet(it[index].id) }
    }

    interface View {
        fun showItemSets(itemSets: List<ItemSet>)

        fun navigateToItemSet(itemSetId: String)
    }
}
