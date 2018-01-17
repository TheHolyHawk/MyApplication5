package com.example.paulfranken.myapplication;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;


import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import android.graphics.Picture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;


import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;


import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.Locale;
import java.util.concurrent.TimeUnit;


import static com.example.paulfranken.myapplication.R.id.text;
import static com.example.paulfranken.myapplication.R.id.text102;
import static com.example.paulfranken.myapplication.R.id.text108;
import static com.example.paulfranken.myapplication.R.id.text16;
import static com.example.paulfranken.myapplication.R.id.text26;
import static com.example.paulfranken.myapplication.R.id.text31;
import static com.example.paulfranken.myapplication.R.id.text37;
import static com.example.paulfranken.myapplication.R.id.text4;
import static com.example.paulfranken.myapplication.R.id.text41;
import static com.example.paulfranken.myapplication.R.id.text46;
import static com.example.paulfranken.myapplication.R.id.text56;
import static com.example.paulfranken.myapplication.R.id.text65;


public class MainActivity extends AppCompatActivity
        implements OnClickListener,View.OnLongClickListener {
    TextView txt;

    private Menu mymenu;
    public static TextView2 test;
    public static int testi;
    public static String klasse="Q2";

    public static ArrayList<Integer> farben=new ArrayList<Integer>();
    public static ArrayList<TextView2> textviews = new ArrayList<TextView2>();
    public static ArrayList<String> texte = new ArrayList<String>();
    public static ArrayList<StundeVplan> stunden=new ArrayList<StundeVplan>();
    public boolean heute=false,morgen=false,montag=false;

    public static String fach,stunde;
    public static String test3 = " ";
    public String kurs, kursid,text,raum2;
    public static ArrayList<String> raum_vorschlage=new ArrayList<>();
    public static String Stest="";
public SwipeRefreshLayout l;
    private AdView adView;



    public static Context context;

    @Override
    protected void onResume() {
        speichern();
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        //Swipe Layout
        l=(SwipeRefreshLayout)findViewById(R.id.swipe);
        l.setColorSchemeResources(R.color.f1,R.color.f4,R.color.f7);//Farben festlegen
        l.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                l.setRefreshing(true);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        aktualisieren();


                    }
                },3000);

            }
        });
