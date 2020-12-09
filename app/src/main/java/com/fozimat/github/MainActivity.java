package com.fozimat.github;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter;
    private String[] dataName;
    private String[] dataUsername;
    private String[] dataCompany;
    private String[] dataLocation;
    private TypedArray dataPhoto;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new UserAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveIntent = new Intent(MainActivity.this, DetailActivity.class);

                User user = users.get(i);

                moveIntent.putExtra(DetailActivity.EXTRA_USER, user);
                startActivity(moveIntent);

            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataUsername = getResources().getStringArray(R.array.data_username);
        dataCompany = getResources().getStringArray(R.array.data_company);
        dataLocation = getResources().getStringArray(R.array.data_location);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        users = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            User user = new User();
            user.setPhoto(dataPhoto.getResourceId(i, -1));
            user.setName(dataName[i]);
            user.setUsername(dataUsername[i]);
            user.setCompany(dataCompany[i]);
            user.setLocation(dataLocation[i]);
            users.add(user);
        }

        adapter.setUsers(users);
    }
}
