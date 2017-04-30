package com.billiamram.prioritizer;

import com.billiamram.prioritizer.domain.Item;
import com.billiamram.prioritizer.domain.ItemSet;
import com.billiamram.prioritizer.domain.ItemSetRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DemoItemSetRepository implements ItemSetRepository {
    private List<ItemSet> itemSets;

    public DemoItemSetRepository() {
        this.itemSets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemSet itemSet = new ItemSet();
            itemSet.id = String.valueOf(i);
            itemSet.name = "Set " + i;
            Set<Item> set = new HashSet<>();
            itemSet.items = set;
            for (int j = 0; j < 15; j++) {
                Item item = new Item();
                item.label = "label " + j;
                set.add(item);
            }

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
