package com.example.screeningtest1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextBTN = findViewById(R.id.button);
        edit1 = findViewById(R.id.editTextTextPersonName);

        nextBTN.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button){
            String nama = edit1.getText().toString();

            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            if(isPalindrome(nama) == true){
                builder.setMessage("isPalindrome");
            } else {
                builder.setMessage("not Palindrome");
            }
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent move = new Intent(MainActivity.this,Screen2.class);
                    move.putExtra(Screen2.ex_nama,nama);
                    startActivity(move);
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    public boolean isPalindrome(String name){
        String temp = "";
        for(int i = name.length() - 1; i >= 0 ; i--){
            temp = temp + name.charAt(i);
        }
        if (temp.equals(name)){
            return true;
        } else {
            return false;
        }
    }
}