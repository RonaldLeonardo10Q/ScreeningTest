package com.example.screeningtest1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.widget.Toast;


public class Screen4 extends AppCompatActivity {
    public static final String ex_nama="ex_nama";
    public static final String ex_event="ex_event";
    Screen4Adapter screen4Adapter;
    String[] id = {"1","2","3","4","5"};
    String[] nama = {"andi","budi","charlie","dede","joko"};
    String[] birthdate = {"2014-01-01","2014-02-02","2014-03-03","2014-06-06","2014-02-12"};
    int[] images = {R.drawable.andi,R.drawable.budi,R.drawable.charlie,R.drawable.dede,R.drawable.joko};
    String prime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
        });
        RecyclerView recyclerView = findViewById(R.id.recycler_screen4);
        recyclerView.setHasFixedSize(true);
        screen4Adapter = new Screen4Adapter(id,nama,birthdate,images);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(screen4Adapter);
        screen4Adapter.setOnItemClickCallback((nama1, tgl_lahir) -> {
            String nama = getIntent().getStringExtra(ex_nama);
            String event = getIntent().getStringExtra(ex_event);
            int date = Integer.parseInt(tgl_lahir.substring(8));
            int month = Integer.parseInt(tgl_lahir.substring(5,7));
            isPrime(month);
            if(date%2==0 && date%3==0){
                Toast.makeText(this, "iOS\n" + prime, Toast.LENGTH_SHORT).show();
            }else if(date%2==0){
                Toast.makeText(this, "blackberry\n" + prime, Toast.LENGTH_SHORT).show();
            }else if(date%3==0){
                Toast.makeText(this, "android\n" + prime, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "feature phone\n" + prime, Toast.LENGTH_SHORT).show();
            }
            Intent moveback = new Intent(Screen4.this,Screen2.class);
            moveback.putExtra(Screen2.ex_nama,nama);
            moveback.putExtra(Screen2.ex_guest, nama1);
            moveback.putExtra(Screen2.ex_event,event);
            finishAffinity();
            finish();
            startActivity(moveback);
        });
    }


    public String isPrime(int month){
        if(month == 2 || month == 3 || month == 7 || month == 11){
            prime = "BULAN PRIMA";
        } else {
            prime = "BUKAN BULAN PRIMA";
        }
        return prime;
    }
}