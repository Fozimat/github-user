package com.fozimat.github;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "extra_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvName = findViewById(R.id.txt_name);
        TextView tvUsername = findViewById(R.id.txt_username);
        TextView tvCompany = findViewById(R.id.txt_company);
        TextView tvLocation = findViewById(R.id.txt_location);
        ImageView imgView = findViewById(R.id.img_photo);

        User user = getIntent().getParcelableExtra(EXTRA_USER);

        String name = user.getName();
        String username = user.getUsername();
        String company = user.getCompany();
        String location = user.getLocation();
        int photo = user.getPhoto();


        tvName.setText(name);
        tvUsername.setText("Username : @" + username);
        tvCompany.setText("Company : " + company);
        tvLocation.setText("Location : " + location);
        imgView.setImageResource(photo);
    }
}
