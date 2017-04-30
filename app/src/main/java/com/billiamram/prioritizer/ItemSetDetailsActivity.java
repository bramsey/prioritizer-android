package com.billiamram.prioritizer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ItemSetDetailsActivity extends AppCompatActivity implements ItemSetDetailsPresenter.View {

    public static final String EXTRA_ITEM_SET_ID = "item_set_id";
    private ItemSetDetailsPresenter presenter = Module.provideItemSetDetailsPresenter();
    private TextView itemSetNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_set_details);

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
}
