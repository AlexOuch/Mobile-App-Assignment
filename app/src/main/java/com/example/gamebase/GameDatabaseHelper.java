
package com.example.gamebase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "game.db";
    private static final Integer DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "game";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_IMAGE = "IMAGE";
    private static final String COL_CONSOLE = "CONSOLE";
    private static final String COL_DESCRIPTION = "DESCRIPTION";
    private static final String COL_PRICE = "PRICE";

    private static GameDatabaseHelper mInstance = null;
    public static synchronized GameDatabaseHelper getInstance(Context context){
        if (mInstance == null){
            mInstance = new GameDatabaseHelper(context.getApplicationContext());
        }
        return mInstance;
    }

    private static final String CREATE_TABLE_ST = "CREATE TABLE " + TABLE_NAME + "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT, " +
            COL_IMAGE + " TEXT, " +
            COL_CONSOLE + " TEXT, " +
            COL_DESCRIPTION + " TEXT, " +
            COL_PRICE + " INTEGER, " + ")";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private static final String GET_ALL_ST = "SELECT * FROM " + TABLE_NAME;

    GameDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ST);
        //String createStatement = "CREATE TABLE GAME(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT"
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public Long insert(String name, String console, String description, Integer price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_IMAGE, getRandomImageName());
        contentValues.put(COL_CONSOLE, console);
        contentValues.put(COL_DESCRIPTION, description);
        contentValues.put(COL_PRICE, price);

        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();

        return result;
    }

    private String getRandomImageName() {
        Random random = new Random();
        int value = random.nextInt(30) + 1;
        return "monster_"+value;
    }

    public boolean update(Long id, String name, String console, String description, Integer price){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_ID, id);
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_CONSOLE, console);
        contentValues.put(COL_DESCRIPTION, description);
        contentValues.put(COL_PRICE, price);

        int numOfRowsUpdated = db.update(TABLE_NAME, contentValues,"ID = ?", new String[]{ id.toString()});
        db.close();
        return numOfRowsUpdated == 1;
    }

    public boolean delete (Long id){
        SQLiteDatabase db = this.getWritableDatabase();

        String valueArray[] = new String[1];
        valueArray[1] = id.toString();

        int numOfRowsDeleted = db.delete(TABLE_NAME, "ID = ?", valueArray );

        db.close();

        return numOfRowsDeleted == 1;
    }

    public List<Game> getGames(){
        List<Game> games = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(GET_ALL_ST, null);
        if(cursor.getCount() > 0){
            Game game;
            while(cursor.moveToNext()){
                Long id = cursor.getLong(0);
                String name = cursor.getString(1);
                String image = cursor.getString(2);
                String console = cursor.getString(3);
                String description = cursor.getString(4);
                Integer price = cursor.getInt(5);

                game = new Game();
                //game.add(game);
            }
        }
        cursor.close();

        return games;
    }
}