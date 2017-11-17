package com.itou.moneycontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

/**
 * Created by itougenta on 2017/11/17.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;


public class Calculator {


  /**
   * Created by itougenta on 2017/11/13.
   */

  public class CaluculaterActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText editText;
    private int recentOperetor = R.id.buttonOk;
    private boolean isOperatorKeyPus;


    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.calculator_layout);

      // setToolbar();
    }

//  public void setToolbar() {
//    toolbar = (Toolbar) findViewById(R.id.toolbar);
//    setSupportActionBar(toolbar);
//    getSupportActionBar().setTitle("電卓の表示");
//    toolbar.setNavigationIcon(R.mipmap.ic_launcher);
//    toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Intent intent = new Intent(this,.class);
//        startActivity(intent);
//      }
//    });

  }
//}

}
