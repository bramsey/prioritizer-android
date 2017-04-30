package com.billiamram.prioritizer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.billiamram.prioritizer.domain.ItemSet;

import java.util.List;

public class ItemSetListActivity extends AppCompatActivity implements ItemSetListPresenter.View {

    private ItemSetListPresenter presenter = Module.provideItemSetListPresenter();
    private ArrayAdapter<String> adapter;
    private ListView itemSetListView;
    private android.content.Intent selectItemSetListIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_set_list);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        itemSetListView = (ListView) findViewById(R.id.item_set_list);

        itemSetListView.setAdapter(adapter);

        selectItemSetListIntent = new Intent(this, ItemSetDetailsActivity.class);

        itemSetListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.itemSetSelected(position);
            }
        });

        presenter.viewLoaded(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.viewUnloaded(this);
    }

    @Override
    public void showItemSets(List<ItemSet> itemSets) {
        adapter.clear();
        for (ItemSet itemSet : itemSets) {
            adapter.add(itemSet.name);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void navigateToItemSet(String itemSetId) {
        selectItemSetListIntent.putExtra(ItemSetDetailsActivity.EXTRA_ITEM_SET_ID, itemSetId);
        startActivity(selectItemSetListIntent);
    }
}
