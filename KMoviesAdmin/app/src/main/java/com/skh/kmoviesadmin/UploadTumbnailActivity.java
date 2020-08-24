package com.skh.kmoviesadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

public class UploadTumbnailActivity extends AppCompatActivity {
       Uri videothumburi;
       String thumbnail_url;
       ImageView thumbnail_image ;
       StorageReference mStoragerefthumbnails;
       DatabaseReference referenceVideos;
       TextView textSelected;
       RadioButton radioButtonlatest,radioButtonpopular, radioButtonNottype,radioButtonSlide;
        StorageTask mStorageTask ;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_tumbnail);
        textSelected = findViewById(R.id.textnothumbnailselected);
         thumbnail_image = findViewById(R.id.imageview);
         radioButtonlatest = findViewById(R.id.radiolatestmovies);
         radioButtonpopular = findViewById(R.id.radiobestpopulermovies);
         radioButtonNottype = findViewById(R.id.radioNoType);
         radioButtonSlide = findViewById(R.id.radioslidemovies);
         mStoragerefthumbnails = FirebaseStorage.getInstance().getReference().child("VideoThumbnails");
         referenceVideos = FirebaseDatabase.getInstance().getReference().child("videos");
         String currentUid =
    }

}