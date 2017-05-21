package com.billiamram.prioritizer.domain

interface ItemSetRepository {
    fun findAll(): List<ItemSet>

    fun findById(id: String): ItemSet?
}
