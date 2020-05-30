import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class GameDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "game.db";
    private static final Integer DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "game";
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
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
            COL_CONSOLE + " TEXT, " +
            COL_DESCRIPTION + " TEXT, " +
            COL_PRICE + " INTEGER, " + ")";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private GameDatabaseHelper(@Nullable Context context) {
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
        onCreate();
    }

    public Long insert(String name, String console, String description, Integer price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, name);
        contentValues.put(COL_CONSOLE, console);
        contentValues.put(COL_DESCRIPTION, description);
        contentValues.put(COL_PRICE, price);

        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();

        return result;
    }
}
