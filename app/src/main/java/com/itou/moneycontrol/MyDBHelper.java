package com.itou.moneycontrol;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.github.mikephil.charting.charts.Chart.LOG_TAG;

/**
 * Created by itougenta on 2017/11/19.
 */

public class MyDBHelper extends SQLiteOpenHelper {

  public static final String TABLE_NAME = "data_table";
  //テーブル名
  public static final String PET_NAME_KEY = "name";
  public static final String PET_TYPE_KEY = "type";

  public MyDBHelper(Context context)
  {
    super(context,"categoryDB",null,1);
  }

  /**テーブルの初期化*/
  @Override
  public void onCreate(SQLiteDatabase db)
  {
    try{
      db.execSQL(
              String.format(
                      "create table %s (" +
                              "_id integer primary key autoincrement not null, " +
                              "category text not null" +
                              "price integer not null"+
                              ");",
                      TABLE_NAME)
      );
    }catch(SQLiteException err){
      Log.e(LOG_TAG, "sql statement is invalid");
    }
  }

  /**データベースのアップグレード時の処理*/
  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
  {

  }
}
