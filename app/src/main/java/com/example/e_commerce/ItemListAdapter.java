package com.example.e_commerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ItemListAdapter extends ArrayAdapter<Item> {

    private List<Item> itemList;

    public ItemListAdapter(Context context, int resource, List<Item> itemList) {
        super(context, resource, itemList);
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item2_layout, parent, false);
        }

        Item item = itemList.get(position);

        TextView name = convertView.findViewById(R.id.name);
        TextView price = convertView.findViewById(R.id.price);
        CheckBox checkBox = convertView.findViewById(R.id.checkbox);

        name.setText(item.getName());
        checkBox.setChecked(item.isSelected());
        price.setText("$" + String.format("%.2f", item.getPrice()));


        return convertView;
    }
}