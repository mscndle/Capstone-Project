package com.mcondle.capstone.db;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by mandeep.condle on 6/2/16.
 */
public class NotesContract {

    // using the app's package name as the content authority string
    public static final String CONTENT_AUTHORITY = "com.mcondle.capstone";

    // using CONTENT_AUTHORITY to create the base of all URIs
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // possible paths, for now all favorites, we'll just use this path
    public static final String PATH_NOTES = "notes";

    public static final class NotesEntry implements BaseColumns {

        public static final String TABLE_NAME = "notes";

        // note title, used as primary key (not a good idea, but lets go with this for now)
        public static final String COLUMN_NOTE_TITLE = "note_title";

        // note content
        public static final String COLUMN_NOTE_CONTENT = "note_content";

        // note created date
        public static final String COLUMN_NOTE_CREATED_DATE = "note_created_date";

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_NOTES).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_NOTES;

        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_NOTES;

        public static Uri buildNotesUri() {
            return CONTENT_URI;
        }

    }

}
