package br.com.renan.appmix.lab14.app.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.renan.appmix.lab14.domain.model.Hotel;

public class HotelListFragment extends ListFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<Hotel> model;
        model = new ArrayList<>();
        model.add(new Hotel("A", "AA", 5f));
        model.add(new Hotel("B", "BB", 6f));
        model.add(new Hotel("C", "CC", 7f));
        model.add(new Hotel("D", "DD", 8f));
        model.add(new Hotel("E", "EE", 3.6f));

        setListAdapter(new ArrayAdapter<Hotel>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                model));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.i("LAB", "item clicado...");
    }
}
