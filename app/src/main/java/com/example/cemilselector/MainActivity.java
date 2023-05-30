package com.example.cemilselector;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton correctChoose, wrongChoose;
    TextView result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correctChoose = (RadioButton) findViewById(R.id.correctChoose);
        wrongChoose = (RadioButton) findViewById(R.id.wrongChoose);
        result = (TextView) findViewById(R.id.textResult);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedChoose = "Итог: ";
                if (correctChoose.isChecked()) {
                    selectedChoose+= "Души твоей больше нет.";
                }
                if (wrongChoose.isChecked()) {
                    selectedChoose+= "Душа твоя осталась на месте. Поздравляю.";
                }
                result.setText(selectedChoose);
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String str = "";
        switch (view.getId()) {
            case R.id.correctChoose:
                if (checked) {
                    str = "Ты принял, то решение, которое считаешь нужным. " +
                            "Ответы будут, но душу ты свою больше не почувствуешь. " +
                            "Каково твоему брату прямо сейчас? ";
                }
                break;case R.id.wrongChoose:
                if (checked) {
                    str = "Ты принял, то решение, которое считаешь нужным. " +
                            "Ответов не будет, но ты остался человеком. Молодец!";
                }
                break;
        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG * 100).show();

        // я не ебу то время чето не меняется. Я знаю, что ты полезешь в код поэтому я это напишу)
    }
}