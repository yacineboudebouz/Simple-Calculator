package com.example.calculatorpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {
    private EditText show;
    private TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tx = findViewById(R.id.textView);
        show = findViewById(R.id.number);
        show.setShowSoftInputOnFocus(false);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(show.getText().toString())){
                    show.setText("");
                }
            }
        });
    }
    private void updateText(String str2add)
    {
        String old = show.getText().toString();
        int position = show.getSelectionStart();
        String leftstr = old.substring(0,position);
        String rightstr = old.substring(position);
        if(getString(R.string.display).equals(show.getText().toString())){
            show.setText(str2add);
            show.setSelection(position + 1);
        }
        show.setText(String.format("%s%s%s",leftstr,str2add,rightstr));
        show.setSelection(position + 1);
    }

    public void zeroBTN(View v){
        updateText("0");
    }
    public void oneBTN(View v){
        updateText("1");
    }
    public void twoBTN(View v){
        updateText("2");
    }
    public void threeBTN(View v){
        updateText("3");
    }
    public void fourBTN(View v){
        updateText("4");
    }
    public void fiveBTN(View v){
        updateText("5");
    }
    public void sixBTN(View v){
        updateText("6");
    }
    public void sevenBTN(View v){
        updateText("7");
    }
    public void eightBTN(View v){
        updateText("8");
    }
    public void nineBTN(View v){
        updateText("9");
    }
    public void sumBTN(View v){
        updateText("+");
    }
    public void sousBTN(View v){
        updateText("-");
    }
    public void mulBTN(View v){
        updateText("*");
    }
    public void divBTN(View v){
        updateText("/");
    }
    public void pointBTN(View v){
        updateText(".");
    }
    public void openBTN(View v){
        updateText("(");
    }
    public void closeBTN(View v){
        updateText(")");
    }
    public void clearBTN(View v){
        show.setText("");
    }
    public void equalBTN(View v){
        String expn = show.getText().toString();
        Expression exp = new Expression(expn);
        String rslt = String.valueOf(exp.calculate());
        tx.setText(rslt);
        show.setSelection(expn.length());
    }
    public void positiveBTN(View v){
        updateText("-");
    }

    public void removeBTN(View v){
        int position = show.getSelectionStart();
        int textLen = show.getText().length();
        if(position != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) show.getText();
            selection.replace(position-1,position,"");
            show.setText(selection);
            show.setSelection(position - 1);
        }
    }
    public void powerBTN(View v){
        updateText("^");
    }
}

