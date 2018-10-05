package com.uinam.saintek.prjcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String STATE_HASIL = "state_hasil";
    private EditText edtNilaiA, edtNilaiB;
    private Button btnCalculate;
    private TextView txvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        edtNilaiA = (EditText)findViewById(R.id.edt_nilai_a);
        edtNilaiB = findViewById(R.id.edt_nilai_b);
        btnCalculate = findViewById(R.id.btn_calculate);
        txvHasil = findViewById(R.id.txv_hasil);
        btnCalculate.setOnClickListener(this);
        if (savedInstanceState != null){
            txvHasil.setText(savedInstanceState.getString(STATE_HASIL));
        }
        txvHasil.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, txvHasil.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        int nilA = Integer.parseInt(edtNilaiA.getText().toString());
        int nilB = Integer.parseInt(edtNilaiB.getText().toString());
        String hasil = String.valueOf(nilA * nilB);
        txvHasil.setText(hasil);
    }
}
