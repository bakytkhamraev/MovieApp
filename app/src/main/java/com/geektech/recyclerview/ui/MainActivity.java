package com.geektech.recyclerview.ui;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.recyclerview.presenter.MovieAdapter;
import com.geektech.recyclerview.presenter.MovieTask;
import com.geektech.recyclerview.OnItemClickListener;
import com.geektech.recyclerview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter adapter;
    private ArrayList<MovieTask> movieDes = new ArrayList<>();
    RecyclerView recyclerView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_movie);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MovieAdapter(movieDes);
        recyclerView.setAdapter(adapter);
        adapter.setInBookClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClickListener(int pos) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("pos", movieDes.get(pos));
                MovieDescFragment fragment = new MovieDescFragment();
                fragment.setArguments(bundle);
                Log.d("ololo", "ololo");
                getSupportFragmentManager().beginTransaction().add(R.id.frame_movie, fragment).addToBackStack(null).commit();
                recyclerView.setVisibility(View.INVISIBLE);
            }
        });

        toolbar();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void toolbar() {

        ArrayList<View> textViews = new ArrayList<>();

            getWindow().getDecorView().findViewsWithText(textViews, getTitle(), View.FIND_VIEWS_WITH_TEXT);

            if (textViews.size() > 0) {
                AppCompatTextView appCompatTextView = null;
                if (textViews.size() == 1) {
                    appCompatTextView = (AppCompatTextView) textViews.get(0);
                } else {
                    for (View v : textViews) {
                        if (v.getParent() instanceof Toolbar) {
                            appCompatTextView = (AppCompatTextView) v;
                            break;
                        }
                    }
                }

                if (appCompatTextView != null) {
                    ViewGroup.LayoutParams params = appCompatTextView.getLayoutParams();
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    appCompatTextView.setLayoutParams(params);
                    appCompatTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                }
            }
        }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        recyclerView.setVisibility(View.VISIBLE);
    }
}