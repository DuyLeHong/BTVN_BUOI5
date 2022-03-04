package com.example.btvn_buoi4.Group;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.btvn_buoi4.R;

import java.util.ArrayList;
import java.util.List;

public class Activity_group extends AppCompatActivity {
    private RecyclerView rcv_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        rcv_group = findViewById(R.id.rcv_group);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication(),RecyclerView.VERTICAL,false);
        GroupAdapter adapter = new GroupAdapter(setList());
        rcv_group.setLayoutManager(linearLayoutManager);
        rcv_group.setAdapter(adapter);

        setToolbar();

    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.icon_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        getWindow().setStatusBarColor(getColor(R.color.white));

    }

    private List<GroupModel> setList() {
        List<GroupModel> groupModelList = new ArrayList<>();
        //        status = 1 => nhóm đóng
        //        status = 2 => nhóm kín
        //        status = 3 => nhóm mở
        groupModelList.add(new GroupModel(R.drawable.martphone,"Mua bán có tâm",8,10, GroupModel.STATUS_POST.NHOM_DONG));
        groupModelList.add(new GroupModel(R.drawable.eat_clean,"Ăn để lăn", 11,10, GroupModel.STATUS_POST.NHOM_KIN));
        groupModelList.add(new GroupModel(R.drawable.baby,"Chia sẽ kiến thức tài liệu Montessori",8,10, GroupModel.STATUS_POST.NHOM_MO));
        groupModelList.add(new GroupModel(R.drawable.eat_clean_2,"Thực đơn Eat-Clean giảm cân khỏe đẹp",8,10, GroupModel.STATUS_POST.NHOM_MO));
        groupModelList.add(new GroupModel(R.drawable.kento,"Easy kento for busy People",8,8,GroupModel.STATUS_POST.NHOM_KIN));
        groupModelList.add(new GroupModel(R.drawable.car,"OFBB",8,10, GroupModel.STATUS_POST.NHOM_MO));
        groupModelList.add(new GroupModel(R.drawable.eat_clean_2,"Thực đơn Eat-Clean giảm cân khỏe đẹp",11,10, GroupModel.STATUS_POST.NHOM_MO));
        groupModelList.add(new GroupModel(R.drawable.kento,"Easy kento for busy People",8,10,GroupModel.STATUS_POST.NHOM_KIN));

        return groupModelList;
    }
}