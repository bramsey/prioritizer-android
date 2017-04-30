package com.billiamram.prioritizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.billiamram.prioritizer.domain.Item;

import java.util.Set;

public class ItemSetDetailsActivity extends AppCompatActivity implements ItemSetDetailsPresenter.View {

    public static final String EXTRA_ITEM_SET_ID = "item_set_id";
    private ItemSetDetailsPresenter presenter = Module.provideItemSetDetailsPresenter();
    private TextView itemSetNameText;
    private ListView itemListView;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_set_details);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);

        itemListView = (ListView) findViewById(R.id.details_item_list);

        itemListView.setAdapter(adapter);

        itemSetNameText = (TextView) findViewById(R.id.details_item_set_name);
        String itemSetId = getIntent().getStringExtra(EXTRA_ITEM_SET_ID);

        presenter.viewLoaded(this, itemSetId);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.viewUnloaded(this);
    }

    @Override
    public void showItemSetName(String name) {
        itemSetNameText.setText(name);
    }

    @Override
    public void showItems(Set<Item> items) {
        adapter.clear();
        for (Item item : items) {
            adapter.add(item.label);
        }
        adapter.notifyDataSetChanged();
    }
}
