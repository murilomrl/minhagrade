package com.devmob.minhagrade;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private Spinner spinner1, spinner2;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        addItemsOnSpinner();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();
    }

    // add items into spinner dynamically
    public void addItemsOnSpinner() {
        Cursos courses = new Cursos();

        spinner2 = (Spinner) findViewById(R.id.spinner);
        List<String> list = courses.getCourses();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list){

            public View getView(int position, View convertView,ViewGroup parent) {

                View v = super.getView(position, convertView, parent);

                ((TextView) v).setTextSize(26);

                return v;

            }

            public View getDropDownView(int position, View convertView,ViewGroup parent) {

                View v = super.getDropDownView(position, convertView,parent);

                ((TextView) v).setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                ((TextView) v).setTextSize(26);
                return v;

            }
        };
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }


    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseActivity.this, ProgressActivity.class);
                String message = String.valueOf(spinner1.getSelectedItem());
                intent.putExtra("MESSAGE", message);
                /**
                 * Animação de transição entre activitys
                 */
                ActivityOptionsCompat opts =  ActivityOptionsCompat.makeCustomAnimation(CourseActivity.this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivity(CourseActivity.this,intent,opts.toBundle());
                //CourseActivity.this.startActivity(intent);
                /*Toast.makeText(CourseActivity.this,
                        "OnClickListener : " +
                                "\nSpinner : "+ String.valueOf(spinner1.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();*/
            }

        });
    }
}