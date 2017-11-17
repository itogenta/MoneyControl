package com.itou.moneycontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;


public class Calculator extends AppCompatActivity {

  private EditText editText;
  private int recentOperator = R.id.button_equal;
  private boolean isOperatorKeyPushed;
  private double result;

  View.OnClickListener buttonNumberListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      String str = editText.getText().toString();
      Button button;
      Button viewButton = (Button) view;
      double value;

      switch(view.getId()){
        case R.id.button_dot:
          if(str.indexOf(".") == -1){
            editText.append(viewButton.getText());
          }
          break;

        case R.id.button_clear:
          button = (Button)findViewById(R.id.button_clear);
          if(button.getText().equals("AC")){
            initValue();
          }
          else if(button.getText().equals("C")){
            button.setText("AC");
            editText.setText("0");
          }
          break;

        case R.id.button_add_sub:
          value = -1 * Double.parseDouble(str);
          editText.setText(String.valueOf(value));
          break;

        case R.id.button_percent:
          value = Double.parseDouble(str) / 1000;
          editText.setText(String.valueOf(value));
          break;

        default:
          if(str.equals("0")){
            editText.setText("");
          }
          if(isOperatorKeyPushed){
            editText.setText(viewButton.getText());
            button = (Button)findViewById(R.id.button_clear);
            button.setText("C");
          }
          else {
            editText.append(viewButton.getText());
          }
          break;
      }
      isOperatorKeyPushed = false;
    }
  };



  View.OnClickListener buttonOperatorListener = new View.OnClickListener() {

    @Override
    public void onClick(View view) {
      Button operatorButton = (Button) view;
      double value = Double.parseDouble(editText.getText().toString());
      if (recentOperator == R.id.button_equal) {
        result = value;
      } else {
        result = calc(recentOperator, result, value);
        editText.setText(String.valueOf(result));
      }
      recentOperator = operatorButton.getId();
      isOperatorKeyPushed = true;
    }
  };



  double calc(int operator, double value1, double value2) {
    switch (operator) {
      case R.id.button_add:
        return value1 + value2;
      case R.id.button_sub:
        return value1 - value2;
      case R.id.button_multiply:
        return value1 * value2;
      case R.id.button_div:
        return value1 / value2;
      default:
        return value1;
    }
  }



  private void initValue(){
    editText.setText("0");
    recentOperator = R.id.button_equal;
    isOperatorKeyPushed = true;
    result = 0.0;
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.calculator_layout);

    editText = (EditText) findViewById(R.id.editText);
    initValue();

    //0-9 . AC C +/- %
    findViewById(R.id.button_1).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_2).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_3).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_4).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_5).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_6).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_7).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_8).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_9).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_0).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_dot).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_clear).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_add_sub).setOnClickListener(buttonNumberListener);
    findViewById(R.id.button_percent).setOnClickListener(buttonNumberListener);

    // / * + - =
    findViewById(R.id.button_div).setOnClickListener(buttonOperatorListener);
    findViewById(R.id.button_multiply).setOnClickListener(buttonOperatorListener);
    findViewById(R.id.button_sub).setOnClickListener(buttonOperatorListener);
    findViewById(R.id.button_add).setOnClickListener(buttonOperatorListener);
    findViewById(R.id.button_equal).setOnClickListener(buttonOperatorListener);
  }
}