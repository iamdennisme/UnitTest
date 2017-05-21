package com.dennisce.unittestdemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dennis on 21/05/2017.
 * so.....
 */

public class User implements Parcelable {
    public User(){

    }
    protected User(Parcel in) {
        userName = in.readString();
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

    public static User newInstance(String userName) {
        User user = new User();
        user.userName = userName;
        return user;
    }

    public String userName;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
    }
}
