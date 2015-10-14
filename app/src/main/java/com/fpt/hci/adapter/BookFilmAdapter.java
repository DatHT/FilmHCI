package com.fpt.hci.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fpt.hci.activity.R;
import com.fpt.hci.model.PlaceFilmBooking;

import java.util.List;

/**
 * Created by Daniel on 10/10/2015.
 */
public class BookFilmAdapter extends RecyclerView.Adapter<BookFilmAdapter.ViewHolder> {
    Context mContext;
    List<PlaceFilmBooking> list;

    public BookFilmAdapter(Context mContext, List<PlaceFilmBooking> data) {
        this.mContext = mContext;
        this.list = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_bookingfilm, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imBooking.setImageResource(R.drawable.timefilm);
        holder.tvCinema.setText(list.get(position).getCinemaName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imBooking;
        TextView tvCinema;

        public ViewHolder(View itemView) {
            super(itemView);
            imBooking = (ImageView) itemView.findViewById(R.id.book_photo_iv);
            tvCinema = (TextView) itemView.findViewById(R.id.book_cinema_tv);
        }
    }
}
