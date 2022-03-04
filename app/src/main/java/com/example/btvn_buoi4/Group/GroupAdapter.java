package com.example.btvn_buoi4.Group;

import static java.lang.Integer.parseInt;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btvn_buoi4.R;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter {

    List<GroupModel> groupModelList;

    public GroupAdapter(List<GroupModel> groupModelList) {
        this.groupModelList = groupModelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_layout_item,parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GroupModel groupModel = groupModelList.get(position);

        ((GroupViewHolder) holder).img_group.setImageResource(groupModel.getImgResource());
        ((GroupViewHolder) holder).tv_name.setText(groupModel.getNameGroup());
        ((GroupViewHolder) holder).tv_qty_folow.setText(String.valueOf(groupModel.getQtyFolower())+"K"+" Fan");
        ((GroupViewHolder) holder).tv_qty_post.setText("+" + String.valueOf(groupModel.getQtyPost())+" bài viết mới nhất");

        //        status = 1 => nhóm đóng
        //        status = 2 => nhóm kín
        //        status = 3 => nhóm mở

        switch (groupModel.getStatus()){
            case NHOM_DONG:
                ((GroupViewHolder) holder).tv_status.setText("Nhóm đóng");
                break;
            case NHOM_KIN:
                ((GroupViewHolder) holder).tv_status.setText("Nhóm kín");
                ((GroupViewHolder) holder).tv_status.setTextColor(Color.parseColor("#FFD85A29"));
                break;
            case NHOM_MO:
                ((GroupViewHolder) holder).tv_status.setText("Nhóm mở");
                ((GroupViewHolder) holder).tv_status.setTextColor(Color.parseColor("#336AD8"));
                break;

        }
    }

    @Override
    public int getItemCount() {
        return groupModelList.size();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_group;
        private TextView tv_name,tv_qty_folow,tv_qty_post,tv_status;
        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            img_group = itemView.findViewById(R.id.img_group);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_qty_folow = itemView.findViewById(R.id.tv_qty_folow);
            tv_qty_post = itemView.findViewById(R.id.tv_qty_post);
            tv_status = itemView.findViewById(R.id.tv_status);

        }
    }
}
