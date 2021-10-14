package com.example.coinflip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
            if (!(dobasokSzamlalo == 5 || gyozelemSzamlalo >= 3 || veresegSzamlalo >= 3)){
                Sorsol(0);
                dobasokTextView.setText("Dobások: " + dobasokSzamlalo);
                gyozelemTextView.setText("Győzelem: " + gyozelemSzamlalo);
                veresegTextView.setText("Vereség: " + veresegSzamlalo);}
        });

        irasGomb.setOnClickListener((view) -> {
            if (!(dobasokSzamlalo == 5 || gyozelemSzamlalo >= 3 || veresegSzamlalo >= 3)){
                Sorsol(1);
                dobasokTextView.setText("Dobások: " + dobasokSzamlalo);
                gyozelemTextView.setText("Győzelem: " + gyozelemSzamlalo);
                veresegTextView.setText("Vereség: " + veresegSzamlalo);}
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

        if (dobasokSzamlalo == 5 || gyozelemSzamlalo >= 3 || veresegSzamlalo >= 3) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            if (gyozelemSzamlalo >= 3) {
                alertBuilder.setTitle("Győzelem");
            } else {
                alertBuilder.setTitle("Vereség");
            }
            alertBuilder.setMessage("Szeretne új játékot játszani?");
            alertBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alertBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ujJatek();
                    closeContextMenu();
                }
            });
            alertBuilder.setCancelable(false);
            alertBuilder.create().show();
        }
    }

    private void ujJatek() {
        dobasokSzamlalo = 0;
        gyozelemSzamlalo = 0;
        veresegSzamlalo = 0;
        dobasokTextView.setText("Dobások: " + dobasokSzamlalo);
        gyozelemTextView.setText("Győzelem: " + gyozelemSzamlalo);
        veresegTextView.setText("Vereség: " + veresegSzamlalo);
        kepFejIras.setImageResource(R.drawable.heads);
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