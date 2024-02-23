package com.example.unsplashapi.presentation.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unsplashapi.R;
import com.example.unsplashapi.data.helper.RecentSearchHelper;
import com.example.unsplashapi.presentation.searchphotoresult.SearchResultActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchFragment extends Fragment {

    private RecentSearchHelper recentSearchHelper;
    private ArrayList<String> dataList;
    private ArrayAdapter<String> adapter;
    private ImageView delete;
    public SearchFragment() {
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recentSearchHelper = new RecentSearchHelper(getContext());
        EditText searchField = view.findViewById(R.id.searchField);
        TextView textTags = view.findViewById(R.id.textTags);
        TextView textClear = view.findViewById(R.id.textClear);
        ListView listView = view.findViewById(R.id.listView);

        dataList = new ArrayList<>();
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, dataList);
        recentSearchHelper.loadData(dataList, adapter);
        textClear.setVisibility(adapter != null ? View.VISIBLE : View.GONE);
        textTags.setText(dataList != null ? R.string.recent_searches : R.string.no_recent_searches);
        searchField.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                // If successful
                // Open SearchResultActivity then save to recent search
                Intent i = new Intent(getContext(), SearchResultActivity.class);
                Bundle bundle = new Bundle();
                recentSearchHelper.addData(dataList,adapter, String.valueOf(searchField.getText()));
                bundle.putString("id", searchField.getText().toString());
                i.putExtras(bundle);
                getContext().startActivity(i);
                searchField.setText(null);
                return true;
            }
            return false;
        });
        listView.setAdapter(adapter);

        textClear.setOnClickListener(view1 -> {
            recentSearchHelper.deleteAllData(adapter);
            textClear.setVisibility(View.GONE);
        });

        return view;
    }
}