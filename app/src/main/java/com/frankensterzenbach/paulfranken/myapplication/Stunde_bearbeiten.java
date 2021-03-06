package com.frankensterzenbach.paulfranken.myapplication;


import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.colorpicker.ColorPickerDialog;
import com.android.colorpicker.ColorPickerSwatch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Stunde_bearbeiten extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener{
    Button farbe;
    Button hinzufügen;
    Spinner fach;
    Spinner kurs;
    public Calendar datumheute = Calendar.getInstance();
    Spinner nummer;
    public String raum2="";
    TextView raum;
    static int farbeint=-769482;
    public ArrayList<String>facher=new ArrayList<>();
    public static boolean bearbeiten=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_stunde_bearbeiten);

        farbe=(Button)findViewById(R.id.button);
        farbe.setOnClickListener(this);
        String string;
        string="    "+MainActivity.alleStunden.get(MainActivity.bearbeiteni).stunde+".Stunde "+MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag;
        setTitle(string);





        fach=(Spinner)findViewById(R.id.spinner);
        fach.setOnItemSelectedListener(this);


        kurs=(Spinner)findViewById(R.id.spinner2);
        raum=(AutoCompleteTextView) findViewById(R.id.editText);
        nummer=(Spinner) findViewById(R.id.spinner3);


        String[] faecher;
        faecher = getResources().getStringArray(R.array.facher);

       for(int i =0; i< faecher.length; i++){
           facher.add(faecher[i]);

       }



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_neue, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings2) {

            MainActivity.alleStunden.get(MainActivity.bearbeiteni).setTextColor(Color.BLACK);
            testRaum();

            MainActivity.alleStunden.get(MainActivity.bearbeiteni).setText(fach.getSelectedItem().toString()+"\n"+"\n"+raum2);
            MainActivity.alleStunden.get(MainActivity.bearbeiteni).farbe=String.valueOf(farbeint);
            MainActivity.alleStunden.get(MainActivity.bearbeiteni).kurs=kurs.getSelectedItem().toString();
            MainActivity.alleStunden.get(MainActivity.bearbeiteni).nummer=nummer.getSelectedItem().toString();

            MainActivity.alleStunden.get(MainActivity.bearbeiteni).lehrer="";



            String weekDay;
            SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.US);

            Calendar calendar = Calendar.getInstance();
            weekDay = dayFormat.format(calendar.getTime());

            if(weekDay.equals("Monday")){

                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Montag")){
                    datumheute.add(Calendar.DATE,0);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Dienstag")){
                    datumheute.add(Calendar.DATE,1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Mittwoch")){
                    datumheute.add(Calendar.DATE,2);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Donnerstag")){
                    datumheute.add(Calendar.DATE,3);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Freitag")){
                    datumheute.add(Calendar.DATE,4);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Samstag")){
                    datumheute.add(Calendar.DATE,5);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                } if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Sonntag")){
                    datumheute.add(Calendar.DATE,6);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

            }
            if(weekDay.equals("Tuesday")){
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Montag")){
                    datumheute.add(Calendar.DATE,-1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Dienstag")){
                    datumheute.add(Calendar.DATE,0);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Mittwoch")){
                    datumheute.add(Calendar.DATE,1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Donnerstag")){
                    datumheute.add(Calendar.DATE,2);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Freitag")){
                    datumheute.add(Calendar.DATE,3);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Samstag")){
                    datumheute.add(Calendar.DATE,4);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                } if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Sonntag")){
                    datumheute.add(Calendar.DATE,5);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

            }
            if(weekDay.equals("Wednesday")){
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Montag")){
                    datumheute.add(Calendar.DATE,-2);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Dienstag")){
                    datumheute.add(Calendar.DATE,-1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Mittwoch")){
                    datumheute.add(Calendar.DATE,0);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Donnerstag")){
                    datumheute.add(Calendar.DATE,1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Freitag")){
                    datumheute.add(Calendar.DATE,2);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Samstag")){
                    datumheute.add(Calendar.DATE,3);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                } if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Sonntag")){
                    datumheute.add(Calendar.DATE,4);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

            }
            if(weekDay.equals("Thursday")){
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Montag")){
                    datumheute.add(Calendar.DATE,-3);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Dienstag")){
                    datumheute.add(Calendar.DATE,-2);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Mittwoch")){
                    datumheute.add(Calendar.DATE,-1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Donnerstag")){
                    datumheute.add(Calendar.DATE,0);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Freitag")){
                    datumheute.add(Calendar.DATE,1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Samstag")){
                    datumheute.add(Calendar.DATE,2);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                } if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Sonntag")){
                    datumheute.add(Calendar.DATE,3);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

            }
            if(weekDay.equals("Friday")){

                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Montag")){
                    datumheute.add(Calendar.DATE,-4);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Dienstag")){
                    datumheute.add(Calendar.DATE,-3);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Mittwoch")){
                    datumheute.add(Calendar.DATE,-2);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Donnerstag")){
                    datumheute.add(Calendar.DATE,-1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Freitag")){
                    datumheute.add(Calendar.DATE,0);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Samstag")){
                    datumheute.add(Calendar.DATE,1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                } if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Sonntag")){
                    datumheute.add(Calendar.DATE,2);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
            }
            if(weekDay.equals("Saturday")){
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Montag")){
                    datumheute.add(Calendar.DATE,-5);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Dienstag")){
                    datumheute.add(Calendar.DATE,-4);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Mittwoch")){
                    datumheute.add(Calendar.DATE,-3);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Donnerstag")){
                    datumheute.add(Calendar.DATE,-2);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Freitag")){
                    datumheute.add(Calendar.DATE,-1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Samstag")){
                    datumheute.add(Calendar.DATE,0);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                } if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Sonntag")){
                    datumheute.add(Calendar.DATE,1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

            }
            if(weekDay.equals("Sunday")){

                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Montag")){
                    datumheute.add(Calendar.DATE,-6);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Dienstag")){
                    datumheute.add(Calendar.DATE,-5);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Mittwoch")){
                    datumheute.add(Calendar.DATE,-4);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Donnerstag")){
                    datumheute.add(Calendar.DATE,-3);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }

                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Freitag")){
                    datumheute.add(Calendar.DATE,-2);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
                if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Samstag")){
                    datumheute.add(Calendar.DATE,-1);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                } if( MainActivity.alleStunden.get(MainActivity.bearbeiteni).tag.equals("Sonntag")){
                    datumheute.add(Calendar.DATE,0);
                    SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                    String formatted = format1.format(datumheute.getTime());
                    MainActivity.alleStunden.get(MainActivity.bearbeiteni).datum=formatted;

                }
            }



            MainActivity.alleStunden.get(MainActivity.bearbeiteni).fach=fach.getSelectedItem().toString();

            MainActivity.alleStunden.get(MainActivity.bearbeiteni).platz=String.valueOf(MainActivity.bearbeiteni);
            if(!String.valueOf(raum2).equals("")){
                MainActivity.alleStunden.get(MainActivity.bearbeiteni).raum=String.valueOf(raum2);
            }else{
                MainActivity.alleStunden.get(MainActivity.bearbeiteni).raum=" ";
            }
            MainActivity.alleStunden.get(MainActivity.bearbeiteni).aktualisieren();

            for(int i=0;i<MainActivity.alleStunden.size();i++){
                if(MainActivity.alleStunden.get(i).fach.equals(MainActivity.bearbeiten.fach)){
                    if(!String.valueOf(raum.getText()).equals("")){
                        MainActivity.alleStunden.get(MainActivity.bearbeiteni).raum=String.valueOf(raum2);
                    }else{
                        MainActivity.alleStunden.get(MainActivity.bearbeiteni).raum=" ";
                    }
                    MainActivity.alleStunden.get(i).kurs=String.valueOf(kurs.getSelectedItem());
                    MainActivity.alleStunden.get(i).nummer=String.valueOf(nummer.getSelectedItem());
                    MainActivity.alleStunden.get(i).farbe=String.valueOf(farbeint);

                    MainActivity.alleStunden.get(i).aktualisieren();
                    MainActivity.alleStunden.get(i).setText(fach.getSelectedItem().toString()+"\n"+"\n"+MainActivity.alleStunden.get(i).raum);

                }

            }

            speichern();

            widget_speichern();
            WidgetProvider.updateWidget(getApplicationContext());
            this.finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public  void speichern(){
        umwandelnhin();
        StringBuilder stringBuilder=new StringBuilder();
        for(String s: MainActivity.speichern_laden){
            stringBuilder.append(s);
            stringBuilder.append(",");


        }


        SharedPreferences settings=getSharedPreferences("PREFS",0);
        SharedPreferences.Editor editor=settings.edit();

        editor.putString("words",stringBuilder.toString());

        editor.commit();

    }

    public void umwandelnhin() {
        ArrayList<String> t=new ArrayList<String>();
        MainActivity.speichern_laden=t;

        for (int i = 0; i < MainActivity.alleStunden.size(); i++) {

            if(!MainActivity.alleStunden.get(i).farbe.equals("")) {

                MainActivity.speichern_laden.add(String.valueOf(MainActivity.alleStunden.get(i).getText()));
                MainActivity.speichern_laden.add(String.valueOf(MainActivity.alleStunden.get(i).farbe));
                MainActivity.speichern_laden.add(String.valueOf(MainActivity.alleStunden.get(i).kurs));
                MainActivity.speichern_laden.add(String.valueOf(MainActivity.alleStunden.get(i).nummer));
                MainActivity.speichern_laden.add(String.valueOf(MainActivity.alleStunden.get(i).datum));
                MainActivity.speichern_laden.add(String.valueOf(MainActivity.alleStunden.get(i).platz));
                MainActivity.speichern_laden.add(String.valueOf(MainActivity.alleStunden.get(i).fach));
                MainActivity.speichern_laden.add(String.valueOf(MainActivity.alleStunden.get(i).raum));
                MainActivity.speichern_laden.add(String.valueOf(MainActivity.alleStunden.get(i).lehrer));



            }








        }


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(bearbeiten==false){
            boolean Z=false;

            int f=0;

            for(int m=0;m<MainActivity.alleStunden.size();m++){
                if(!MainActivity.alleStunden.get(m).fach.equals(fach.getSelectedItem())){


                }else{
                    Z=true;
                    f=m;

                }

            }
            if(Z==true){


                if(MainActivity.alleStunden.get(f).kurs.equals("LK")){
                    kurs.setSelection(1);
                }else{
                    kurs.setSelection(0);
                }



                if(MainActivity.alleStunden.get(f).nummer.equals("1")){
                    nummer.setSelection(0);
                }
                else if(MainActivity.alleStunden.get(f).nummer.equals("2")){
                    nummer.setSelection(1);
                }
                else if(MainActivity.alleStunden.get(f).nummer.equals("3")){
                    nummer.setSelection(2);
                }
                else if(MainActivity.alleStunden.get(f).nummer.equals("4")){
                    nummer.setSelection(3);
                }
                else if(MainActivity.alleStunden.get(f).nummer.equals("5")){
                    nummer.setSelection(4);
                }









                farbeint=Integer.parseInt(MainActivity.alleStunden.get(f).farbe);
                farbe.setBackgroundTintList(ColorStateList.valueOf(farbeint));
            }

        }
        if(bearbeiten==true) {
            boolean Z2 = false;
            int selection = 0;
            int f2 = 0;
            for (int o = 0; o < facher.size(); o++) {
                if (facher.get(o).equals(MainActivity.bearbeiten.fach)) {
                    selection = o;
                }
            }


            for (int m = 0; m < MainActivity.alleStunden.size(); m++) {
                if (!MainActivity.alleStunden.get(m).fach.equals(MainActivity.bearbeiten.fach)) {


                } else {

                    Z2 = true;
                    f2 = m;
                    fach.setSelection(selection);


                }

            }

            if (Z2 == true) {
                raum.setText(MainActivity.bearbeiten.raum);


                if (MainActivity.alleStunden.get(f2).kurs.equals("LK")) {
                    kurs.setSelection(1);

                } else {
                    kurs.setSelection(0);
                }
                if (MainActivity.alleStunden.get(f2).nummer.equals("1")) {
                    nummer.setSelection(0);
                } else if (MainActivity.alleStunden.get(f2).nummer.equals("2")) {
                    nummer.setSelection(1);
                } else if (MainActivity.alleStunden.get(f2).nummer.equals("3")) {
                    nummer.setSelection(2);
                } else if (MainActivity.alleStunden.get(f2).nummer.equals("4")) {
                    nummer.setSelection(3);
                } else if (MainActivity.alleStunden.get(f2).nummer.equals("5")) {
                    nummer.setSelection(4);
                }

                farbeint = Integer.parseInt(MainActivity.alleStunden.get(f2).farbe);
                farbe.setBackgroundTintList(ColorStateList.valueOf(farbeint));
            }

            bearbeiten=false;
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void onClick(View view) {
        if (view.equals(farbe)) {

            showColourPicker(view);
        }




    }
    public void showColourPicker(View view) {
        final ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
        colorPickerDialog.initialize(R.string.color_picker_default_title,
                new int[] {

                        getResources().getColor(R.color.f1),
                        getResources().getColor(R.color.f2),
                        getResources().getColor(R.color.f3),
                        getResources().getColor(R.color.f4),
                        getResources().getColor(R.color.f5),

                        getResources().getColor(R.color.f10),
                        getResources().getColor(R.color.f9),
                        getResources().getColor(R.color.f8),
                        getResources().getColor(R.color.f7),
                        getResources().getColor(R.color.f6),

                        getResources().getColor(R.color.f11),
                        getResources().getColor(R.color.f12),
                        getResources().getColor(R.color.f13),
                        getResources().getColor(R.color.f14),
                        getResources().getColor(R.color.f15),

                        getResources().getColor(R.color.f20),
                        getResources().getColor(R.color.f19),
                        getResources().getColor(R.color.f18),
                        getResources().getColor(R.color.f17),
                        getResources().getColor(R.color.f16),

                        getResources().getColor(R.color.f21),
                        getResources().getColor(R.color.f22),
                        getResources().getColor(R.color.f23),
                        getResources().getColor(R.color.f24),

                        getResources().getColor(R.color.f30),
                        getResources().getColor(R.color.f25),
                        getResources().getColor(R.color.f26),
                        getResources().getColor(R.color.f27),
                        getResources().getColor(R.color.f28),
                        getResources().getColor(R.color.f29),




                }, 25, 5, 2);

        colorPickerDialog.setOnColorSelectedListener(new ColorPickerSwatch.OnColorSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onColorSelected(int colour) {
                farbeint=colour;

                farbe.setBackgroundTintList(ColorStateList.valueOf(farbeint));


            }
        });

        android.app.FragmentManager fm = this.getFragmentManager();
        colorPickerDialog.show(fm, "colorpicker");
    }

    public   void  widget_speichern(){

        ArrayList<String> fach=new ArrayList<>();
        ArrayList<String> raum=new ArrayList<>();

//alle facher informationen
        fach.clear();

        fach.add(MainActivity.alleStunden.get(1).fach);
        fach.add(MainActivity.alleStunden.get(7).fach);
        fach.add(MainActivity.alleStunden.get(13).fach);
        fach.add(MainActivity.alleStunden.get(19).fach);
        fach.add(MainActivity.alleStunden.get(25).fach);
        fach.add(MainActivity.alleStunden.get(31).fach);
        fach.add(MainActivity.alleStunden.get(37).fach);
        fach.add(MainActivity.alleStunden.get(43).fach);
        fach.add(MainActivity.alleStunden.get(49).fach);
        fach.add(MainActivity.alleStunden.get(55).fach);
        fach.add(MainActivity.alleStunden.get(61).fach);



        fach.add(MainActivity.alleStunden.get(2).fach);
        fach.add(MainActivity.alleStunden.get(8).fach);
        fach.add(MainActivity.alleStunden.get(14).fach);
        fach.add(MainActivity.alleStunden.get(20).fach);
        fach.add(MainActivity.alleStunden.get(26).fach);
        fach.add(MainActivity.alleStunden.get(32).fach);
        fach.add(MainActivity.alleStunden.get(38).fach);
        fach.add(MainActivity.alleStunden.get(44).fach);
        fach.add(MainActivity.alleStunden.get(50).fach);
        fach.add(MainActivity.alleStunden.get(56).fach);
        fach.add(MainActivity.alleStunden.get(62).fach);



        fach.add(MainActivity.alleStunden.get(3).fach);
        fach.add(MainActivity.alleStunden.get(9).fach);
        fach.add(MainActivity.alleStunden.get(15).fach);
        fach.add(MainActivity.alleStunden.get(21).fach);
        fach.add(MainActivity.alleStunden.get(27).fach);
        fach.add(MainActivity.alleStunden.get(33).fach);
        fach.add(MainActivity.alleStunden.get(39).fach);
        fach.add(MainActivity.alleStunden.get(45).fach);
        fach.add(MainActivity.alleStunden.get(51).fach);
        fach.add(MainActivity.alleStunden.get(57).fach);
        fach.add(MainActivity.alleStunden.get(63).fach);



        fach.add(MainActivity.alleStunden.get(4).fach);
        fach.add(MainActivity.alleStunden.get(10).fach);
        fach.add(MainActivity.alleStunden.get(16).fach);
        fach.add(MainActivity.alleStunden.get(22).fach);
        fach.add(MainActivity.alleStunden.get(28).fach);
        fach.add(MainActivity.alleStunden.get(34).fach);
        fach.add(MainActivity.alleStunden.get(40).fach);
        fach.add(MainActivity.alleStunden.get(46).fach);
        fach.add(MainActivity.alleStunden.get(52).fach);
        fach.add(MainActivity.alleStunden.get(58).fach);
        fach.add(MainActivity.alleStunden.get(64).fach);



        fach.add(MainActivity.alleStunden.get(5).fach);
        fach.add(MainActivity.alleStunden.get(11).fach);
        fach.add(MainActivity.alleStunden.get(17).fach);
        fach.add(MainActivity.alleStunden.get(23).fach);
        fach.add(MainActivity.alleStunden.get(29).fach);
        fach.add(MainActivity.alleStunden.get(35).fach);
        fach.add(MainActivity.alleStunden.get(41).fach);
        fach.add(MainActivity.alleStunden.get(47).fach);
        fach.add(MainActivity.alleStunden.get(53).fach);
        fach.add(MainActivity.alleStunden.get(59).fach);
        fach.add(MainActivity.alleStunden.get(65).fach);

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

        raum.add(MainActivity.alleStunden.get(1).raum);
        raum.add(MainActivity.alleStunden.get(7).raum);
        raum.add(MainActivity.alleStunden.get(13).raum);
        raum.add(MainActivity.alleStunden.get(19).raum);
        raum.add(MainActivity.alleStunden.get(25).raum);
        raum.add(MainActivity.alleStunden.get(31).raum);
        raum.add(MainActivity.alleStunden.get(37).raum);
        raum.add(MainActivity.alleStunden.get(43).raum);
        raum.add(MainActivity.alleStunden.get(49).raum);
        raum.add(MainActivity.alleStunden.get(55).raum);
        raum.add(MainActivity.alleStunden.get(61).raum);



        raum.add(MainActivity.alleStunden.get(2).raum);
        raum.add(MainActivity.alleStunden.get(8).raum);
        raum.add(MainActivity.alleStunden.get(14).raum);
        raum.add(MainActivity.alleStunden.get(20).raum);
        raum.add(MainActivity.alleStunden.get(26).raum);
        raum.add(MainActivity.alleStunden.get(32).raum);
        raum.add(MainActivity.alleStunden.get(38).raum);
        raum.add(MainActivity.alleStunden.get(44).raum);
        raum.add(MainActivity.alleStunden.get(50).raum);
        raum.add(MainActivity.alleStunden.get(56).raum);
        raum.add(MainActivity.alleStunden.get(62).raum);



        raum.add(MainActivity.alleStunden.get(3).raum);
        raum.add(MainActivity.alleStunden.get(9).raum);
        raum.add(MainActivity.alleStunden.get(15).raum);
        raum.add(MainActivity.alleStunden.get(21).raum);
        raum.add(MainActivity.alleStunden.get(27).raum);
        raum.add(MainActivity.alleStunden.get(33).raum);
        raum.add(MainActivity.alleStunden.get(39).raum);
        raum.add(MainActivity.alleStunden.get(45).raum);
        raum.add(MainActivity.alleStunden.get(51).raum);
        raum.add(MainActivity.alleStunden.get(57).raum);
        raum.add(MainActivity.alleStunden.get(63).raum);



        raum.add(MainActivity.alleStunden.get(4).raum);
        raum.add(MainActivity.alleStunden.get(10).raum);
        raum.add(MainActivity.alleStunden.get(16).raum);
        raum.add(MainActivity.alleStunden.get(22).raum);
        raum.add(MainActivity.alleStunden.get(28).raum);
        raum.add(MainActivity.alleStunden.get(34).raum);
        raum.add(MainActivity.alleStunden.get(40).raum);
        raum.add(MainActivity.alleStunden.get(46).raum);
        raum.add(MainActivity.alleStunden.get(52).raum);
        raum.add(MainActivity.alleStunden.get(58).raum);
        raum.add(MainActivity.alleStunden.get(64).raum);



        raum.add(MainActivity.alleStunden.get(5).raum);
        raum.add(MainActivity.alleStunden.get(11).raum);
        raum.add(MainActivity.alleStunden.get(17).raum);
        raum.add(MainActivity.alleStunden.get(23).raum);
        raum.add(MainActivity.alleStunden.get(29).raum);
        raum.add(MainActivity.alleStunden.get(35).raum);
        raum.add(MainActivity.alleStunden.get(41).raum);
        raum.add(MainActivity.alleStunden.get(47).raum);
        raum.add(MainActivity.alleStunden.get(53).raum);
        raum.add(MainActivity.alleStunden.get(59).raum);
        raum.add(MainActivity.alleStunden.get(65).raum);

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

    public void testRaum(){
        String tester = raum.getText().toString();
        String test="";
        if (tester.contains(",")) {
            test= tester.replace(",", "");;

            raum2 = test;
        }
        else {
            raum2 = tester;

        }

    }
}
