package com.byhieg.processdemo.ser;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by shiqifeng on 2017/3/21.
 * Mail:byhieg@gmail.com
 */

public class Book implements Parcelable {

    public String name;
    public String pageTotal;


    protected Book(Parcel in) {
        name = in.readString();
        pageTotal = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(pageTotal);
    }
}
