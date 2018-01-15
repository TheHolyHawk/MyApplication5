package com.example.paulfranken.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.colorpicker.ColorPickerDialog;
import com.android.colorpicker.ColorPickerSwatch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import static com.example.paulfranken.myapplication.WidgetProvider.raum2;

public class neueStunde_java extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    String tag="JJ";

    Button farbe;
    Button hinzufügen;
    Spinner fach;
    Spinner kurs;
    public Calendar datumheute = Calendar.getInstance();
    Spinner nummer;
    AutoCompleteTextView raum;
    public ArrayList<String>facher=new ArrayList<>();


    static int farbeint=-769482;
    private ArrayAdapter<String>adapter;
    public static boolean bearbeiten=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neue_stunde_java);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        farbe=(Button)findViewById(R.id.button);
        farbe.setOnClickListener(this);


        String raum2="";
        String string;
        string="    "+MainActivity.textviews.get(MainActivity.testi).stunde+".Stunde "+MainActivity.textviews.get(MainActivity.testi).tag;
        setTitle(string);


        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MainActivity.raum_vorschlage);


        fach=(Spinner)findViewById(R.id.spinner);
        fach.setOnItemSelectedListener(this);


        kurs=(Spinner)findViewById(R.id.spinner2);
        raum=(AutoCompleteTextView) findViewById(R.id.editText);
        nummer=(Spinner) findViewById(R.id.spinner3);

        raum.setAdapter(adapter);


        facher.add("Englisch");
        facher.add("Religion");
        facher.add("Musik");
        facher.add("Erdkunde");
        facher.add("Deutsch");
        facher.add("Mathe");
        facher.add("Latein");
        facher.add("Politik");
        facher.add("Info");
        facher.add("Sport");
        facher.add("Biologie");
        facher.add("Spanisch");
        facher.add("Chemie");
        facher.add("Geschichte");
        facher.add("Physik");
        facher.add("Kunst");
        facher.add("Philosophie");
        facher.add("Latein");
        facher.add("Literatur");
        facher.add("K.Religion");
        facher.add("S8");






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

                testRaum();

                MainActivity.textviews.get(MainActivity.testi).setText(fach.getSelectedItem().toString()+"\n"+"\n"+raum2);
                MainActivity.textviews.get(MainActivity.testi).farbe=String.valueOf(farbeint);
                MainActivity.textviews.get(MainActivity.testi).kurs=kurs.getSelectedItem().toString();
                MainActivity.textviews.get(MainActivity.testi).nummer=nummer.getSelectedItem().toString();



                String weekDay;
                SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.US);

                Calendar calendar = Calendar.getInstance();
                weekDay = dayFormat.format(calendar.getTime());

                if(weekDay.equals("Monday")){

                   if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Montag")){
                       datumheute.add(Calendar.DATE,0);
                       SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                       String formatted = format1.format(datumheute.getTime());
                       MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                   }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Dienstag")){
                        datumheute.add(Calendar.DATE,1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Mittwoch")){
                        datumheute.add(Calendar.DATE,2);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Donnerstag")){
                        datumheute.add(Calendar.DATE,3);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Freitag")){
                        datumheute.add(Calendar.DATE,4);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Samstag")){
                        datumheute.add(Calendar.DATE,5);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    } if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Sonntag")){
                        datumheute.add(Calendar.DATE,6);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                }
                if(weekDay.equals("Tuesday")){
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Montag")){
                        datumheute.add(Calendar.DATE,-1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Dienstag")){
                        datumheute.add(Calendar.DATE,0);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Mittwoch")){
                        datumheute.add(Calendar.DATE,1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Donnerstag")){
                        datumheute.add(Calendar.DATE,2);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Freitag")){
                        datumheute.add(Calendar.DATE,3);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Samstag")){
                        datumheute.add(Calendar.DATE,4);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    } if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Sonntag")){
                        datumheute.add(Calendar.DATE,5);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                }
                if(weekDay.equals("Wednesday")){
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Montag")){
                        datumheute.add(Calendar.DATE,-2);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Dienstag")){
                        datumheute.add(Calendar.DATE,-1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Mittwoch")){
                        datumheute.add(Calendar.DATE,0);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Donnerstag")){
                        datumheute.add(Calendar.DATE,1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Freitag")){
                        datumheute.add(Calendar.DATE,2);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Samstag")){
                        datumheute.add(Calendar.DATE,3);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    } if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Sonntag")){
                        datumheute.add(Calendar.DATE,4);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                }
                if(weekDay.equals("Thursday")){
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Montag")){
                        datumheute.add(Calendar.DATE,-3);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Dienstag")){
                        datumheute.add(Calendar.DATE,-2);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Mittwoch")){
                        datumheute.add(Calendar.DATE,-1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Donnerstag")){
                        datumheute.add(Calendar.DATE,0);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Freitag")){
                        datumheute.add(Calendar.DATE,1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Samstag")){
                        datumheute.add(Calendar.DATE,2);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    } if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Sonntag")){
                        datumheute.add(Calendar.DATE,3);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                }
                if(weekDay.equals("Friday")){

                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Montag")){
                        datumheute.add(Calendar.DATE,-4);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Dienstag")){
                        datumheute.add(Calendar.DATE,-3);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Mittwoch")){
                        datumheute.add(Calendar.DATE,-2);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Donnerstag")){
                        datumheute.add(Calendar.DATE,-1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Freitag")){
                        datumheute.add(Calendar.DATE,0);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Samstag")){
                        datumheute.add(Calendar.DATE,1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    } if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Sonntag")){
                        datumheute.add(Calendar.DATE,2);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                }
                if(weekDay.equals("Saturday")){
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Montag")){
                        datumheute.add(Calendar.DATE,-5);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Dienstag")){
                        datumheute.add(Calendar.DATE,-4);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Mittwoch")){
                        datumheute.add(Calendar.DATE,-3);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Donnerstag")){
                        datumheute.add(Calendar.DATE,-2);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Freitag")){
                        datumheute.add(Calendar.DATE,-1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Samstag")){
                        datumheute.add(Calendar.DATE,0);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    } if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Sonntag")){
                        datumheute.add(Calendar.DATE,1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                }
                if(weekDay.equals("Sunday")){

                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Montag")){
                        datumheute.add(Calendar.DATE,-6);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Dienstag")){
                        datumheute.add(Calendar.DATE,-5);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Mittwoch")){
                        datumheute.add(Calendar.DATE,-4);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Donnerstag")){
                        datumheute.add(Calendar.DATE,-3);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }

                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Freitag")){
                        datumheute.add(Calendar.DATE,-2);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                    if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Samstag")){
                        datumheute.add(Calendar.DATE,-1);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    } if( MainActivity.textviews.get(MainActivity.testi).tag.equals("Sonntag")){
                        datumheute.add(Calendar.DATE,0);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd");
                        String formatted = format1.format(datumheute.getTime());
                        MainActivity.textviews.get(MainActivity.testi).datum=formatted;

                    }
                }


                MainActivity.textviews.get(MainActivity.testi).fach=fach.getSelectedItem().toString();

                MainActivity.textviews.get(MainActivity.testi).platz=String.valueOf(MainActivity.testi);
                if(!String.valueOf(raum2).equals("")){
                    MainActivity.textviews.get(MainActivity.testi).raum=String.valueOf(raum2);
                }else{
                    MainActivity.textviews.get(MainActivity.testi).raum=" ";
                }
                MainActivity.textviews.get(MainActivity.testi).aktualisieren();



                speichern();

widget_speichern();
                WidgetProvider.updateWidget(getApplicationContext());
                this.finish();

                return true;
            }

            return super.onOptionsItemSelected(item);
        }


    @Override
    public void onClick(View view) {
        if (view.equals(farbe)) {

                    showColourPicker(view);
                }




    }
    public  void speichern(){
        umwandelnhin();
        StringBuilder stringBuilder=new StringBuilder();
        for(String s: MainActivity.texte){
            stringBuilder.append(s);
            stringBuilder.append(",");


        }


        SharedPreferences settings=getSharedPreferences("PREFS",0);
        SharedPreferences.Editor editor=settings.edit();

        editor.putString("words",stringBuilder.toString());

        editor.commit();

    }

    public void umwandelnhin() {



        MainActivity.texte.add((String) MainActivity.textviews.get(MainActivity.testi).getText());
        MainActivity.texte.add((String) MainActivity.textviews.get(MainActivity.testi).farbe);
        MainActivity.texte.add((String) MainActivity.textviews.get(MainActivity.testi).kurs);
        MainActivity.texte.add((String) MainActivity.textviews.get(MainActivity.testi).nummer);
        MainActivity.texte.add((String) MainActivity.textviews.get(MainActivity.testi).datum);
        MainActivity.texte.add((String) MainActivity.textviews.get(MainActivity.testi).platz);
        MainActivity.texte.add(MainActivity.textviews.get(MainActivity.testi).fach);
        MainActivity.texte.add(MainActivity.textviews.get(MainActivity.testi).raum);

    }





    public void showColourPicker(View view) {
        final ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
        colorPickerDialog.initialize(R.string.color_picker_default_title,
                new int[] {

                        getResources().getColor(R.color.f11),
                        getResources().getColor(R.color.f12),
                        getResources().getColor(R.color.f15),

                        getResources().getColor(R.color.f17),
                        getResources().getColor(R.color.f2),
                        getResources().getColor(R.color.f3),


                        getResources().getColor(R.color.f13),
                        getResources().getColor(R.color.f14),
                        getResources().getColor(R.color.f5),
                        getResources().getColor(R.color.f6),
                        getResources().getColor(R.color.f7),
                        getResources().getColor(R.color.f4),
                        getResources().getColor(R.color.f8),
                        getResources().getColor(R.color.f9),
                        getResources().getColor(R.color.f10),





                        getResources().getColor(R.color.f19),

                        getResources().getColor(R.color.f20),
                        getResources().getColor(R.color.f21),
                        getResources().getColor(R.color.f22),







                }, 5, 4, 2);

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


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


        boolean Z=false;

        int f=0;

        for(int m=0;m<MainActivity.textviews.size();m++){
            if(!MainActivity.textviews.get(m).fach.equals(fach.getSelectedItem())){


            }else{
                Z=true;
                f=m;

            }

        }
        if(Z==true){

           farbe.setClickable(false);
            kurs.setClickable(false);
            nummer.setClickable(false);
            if(MainActivity.textviews.get(f).kurs.equals("LK")){
                kurs.setSelection(1);
            }else{
                kurs.setSelection(0);
            }



            if(MainActivity.textviews.get(f).nummer.equals("1")){
                nummer.setSelection(0);
            }
            else if(MainActivity.textviews.get(f).nummer.equals("2")){
                nummer.setSelection(1);
            }
            else if(MainActivity.textviews.get(f).nummer.equals("3")){
                nummer.setSelection(2);
            }
            else if(MainActivity.textviews.get(f).nummer.equals("4")){
                nummer.setSelection(3);
            }
            else if(MainActivity.textviews.get(f).nummer.equals("5")){
                nummer.setSelection(4);
            }









           farbeint=Integer.parseInt(MainActivity.textviews.get(f).farbe);
            farbe.setBackgroundTintList(ColorStateList.valueOf(farbeint));
        }
        if(Z==false){
            farbe.setClickable(true);
            kurs.setClickable(true);
            nummer.setClickable(true);
        }




    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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