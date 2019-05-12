package com.zxn.qqlivebubble;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zxn.xmbubbleview.BubbleView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BubbleView bubbleView;
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSystemView();

        bubbleView = (BubbleView) findViewById(R.id.BubbleView);
        List<Drawable> drawableList = new ArrayList<>();
        drawableList.add(getResources().getDrawable(R.drawable.ic_heart_balloon_a));
        drawableList.add(getResources().getDrawable(R.drawable.ic_heart_balloon_b));
        drawableList.add(getResources().getDrawable(R.drawable.ic_heart_balloon_c));
        drawableList.add(getResources().getDrawable(R.drawable.ic_heart_balloon_d));
        drawableList.add(getResources().getDrawable(R.drawable.ic_heart_balloon_e));
        drawableList.add(getResources().getDrawable(R.drawable.ic_heart_balloon_f));
        drawableList.add(getResources().getDrawable(R.drawable.ic_heart_balloon_h));
        drawableList.add(getResources().getDrawable(R.drawable.ic_heart_balloon_i));
        drawableList.add(getResources().getDrawable(R.drawable.ic_heart_balloon_j));
//        drawableList.add(getResources().getDrawable(R.drawable.ic_heart_balloon_k));

        /*Drawable drawable = getResources().getDrawable(R.drawable.ic_three_ball);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        bubbleView.setGiftBoxImage(drawable, bubbleView.getWidth() / 2, bubbleView.getHeight() / 2);*/

        bubbleView.setDrawableList(drawableList)
                .setAnimationDelay(200)
                .setRiseDuration(7 * 1000)
                .setMinHeartNum(10)
                .setItemViewWH(getResources().getDimensionPixelOffset(R.dimen.dp_60), getResources().getDimensionPixelOffset(R.dimen.dp_120))
                .setScaleAnimation(2, 1);

    }

    private void initSystemView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bubbleView.startAnimation(bubbleView.getWidth(), bubbleView.getHeight());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
