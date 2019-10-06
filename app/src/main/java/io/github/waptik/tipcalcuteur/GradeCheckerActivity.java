package io.github.waptik.tipcalcuteur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GradeCheckerActivity  extends AppCompatActivity {

    private TextView gradeResultTextView;
    private TextView GradeTextView;
    private  EditText gradeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grade);

        GradeTextView = (TextView) findViewById(R.id.gardeTextView);
        GradeTextView.setEnabled(false); // disable textview editable


        /**
         *  Button & event listener to go back to main activity
         */
        Button mainBtn = (Button) findViewById(R.id.mainBtn);
        mainBtn.setMovementMethod(LinkMovementMethod.getInstance());

        // for tipBtn
        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GradeCheckerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        /**
         *  event listener for grade submission button
         */
        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setMovementMethod(LinkMovementMethod.getInstance());

        // TextView

        gradeResultTextView = (TextView) findViewById(R.id.gradeResultTextView);
        gradeEditText = (EditText) findViewById(R.id.gradeEditText);


        // for submitBtn
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scoreEmpty = gradeEditText.getText().toString();


                int score = Integer.parseInt(scoreEmpty);
                String rs = "Your grade is: ";


                if (scoreEmpty.isEmpty()) {
                    gradeResultTextView.setText("Nothing here!");
                } else if(score >= 79) {
                    gradeResultTextView.setText(rs + "A");
                } else if(score >= 60 || score == 78) {
                        gradeResultTextView.setText(rs + "B");
                    } else if(score == 50) {
                            gradeResultTextView.setText(rs + "C");
                        } else if(score == 49 || score >= 40) {
                    gradeResultTextView.setText(rs + "C-");
                } else{
                                    gradeResultTextView.setText(rs + "F");
                                }
            } // onclick
        });
    }
}
