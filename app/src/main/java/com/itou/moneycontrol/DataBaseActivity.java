package com.itou.moneycontrol;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by itougenta on 2017/11/18.
 */

public class DataBaseActivity extends AppCompatActivity {
  private TextView textprice;
  private String category;
  public EditText editText;
  public Button buttonok;
  Settings.Global globals;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.database_layout);


    MyDBHelper helper = new MyDBHelper(this);
    SQLiteDatabase db = helper.getReadableDatabase();

    textprice =(TextView)findViewById(R.id.data_text);
    globals =(Settings.Global)this.getApplication();
    globals.textprice = Integer.parseInt(getSumTotal);




  public String getSumTotal(SQLiteDatabase db) {
    Cursor cursor = null;
    try{
      cursor = db.query(MyDBHelper.TABLE_NAME, new String[]{"price"},
              null, null, null, null, null);
      return readCursur(cursor);
    } finally{
      if (cursor != null)
        cursor.close();
    }
  }

  public String readCursur(Cursor cursor) {
    int result = 0;
    int indexPrice = cursor.getColumnIndex("price");

    while (cursor.moveToNext()) {
      int price = cursor.getInt(indexPrice);
      result += price;
    }
    return String.valueOf(result);
  }


 }

