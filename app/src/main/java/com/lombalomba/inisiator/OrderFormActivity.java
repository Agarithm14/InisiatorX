package com.lombalomba.inisiator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderFormActivity extends AppCompatActivity {

    int ukuranKertas;
    int jumlahKertas = 1;
    TextView totalText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);

        //Spinner
        String[] arraySpinner = new String[] {
                "A4","F4"
        };
        Spinner s = (Spinner) findViewById(R.id.pilihan_ukuran_kertas);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ukuranKertas = i;
                hitungTotal();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        //Jumlah Text
        final EditText jumlahText = findViewById(R.id.jumlahText);
        jumlahText.setText(String.valueOf(jumlahKertas));
        jumlahText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    jumlahKertas = Integer.parseInt(s.toString());
                }
                catch (Exception e){

                }
                hitungTotal();
            }
        });

        totalText = findViewById(R.id.totalText);

    }

    private void hitungTotal(){
        int harga = 1;
        switch (ukuranKertas){
            case 0:
                harga = 1000;
                break;
            case 1 :
                harga = 2000;
                break;
        }
        harga *= jumlahKertas;
        totalText.setText(Integer.toString(harga));
    }
}
