package com.example.paulfranken.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Stunde_info extends AppCompatActivity {
private RelativeLayout layout;
    private TextView fach,raum,kurs,nummer;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stunde__info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layout=(RelativeLayout)findViewById(R.id.relativeLayout);
        layout.setBackgroundColor(Integer.parseInt(MainActivity.test.farbe));
        fach=(TextView)findViewById(R.id.fach);
        fach.setText(MainActivity.test.fach);
        raum=(TextView)findViewById(R.id.raum);
        raum.setText(MainActivity.test.raum);
        kurs=(TextView)findViewById(R.id.Kurs);
        kurs.setText(MainActivity.test.kurs);
        nummer=(TextView)findViewById(R.id.nummer);
        nummer.setText(MainActivity.test.nummer);

        btn=(Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Stunde_info.this, Stunde_bearbeiten.class);
                Stunde_bearbeiten.bearbeiten=true;


                startActivity(intent);
                finish2();
            }
        });





    }
public void finish2(){
    this.finish();
}

}