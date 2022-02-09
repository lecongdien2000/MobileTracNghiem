package com.example.quanlitaikhoan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlitaikhoan.Model.User;

import java.util.ArrayList;
import java.util.List;

public class ListAccountAdapter extends ArrayAdapter<User> {
   public ListAccountAdapter(Context context, ArrayList<User> userArrayList){
       super(context, R.layout.item_user, userArrayList);
   }

    public ListAccountAdapter(AccountInfo accountInfo, int item_user, List<User> userList) {
        super(accountInfo, item_user, userList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.profile_pic);
        TextView textView = convertView.findViewById(R.id.tv_nameuser);

        imageView.setImageResource(user.getResouceId());
        textView.setText(user.getName());

       return super.getView(position, convertView, parent);
    }
}
