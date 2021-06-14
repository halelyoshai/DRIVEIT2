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

public class Testslist_Activity extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    private ArrayList<Test> tests;
    private ListView lv_t;
    private TestsAdapter testsAdapter;
    private Test testSelected;
    private TextView studentname;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    static int REQUEST_CODE_ADD_TEST = 1000;
    static int REQUEST_CODE_EDIT_TEST = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testslist);
        studentname= findViewById(R.id.txtstudentname);
        firebaseDatabase= FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference("Users");
        tests = new ArrayList<Test>();
        databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                studentname.setText("student name: "+snapshot.getValue(Student.class).getName());


                for (DataSnapshot d:snapshot.child("tests").getChildren()){
                    tests.add(d.getValue(Test.class));
                    Log.d("onDataChange",d.getValue(Test.class).getdate());
                }
                testsAdapter = new TestsAdapter(Testslist_Activity.this, 0, 0, tests);

                lv_t = findViewById(R.id.Lv_t);
                lv_t.setAdapter(testsAdapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }



    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data) {
        super.onActivityResult(requestcode, resultcode, data);

        if (requestcode == REQUEST_CODE_ADD_TEST) {
            if (requestcode == RESULT_OK) {
                String numtest = data.getExtras().getString("testnum");
                String datetest = data.getExtras().getString("testdate");

                testSelected.setCounttest(numtest);
                testSelected.setCounttest(datetest);

                Snackbar.make(findViewById(android.R.id.content), "הפרטים נשמרו", Snackbar.LENGTH_SHORT).show();
            } else if (resultcode == RESULT_CANCELED)
                Snackbar.make(findViewById(android.R.id.content), "הפרטים לא נשמרו", Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();

        if (id == R.id.action_addtest) {
            Intent intent = new Intent(this, activity_Edittest.class);
            startActivity(intent);
        }
        if (id == R.id.action_home) {
            Intent intent = new Intent(this, StudentsProfile_Activity.class);
            startActivity(intent);
        }

        return true;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }


}
