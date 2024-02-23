package com.example.unsplashapi.data.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ArrayAdapter;

import com.example.unsplashapi.data.util.RecentSearchConstant;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecentSearchHelper {

    private final SharedPreferences sharedPreferences;
    private final Gson gson;

    public RecentSearchHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(RecentSearchConstant.PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void saveData(ArrayList<String> list) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> set = new HashSet<>(list);
        editor.putStringSet(RecentSearchConstant.KEY_LIST, set);
        editor.apply();
    }

    public void loadData(ArrayList<String> dataList, ArrayAdapter<String> adapter) {
        Set<String> set = sharedPreferences.getStringSet(RecentSearchConstant.KEY_LIST, null);
        if (set != null) {
            dataList.clear();
            dataList.addAll(set);
            adapter.notifyDataSetChanged();
        }
    }

    public void addData(ArrayList<String> dataList, ArrayAdapter<String> adapter, String data) {
        dataList.add(data);
        adapter.notifyDataSetChanged();
        saveData(dataList);
    }

    public void updateData(ArrayList<String> dataList, ArrayAdapter<String> adapter, int position, String newData) {
        dataList.set(position, newData);
        adapter.notifyDataSetChanged();
        saveData(dataList);
    }

    public void deleteData(ArrayList<String> dataList, ArrayAdapter<String> adapter, int position) {
        dataList.remove(position);
        adapter.notifyDataSetChanged();
        saveData(dataList);
    }

    public void deleteAllData(ArrayAdapter<String> adapter) {
        adapter.clear();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        adapter.notifyDataSetChanged();
    }
}
