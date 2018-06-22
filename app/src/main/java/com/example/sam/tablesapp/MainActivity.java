package com.example.sam.tablesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public void generateTimetable(int timetable)
    {
        //int timetable=10;
        ListView list = (ListView) findViewById(R.id.list);
        ArrayList<String> table = new ArrayList<String>();



        for (int i = 1; i <= 10; i++)
        {
            table.add(Integer.toString(i* timetable));

        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,table);
        list.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar=(SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        int timetable;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min=1;
                int timetable=0;
                if(progress<1)
                {
                    timetable=min;
                    seekBar.setProgress(min);
                }
                else
                    timetable=progress;

                Log.i("Seekbar value",Integer.toString(timetable));
                generateTimetable(timetable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimetable(10);
    }
}
