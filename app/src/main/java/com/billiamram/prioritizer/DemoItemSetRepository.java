package com.billiamram.prioritizer;

import com.billiamram.prioritizer.domain.ItemSet;
import com.billiamram.prioritizer.domain.ItemSetRepository;

import java.util.ArrayList;
import java.util.List;

public class DemoItemSetRepository implements ItemSetRepository {
    private List<ItemSet> itemSets;

    public DemoItemSetRepository() {
        this.itemSets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemSet itemSet = new ItemSet();
            itemSet.id = String.valueOf(i);
            itemSet.name = "Set " + i;
            itemSets.add(itemSet);
        }
    }

    @Override
    public List<ItemSet> findAll() {
        return itemSets;
    }

    @Override
    public ItemSet findById(String id) {
        for (ItemSet itemSet : itemSets) {
            if (itemSet.id.equals(id)) return itemSet;
        }
        return null;
    }
}
