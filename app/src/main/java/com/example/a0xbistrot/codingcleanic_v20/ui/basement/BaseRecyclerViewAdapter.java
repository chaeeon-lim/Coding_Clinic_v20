package com.example.a0xbistrot.codingcleanic_v20.ui.basement;

import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerViewAdapter extends RecyclerView.Adapter<BaseViewHolder>{

    protected List<Object> itemList = new ArrayList<>();

    public void addAll(List<?> items){
        this.itemList.addAll(items);
        notifyDataSetChanged();
    }

    protected abstract BaseViewHolder getViewHolder(int viewType, ViewGroup parent);

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getViewHolder(viewType, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
