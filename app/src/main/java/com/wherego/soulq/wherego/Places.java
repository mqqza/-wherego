package com.wherego.soulq.wherego;

public class Places {
    String mImage;
    String mTitle;
    String mAdress;
    String mAbout;


    Places(String image, String title, String adress, String about) {
        mImage = image;
        mTitle = title;
        mAdress = adress;
        mAbout = about;
    }

    public String getImage() {
        return mImage;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAdress() {
        return mAdress;
    }

    public String getAbout() {
        return mAbout;
    }

}
