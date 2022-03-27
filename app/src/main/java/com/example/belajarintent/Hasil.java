package com.example.belajarintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hasil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        Button buton = findViewById(R.id.button);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hasil.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();

        String usname = intent.getStringExtra("usname");
        String phon = intent.getStringExtra("phon");
        String em = intent.getStringExtra("em");
        String pass = intent.getStringExtra("pass");
        String conf = intent.getStringExtra("conf");
        String univ = intent.getStringExtra("univ");
        String stud = intent.getStringExtra("stud");


        TextView tampil = findViewById(R.id.data);

        tampil.setText(    "Username: " +
                usname+"\n\nPhone Number: " +
                phon+"\n\nEmail: " +
                em+"\n\nPassword: " +
                pass+"\n\nConfirm Password: " +
                conf+"\n\nUniversity: " +
                univ+"\n\nStudy Program: "
                +stud);

    }
}