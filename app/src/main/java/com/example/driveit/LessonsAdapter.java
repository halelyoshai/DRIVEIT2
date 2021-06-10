package com.example.driveit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.PropertyResourceBundle;

public class LessonsAdapter extends ArrayAdapter<lesson> {

    Context context;
    List<lesson> lessons;

    public LessonsAdapter(@NonNull Context context, int resource, int textViewResorceId, @NonNull List<lesson> objects) {
        super(context, resource, textViewResorceId, objects);

        this.context = context;
        this.lessons = objects;
    }

    @NonNull
    @Override
    public View getView(int possision, @Nullable View convertView, @NonNull ViewGroup parent) {
        lesson lesson = getItem(possision);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.costume_layout, parent, false);
        }

        TextView countlesson = convertView.findViewById(R.id.countlesson);
        TextView date = convertView.findViewById(R.id.date);

        countlesson.setText(lesson.getCountlesson());
        date.setText(lesson.getdate());

        return convertView;
    }
}
