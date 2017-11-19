package com.itou.moneycontrol;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

//import static com.itou.moneycontrol.MyDBHelper.TABLE_NAME;


public class Calculator extends AppCompatActivity implements View.OnClickListener {

  private EditText editText;
  private int recentOperator = R.id.button_equal;
  private boolean isOperatorKeyPushed;
  private double result;
  private Toolbar toolbar;
  private String category;
  public Button buttonok;
  private int price;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.calculator_layout);

    final MyDBHelper helper = new MyDBHelper(this);
    final SQLiteDatabase db = helper.getWritableDatabase();

    setView();
    editText = (EditText) findViewById(R.id.editText);
    initValue();
    buttonok = (Button) findViewById(R.id.button_ok);
    buttonok.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        price = Integer.parseInt(editText.getText().toString());
        Log.d("Price", "price=" + price);
        ContentValues contentValues = new ContentValues();
        contentValues.put("category", category);
        contentValues.put("price", price);
        db.insert("dataTable", null, contentValues);

      }
    });


  }

  View.OnClickListener buttonNumberListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      String str = editText.getText().toString();
      Button button;
      Button viewButton = (Button) view;
      double value;

      switch (view.getId()) {
        case R.id.button_dot:
          if (str.indexOf(".") == -1) {
            editText.append(viewButton.getText());
          }
          break;

        case R.id.button_clear:
          button = (Button) findViewById(R.id.button_clear);
          if (button.getText().equals("AC")) {
            initValue();
          } else if (button.getText().equals("C")) {
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
          if (str.equals("0")) {
            editText.setText("");
          }
          if (isOperatorKeyPushed) {
            editText.setText(viewButton.getText());
            button = (Button) findViewById(R.id.button_clear);
            button.setText("C");
          } else {
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


  //オプションメニューの画面遷移
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu, menu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.item1:
        Intent intent11 = new Intent(this, Calculator.class);
        startActivity(intent11);
        break;
      case R.id.item2:
        Intent intent12 = new Intent(this, DataBaseActivity.class);
        startActivity(intent12);
        break;
      case R.id.item3:
        Intent intent13 = new Intent(this, Calculator.class);
        startActivity(intent13);
        break;
    }
    return false;
  }


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


  private void initValue() {
    editText.setText("0");
    recentOperator = R.id.button_equal;
    isOperatorKeyPushed = true;
    result = 0.0;
  }


  void setView() {


//    findViewById(R.id.food).setOnClickListener(this);
//    findViewById(R.id.water).setOnClickListener(this);
//    findViewById(R.id.internet).setOnClickListener(this);
//    findViewById(R.id.drive).setOnClickListener(this);
//    findViewById(R.id.wear).setOnClickListener(this);
//    findViewById(R.id.thing).setOnClickListener(this);
//    findViewById(R.id.education).setOnClickListener(this);
//    findViewById(R.id.date).setOnClickListener(this);
//    findViewById(R.id.house).setOnClickListener(this);
//    findViewById(R.id.tax).setOnClickListener(this);
//    findViewById(R.id.other).setOnClickListener(this);
//    findViewById(R.id.button_ok).setOnClickListener(this);

    View.OnClickListener buttonCategoryListener = new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Button button = (Button) v;
        category = button.getText().toString();
        Log.d("category", "category=" + category);
      }
    };

    findViewById(R.id.food).setOnClickListener(buttonCategoryListener);
    findViewById(R.id.water).setOnClickListener(buttonCategoryListener);
    findViewById(R.id.internet).setOnClickListener(buttonCategoryListener);
    findViewById(R.id.drive).setOnClickListener(buttonCategoryListener);
    findViewById(R.id.wear).setOnClickListener(buttonCategoryListener);
    findViewById(R.id.thing).setOnClickListener(buttonCategoryListener);
    findViewById(R.id.education).setOnClickListener(buttonCategoryListener);
    findViewById(R.id.date).setOnClickListener(buttonCategoryListener);
    findViewById(R.id.house).setOnClickListener(buttonCategoryListener);
    findViewById(R.id.tax).setOnClickListener(buttonCategoryListener);
    findViewById(R.id.other).setOnClickListener(buttonCategoryListener);
    findViewById(R.id.button_ok).setOnClickListener(buttonCategoryListener);

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
    //findViewById(R.id.buttonOk).setOnClickListener(buttonOperatorListener);

    // / * + - =
    findViewById(R.id.button_div).setOnClickListener(buttonOperatorListener);
    findViewById(R.id.button_multiply).setOnClickListener(buttonOperatorListener);
    findViewById(R.id.button_sub).setOnClickListener(buttonOperatorListener);
    findViewById(R.id.button_add).setOnClickListener(buttonOperatorListener);
    findViewById(R.id.button_equal).setOnClickListener(buttonOperatorListener);


  }




  @Override
  public void onClick(View v) {

  }
}