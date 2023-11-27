package com.info.genclikvesporform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class Form1DoldurActivity extends AppCompatActivity {

    private static final int STORAGE_CODE = 1000;
    private EditText editTextSporcuAdSoyad,editTextTcNo,editTextDogumTarih,editTextDogumYeri;
    private EditText editTextBabaAdi,editTextAnneAdi,editTextOkuluVeSinifi;
    private RadioButton radioButtonSaat,radioButtonSaat2,radioButtonSaat3;
    private RadioButton radioButtonGelir,radioButtonGelir2,radioButtonGelir3;
    private EditText editTextBrans;
    private CheckBox checkBoxIzin;
    private EditText editTextVeliAdSoyad,editTextVeliTelefon;
    private Button buttonFormuOlustur;
    private TextView textViewFormTarih;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1_doldur);

        editTextSporcuAdSoyad = findViewById(R.id.editTextSporcuAdSoyad);
        editTextTcNo = findViewById(R.id.editTextTcNo);
        editTextDogumTarih = findViewById(R.id.editTextDogumTarih);
        editTextDogumYeri = findViewById(R.id.editTextDogumYeri);
        editTextBabaAdi = findViewById(R.id.editTextBabaAdi);
        editTextAnneAdi = findViewById(R.id.editTextAnneAdi);
        editTextOkuluVeSinifi = findViewById(R.id.editTextOkuluVeSinifi);
        radioButtonSaat = findViewById(R.id.radioButtonSaat);
        radioButtonSaat2 = findViewById(R.id.radioButtonSaat2);
        radioButtonSaat3 = findViewById(R.id.radioButtonSaat3);
        radioButtonGelir = findViewById(R.id.radioButtonGelir);
        radioButtonGelir2 = findViewById(R.id.radioButtonGelir2);
        radioButtonGelir3 = findViewById(R.id.radioButtonGelir3);
        editTextBrans = findViewById(R.id.editTextBrans);
        checkBoxIzin = findViewById(R.id.checkBoxIzin);
        editTextVeliAdSoyad = findViewById(R.id.editTextVeliAdSoyad);
        editTextVeliTelefon = findViewById(R.id.editTextVeliTelefon);
        buttonFormuOlustur = findViewById(R.id.buttonFormuOlustur);
        textViewFormTarih = findViewById(R.id.textViewFormTarih);



        buttonFormuOlustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT>Build.VERSION_CODES.M){

                    if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                            PackageManager.PERMISSION_DENIED){
                        String [] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission,STORAGE_CODE);
                    }else {
                        pdfKaydet();
                    }

                }else {
                        pdfKaydet();
                }

            }
        });

    }

    private void pdfKaydet() {

        Document doc = new Document();
        String filename = new String("deneme");
        String filepath = Environment.getExternalStorageDirectory()+"/"+filename+".pdf";

        try {

            PdfWriter.getInstance(doc,new FileOutputStream(filepath));
            doc.open();
            doc.add(new Paragraph("deneme metni buradadır"));
            doc.close();
            Toast.makeText(this,"Dosya Oluşturuldu",Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {

            case STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pdfKaydet();
                } else {
                    Toast.makeText(this, "Uygulamaya Okuma-Yazma yetkisi veriniz..", Toast.LENGTH_SHORT).show();
                }
            }

        }
    }


}