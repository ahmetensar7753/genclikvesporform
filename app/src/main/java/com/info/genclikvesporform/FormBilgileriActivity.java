package com.info.genclikvesporform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class FormBilgileriActivity extends AppCompatActivity {

    private PDFView pdfOkuyucu;
    private Button buttonFormuDoldur;
    private String formAd = "form1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_bilgileri);

        pdfOkuyucu = (PDFView) findViewById(R.id.pdfOkuyucu);
        buttonFormuDoldur = findViewById(R.id.buttonFormuDoldur);

        buttonFormuDoldur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(FormBilgileriActivity.this,Form1DoldurActivity.class));

            }
        });

        oku(formAd);

    }

    public  void oku(String formAdi){
        pdfOkuyucu.fromAsset(formAdi+".pdf")
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAntialiasing(true).enableAnnotationRendering(false)
                .scrollHandle(null)
                .password(null)
                .spacing(0)
                .pageFitPolicy(FitPolicy.WIDTH)
                .load();
    }

}