package com.fpt.hci.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.support.v4.util.Pair;

import com.fpt.hci.activity.DetailActivity;
import com.fpt.hci.activity.R;
import com.fpt.hci.adapter.ListFilmAdapter;
import com.fpt.hci.adapter.ViewPageAdapter;
import com.fpt.hci.slidingtab.SlidingTabLayout;

/**
 * Created by Daniel on 9/24/2015.
 */
public class TabFilm extends Fragment {
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private ListFilmAdapter filmAdapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_film, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.listFilm);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        filmAdapter = new ListFilmAdapter(getActivity());
        mRecyclerView.setAdapter(filmAdapter);
        ListFilmAdapter.OnItemClickListener onItemClickListener = new ListFilmAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(getActivity(), "Click " + position, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_PARAM_ID, position);
                ImageView placeImage = (ImageView) view.findViewById(R.id.placeImage);
                LinearLayout placeHoldername = (LinearLayout) view.findViewById(R.id.placeNameHolder);
                Pair<View, String > imagePair = Pair.create((View) placeImage, "tImage");
                Pair<View, String> holderPair = Pair.create((View) placeHoldername, "tNameHolder");
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                        imagePair, holderPair);
                ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
            }
        };
        filmAdapter.setOnItemClickListener(onItemClickListener);
        return v;
    }
}
