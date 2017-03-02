package haagcolorado.joseph.edu.learnmalayalamnow;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by josephhaag on 2/18/17.
 */

//Use SQLite database in subclass of SQLiteOpenHelper. LMN stands for, of course, Learn Malayalm Now!

public class DatabaseLMN extends SQLiteOpenHelper {
    public static final int VERSION=1;
    public static final String DBNAME="databaseLMN.sqlite";
    public static final String TABLE_NAME = "UserProgress";
    public static final String ID = "id";
    public static final String NAME= "user";
    public  SQLiteDatabase.CursorFactory factory;

    //Constructor
    public DatabaseLMN(Context context){
        super(context, DBNAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        createDatabase(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void createDatabase(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,");
    }

    //Insert
    ContentValues values = new ContentValues();

}
