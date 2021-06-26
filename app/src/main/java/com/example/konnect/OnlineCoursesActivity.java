package com.example.konnect;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class OnlineCoursesActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"100days Python", "Machine Learning A-Z™", "Web Dev Bootcamp", "Java Programming Masterclass", "Angular - The Complete Guide ", "Complete Android N Developer Course", "Automate the Boring Stuff " };

    String mProfile[] = {"Angela YU", "Kiril Eremenko", "Colt Steele", "Tim Buchalka", "Maxmillian", "Rob Percival", "AL Sweigart"};

    String mDescription[] = {"Master Python by building 100 projects in 100 days. Learn to build websites, games, apps, plus scraping and data science",
            "Learn to create Machine Learning Algorithms in Python and R from two Data Science experts. Code templates included.",
            "COMPLETELY REDONE - The only course you need to learn web development - HTML, CSS, JS, Node, and More!",
            "Learn Java In This Course And Become a Computer Programmer. Obtain valuable Core Java Skills And Java Certification",
            "Master Angular 12 (formerly Angular 2) and build awesome, reactive web apps with the successor of Angular.js",
            "Learn Android App Development with Android 7 Nougat by building real apps including Uber, Whatsapp and Instagram!",
            "A practical programming course for office workers, academics, and administrators who want to improve their productivity."};

    int images[] = {R.drawable.angelayu,R.drawable.machinelearning, R.drawable.bootcamp, R.drawable.java, R.drawable.angular,  R.drawable.android,R.drawable.python_boring};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_courses);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#055E11")));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int startColor = getWindow().getStatusBarColor();
            int endColor = ContextCompat.getColor(this, R.color.darkergreen);
            ObjectAnimator.ofArgb(getWindow(), "statusBarColor", startColor, endColor).start();
        }

        getSupportActionBar().setTitle("Courses");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.internship_listview);

        MyAdapter adapter = new MyAdapter(this, mTitle, mProfile, mDescription, images);
        listView.setAdapter(adapter);


    }


    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rProfile[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String profile[], String description[], int imgs[]) {
            super(c, R.layout.listview_courses_row, R.id.tv_coursename, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rProfile = profile;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.listview_courses_row,parent, false);
            ImageView images = row.findViewById(R.id.course_image);
            TextView myTitle = row.findViewById(R.id.tv_coursename);
            TextView myProfile = row.findViewById(R.id.tv_instructor);
            TextView myDesc = row.findViewById(R.id.tv_coursedesc);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myProfile.setText(rProfile[position]);
            myDesc.setText(rDescription[position]);

            return row;


        }
    }
}