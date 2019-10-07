package io.github.waptik.classactivity3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtext1;
    EditText edtext2;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtext1 = (EditText) findViewById(R.id.edtext1);
        edtext2 = (EditText) findViewById(R.id.edtext2);
        tv1 = (TextView) findViewById(R.id.tv1);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        Double num1 = Double.parseDouble(edtext1.getText().toString());
        Double num2 = Double.parseDouble(edtext2.getText().toString());
        Double sum = num1 + num2;
        Double moins = num1 - num2;
        Double div = num1 / num2;
        Double times = num1 * num2;
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.add:
                if (checked)
                    tv1.setText(String.valueOf(sum));
                    break;
            case R.id.times:
                if (checked)
                    tv1.setText(String.valueOf(times));
                    break;
            case R.id.minus:
                if (checked)
                    tv1.setText(String.valueOf(moins));
                    break;
            case R.id.divide:
                if (checked)
                    tv1.setText(String.valueOf(div));
                    break;
        }
    }
}
