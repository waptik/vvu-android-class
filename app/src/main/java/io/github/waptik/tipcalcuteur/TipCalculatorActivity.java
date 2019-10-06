package io.github.waptik.tipcalcuteur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import java.text.NumberFormat;

public class TipCalculatorActivity  extends AppCompatActivity {

    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentageFormat = NumberFormat.getCurrencyInstance();

    private double bill = 0.0;
    private double percent = .15;

    private TextView amountTextView;
    private TextView percentageTextView;
    private TextView tipTextView;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_calc);

        amountTextView = (TextView) findViewById(R.id.amountTextView);
        percentageTextView = (TextView) findViewById(R.id.percentageTextView);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);

        tipTextView.setText(currencyFormat.format(0));
        totalTextView.setText(currencyFormat.format(0));

        EditText amountEditText = (EditText) findViewById(R.id.amountEditText);
        amountEditText.addTextChangedListener(amountEditTextWatcher);

        SeekBar percentageSeekBar = (SeekBar) findViewById(R.id.percentageSeekBar);
        percentageSeekBar.setOnSeekBarChangeListener(seekBarListener);

        /**
         *  Button & event listener to go back to main activity
         */
        Button mainBtn = (Button) findViewById(R.id.mainBtn);
        mainBtn.setMovementMethod(LinkMovementMethod.getInstance());

        // for tipBtn
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TipCalculatorActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculate() {
        percentageTextView.setText(percentageFormat.format(percent));

        double tip = bill * percent;
        double total = bill + tip;

        tipTextView.setText(currencyFormat.format(tip));
        totalTextView.setText(currencyFormat.format(total));
    }

    private final OnSeekBarChangeListener seekBarListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            percent = progress / 100.0;
            calculate();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private final TextWatcher amountEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            try {
                bill = Double.parseDouble(s.toString()) / 100.0;
                amountTextView.setText(currencyFormat.format(bill));
            } catch (NumberFormatException e) {
                bill = 0.0;
                amountTextView.setText("");
            }
            calculate();
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
