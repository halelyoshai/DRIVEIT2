package com.example.driveit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Lessonlist_Activity extends AppCompatActivity implements AdapterView.OnItemClickListener,
        AdapterView.OnItemLongClickListener {

    ArrayList<lesson> lessons;
    ListView lv;
    LessonsAdapter lessonsAdapter;
    lesson lessonSelected;
    static int REQUEST_CODE_ADD_LESSON= 1000;
    static int REQUEST_CODE_EDIT_LESSON= 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessonslist);

       // lesson l1= new lesson(1, 8.9);
       // lesson l2= new lesson(2, 25.6.21);

        lessons= new ArrayList<lesson>();

     //  lessons.add(l1);
     //  lessons.add(l2);

        lessonsAdapter= new LessonsAdapter(this, 0, 0, lessons);

        lv=findViewById(R.id.Lv);
        lv.setAdapter(lessonsAdapter);

        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
    }

    public void onItemclick(AdapterView<?> parent, View view, int position, long id) {
        lessonSelected=lessonsAdapter.getItem(position);
        Intent intent= new Intent(Lessonlist_Activity.this, activity_Editlesson.class);

        intent.putExtra("numlesson", lessonSelected.getCountlesson());
        intent.putExtra("lessondate", lessonSelected.getdate());

        startActivityForResult(intent, REQUEST_CODE_EDIT_LESSON);
        }


    @Override
    protected void onActivityResult(int requestcode, int resultcode, Intent data) {
        super.onActivityResult(requestcode, resultcode, data);

        if(requestcode==REQUEST_CODE_ADD_LESSON){
            if(requestcode==RESULT_OK){
                String numlesson= data.getExtras().getString("numlesson");
                String datelesson= data.getExtras().getString("datelesson");

                lessonSelected.setCountlesson(numlesson);
                lessonSelected.setCountlesson(datelesson);

                Snackbar.make(findViewById(android.R.id.content),"הפרטים נשמרו", Snackbar.LENGTH_SHORT).show();
            }
            else if(resultcode==RESULT_CANCELED)
                Snackbar.make(findViewById(android.R.id.content),"הפרטים לא נשמרו", Snackbar.LENGTH_SHORT).show();
        }
    }


    public boolean onOptionItemselected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id= item.getItemId();

        if(id==R.id.action_add){
            Intent intent= new Intent(this, activity_Editlesson.class);
            startActivityForResult(intent,REQUEST_CODE_ADD_LESSON);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onItenLongClick(AdapterView<?>parent, View view, int position, long id){
        lessonSelected=lessonsAdapter.getItem(position);
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
