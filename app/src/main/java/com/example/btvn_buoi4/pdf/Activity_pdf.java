package com.example.btvn_buoi4.pdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btvn_buoi4.R;
import com.example.btvn_buoi4.folder.FolderModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Activity_pdf extends AppCompatActivity {
    private RecyclerView rcv_pdf;
    private TextView tv_add_item;
    private List<PdfModel> pdfModelList;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        rcv_pdf = findViewById(R.id.rcv_pdf);
        tv_add_item = findViewById(R.id.tv_add_item);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication(), RecyclerView.VERTICAL, false);
        PdfAdapter adapter = new PdfAdapter(setListPdf());
        rcv_pdf.setLayoutManager(linearLayoutManager);
        rcv_pdf.setAdapter(adapter);

        setToolbar();

        tv_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder diaLog = new AlertDialog.Builder(view.getContext());
                diaLog.setMessage("Nhap ten file moi");

                final EditText etInput = new EditText(view.getContext());

                diaLog.setView(etInput);

//                View dialogCustomLayout = LayoutInflater.from(view.getContext()).inflate(R.layout.dialog_custom_layout, null);

                diaLog.setNegativeButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //EditText etInput = (EditText) dialogCustomLayout.findViewById(R.id.edtInput);

                        String sNewFolderName = etInput.getText().toString();

                        if (sNewFolderName.trim().equals("")) {
                            Toast.makeText(view.getContext(), "Ten file khong duoc de trong", Toast.LENGTH_SHORT).show();
                            return;
                        } else if (checkFolderNameIsIncorrect(sNewFolderName)) {
                            Toast.makeText(view.getContext(), "Ten file khong duoc giong file cu", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        pdfModelList.add(new PdfModel(sNewFolderName));
                        adapter.notifyDataSetChanged();
                        linearLayoutManager.scrollToPosition(pdfModelList.size() - 1);
                        index++;
                    }
                });

                diaLog.setPositiveButton("Thôi", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                diaLog.show();
            }
        });
    }

    private boolean checkFolderNameIsIncorrect(String sNewFolderName) {
        for (PdfModel pdfModel : pdfModelList) {
            if (pdfModel.getName().equals(sNewFolderName))
                return true;
        }

        return false;
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_item_pdf);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.search:
                        Toast.makeText(Activity_pdf.this, "This is menu search", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.option:
                        Toast.makeText(Activity_pdf.this, "This is menu option", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        getWindow().setStatusBarColor(getColor(R.color.color_status_bar));
    }

    private List<PdfModel> setListPdf() {
        pdfModelList = new ArrayList<>();

        pdfModelList.add(new PdfModel("To skill a Mockingbird"));
        pdfModelList.add(new PdfModel("To skill a Mockingbird"));
        pdfModelList.add(new PdfModel("To skill a Mockingbird"));
        pdfModelList.add(new PdfModel("To skill a Mockingbird"));
        pdfModelList.add(new PdfModel("To skill a Mockingbird"));
        return pdfModelList;
    }
}