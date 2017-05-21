package com.billiamram.prioritizer

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

import com.billiamram.prioritizer.domain.ItemSet

class ItemSetListActivity : AppCompatActivity(), ItemSetListPresenter.View {

    private val presenter = Module.provideItemSetListPresenter()
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var itemSetListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_set_list)

        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        itemSetListView = findViewById(R.id.item_set_list) as ListView

        itemSetListView.adapter = adapter

        itemSetListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ -> presenter.itemSetSelected(position) }

        presenter.viewLoaded(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.viewUnloaded(this)
    }

    override fun showItemSets(itemSets: List<ItemSet>) {
        adapter.clear()
        itemSets.forEach { adapter.add(it.name) }
        adapter.notifyDataSetChanged()
    }

    override fun navigateToItemSet(itemSetId: String) {
        val selectItemSetListIntent = Intent(this, ItemSetDetailsActivity::class.java)
        selectItemSetListIntent.putExtra(ItemSetDetailsActivity.EXTRA_ITEM_SET_ID, itemSetId)
        startActivity(selectItemSetListIntent)
    }
}
