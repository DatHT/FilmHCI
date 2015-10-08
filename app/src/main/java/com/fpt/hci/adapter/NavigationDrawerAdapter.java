package com.fpt.hci.adapter;

/**
 * Created by Daniel on 9/22/2015.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fpt.hci.activity.R;
import com.fpt.hci.model.NavDrawerItem;

import java.util.Collections;
import java.util.List;

/**
 * this class use to adapter to render xml layout in RecycleViewer
 * This adapter class inflates nav_drawer_row.xml and renders the RecycleView drawer menu
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {

    List<NavDrawerItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(List<NavDrawerItem> data, Context context) {
        this.data = data;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void delete(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        NavDrawerItem current = data.get(position);
        holder.title.setText(current.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
