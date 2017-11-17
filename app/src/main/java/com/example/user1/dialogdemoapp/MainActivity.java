package com.example.user1.dialogdemoapp;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private AlertDialog.Builder builder;
    private DatePickerDialog myDatePicker;
    private Button btnQuit;
    private TextView tvDateSelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQuit = (Button) findViewById(R.id.btnQuit);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(getResources().getString(R.string.dialog_title));
                builder.setMessage(getResources().getString(R.string.dialog_message));
                builder.setCancelable(false);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog myDialog = builder.create();
                myDialog.show();

            }
        });

        tvDateSelected = (TextView) findViewById(R.id.tvDateSelected);

    }

    public void showDatePickerDialog(View v) {
        Calendar calendar = Calendar.getInstance();
        int year_x = calendar.get(Calendar.YEAR);
        int month_x = calendar.get(Calendar.MONTH);
        int day_x = calendar.get(Calendar.DAY_OF_MONTH);
        myDatePicker = new DatePickerDialog(this, MainActivity.this, year_x, month_x, day_x);

        myDatePicker.show();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        tvDateSelected.setText("Selected date is " + (month + 1) + "/" + dayOfMonth + "/" + year);
    }
}