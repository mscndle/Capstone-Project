package com.mcondle.capstone.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mcondle.capstone.db.NotesContract.NotesEntry;

/**
 * Created by mandeep.condle on 6/2/16.
 */
public class NotesDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "favorites.db";

    public NotesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_NOTES_TABLE = "CREATE TABLE " + NotesEntry.TABLE_NAME + " (" +
                // add all columns + default ._ID
                NotesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                NotesEntry.COLUMN_NOTE_TITLE + " TEXT NOT NULL, " +
                NotesEntry.COLUMN_NOTE_CONTENT + " TEXT, " +
                NotesEntry.COLUMN_NOTE_CREATED_DATE+ " DATE NOT NULL, " +

                /*** Taken from project Sunshine sample code  ***/
                // To assure the application have just one favorites entry per movie_id
                // per location, it's created a UNIQUE constraint with REPLACE strategy
                " UNIQUE (" + NotesEntry.COLUMN_NOTE_TITLE+ ") ON CONFLICT REPLACE);";

        db.execSQL(SQL_CREATE_NOTES_TABLE)git;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NotesEntry.TABLE_NAME);
        onCreate(db);
    }
}
