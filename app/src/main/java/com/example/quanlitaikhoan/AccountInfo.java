package com.example.quanlitaikhoan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.quanlitaikhoan.Model.User;

import java.util.ArrayList;
import java.util.List;

public class AccountInfo extends AppCompatActivity {
    private List<User> userList;
    private ListView listView;
    private ListAccountAdapter listAccountAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_info);

        userList = new ArrayList<>();
        userList.add(new User(R.drawable.avatar, "Kim Hồng"));
        userList.add(new User(R.drawable.avatar, "Kim Hồng2"));
        userList.add(new User(R.drawable.avatar, "Kim Hồng3"));
        userList.add(new User(R.drawable.avatar, "Kim Hồng4"));
        userList.add(new User(R.drawable.avatar, "Kim Hồng5"));
        userList.add(new User(R.drawable.avatar, "Kim Hồng6"));

        listAccountAdapter = new ListAccountAdapter(this, R.layout.item_user, userList);
        listView = findViewById(R.id.lv_account_info);
        listView.setAdapter(listAccountAdapter);

    }
}