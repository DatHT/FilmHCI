package com.fpt.hci.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.fpt.hci.adapter.BookFilmAdapter;
import com.fpt.hci.model.PlaceFilmBooking;

/**
 * Created by Daniel on 10/8/2015.
 */
public class BookFilmActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager manager;
    private BookFilmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookfilm_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.book_list_rv);
        manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        PlaceFilmBooking data = new PlaceFilmBooking("aa");
        adapter = new BookFilmAdapter(getBaseContext(), data.initialData());
        mRecyclerView.setAdapter(adapter);
    }
}
