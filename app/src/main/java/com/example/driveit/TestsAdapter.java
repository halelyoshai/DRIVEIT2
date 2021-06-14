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

public class TestsAdapter extends ArrayAdapter<Test> {

        Context context;
        List<Test> tests;

        public TestsAdapter(@NonNull Context context, int resource, int textViewResorceId, @NonNull List<Test> objects) {
            super(context, resource, textViewResorceId, objects);

            this.context = context;
            this.tests = objects;
        }


        @NonNull
        @Override
        public View getView(int possision, @Nullable View convertView, @NonNull ViewGroup parent) {
            Test test = getItem(possision);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.costume_layout_tests, parent, false);
            }

            TextView counttest = convertView.findViewById(R.id.counttest);
            TextView date = convertView.findViewById(R.id.datetest);

            counttest.setText(test.getCounttest());
            date.setText(test.getdate());


            return convertView;
        }
    }


