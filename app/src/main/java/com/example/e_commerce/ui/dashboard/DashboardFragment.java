package com.example.e_commerce.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.e_commerce.Item;
import com.example.e_commerce.ItemListAdapter;
import com.example.e_commerce.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    List<Item> itemList;
    ListView listView;
    TextView total;
    Button checkout;
    ItemListAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);


        itemList = new ArrayList<Item>();
        itemList.add(new Item("Item 1", 10.99));
        itemList.add(new Item("Item 2", 15.99));
        itemList.add(new Item("Item 3", 5.99));

        listView = view.findViewById(R.id.listView);
        total = view.findViewById(R.id.total);
        checkout = view.findViewById(R.id.checkout);

        adapter = new ItemListAdapter(getActivity(), R.layout.item2_layout, itemList);
        listView.setAdapter(adapter);

        // Update total amount on item selection
        listView.setOnItemClickListener((adapterView, view1, i, l) -> {
            Item item = itemList.get(i);
            item.setSelected(!item.isSelected());
            adapter.notifyDataSetChanged();
            updateTotalAmount();
        });

        // Checkout button click listener
        checkout.setOnClickListener(view1 -> Toast.makeText(getActivity(), "Checkout clicked", Toast.LENGTH_SHORT).show());

        updateTotalAmount();

        return view;
    }
    // Update total amount based on selected items
    private void updateTotalAmount() {
        double totalAmount = 0.0;
        for (Item item: itemList) {
            if (item.isSelected()) {
                totalAmount += item.getPrice();
            }
        }
        total.setText("Total: $" + String.format("%.2f", totalAmount));
    }


}