//Swipe Layout ende

        speichernlayouts();
        Laden();
        setTage();
        setzeZeiten();
        laden_einstellungen();

        context=getApplicationContext();

        widget_speichern();
        WidgetProvider.updateWidget(getApplicationContext());

        adView = findViewById(R.id.testadview);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        SharedPreferences settings=getSharedPreferences("ADPREFS",0);


        String addys= settings.getString("adwords",null);
        if(addys != null){
            if (addys.equals("aus")) {
                adView.setVisibility(View.GONE);
            }}


    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        mymenu=menu;


        return true;
    }

    //kontrolliert ob ein neuer Vertretungsplan zur Verfügung steht und vergleicht diesen mit dem Stundenplan
    public void aktualisieren(){

        widget_speichern();

        stunden.clear();
        new MyTask(this).execute();

        new MyTask2(this).execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


       switch(item.getItemId()) {
            case R.id.action_refresh:


                widget_speichern();

                stunden.clear();




                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                ImageView iv = (ImageView)inflater.inflate(R.layout.ic_refresh, null);
                Animation rotation = AnimationUtils.loadAnimation(this, R.anim.rotate_refrsh);
                rotation.setRepeatCount(Animation.INFINITE);
                iv.startAnimation(rotation);
                item.setActionView(iv);



                new MyTask(this).execute();

                new MyTask2(this).execute();



                return true;
        }

        if(id==R.id.einstellung){



            Intent intent = new Intent(MainActivity.this, Einstellungen.class);

            startActivity(intent);
        }


        if(id==R.id.action_settings2){

          Intent intent = new Intent(MainActivity.this, Klausurplan.class);

            startActivity(intent);
        }
        if (id == R.id.action_settings) {


           AlertDialog.Builder builder = new AlertDialog.Builder(this);

         //   builder.setTitle("Confirm");
            builder.setMessage("Wollen sie alle Stunden löschen?");
            builder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {


                    SharedPreferences settings=getSharedPreferences("PREFS",0);
                    SharedPreferences.Editor editor=settings.edit();
                    editor.clear();
                    editor.commit();
                    löschen();
                    for(int i=0;i<MainActivity.textviews.size();i++){
                        MainActivity.textviews.get(i).löschen();
                    }
                    dialog.dismiss();
                }
            });

            builder.setNegativeButton("Nein", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    // Do nothing
                    dialog.dismiss();
                }
            });



            AlertDialog alert = builder.create();
            alert.show();



            return true;
        }
        if (id == R.id.testy) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Code eingeben!");

            // Set up the input
            final EditText input = new EditText(this);
            // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            builder.setView(input);

            // Set up the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (input.getText().toString().equals("1234")){
                        Toast.makeText(getApplicationContext(), "Hallo", Toast.LENGTH_SHORT).show();
                    }
                    if (input.getText().toString().equals("84110")){
                        Toast.makeText(getApplicationContext(), "Hallo", Toast.LENGTH_SHORT).show();
                    }
                    if (input.getText().toString().equals("vikings")){
                        Toast.makeText(getApplicationContext(), "Superbowl", Toast.LENGTH_SHORT).show();
                    }
                    if (input.getText().toString().equals("fuckgoogle")){
                        Toast.makeText(getApplicationContext(), "Ads aus", Toast.LENGTH_SHORT).show();
                        adView.setVisibility(View.GONE);

                        SharedPreferences settings=getSharedPreferences("ADPREFS",0);
                        SharedPreferences.Editor editor=settings.edit();

                        editor.putString("adwords","aus");

                        editor.commit();
                    }
                    if (input.getText().toString().equals("sorry")){
                        Toast.makeText(getApplicationContext(), "Ads an", Toast.LENGTH_SHORT).show();
                        adView.setVisibility(View.VISIBLE);

                        SharedPreferences settings=getSharedPreferences("ADPREFS",0);
                        SharedPreferences.Editor editor=settings.edit();

                        editor.putString("adwords","an");

                        editor.commit();
                    }
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();

        }
        if (id == R.id.kon){
            Intent intent = new Intent(MainActivity.this, Kontakt.class);

            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
    public void setzeZeiten(){

        MainActivity.textviews.get(0).setText("7:50"+"\n"+"-"+"\n8:35");
        MainActivity.textviews.get(6).setText("8:40"+"\n"+"-"+"\n9:25");
        MainActivity.textviews.get(12).setText("9:45"+"\n"+"-"+"\n10:30");
        MainActivity.textviews.get(18).setText("10:35"+"\n"+"-"+"\n11:20");
        MainActivity.textviews.get(24).setText("11:40"+"\n"+"-"+"\n12:25");
        MainActivity.textviews.get(30).setText("12:30"+"\n"+"-"+"\n13:15");
        MainActivity.textviews.get(36).setText("13:20"+"\n"+"-"+"\n14:10");
        MainActivity.textviews.get(42).setText("14:15"+"\n"+"-"+"\n15:00");
        MainActivity.textviews.get(48).setText("15:05"+"\n"+"-"+"\n15:50");
        MainActivity.textviews.get(54).setText("15:55"+"\n"+"-"+"\n16:40");
        MainActivity.textviews.get(60).setText("16:45"+"\n"+"-"+"\n17:30");


    }
    public void onClick(View e) {

        if (e.getId() == text65 || e.getId() == text4 || e.getId() == text16 || e.getId() == text102 || e.getId() == text26 || e.getId() == text31 || e.getId() == text37 || e.getId() == text41 || e.getId() == text46 || e.getId() == text108 || e.getId() == text56) {
            // TODO Auto-generated method stub



        } else {

            for (int i = 0; i < textviews.size(); i++) {

                if (e.equals(textviews.get(i))) {
                    test = textviews.get(i);
                    testi = i;
                }
            }if(!test.fach.equals("")){
                Intent intent = new Intent(MainActivity.this, Stunde_info.class);

                startActivity(intent);
            }else{
                Intent intent = new Intent(MainActivity.this, neueStunde_java.class);

                startActivity(intent);
            }






        }
    }
    public void setTage(){
        for(int i=0;i<textviews.size();i++){
            textviews.get(i+1).tag="Montag";
            textviews.get(i+2).tag="Dienstag";
            textviews.get(i+3).tag="Mittwoch";
            textviews.get(i+4).tag="Donnerstag";
            textviews.get(i+5).tag="Freitag";
            i=i+5;


        }
    }
    public void   Laden(){


        SharedPreferences settings=getSharedPreferences("PREFS",0);


        String test= settings.getString("words",null);

if(test!=null){
        String[]itemwors=test.split(",");
        ArrayList<String>worte=new ArrayList<>();
        for(int i=0;i<itemwors.length;i++) {

            worte.add(itemwors[i]);
            texte = worte;


        }
        }



        umwandelnzuruck();



    }
    public void umwandelnzuruck() {
        int platz;


        if(texte.size()!=0) {
            for (int i = 0; i < texte.size(); i++) {
            platz=Integer.parseInt(texte.get(i+5));



                textviews.get(platz).setText(texte.get(i+6)+"\n"+"\n"+texte.get(i+7));
                textviews.get(platz).farbe = texte.get(i+1);
                textviews.get(platz).kurs = texte.get(i + 2);
                textviews.get(platz).nummer = texte.get(i + 3);
                textviews.get(platz).datum = texte.get(i + 4);
                textviews.get(platz).aktualisieren();
                textviews.get(platz).platz = texte.get(i + 5);
                textviews.get(platz).fach = texte.get(i + 6);
                textviews.get(platz).raum=texte.get(i+7);



                i = i + 7;



            }
        }
    }
    public void speichernlayouts(){
        LinearLayout  layout1 = (LinearLayout) findViewById( R.id.layout1 );
        LinearLayout  layout2 = (LinearLayout) findViewById( R.id.layout2 );
        LinearLayout  layout3 = (LinearLayout) findViewById( R.id.layout3 );
        LinearLayout  layout4 = (LinearLayout) findViewById( R.id.layout4 );
        LinearLayout  layout5 = (LinearLayout) findViewById( R.id.layout5 );
        LinearLayout  layout6 = (LinearLayout) findViewById( R.id.layout6 );
        LinearLayout  layout7 = (LinearLayout) findViewById( R.id.layout7 );
        LinearLayout  layout8 = (LinearLayout) findViewById( R.id.layout8 );
        LinearLayout  layout9 = (LinearLayout) findViewById( R.id.layout9 );
        LinearLayout  layout10 = (LinearLayout) findViewById( R.id.layout10 );
        LinearLayout  layout11 = (LinearLayout) findViewById( R.id.layout11 );




            for (int i = 0; i < layout1.getChildCount(); i++) {
                if (layout1.getChildAt(i) instanceof TextView2) {
                    TextView2 textview=(TextView2)layout1.getChildAt(i);
                    textview.stunde="1";
                    textviews.add((TextView2) layout1.getChildAt(i));
                    layout1.getChildAt(i).setOnClickListener(this);
                    layout1.getChildAt(i).setOnLongClickListener(this);


                }}
        for (int i = 0; i < layout2.getChildCount(); i++) {
            if (layout2.getChildAt(i) instanceof TextView2) {
                TextView2 textview=(TextView2)layout2.getChildAt(i);
                textview.stunde="2";
                textviews.add((TextView2) layout2.getChildAt(i));
                layout2.getChildAt(i).setOnClickListener(this);
                layout2.getChildAt(i).setOnLongClickListener(this);
            }}
        for (int i = 0; i < layout3.getChildCount(); i++) {
            if (layout3.getChildAt(i) instanceof TextView2) {
                TextView2 textview=(TextView2)layout3.getChildAt(i);
                textview.stunde="3";
                textviews.add((TextView2) layout3.getChildAt(i));
                layout3.getChildAt(i).setOnClickListener(this);
                layout3.getChildAt(i).setOnLongClickListener(this);
            }}
        for (int i = 0; i < layout4.getChildCount(); i++) {
            if (layout4.getChildAt(i) instanceof TextView2) {
                TextView2 textview=(TextView2)layout4.getChildAt(i);
                textview.stunde="4";
                textviews.add((TextView2) layout4.getChildAt(i));
                layout4.getChildAt(i).setOnClickListener(this);
                layout4.getChildAt(i).setOnLongClickListener(this);
            }}
        for (int i = 0; i < layout5.getChildCount(); i++) {
            TextView2 textview=(TextView2)layout5.getChildAt(i);
            textview.stunde="5";
            if (layout5.getChildAt(i) instanceof TextView2) {
                textviews.add((TextView2) layout5.getChildAt(i));
                layout5.getChildAt(i).setOnClickListener(this);
                layout5.getChildAt(i).setOnLongClickListener(this);
            }}
        for (int i = 0; i < layout6.getChildCount(); i++) {
            if (layout6.getChildAt(i) instanceof TextView2) {
                TextView2 textview=(TextView2)layout6.getChildAt(i);
                textview.stunde="6";
                textviews.add((TextView2) layout6.getChildAt(i));
                layout6.getChildAt(i).setOnClickListener(this);
                layout6.getChildAt(i).setOnLongClickListener(this);
            }}
        for (int i = 0; i < layout7.getChildCount(); i++) {
            if (layout7.getChildAt(i) instanceof TextView2) {
                TextView2 textview=(TextView2)layout7.getChildAt(i);
                textview.stunde="7";
                textviews.add((TextView2) layout7.getChildAt(i));
                layout7.getChildAt(i).setOnClickListener(this);
                layout7.getChildAt(i).setOnLongClickListener(this);
            }}
        for (int i = 0; i < layout8.getChildCount(); i++) {
            TextView2 textview=(TextView2)layout8.getChildAt(i);
            textview.stunde="8";
            if (layout8.getChildAt(i) instanceof TextView2) {
                textviews.add((TextView2) layout8.getChildAt(i));
                layout8.getChildAt(i).setOnClickListener(this);
                layout8.getChildAt(i).setOnLongClickListener(this);
            }}
        for (int i = 0; i < layout9.getChildCount(); i++) {
            if (layout9.getChildAt(i) instanceof TextView2) {
                TextView2 textview=(TextView2)layout9.getChildAt(i);
                textview.stunde="9";
                textviews.add((TextView2) layout9.getChildAt(i));
                layout9.getChildAt(i).setOnClickListener(this);
                layout9.getChildAt(i).setOnLongClickListener(this);
            }}
        for (int i = 0; i < layout10.getChildCount(); i++) {
            TextView2 textview=(TextView2)layout10.getChildAt(i);
            textview.stunde="10";
            if (layout10.getChildAt(i) instanceof TextView2) {
                textviews.add((TextView2) layout10.getChildAt(i));
                layout10.getChildAt(i).setOnClickListener(this);
                layout10.getChildAt(i).setOnLongClickListener(this);
            }}
        for (int i = 0; i < layout11.getChildCount(); i++) {
            TextView2 textview=(TextView2)layout11.getChildAt(i);
            textview.stunde="11";
            if (layout11.getChildAt(i) instanceof TextView2) {
                textviews.add((TextView2) layout11.getChildAt(i));
                layout11.getChildAt(i).setOnClickListener(this);
                layout11.getChildAt(i).setOnLongClickListener(this);
            }}

















    }
    @Override
    public boolean onLongClick(View view) {
        for (int i = 0; i < textviews.size(); i++) {

            if (view.equals(textviews.get(i))) {
                test = textviews.get(i);
                testi = i;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);



        builder.setMessage("Wollen sie diese Stunde löschen?");
        builder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                test.löschen();
                speichern();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Nein", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
        return true;
    }


    public  void speichern(){
        umwandelnhin();
        if(texte.size()>0){
        StringBuilder stringBuilder=new StringBuilder();
        for(String s: MainActivity.texte){

            stringBuilder.append(s);
            stringBuilder.append(",");


        }


        SharedPreferences settings=getSharedPreferences("PREFS",0);
        SharedPreferences.Editor editor=settings.edit();

        editor.putString("words",stringBuilder.toString());

        editor.commit();

    }else if(texte.size()==0){
            SharedPreferences settings=getSharedPreferences("raume",0);
            SharedPreferences.Editor editor=settings.edit();
            editor.clear();
            editor.commit();
    }

    }
    public void löschen(){
        SharedPreferences settings=getSharedPreferences("PREFS",0);
        SharedPreferences.Editor editor=settings.edit();
        editor.clear();
        editor.commit();
    }
    public void umwandelnhin() {
        ArrayList<String> t=new ArrayList<String>();
        texte=t;

        for (int i = 0; i < textviews.size(); i++) {

if(!textviews.get(i).farbe.equals("")) {

    texte.add(String.valueOf(textviews.get(i).getText()));
    texte.add(String.valueOf(textviews.get(i).farbe));
    texte.add(String.valueOf(textviews.get(i).kurs));
    texte.add(String.valueOf(textviews.get(i).nummer));
    texte.add(String.valueOf(textviews.get(i).datum));
    texte.add(String.valueOf(textviews.get(i).platz));
    texte.add(String.valueOf(textviews.get(i).fach));
    texte.add(String.valueOf(textviews.get(i).raum));



}








        }


    }
    public static  void check() {



        for (int i = 0; i < MainActivity.textviews.size(); i++) {


            for (int m = 0; m < MainActivity.stunden.size(); m++) {
                if(MainActivity.stunden.get(m).fach.equals(MainActivity.textviews.get(i).fach)&&MainActivity.stunden.get(m).kursid.equals(MainActivity.textviews.get(i).nummer) &&MainActivity.stunden.get(m).kurs.equals(MainActivity.textviews.get(i).kurs)&&MainActivity.stunden.get(m).tag.equals(MainActivity.textviews.get(i).tag)&&MainActivity.stunden.get(m).stunde.equals(MainActivity.textviews.get(i).stunde)){

                   if(stunden.get(m).text.equals("Selbstlernen")) {
                       MainActivity.textviews.get(i).setText("" + textviews.get(i).fach + " " +"Frei");
                       MainActivity.textviews.get(i).farbe2=String.valueOf(R.color.raum);
                       MainActivity.textviews.get(i).aktualisieren2();


                   }else if(stunden.get(m).text.equals("Vertretung")){
                       MainActivity.textviews.get(i).setText("" + textviews.get(i).fach + " " + stunden.get(m).text);
                       MainActivity.textviews.get(i).farbe2=String.valueOf(R.color.colorAccent);
                       MainActivity.textviews.get(i).aktualisieren2();


                   }else
                   {
                       MainActivity.textviews.get(i).setText("" + textviews.get(i).fach + " " + stunden.get(m).text+" "+stunden.get(m).raum);
                       MainActivity.textviews.get(i).farbe2=String.valueOf(R.color.colorAccent);
                       MainActivity.textviews.get(i).aktualisieren2();

                   }

                }
            }

        }

    }





    class MyTask2 extends AsyncTask<Void,Void,Void>{
       Calendar datumheute = Calendar.getInstance();

        private Context mCon;

        public MyTask2(Context con)
        {
            mCon = con;
        }
        @Override
        protected Void doInBackground(Void... voids) {

   for(int l=0;l<5;l++) {
    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
    String formatted = format1.format(datumheute.getTime());
    try {
        String code = "http://www.ohg-bensberg.de/WSK_extdata/vplan/" + formatted + "/Ver_Kla_" + klasse + ".htm";
        org.jsoup.nodes.Document doc = Jsoup.connect(code).ignoreHttpErrors(true).get();

        if (!doc.title().equals("Object not found!")) {
            Element tables = doc.select("center font table").get(1);
            Elements rows = tables.select("tr");
            // zählt wie viele
            // spalten
            // es
            // gibt
            int spalten = rows.size() + 1;

            for (int i = 2; i < spalten; i++) {

                String test = ("center font tbody tr:nth-child(" + i + ") td:nth-child(4)");
                String hallo = ("center font tbody tr:nth-child(" + i + ") td:nth-child(2)");
                String art = ("center font tbody tr:nth-child(" + i + ") td:nth-child(6)");
                String raum = ("center font tbody tr:nth-child(" + i + ") td:nth-child(5)");


                Elements values = doc.select(test);
                for (Element elem : values) {
                    fach = elem.text();

                }

                Elements values4 = doc.select(raum);
                for (Element elem : values4) {
                    raum2 = elem.text();

                }

                Elements values3 = doc.select(art);
                for (Element elem : values3) {
                    text = elem.text();

                }
                Elements values2 = doc.select(hallo);
                for (Element elem : values2) {
                    stunde = elem.text();

                }

                String c = kurs;


                if (!fach.equals(test3) && !fach.equals("---")) {
                    if (fach.length() == 5) {
                        kurs = String.valueOf(fach.charAt(3));
                        kursid = String.valueOf(fach.charAt(4));
                    } else if (fach.length() == 4) {
                        kurs = String.valueOf(fach.charAt(2));
                        kursid = String.valueOf(fach.charAt(3));
                    }
                    if (fach.equals("---")) {
                        kurs = "---";
                        kursid = "---";
                    }
                    if (kurs == null) {
                        kurs = "";
                    }


                    fach = String.valueOf(fach.charAt(0) + String.valueOf(fach.charAt(1)));


                    c = kurs;
                    StundeVplan vplan;

                    if(stunde.length()==1){
                        vplan = new StundeVplan(fach, datumheute, c, kursid, text, raum2,stunde);
                        MainActivity.stunden.add(vplan);
                    }else if (stunde.length()==5){
                        String stunde1=String.valueOf(stunde.charAt(0));
                        String stunde2=String.valueOf(stunde.charAt(4));
                        vplan = new StundeVplan(fach, datumheute, c, kursid, text, raum2,stunde1);
                        MainActivity.stunden.add(vplan);

                        vplan = new StundeVplan(fach, datumheute, c, kursid, text, raum2,stunde2);
                        MainActivity.stunden.add(vplan);


                    }
                    else if (stunde.length()==7){
                        String stunde1=String.valueOf(stunde.charAt(0)+String.valueOf(stunde.charAt(1)));
                        String stunde2=String.valueOf(stunde.charAt(5)+String.valueOf(stunde.charAt(6)));
                        vplan = new StundeVplan(fach, datumheute, c, kursid, text, raum2,stunde1);
                        MainActivity.stunden.add(vplan);

                        vplan = new StundeVplan(fach, datumheute, c, kursid, text, raum2,stunde2);
                        MainActivity.stunden.add(vplan);


                    }







                }

            }

        }


    } catch (IOException e) {
        e.printStackTrace();
    }

    datumheute.add(Calendar.DATE, 1);
}


            return null;
        }
        public void Toast(String ptext){
            Context context = getApplicationContext();
            CharSequence text = ptext;
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }



        @Override
        protected void onPostExecute(Void aVoid) {
           check();
            ((MainActivity) mCon).resetUpdating();





        }
    }










    class MyTask extends AsyncTask<Void,Void,Void>{

        private Context mCon;

        public MyTask(Context con)
        {
            mCon = con;
        }
        public void Toast(String ptext){
            Context context = getApplicationContext();
            CharSequence text = ptext;
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            Calendar c=Calendar.getInstance();

         try{



            SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");


            String formatted = format1.format(c.getTime());
            String code = "http://www.ohg-bensberg.de/WSK_extdata/vplan/"+formatted+"/Ver_Kla_"+klasse+".htm";

            org.jsoup.nodes.Document doc = Jsoup.connect(code).ignoreHttpErrors(true).get();

            if (!doc.title().equals("Object not found!")) {
                heute=true;


            }else{
                heute=false;



            }


            c.add(Calendar.DATE,1);
            formatted = format1.format(c.getTime());
            code = "http://www.ohg-bensberg.de/WSK_extdata/vplan/"+formatted+"/Ver_Kla_"+klasse+".htm";

            doc = null;
            try {
                doc = Jsoup.connect(code).ignoreHttpErrors(true).get();
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (!doc.title().equals("Object not found!")) {
                morgen=true;


            }else{
                morgen=false;




            }


             Calendar calendar=Calendar.getInstance();

             String weekDay;
             SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.US);




             weekDay = dayFormat.format(calendar.getTime());


             if(weekDay.equals("Friday")){

                 c.add(Calendar.DATE,1);
                 c.add(Calendar.DATE,1);

                 formatted = format1.format(c.getTime());

                 code = "http://www.ohg-bensberg.de/WSK_extdata/vplan/"+formatted+"/Ver_Kla_"+klasse+".htm";
                 Stest=code;
                 doc = null;
                 try {
                     doc = Jsoup.connect(code).ignoreHttpErrors(true).get();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }


                 if (!doc.title().equals("Object not found!")) {
                     montag=true;


                 }else{
                     montag=false;




                 }
             }
             if(weekDay.equals("Saturday")){

                 c.add(Calendar.DATE,1);


                 formatted = format1.format(c.getTime());

                 code = "http://www.ohg-bensberg.de/WSK_extdata/vplan/"+formatted+"/Ver_Kla_"+klasse+".htm";
                 Stest=code;
                 doc = null;
                 try {
                     doc = Jsoup.connect(code).ignoreHttpErrors(true).get();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }


                 if (!doc.title().equals("Object not found!")) {
                     montag=true;


                 }else{
                     montag=false;




                 }
             }
             if(weekDay.equals("Sunday")){




                 formatted = format1.format(c.getTime());

                 code = "http://www.ohg-bensberg.de/WSK_extdata/vplan/"+formatted+"/Ver_Kla_"+klasse+".htm";
                 Stest=code;
                 doc = null;
                 try {
                     doc = Jsoup.connect(code).ignoreHttpErrors(true).get();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }


                 if (!doc.title().equals("Object not found!")) {
                     montag=true;


                 }else{
                     montag=false;




                 }
             }
         }catch (IOException e){
             e.printStackTrace();
         }


            return null;
        }



        @Override
        protected void onPostExecute(Void aVoid) {

            Context context;
            CharSequence text ;
            int duration ;

            Toast toast;


            l.setRefreshing(false);

            if (heute == true && morgen == false&&montag==false) {
                context = getApplicationContext();
                text = "Der Vertretungsplan für Heute ist verfügbar!";
                duration = Toast.LENGTH_SHORT;

                toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            if (heute == true && morgen == false&&montag==true) {
                context = getApplicationContext();
                text = "Der Vertretungsplan für Heute und Montag ist verfügbar!";
                duration = Toast.LENGTH_SHORT;

                toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            if (morgen == true && heute == false&&montag==false) {
                context = getApplicationContext();
                text = "Der Vertretungsplan ist für Morgen verfügbar!";
                duration = Toast.LENGTH_SHORT;

                toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            if (morgen == true && heute == false&&montag==true) {
                context = getApplicationContext();
                text = "Der Vertretungsplan ist für Morgen und Montag verfügbar!";
                duration = Toast.LENGTH_SHORT;

                toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            if (heute == true && morgen == true&&montag==false) {
                context = getApplicationContext();
                text = "Der Vertretungsplan für Heute und Morgen ist verfügbar!";
                duration = Toast.LENGTH_SHORT;

                toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            if (heute == true && morgen == true&&montag==true) {
                context = getApplicationContext();
                text = "Der Vertretungsplan für Heute und Morgen und Montag ist verfügbar!";
                duration = Toast.LENGTH_SHORT;

                toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            if (heute == false && morgen == false&&montag ==false) {
                context = getApplicationContext();

                text = "Der Vertretungsplan für Heute und Morgen ist noch nicht verfügbar oder du hast kein Internetzugriff!";
                duration = Toast.LENGTH_SHORT;

                toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            if (heute == false && morgen == false&&montag ==true) {
                context = getApplicationContext();

                text = "Der Vertretungsplan für Montag ist verfügbar!";
                duration = Toast.LENGTH_SHORT;

                toast = Toast.makeText(context, text, duration);
                toast.show();
            }

            heute = false;
            morgen = false;
            montag=false;



        }


    }
    public void resetUpdating() {
// Get our refresh item from the menu
        MenuItem m = mymenu.findItem(R.id.action_refresh);
        if(m.getActionView()!=null)
        {
// Remove the animation.
            m.getActionView().clearAnimation();
            m.setActionView(null);
        }
    }

 public void laden_einstellungen(){
        SharedPreferences settings=getSharedPreferences("Einstellungen",0);


        String test= settings.getString("words2",null);
        klasse=test;
    }
    public   void  widget_speichern(){

        ArrayList<String> fach=new ArrayList<>();
        ArrayList<String> raum=new ArrayList<>();

//alle facher informationen
        fach.clear();

        fach.add(MainActivity.textviews.get(1).fach);
        fach.add(MainActivity.textviews.get(7).fach);
        fach.add(MainActivity.textviews.get(13).fach);
        fach.add(MainActivity.textviews.get(19).fach);
        fach.add(MainActivity.textviews.get(25).fach);
        fach.add(MainActivity.textviews.get(31).fach);
        fach.add(MainActivity.textviews.get(37).fach);
        fach.add(MainActivity.textviews.get(43).fach);
        fach.add(MainActivity.textviews.get(49).fach);
        fach.add(MainActivity.textviews.get(55).fach);
        fach.add(MainActivity.textviews.get(61).fach);



        fach.add(MainActivity.textviews.get(2).fach);
        fach.add(MainActivity.textviews.get(8).fach);
        fach.add(MainActivity.textviews.get(14).fach);
        fach.add(MainActivity.textviews.get(20).fach);
        fach.add(MainActivity.textviews.get(26).fach);
        fach.add(MainActivity.textviews.get(32).fach);
        fach.add(MainActivity.textviews.get(38).fach);
        fach.add(MainActivity.textviews.get(44).fach);
        fach.add(MainActivity.textviews.get(50).fach);
        fach.add(MainActivity.textviews.get(56).fach);
        fach.add(MainActivity.textviews.get(62).fach);



        fach.add(MainActivity.textviews.get(3).fach);
        fach.add(MainActivity.textviews.get(9).fach);
        fach.add(MainActivity.textviews.get(15).fach);
        fach.add(MainActivity.textviews.get(21).fach);
        fach.add(MainActivity.textviews.get(27).fach);
        fach.add(MainActivity.textviews.get(33).fach);
        fach.add(MainActivity.textviews.get(39).fach);
        fach.add(MainActivity.textviews.get(45).fach);
        fach.add(MainActivity.textviews.get(51).fach);
        fach.add(MainActivity.textviews.get(57).fach);
        fach.add(MainActivity.textviews.get(63).fach);



        fach.add(MainActivity.textviews.get(4).fach);
        fach.add(MainActivity.textviews.get(10).fach);
        fach.add(MainActivity.textviews.get(16).fach);
        fach.add(MainActivity.textviews.get(22).fach);
        fach.add(MainActivity.textviews.get(28).fach);
        fach.add(MainActivity.textviews.get(34).fach);
        fach.add(MainActivity.textviews.get(40).fach);
        fach.add(MainActivity.textviews.get(46).fach);
        fach.add(MainActivity.textviews.get(52).fach);
        fach.add(MainActivity.textviews.get(58).fach);
        fach.add(MainActivity.textviews.get(64).fach);



        fach.add(MainActivity.textviews.get(5).fach);
        fach.add(MainActivity.textviews.get(11).fach);
        fach.add(MainActivity.textviews.get(17).fach);
        fach.add(MainActivity.textviews.get(23).fach);
        fach.add(MainActivity.textviews.get(29).fach);
        fach.add(MainActivity.textviews.get(35).fach);
        fach.add(MainActivity.textviews.get(41).fach);
        fach.add(MainActivity.textviews.get(47).fach);
        fach.add(MainActivity.textviews.get(53).fach);
        fach.add(MainActivity.textviews.get(59).fach);
        fach.add(MainActivity.textviews.get(65).fach);

        for(int i=0;i<fach.size();i++){
            if(fach.get(i).equals("")){
                fach.set(i," ");
            }
        }


        //fach
        if(fach.size()>0){
            StringBuilder stringBuilder=new StringBuilder();
            for(String s: fach){

                stringBuilder.append(s);
                stringBuilder.append(",");


            }



            SharedPreferences settings=getSharedPreferences("fach",0);
            SharedPreferences.Editor editor=settings.edit();

            editor.putString("fach",stringBuilder.toString());

            editor.commit();

        }else if(fach.size()==0){
            SharedPreferences settings=getSharedPreferences("fach",0);
            SharedPreferences.Editor editor=settings.edit();
            editor.clear();
            editor.commit();
        }



        //alle raum informationen


        raum.clear();

        raum.add(MainActivity.textviews.get(1).raum);
        raum.add(MainActivity.textviews.get(7).raum);
        raum.add(MainActivity.textviews.get(13).raum);
        raum.add(MainActivity.textviews.get(19).raum);
        raum.add(MainActivity.textviews.get(25).raum);
        raum.add(MainActivity.textviews.get(31).raum);
        raum.add(MainActivity.textviews.get(37).raum);
        raum.add(MainActivity.textviews.get(43).raum);
        raum.add(MainActivity.textviews.get(49).raum);
        raum.add(MainActivity.textviews.get(55).raum);
        raum.add(MainActivity.textviews.get(61).raum);



        raum.add(MainActivity.textviews.get(2).raum);
        raum.add(MainActivity.textviews.get(8).raum);
        raum.add(MainActivity.textviews.get(14).raum);
        raum.add(MainActivity.textviews.get(20).raum);
        raum.add(MainActivity.textviews.get(26).raum);
        raum.add(MainActivity.textviews.get(32).raum);
        raum.add(MainActivity.textviews.get(38).raum);
        raum.add(MainActivity.textviews.get(44).raum);
        raum.add(MainActivity.textviews.get(50).raum);
        raum.add(MainActivity.textviews.get(56).raum);
        raum.add(MainActivity.textviews.get(62).raum);



        raum.add(MainActivity.textviews.get(3).raum);
        raum.add(MainActivity.textviews.get(9).raum);
        raum.add(MainActivity.textviews.get(15).raum);
        raum.add(MainActivity.textviews.get(21).raum);
        raum.add(MainActivity.textviews.get(27).raum);
        raum.add(MainActivity.textviews.get(33).raum);
        raum.add(MainActivity.textviews.get(39).raum);
        raum.add(MainActivity.textviews.get(45).raum);
        raum.add(MainActivity.textviews.get(51).raum);
        raum.add(MainActivity.textviews.get(57).raum);
        raum.add(MainActivity.textviews.get(63).raum);



        raum.add(MainActivity.textviews.get(4).raum);
        raum.add(MainActivity.textviews.get(10).raum);
        raum.add(MainActivity.textviews.get(16).raum);
        raum.add(MainActivity.textviews.get(22).raum);
        raum.add(MainActivity.textviews.get(28).raum);
        raum.add(MainActivity.textviews.get(34).raum);
        raum.add(MainActivity.textviews.get(40).raum);
        raum.add(MainActivity.textviews.get(46).raum);
        raum.add(MainActivity.textviews.get(52).raum);
        raum.add(MainActivity.textviews.get(58).raum);
        raum.add(MainActivity.textviews.get(64).raum);



        raum.add(MainActivity.textviews.get(5).raum);
        raum.add(MainActivity.textviews.get(11).raum);
        raum.add(MainActivity.textviews.get(17).raum);
        raum.add(MainActivity.textviews.get(23).raum);
        raum.add(MainActivity.textviews.get(29).raum);
        raum.add(MainActivity.textviews.get(35).raum);
        raum.add(MainActivity.textviews.get(41).raum);
        raum.add(MainActivity.textviews.get(47).raum);
        raum.add(MainActivity.textviews.get(53).raum);
        raum.add(MainActivity.textviews.get(59).raum);
        raum.add(MainActivity.textviews.get(65).raum);

        for(int i=0;i<raum.size();i++){
            if(raum.get(i).equals("")){
                raum.set(i," ");
            }
        }


        //raum
        if(raum.size()>0){
            StringBuilder stringBuilder=new StringBuilder();
            for(String s: raum){

                stringBuilder.append(s);
                stringBuilder.append(",");


            }



            SharedPreferences settings=getSharedPreferences("raum",0);
            SharedPreferences.Editor editor=settings.edit();

            editor.putString("raum",stringBuilder.toString());

            editor.commit();

        }else if(raum.size()==0){
            SharedPreferences settings=getSharedPreferences("raum",0);
            SharedPreferences.Editor editor=settings.edit();
            editor.clear();
            editor.commit();
        }

    }

}
