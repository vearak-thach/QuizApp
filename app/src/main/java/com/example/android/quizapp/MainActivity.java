package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.checked;
import static android.R.id.edit;
import static android.R.id.message;
import static android.R.id.switch_widget;
import static com.example.android.quizapp.R.id.all;
import static com.example.android.quizapp.R.id.checkbox;


public class MainActivity extends AppCompatActivity {

    int scoredPoint = 0;
    String wonderWoman = "Wonder Woman";

    RadioButton radioButton1b;
    RadioButton radioButton2d;
    CheckBox checkBoxAquaman;
    CheckBox checkBoxCyborg;
    CheckBox checkBoxGorillaGrodd;
    EditText editTextWonderWoman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButton1b = (RadioButton) findViewById(R.id.answer_button_1b);
        radioButton2d = (RadioButton) findViewById(R.id.answer_button_2d);
        checkBoxAquaman = (CheckBox) findViewById(R.id.checkbox_aquaman);
        checkBoxCyborg = (CheckBox) findViewById(R.id.checkbox_cyborg);
        checkBoxGorillaGrodd = (CheckBox) findViewById(R.id.checkbox_gorillaGrodd);
        editTextWonderWoman = (EditText) findViewById(R.id.answer_text1);
    }

    public void submitResult(View view) {
        displayMessage("You got " + calculatePoints() + "/4 correct.");
    }

    private int totalRadioButtonPoints() {
        if (radioButton1b.isChecked() && radioButton2d.isChecked()) {
            return scoredPoint + 2;
        } else if (radioButton1b.isChecked()) {
            return scoredPoint + 1;
        } else if (radioButton2d.isChecked()) {
            return scoredPoint + 1;
        } else
            return scoredPoint;
    }

    private int totalCheckBoxPoints() {
        if (checkBoxAquaman.isChecked() && checkBoxCyborg.isChecked() && !checkBoxGorillaGrodd.isChecked()) {
            return 1;
        } else
            return 0;

    }

    private int totalEditTextPoints() {
        if (editTextWonderWoman.equals(wonderWoman)) {
            return 1;
        } else
            return -1;
    }

    public int calculatePoints() {
        return totalRadioButtonPoints() + totalCheckBoxPoints() + totalEditTextPoints();
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.submit_quiz_result);
        orderSummaryTextView.setText(message);
    }
}


