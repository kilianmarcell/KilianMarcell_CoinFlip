package com.example.coinflip;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView kepFejIras;
    private Button fejGomb, irasGomb;
    private TextView dobasokTextView, gyozelemTextView, veresegTextView;
    private int dobasokSzamlalo, gyozelemSzamlalo, veresegSzamlalo;
    private Random rnd;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        fejGomb.setOnClickListener((view) -> {
            Sorsol(0);
            dobasokTextView.setText("Dobások: " + dobasokSzamlalo);
            gyozelemTextView.setText("Győzelem: " + gyozelemSzamlalo);
            veresegTextView.setText("Vereség: " + veresegSzamlalo);
        });

        irasGomb.setOnClickListener((view) -> {
            Sorsol(1);
            dobasokTextView.setText("Dobások: " + dobasokSzamlalo);
            gyozelemTextView.setText("Győzelem: " + gyozelemSzamlalo);
            veresegTextView.setText("Vereség: " + veresegSzamlalo);
        });
    }

    public void Sorsol(int tipp) {
        double randomSzam = Math.floor(Math.random() * 2);
        if (randomSzam == 1) {
            kepFejIras.setImageResource(R.drawable.tails);
            dobasokSzamlalo++;
            if (tipp == 1) {
                gyozelemSzamlalo++;
            } else {
                veresegSzamlalo++;
            }
            Toast.makeText(MainActivity.this, "Írás", Toast.LENGTH_SHORT).show();
        } else {
            kepFejIras.setImageResource(R.drawable.heads);
            dobasokSzamlalo++;
            if (tipp == 0) {
                gyozelemSzamlalo++;
            } else {
                veresegSzamlalo++;
            }
            Toast.makeText(MainActivity.this, "Fej", Toast.LENGTH_LONG).show();
        }
    }

    private void init() {
        kepFejIras = findViewById(R.id.kepFejIras);
        fejGomb = findViewById(R.id.fejGomb);
        irasGomb = findViewById(R.id.irasGomb);
        dobasokTextView = findViewById(R.id.dobasokTextView);
        gyozelemTextView = findViewById(R.id.gyozelemTextView);
        veresegTextView = findViewById(R.id.veresegTextView);
        dobasokSzamlalo = 0;
        gyozelemSzamlalo = 0;
        veresegSzamlalo = 0;
    }
}