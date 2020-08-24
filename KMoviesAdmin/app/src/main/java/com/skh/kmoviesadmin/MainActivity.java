package com.skh.kmoviesadmin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.icu.lang.UCharacter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.skh.kmoviesadmin.Model.VideoUploadDetails;

import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Uri videoUri;
    TextView text_video_selected;
    String videoCategory;
    String videotitle;
    String currentuid;
    StorageReference mstorageRef;
    StorageTask mUploadsTask;
    DatabaseReference referenceVideos;
    EditText video_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_video_selected = findViewById(R.id.testvideoselected);
        video_description = findViewById(R.id.movies_description);
        referenceVideos = FirebaseDatabase.getInstance().getReference().child("videos");
        mstorageRef = FirebaseStorage.getInstance().getReference().child("videos");

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        List<String> categories = new ArrayList<>();
        categories.add("Action");
        categories.add("Adventure");
        categories.add("Sports");
        categories.add("Romantic");
        categories.add("Comedy");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        videoCategory = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this, "selected: " + videoCategory, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void openvideoFiles(View view) {
        Intent in = new Intent(Intent.ACTION_GET_CONTENT);
        in.setType("video/*");
        startActivityForResult(in, 101);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 101) && (resultCode == RESULT_OK) && (data.getData() != null)) {
            videoUri = data.getData();
            String path = null;
            Cursor cursor;
            int coloum_index_data;
            String[] projection = {MediaStore.MediaColumns.DATA, MediaStore.Video.Media.BUCKET_DISPLAY_NAME,
                    MediaStore.Video.Media._ID, MediaStore.Video.Thumbnails.DATA};
            final String orderby = MediaStore.Video.Media.DEFAULT_SORT_ORDER;
            cursor = MainActivity.this.getContentResolver().query(videoUri, projection, null,
                    null, orderby);
            coloum_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            while (cursor.moveToNext()) {
                path = cursor.getString(coloum_index_data);
                videotitle = FilenameUtils.getBaseName(path);
            }
            text_video_selected.setText(videotitle);
        }
    }
        public void uploadFileFirebase(View v){
            if (text_video_selected.equals("no video selected")) {
                Toast.makeText(this, "please selected an video! ", Toast.LENGTH_SHORT).show();
            } else {
                if (mUploadsTask != null && mUploadsTask.isInProgress()) {
                    Toast.makeText(this, "video uploads all ready in progress....", Toast.LENGTH_SHORT).show();
                } else {
                    uploadFiles();
                }
            }

        }



    private void uploadFiles() {
        if (videoUri != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("video uploading.......");
            progressDialog.show();
            final StorageReference storageReference = mstorageRef.child(videotitle);
            mUploadsTask = storageReference.putFile(videoUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String video_url = uri.toString();

                            VideoUploadDetails videoUploadDetails = new VideoUploadDetails("", "",
                                    "",
                                    video_url, videotitle, video_description.getText().toString(), videoCategory);
                            String uploadsid = referenceVideos.push().getKey();
                            referenceVideos.child(uploadsid).setValue(videoUploadDetails);
                            currentuid = uploadsid;
                            progressDialog.dismiss();


                        }
                    });
                }
            }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                    progressDialog.setMessage("uploaded " + ((int) progress) + "%...");

                }
            });
        } else {
            Toast.makeText(this, "no video selected to upload", Toast.LENGTH_SHORT).show();
        }
    }

    public void uploadMovieFirebase(View view) {
    }
}

