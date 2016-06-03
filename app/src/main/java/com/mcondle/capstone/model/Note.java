package com.mcondle.capstone.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by mandeep.condle on 6/2/16.
 */
public class Note implements Parcelable {

    private String title;
    private String content; //can be null
    private Date createdDate;

    public Note(String header,
                String content,
                Date createdDate) {
        this.title = header;
        this.content = content;
        this.createdDate = createdDate;
    }

    /***********************************
     Parcelable interface implementation
     ***********************************/

    protected Note(Parcel in) {
        title = in.readString();
        content = in.readString();
        long tmpCreatedDate = in.readLong();
        createdDate = tmpCreatedDate != -1 ? new Date(tmpCreatedDate) : null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeLong(createdDate != null ? createdDate.getTime() : -1L);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Note> CREATOR = new Parcelable.Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}
