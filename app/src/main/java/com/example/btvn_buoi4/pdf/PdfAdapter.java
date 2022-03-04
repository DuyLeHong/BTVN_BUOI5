package com.example.btvn_buoi4.pdf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btvn_buoi4.R;

import java.util.List;

public class PdfAdapter extends RecyclerView.Adapter {

    private List<PdfModel> pdfModelList;
    int index = 1;

    public PdfAdapter(List<PdfModel> pdfModelList) {
        this.pdfModelList = pdfModelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pdf_layout_item, parent, false);
        return new PdfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        PdfModel pdfModel = pdfModelList.get(position);

        ((PdfViewHolder) holder).tv_name_pdf.setText(pdfModel.getName());

    }

    @Override
    public int getItemCount() {
        return pdfModelList.size();
    }

    public class PdfViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name_pdf, tv_add_item;

        public PdfViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name_pdf = itemView.findViewById(R.id.tv_name_pdf);
        }
    }
}
