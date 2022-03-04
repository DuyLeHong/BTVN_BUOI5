package com.example.btvn_buoi4.folder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btvn_buoi4.MainActivity;
import com.example.btvn_buoi4.R;

import java.util.List;

public class FolderAdapter extends RecyclerView.Adapter {

    private List<FolderModel> folderModelList;
//    private View dialogCustomLayout;
//    EditText etInput;

    public FolderAdapter(List<FolderModel> folderModelList, Context ctx) {
        this.folderModelList = folderModelList;

//        dialogCustomLayout = LayoutInflater.from(ctx).inflate(R.layout.dialog_custom_layout, null);
//
//        etInput = (EditText) dialogCustomLayout.findViewById(R.id.edtInput);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.folder_layout_item, parent, false);
        FolderViewHolder folderViewHolder = new FolderViewHolder(view);
        return folderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int index = position;
        FolderModel folderModel = folderModelList.get(position);
        ((FolderViewHolder) holder).tv_name.setText(folderModel.getName());

        ((FolderViewHolder) holder).img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder diaLog = new AlertDialog.Builder(view.getContext());
                diaLog.setMessage("Nhap ten folder moi");

                final EditText etInput = new EditText(view.getContext());

                diaLog.setView(etInput);

//                View dialogCustomLayout = LayoutInflater.from(view.getContext()).inflate(R.layout.dialog_custom_layout, null);

                diaLog.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //EditText etInput = (EditText) dialogCustomLayout.findViewById(R.id.edtInput);

                        String sNewFolderName = etInput.getText().toString();

                        if (sNewFolderName.trim().equals("")) {
                            Toast.makeText(view.getContext(), "Ten folder khong duoc de trong", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        folderModel.setName(sNewFolderName);
                        notifyItemChanged(index);
                    }
                });

                diaLog.setPositiveButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                diaLog.show();
            }
        });

        ((FolderViewHolder) holder).img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder diaLog = new AlertDialog.Builder(view.getContext());
                diaLog.setMessage("Bạn có muốn xóa folder " + folderModel.getName() + " không");
                diaLog.setNegativeButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        folderModelList.remove(index);
                        notifyItemRemoved(index);
                        notifyItemRangeRemoved(index, folderModelList.size());
                    }
                });

                diaLog.setPositiveButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                diaLog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return folderModelList.size();
    }

    public class FolderViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private ImageView img_delete, img_edit;

        public FolderViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            img_delete = itemView.findViewById(R.id.img_delete);
            img_edit = itemView.findViewById(R.id.img_edit);
        }
    }
}
