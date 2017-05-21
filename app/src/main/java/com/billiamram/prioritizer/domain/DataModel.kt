package com.billiamram.prioritizer.domain

data class Item(val label: String)
data class ItemSet(val id: String, val name: String, val items: Set<Item>)

data class Comparison(val a: Item, val b: Item, val greater: Item)
data class Prioritization(val comparisons: List<Comparison>)
