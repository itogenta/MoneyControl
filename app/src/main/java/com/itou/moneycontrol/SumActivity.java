package com.itou.moneycontrol;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by itougenta on 2017/11/18.
 */

public class SumActivity extends AppCompatActivity {

  private TextView textprice;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.sum_layout);

    MyDBHelper helper = new MyDBHelper(this);
    SQLiteDatabase db = helper.getReadableDatabase();

    textprice = (TextView) findViewById(R.id.price_text);
    //textprice.setText(String.valueOf(db));
    textprice.setText(getSumTotal(db));
  }

  public String getSumTotal(SQLiteDatabase db) {
    Cursor cursor = null;

    try {
      cursor = db.query("dataTable", new String[]{"price"},
              null, null, null, null, null);

      return readCursur(cursor);

    } finally {
      if (cursor != null)
        cursor.close();
    }

  }

  public String readCursur(Cursor cursor) {
    int result = 0;
    int indexPrice = cursor.getColumnIndex("price");
    boolean move = cursor.moveToFirst();
    move = cursor.moveToNext();

    while (cursor.moveToNext()) {
      int price = cursor.getInt(indexPrice);
      result += price;
    }
    return String.valueOf(result);
  }
}
//
//  public String readcategoryCursur(Cursor cursor) {
//    String result = null;
//    String indexPrice = cursor.getColumnIndex("category");
//
//    while (cursor.moveToNext()) {
//      String category = cursor.getInt(indexPrice);
//      result += category;
//    }
//    return String.valueOf(result);
//  }


//  public String getCategory(SQLiteDatabase db) {
//    Cursor cursor = null;
//
//    try {
//      cursor = db.query(MyDBHelper.TABLE_NAME, new String[]{"category"},
//              null, null, null, null, null);
//      return readcategoryCursur(cursor);
//
//    } finally
//    {
//      if (cursor != null)
//        cursor.close();
//    }
//
//  }




