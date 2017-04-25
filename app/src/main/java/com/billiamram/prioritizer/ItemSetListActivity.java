package com.billiamram.prioritizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.billiamram.prioritizer.domain.ItemSet;

import java.util.List;

public class ItemSetListActivity extends AppCompatActivity implements ItemSetListPresenter.View {

    private ItemSetListPresenter presenter = Module.provideItemSetPresenter();
    private ArrayAdapter<String> adapter;
    private ListView itemSetListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_set_list);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        itemSetListView = (ListView) findViewById(R.id.item_set_list);

        itemSetListView.setAdapter(adapter);

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
}
