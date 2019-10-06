package io.github.waptik.tipcalcuteur;

/**
 * Multi Activity tutorial from www.tutlane.com
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.method.LinkMovementMethod;

import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *  Buttons and Onclick events
         */
        Button tipBtn = (Button) findViewById(R.id.tipBtn);
        tipBtn.setMovementMethod(LinkMovementMethod.getInstance());
        Button gradeBtn = (Button) findViewById(R.id.gradeBtn);
        gradeBtn.setMovementMethod(LinkMovementMethod.getInstance());

        // for tipBtn
        tipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TipCalculatorActivity.class);
                startActivity(intent);
            }
        });

        // for gradeBtn
        gradeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GradeCheckerActivity.class);
                startActivity(intent);
            }
        });
    }
}
