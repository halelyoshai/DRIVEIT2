package com.example.driveit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {

    Context context;
    List<Student> students;

    public StudentAdapter(@NonNull Context context, int resource, int textViewResorceId, @NonNull List<Student> objects) {
        super(context, resource, textViewResorceId, objects);

        this.context = context;
        this.students = objects;
    }


    @NonNull
    @Override
    public View getView(int possision, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = getItem(possision);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.costume_layout_students, parent, false);
        }

        TextView mailstudent = convertView.findViewById(R.id.mailstudent);
        TextView namestudent = convertView.findViewById(R.id.namestudent);

        mailstudent.setText(student.getMail());
        namestudent.setText(student.getName());


        return convertView;
    }
}


