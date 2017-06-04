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

/**
 * This app displays the results for a short quiz.
 */
public class MainActivity extends AppCompatActivity {

    int scoredPoint = 0;
    String wonderWoman = "Wonder Woman";

    RadioButton radioButton1b;
    RadioButton radioButton2d;
    CheckBox checkBoxAquaman;
    CheckBox checkBoxCyborg;
    CheckBox checkBoxGorillaGrodd;
    EditText editTextWonderWoman;
    EditText name;

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
        name = (EditText) findViewById(R.id.enterName);
    }

    /**
     * This method is called when the submit quiz is clicked.
     *
     * @param view View
     */
    public void submitResult(View view) {
        String nameEntry = name.getText().toString();
        displayMessage("Name: " + nameEntry + " results: " + calculatePoints() + "/4 correct.");
        Toast.makeText(this, "You got " + calculatePoints() + "/4 correct.", Toast.LENGTH_SHORT).show();
    }

    /**
     * This method adds points when correct radioButtons are clicked.
     *
     * @return int
     */
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

    /**
     * This method adds one point if correct checkBoxes are checked.
     *
     * @return int
     */
    private int totalCheckBoxPoints() {
        if (checkBoxAquaman.isChecked() && checkBoxCyborg.isChecked() && !checkBoxGorillaGrodd.isChecked()) {
            return 1;
        } else
            return 0;
    }

    /**
     * This method adds one point if user enters in correct text
     *
     * @return int
     */
    private int totalEditTextPoints() {
        String userText = editTextWonderWoman.getText().toString();
        if (userText.equals(wonderWoman)) {
            return 1;
        } else
            return 0;
    }

    /**
     * This method calculates the total of points.
     *
     * @return int
     */
    public int calculatePoints() {
        return totalRadioButtonPoints() + totalCheckBoxPoints() + totalEditTextPoints();
    }

    /**
     * Set message as a String.
     *
     * @param message String
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.submit_quiz_result);
        orderSummaryTextView.setText(message);
    }
}


