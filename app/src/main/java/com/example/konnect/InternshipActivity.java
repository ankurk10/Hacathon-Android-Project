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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class InternshipActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"CureFit", "SportsKeeda", "Zoho", "CollegeDunia", "ClearTax", "Zerodha", "Flipkart" };

    String mProfile[] = {"Android Developer Intern", "DevOps Internt", "Web Developer", "Content Writer", "Research Analyst", "Android Developer", "Product Manager"};

    String mDescription[] = {"CureFit is a health and fitness company offering digital and offline experiences across fitness, nutrition, and mental well-being.",
            "Sportskeeda is a global sports and esports news website, founded in 2009. The website has news, features, commentary and videos on sports",
            "Zoho Corporation is an Indian multinational technology company that makes web-based business tools",
    "Collegedunia.com is an extensive search engine for the students, parents, and education industry players who are seeking information on higher education",
    "ClearTax is a Bangalore-based Fintech company offering financial services and Software as a service (SaaS) in India with focus on taxation SaaS",
    "Zerodha Broking Limited is an Indian financial services company offering retail and institutional broking",
    "Flipkart is an Indian e-commerce company, headquartered in Bangalore, Karnataka, India,"};

    int images[] = {R.drawable.curefit2,R.drawable.sportskeeda, R.drawable.zoho, R.drawable.collegedunia, R.drawable.cleartax,  R.drawable.zerodha,R.drawable.flipkart};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internship);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#3D0343")));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int startColor = getWindow().getStatusBarColor();
            int endColor = ContextCompat.getColor(this, R.color.darkviolet);
            ObjectAnimator.ofArgb(getWindow(), "statusBarColor", startColor, endColor).start();
        }

        getSupportActionBar().setTitle("Internships");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.internship_listview);

        MyAdapter adapter = new MyAdapter(this, mTitle, mProfile, mDescription, images);
        listView.setAdapter(adapter);


    }


    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String rTitle[];
        String rProfile[];
        String rDescription[];
        int rImgs[];

         MyAdapter( Context c, String title[], String profile[], String description[], int imgs[]) {
            super(c, R.layout.listview_internship_row, R.id.tv_companyname, title);
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
            View row = layoutInflater.inflate(R.layout.listview_internship_row,parent, false);
            ImageView images = row.findViewById(R.id.company_image);
            TextView myTitle = row.findViewById(R.id.tv_companyname);
            TextView myProfile = row.findViewById(R.id.tv_jobprofile);
            TextView myDesc = row.findViewById(R.id.tv_jobdescription);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myProfile.setText(rProfile[position]);
            myDesc.setText(rDescription[position]);


            return row;


        }
    }
}