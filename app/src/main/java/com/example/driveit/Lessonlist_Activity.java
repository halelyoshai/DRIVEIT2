package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Lessonlist_Activity extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    private ArrayList<Lesson> lessons;
    private ListView lv;
    private LessonsAdapter lessonsAdapter;
    private Lesson lessonSelected;
    private TextView studentname;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    static int REQUEST_CODE_ADD_LESSON = 1000;
    static int REQUEST_CODE_EDIT_LESSON = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessonslist);
        studentname= findViewById(R.id.txtstudentname);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference("Users");
        lessons = new ArrayList<Lesson>();
        databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                studentname.setText("student name: "+snapshot.getValue(Student.class).getName());


                for (DataSnapshot d:snapshot.child("lessons").getChildren()){
                    lessons.add(d.getValue(Lesson.class));
                    Log.d("onDataChange",d.getValue(Lesson.class).getdate());
                }
                lessonsAdapter = new LessonsAdapter(Lessonlist_Activity.this, 0, 0, lessons);

                lv = findViewById(R.id.Lv);
                lv.setAdapter(lessonsAdapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

       // lv.setOnItemClickListener(this);
        // lv.setOnItemLongClickListener(this);
    }

    public void onItemclick(AdapterView<?> parent, View view, int position, long id) {
        lessonSelected = lessonsAdapter.getItem(position);
        Intent intent = new Intent(Lessonlist_Activity.this, activity_Editlesson.class);

        intent.putExtra("numlesson", lessonSelected.getCountlesson());
        intent.putExtra("lessondate", lessonSelected.getdate());

        startActivityForResult(intent, REQUEST_CODE_EDIT_LESSON);
    }


    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data) {
        super.onActivityResult(requestcode, resultcode, data);

        if (requestcode == REQUEST_CODE_ADD_LESSON) {
            if (requestcode == RESULT_OK) {
                String numlesson = data.getExtras().getString("numlesson");
                String datelesson = data.getExtras().getString("datelesson");

                lessonSelected.setCountlesson(numlesson);
                lessonSelected.setCountlesson(datelesson);

                Snackbar.make(findViewById(android.R.id.content), "הפרטים נשמרו", Snackbar.LENGTH_SHORT).show();
            } else if (resultcode == RESULT_CANCELED)
                Snackbar.make(findViewById(android.R.id.content), "הפרטים לא נשמרו", Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_main, menu);
       return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();

        if (id == R.id.action_add) {
            Intent intent = new Intent(this, activity_Editlesson.class);
            startActivity(intent);
        }
        if (id == R.id.tests) {
            Intent intent = new Intent(this, Testslist_Activity.class);
            startActivity(intent);
        }

        return true;
    }



    public boolean onItenLongClick(AdapterView<?> parent, View view, int position, long id) {
        lessonSelected = lessonsAdapter.getItem(position);
        lessonsAdapter.remove(lessonSelected);
        lessonsAdapter.notifyDataSetChanged();
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }


    }


