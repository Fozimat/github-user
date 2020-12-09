package com.fozimat.github;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<User> users = new ArrayList<>();

    void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    UserAdapter(Context context) {
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        User user = (User) getItem(position);
        viewHolder.bind(user);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtUsername;
        private TextView txtLocation;
        private CircleImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtUsername = view.findViewById(R.id.txt_username);
            txtLocation = view.findViewById(R.id.txt_location);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(User user) {
            txtName.setText(user.getName());
            txtUsername.setText("@"+ user.getUsername());
            txtLocation.setText(user.getLocation());
            imgPhoto.setImageResource(user.getPhoto());
        }
    }
}
