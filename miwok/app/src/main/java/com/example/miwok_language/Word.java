package com.example.miwok_language;

public class Word {

    private String mDefaultTranslation;

    private  String mMiwokTranslation;

    private int mImage_resource_id = No_IMAGE_PROVIDED;
    private  static int No_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;
    public Word(String defaultTranslation , String miwokTranslation , int audioResourceId )
    {
        mAudioResourceId  =audioResourceId;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }
    public  Word (String defaultTranslation , String miwokTranslation , int image_resource_id ,int audioResourceId ){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImage_resource_id = image_resource_id;


    }
    public  String getDefaultTranslation() {
        return mDefaultTranslation;
    }
    public  String getMiwokTranslation(){
        return  mMiwokTranslation;
    }
    public  int getImage_resource_id(){return mImage_resource_id;}
    public  boolean hasImage(){
        return  mImage_resource_id != No_IMAGE_PROVIDED;
    }
    public  int getAudioResourceId(){return  mAudioResourceId ;}

}
