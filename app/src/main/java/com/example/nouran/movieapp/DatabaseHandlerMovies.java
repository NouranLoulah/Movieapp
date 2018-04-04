package com.example.nouran.movieapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nouran on 3/6/2018.
 */


public class DatabaseHandlerMovies extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "accountsManager";

    // Contacts table name
    private static final String TABLE_ACCOUNTS = "Movies";

    // Contacts Table Columns names
   private static final String ID="ID";
    private static final String VOTE="VOTE";
    private static final String TITLE="TITLE";
    private static final String POSTER="POSTER";
    private static final String COVER="COVER";
    private static final String OVERVIEW="OVERVIEW";
    private static final String DATE="DATE";


    public DatabaseHandlerMovies(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACCOUNTS_TABLE = "CREATE TABLE " + TABLE_ACCOUNTS + "("
                + ID + " TEXT PRIMARY KEY," + VOTE + " TEXT,"
                + TITLE + " TEXT," + POSTER + " TEXT," + COVER
                + " TEXT," + OVERVIEW + " TEXT," + DATE + " TEXT" + ");";
        db.execSQL(CREATE_ACCOUNTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNTS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addMovie(Model movie) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID, movie.id);
        values.put(VOTE, movie.vote_average+"");
        values.put(TITLE, movie.title);
        values.put(POSTER, movie.poster_path);
        values.put(COVER, movie.backdrop_path);
        values.put(OVERVIEW, movie.overview);
        values.put(DATE, movie.release_date);


        // Inserting Row
        db.insert(TABLE_ACCOUNTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
//    account_model getContact(String email) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(TABLE_ACCOUNTS, new String[] { KEY_EMAIL,
//                        KEY_NAME, KEY_PASSWORD }, KEY_EMAIL + "=?",
//                new String[] { String.valueOf(email) }, null, null, null, null);
//        if (cursor != null)
//            cursor.moveToFirst();
//
//        account_model contact = new account_model(cursor.getString(0),
//                cursor.getString(1), cursor.getString(2));
//        // return contact
//        return contact ;
//    }

    // Getting All Contacts
    public List<Model> getAllMovies() {
        List<Model> movieList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ACCOUNTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
               Model movie = new Model(00,
                       cursor.getString(0)
                       ,Double.parseDouble(cursor.getString(1))
                       ,cursor.getString(2),cursor.getString(3)
                       ,cursor.getString(4),cursor.getString(5)
                       ,cursor.getString(6)
               );

                // Adding movie to list
                movieList.add(movie);
            } while (cursor.moveToNext());
        }

        // return contact list
        return movieList;
    }

    // Updating single contact
//    public int updateContact(account_model contact) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_NAME, contact.getName());
//        values.put(KEY_PASSWORD, contact.getPassword());
//
//        // updating row
//        return db.update(TABLE_ACCOUNTS, values, KEY_EMAIL + " = ?",
//                new String[] { String.valueOf(contact.getEmail()) });
//    }

    // Deleting single contact
    public void deleteMovie(Model movie) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ACCOUNTS, ID + " = ?",
                new String[] { String.valueOf(movie.id) });
        db.close();
    }


    // Getting contacts Count
//    public int getContactsCount() {
//        String countQuery = "SELECT  * FROM " + TABLE_ACCOUNTS;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery, null);
//        cursor.close();
//
//        // return count
//        return cursor.getCount();
//    }

}
