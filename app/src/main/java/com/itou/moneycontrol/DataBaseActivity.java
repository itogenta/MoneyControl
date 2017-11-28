package com.itou.moneycontrol;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by itougenta on 2017/11/18.
 */

public class DataBaseActivity extends AppCompatActivity {
  private TextView textprice;
  private TextView category;
  public EditText editText;
  public Button buttonok;
  Settings.Global globals;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.database_layout);


    ScrollView scrollView = new ScrollView(this);
    LinearLayout linearLayout = new LinearLayout(this);
    linearLayout.setOrientation(LinearLayout.VERTICAL);
    scrollView.addView(linearLayout);
    setContentView(scrollView);

    MyDBHelper helper = new MyDBHelper(this);
    SQLiteDatabase db = helper.getReadableDatabase();


    Cursor cusor = db.query("dataTable", new String[]{"category", "price"}, null, null, null, null, null);

    boolean mov = cusor.moveToFirst();
    while (mov) {
      TextView textView = new TextView(this);
      textView.setText(String.format("%s %d", cusor.getString(0), cusor.getInt(1)));
      mov = cusor.moveToNext();
      linearLayout.addView(textView);
    }
    cusor.close();
    db.close();
  }

  //textprice = (TextView) findViewById(R.id.price_text);
  //textprice.setText(String.valueOf(db));
  //textprice.setText(getSumTotal(db));

//    category =(TextView)findViewById(R.id.category_text);
//   // category.setText(String.valueOf(db));
//    category.setText(getCategory(db));


//  public String getSumTotal(SQLiteDatabase db) {
//    Cursor cursor = null;
//
//    try {
//      cursor = db.query("dataTable", new String[]{"price"},
//              null, null, null, null, null);
//
//      return readCursur(cursor);
//
//    } finally {
//      if (cursor != null)
//        cursor.close();
//    }
//
//  }

//  public String readCursur(Cursor cursor) {
//    int indexPrice = cursor.getColumnIndex("price");
//    boolean move = cursor.moveToFirst();
//    move = cursor.moveToNext();
//
//    while (cursor.moveToNext()) {
//      int price = cursor.getInt(indexPrice);
//      result += price;
//    }
//    return String.valueOf(result);
//  }
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

}

