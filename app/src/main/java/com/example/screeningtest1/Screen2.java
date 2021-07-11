package com.example.screeningtest1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity implements View.OnClickListener {
    TextView tv_nama;
    public static final String ex_nama="ex_nama";
    public static final String ex_event="ex_event";
    public static final String ex_guest="ex_guest";
    Button btn_event;
    Button btn_guest;
    String nama,event,guest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        tv_nama = findViewById(R.id.textView2);
        nama=getIntent().getStringExtra(ex_nama);
        event = getIntent().getStringExtra(ex_event);
        guest = getIntent().getStringExtra(ex_guest);

        String temp=": "+nama;

        tv_nama.setText(temp);
        btn_event = findViewById(R.id.btn_event);
        btn_guest = findViewById(R.id.btn_guest);
        if(event!=null){
            btn_event.setText(event);
        }
        if(guest!=null){
            btn_guest.setText(guest);
        }
        btn_event.setOnClickListener(this);
        btn_guest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_event){
            Intent eventMove = new Intent(Screen2.this,Screen3.class);
            eventMove.putExtra(Screen3.ex_nama,nama);
            eventMove.putExtra(Screen3.ex_guest,guest);
            startActivity(eventMove);

        }else if(v.getId()==R.id.btn_guest){
            Intent guestMove = new Intent(Screen2.this,Screen4.class);
            guestMove.putExtra(Screen4.ex_nama,nama);
            guestMove.putExtra(Screen4.ex_event,event);
            startActivity(guestMove);
        }
    }
}