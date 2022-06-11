package com.example.generic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public abstract class ListViewAdapter<T> extends ArrayAdapter<T> {

    Context context;
    List<T> list;
    int listResourceId;

    public ListViewAdapter(Context context, int listResourceId, List<T> list) {
        super(context, listResourceId, list);
        this.list = list;
        this.context = context;
        this.listResourceId = listResourceId;
    }

    abstract public void setupItemView(View parent, T item);

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(listResourceId, parent, false);
        T item = list.get(position);

        this.setupItemView(convertView, item);

        return convertView;
    }
}
