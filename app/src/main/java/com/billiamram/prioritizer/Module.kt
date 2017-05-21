package com.billiamram.prioritizer

object Module {
    private var itemSetListPresenter: ItemSetListPresenter? = null
    private var itemSetDetailsPresenter: ItemSetDetailsPresenter? = null
    private val itemSetRepository = DemoItemSetRepository()

    fun provideItemSetListPresenter(): ItemSetListPresenter {
        itemSetListPresenter = itemSetListPresenter ?: ItemSetListPresenter(itemSetRepository)
        return itemSetListPresenter!!
    }

    fun provideItemSetDetailsPresenter(): ItemSetDetailsPresenter {
        itemSetDetailsPresenter = itemSetDetailsPresenter ?: ItemSetDetailsPresenter(itemSetRepository)
        return itemSetDetailsPresenter!!
    }
}
