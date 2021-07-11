package com.example.screeningtest1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class Screen3 extends AppCompatActivity implements View.OnClickListener {
    private List<EventModel> eventList = new ArrayList<>();
    ViewPager viewPager;
    public static final String ex_nama="ex_nama";
    public static final String ex_guest="ex_guest";
    ImageButton maps;
    private String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
    Screen3Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);
        maps = findViewById(R.id.map);
        maps.setOnClickListener(this);
        viewPager = findViewById(R.id.viewpager);
        fillRecyclerList();
        RecyclerView recyclerView = findViewById(R.id.recycler_screen3);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(this);
        adapter = new Screen3Adapter(eventList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setOnItemClickCallback(data -> {
            String nama = getIntent().getStringExtra(ex_nama);
            String guest = getIntent().getStringExtra(ex_guest);
            String event = data.getNama();
            Intent moveback = new Intent(Screen3.this,Screen2.class);
            moveback.putExtra(Screen2.ex_nama,nama);
            moveback.putExtra(Screen2.ex_guest,guest);
            moveback.putExtra(Screen2.ex_event,event);
            finishAffinity();
            finish();
            startActivity(moveback);
        });
    }


    private void fillRecyclerList() {
        EventModel ev1 = new EventModel("Lets Success Make the Noise","Nov 09 2014",loremIpsum,R.drawable.andi);
        EventModel ev2 = new EventModel("Semangat Tahun Baru","Oct 21 2014",loremIpsum,R.drawable.dede);
        EventModel ev3 = new EventModel("Work Hard in Smile","Jun 14 2014",loremIpsum,R.drawable.budi);
        EventModel ev4 = new EventModel("Another Message","Jul 09 2021",loremIpsum,R.drawable.charlie);
        eventList.add(ev1);
        eventList.add(ev2);
        eventList.add(ev3);
        eventList.add(ev4);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.map){
            ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(eventList,this);
            viewPager.setAdapter(pagerAdapter);
            viewPager.setVisibility(View.VISIBLE);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.framescreen3,new MapsFragment()).commit();
        }
    }
}