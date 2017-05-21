package com.billiamram.prioritizer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

import com.billiamram.prioritizer.domain.Item

class ItemSetDetailsActivity : AppCompatActivity(), ItemSetDetailsPresenter.View {
    private val presenter = Module.provideItemSetDetailsPresenter()
    private lateinit var itemSetNameText: TextView
    private lateinit var itemListView: ListView
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_set_details)
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        itemListView = findViewById(R.id.details_item_list) as ListView

        itemListView.adapter = adapter

        itemSetNameText = findViewById(R.id.details_item_set_name) as TextView
        val itemSetId = intent.getStringExtra(EXTRA_ITEM_SET_ID)

        presenter.viewLoaded(this, itemSetId)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.viewUnloaded(this)
    }

    override fun showItemSetName(name: String) {
        itemSetNameText.text = name
    }

    override fun showItems(items: Set<Item>) {
        adapter.clear()
        items.forEach { (label) -> adapter.add(label) }
        adapter.notifyDataSetChanged()
    }

    companion object {
        val EXTRA_ITEM_SET_ID = "item_set_id"
    }
}
