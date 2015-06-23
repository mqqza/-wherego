package com.wherego.soulq.wherego;

public class Comments {
    String mImage;
    String mName;
    String mText;
    String mDate;

    Comments(String image, String name, String text, String date) {
        mImage = image;
        mName = name;
        mText = text;
        mDate = date;
    }

    public String getImage() {
        return mImage;
    }

    public String getName() {
        return mName;
    }

    public String getText() {
        return mText;
    }

    public String getDate() {
        return mDate;
    }
}
