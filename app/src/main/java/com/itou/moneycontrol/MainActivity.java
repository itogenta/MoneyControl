package com.itou.moneycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11;
  private Toolbar toolbar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.item_layout);

    setView();



  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu){
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




  void setView() {
    button1 = (Button) findViewById(R.id.food);
    button2 = (Button) findViewById(R.id.water);
    button3 = (Button) findViewById(R.id.internet);
    button4 = (Button) findViewById(R.id.drive);
    button5 = (Button) findViewById(R.id.wear);
    button6 = (Button) findViewById(R.id.thing);
    button7 = (Button) findViewById(R.id.education);
    button8 = (Button) findViewById(R.id.date);
    button9 = (Button) findViewById(R.id.house);
    button10 = (Button) findViewById(R.id.tax);
    button11 = (Button) findViewById(R.id.other);

    button1.setOnClickListener(this);
    button2.setOnClickListener(this);
    button3.setOnClickListener(this);
    button4.setOnClickListener(this);
    button5.setOnClickListener(this);
    button6.setOnClickListener(this);
    button7.setOnClickListener(this);
    button8.setOnClickListener(this);
    button9.setOnClickListener(this);
    button10.setOnClickListener(this);
    button11.setOnClickListener(this);


  }

  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.food:
        Intent intent = new Intent(this, Calculator.class);
        startActivity(intent);
        break;
      case R.id.water:
        Intent intent1 = new Intent(this, Calculator.class);
        startActivity(intent1);
        break;
      case R.id.internet:
        Intent intent2 = new Intent(this, Calculator.class);
        startActivity(intent2);
        break;
      case R.id.drive:
        Intent intent3 = new Intent(this, Calculator.class);
        startActivity(intent3);
        break;
      case R.id.wear:
        Intent intent4 = new Intent(this, Calculator.class);
        startActivity(intent4);
        break;
      case R.id.thing:
        Intent intent5 = new Intent(this, Calculator.class);
        startActivity(intent5);
        break;
      case R.id.education:
        Intent intent6 = new Intent(this, Calculator.class);
        startActivity(intent6);
        break;
      case R.id.date:
        Intent intent7 = new Intent(this, Calculator.class);
        startActivity(intent7);
        break;
      case R.id.house:
        Intent intent8 = new Intent(this, Calculator.class);
        startActivity(intent8);
        break;
      case R.id.tax:
        Intent intent9 = new Intent(this, Calculator.class);
        startActivity(intent9);
        break;
      case R.id.other:
        Intent intent10 = new Intent(this, Calculator.class);
        startActivity(intent10);
        break;
    }
  }


}