package com.byhieg.processdemo.ser;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by shiqifeng on 2017/3/21.
 * Mail:byhieg@gmail.com
 */

public class User implements Parcelable {

    public int userId;
    public String usernName;
    public boolean isMale;

    public List<String> lists;

    public Book mBook;


    protected User(Parcel in) {
        userId = in.readInt();
        usernName = in.readString();
        isMale = in.readByte() != 0;
        lists = in.createStringArrayList();
        mBook = in.readParcelable(Book.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(userId);
        parcel.writeString(usernName);
        parcel.writeByte((byte) (isMale ? 1 : 0));
        parcel.writeStringList(lists);
        parcel.writeParcelable(mBook, i);
    }
}
