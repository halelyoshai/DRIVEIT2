package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class StudentsProfile_Activity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    private TextView studentprofile;
    private ImageView picture;
    private TextView name;
    private TextView teacher;
    private Button info;
    private Button lessons;
    private Button tests;
    private Button show;
    private  static  final  int REQUEST_CAMERA = 1000;
    private  static  final  int REQUEST_STORAGE = 1001;
    private  static  final  int REQUEST_READ_STORAGE = 1002;
    private String key,imageString;
    private Uri uri;
    private Student student;
    private Bitmap bitmap;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile__s);

        studentprofile = findViewById(R.id.txtstudentprofile);
        picture = findViewById(R.id.imageviewprofile);
        show = findViewById(R.id.btnpicture);
        name = findViewById(R.id.txtname);
        teacher = findViewById(R.id.txtteacher);
        info = findViewById(R.id.btninfo);
        lessons = findViewById(R.id.btnlessons);
        tests = findViewById(R.id.btntests);
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        storageReference = FirebaseStorage.getInstance().getReference("ProfilePic");

        show.setOnClickListener(this);
        info.setOnClickListener(this);
        lessons.setOnClickListener(this);
        tests.setOnClickListener(this);



        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String username = snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("name").getValue(String.class);
                    name.setText(username);
                    String teacherName = snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("teacherName").getValue(String.class);
                    teacher.setText(teacherName);
                    student = snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).getValue(Student.class);
                    showPic();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(StudentsProfile_Activity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }


        });
    }
    @Override
    public void onClick(View v) {
        if (v == show){

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_STORAGE);
                }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_READ_STORAGE);
            }
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
            }
                Intent intent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);
        }


        if (v == lessons ) {
            Intent intent = new Intent( StudentsProfile_Activity.this, Lessonlist_Activity.class);
            startActivity(intent);
        }


        if (v == tests){
            Intent intent = new Intent ( this, Testslist_Activity.class);
            startActivity(intent);
        }

        if (v == info){
            Intent intent = new Intent ( this, Info_Activity.class);
            startActivity(intent);
        }



    }



        public void showPic(){
        databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.getValue(Student.class).getKey() != null) {
                    storageReference.child(snapshot.getValue(Student.class).getKey()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Glide.with(StudentsProfile_Activity.this).load(uri).into(picture);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public String getFileExtension(Uri uri){
        String cr = getContentResolver().getType(uri);
        MimeTypeMap mtm = MimeTypeMap.getSingleton();
        return mtm.getExtensionFromMimeType(cr);
    }

    @Override
    protected void onActivityResult(int requrstCode, int resultCode, Intent data){
        super.onActivityResult(requrstCode, resultCode, data);

        if (requrstCode == 0)
        {
            if(resultCode==RESULT_OK)
            {
               bitmap = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);
                String s = MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(),bitmap,"image",null);
                uri = Uri.parse(s);
                key = System.currentTimeMillis() + "." + getFileExtension(uri);
                //Glide.with(StudentsProfile_Activity.this).load(uri).into(picture);
                storageReference.child(key).putFile(uri)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                imageString = taskSnapshot.getUploadSessionUri().toString();
                                student.setImageUri(imageString);
                                student.setKey(key);
                                databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(student);
                                Glide.with(StudentsProfile_Activity.this).load(uri).into(picture);
                            }
                        });


            }
        }
    }



}
                        
                    