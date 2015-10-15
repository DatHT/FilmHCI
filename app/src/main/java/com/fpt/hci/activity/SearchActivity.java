package com.fpt.hci.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fpt.hci.adapter.ListFilmAdapter;

/**
 * Created by Daniel on 10/15/2015.
 */
public class SearchActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private ListFilmAdapter filmAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_film);
        mRecyclerView = (RecyclerView) findViewById(R.id.listFilm);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        filmAdapter = new ListFilmAdapter(SearchActivity.this);
        mRecyclerView.setAdapter(filmAdapter);
        ListFilmAdapter.OnItemClickListener onItemClickListener = new ListFilmAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(getActivity(), "Click " + position, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_PARAM_ID, position);
                ImageView placeImage = (ImageView) view.findViewById(R.id.placeImage);
                LinearLayout placeHoldername = (LinearLayout) view.findViewById(R.id.placeNameHolder);
                Pair<View, String > imagePair = Pair.create((View) placeImage, "tImage");
                Pair<View, String> holderPair = Pair.create((View) placeHoldername, "tNameHolder");
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(SearchActivity.this, imagePair, holderPair);
                ActivityCompat.startActivity(SearchActivity.this, intent, options.toBundle());
            }
        };
        filmAdapter.setOnItemClickListener(onItemClickListener);
    }
}
