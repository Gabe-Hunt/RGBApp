package com.example.rgbapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // All SeekBars are found by their id's
        SeekBar redBar = findViewById(R.id.redSeekBar);
        SeekBar greenBar = findViewById(R.id.greenSeekBar);
        SeekBar blueBar = findViewById(R.id.blueSeekBar);

        /**
         * Defines actions when redSeekBar moves
         */
        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            /**
             * Updates current color and redLabel
             */
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = seekBar.getProgress();
                TextView view = findViewById(R.id.redLabel);
                view.setText(String.format(Locale.US, "%d", value));
                addRGB();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        /**
         * Defines actions when greenSeekBar moves
         */
        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            /**
             * Updates current color and greenLabel
             */
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = seekBar.getProgress();
                TextView view = findViewById(R.id.greenLabel);
                view.setText(String.format(Locale.US, "%d", value));
                addRGB();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        /**
         * Defines actions taken when blueSeekBar moves
         */
        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            /**
             * Updates current color and blueLabel
             */
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int value = seekBar.getProgress();
                TextView view = findViewById(R.id.blueLabel);
                view.setText(String.format(Locale.US, "%d", value));
                addRGB();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


    }

    /**
     * Takes current value of SeekBars and converts to hex. Changes background of TextView accordingly
     */
    public void addRGB() {
        SeekBar redBar = findViewById(R.id.redSeekBar);
        SeekBar greenBar = findViewById(R.id.greenSeekBar);
        SeekBar blueBar = findViewById(R.id.blueSeekBar);

        String rgbString = "#" + Integer.toHexString(redBar.getProgress()) + Integer.toHexString(greenBar.getProgress()) + Integer.toHexString(blueBar.getProgress());
        TextView output = findViewById(R.id.outputLabel);
        output.setText(rgbString);
        output.setBackgroundColor(Color.rgb(redBar.getProgress(), greenBar.getProgress(), blueBar.getProgress()));
    }
}
