package com.billiamram.prioritizer

import com.billiamram.prioritizer.domain.Item
import com.billiamram.prioritizer.domain.ItemSet
import com.billiamram.prioritizer.domain.ItemSetRepository
import java.util.*

class DemoItemSetRepository : ItemSetRepository {
    private val itemSets: MutableList<ItemSet>

    init {
        this.itemSets = ArrayList<ItemSet>()
        (0..9).mapTo(itemSets) { i ->
            ItemSet(
                    id = i.toString(),
                    name = "Set " + i,
                    items = (0..14)
                            .map { "label " + it }
                            .map(::Item)
                            .toSet()
            )
        }
    }

    override fun findAll(): List<ItemSet> = itemSets

    override fun findById(id: String): ItemSet? = itemSets.find { it.id == id }
}
