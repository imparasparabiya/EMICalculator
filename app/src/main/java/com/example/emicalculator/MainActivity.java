package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextInputEditText txtpamount, txtinterest, txtyear;
    Button btncal;
    ;
    TextView txt1, txtans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtpamount = findViewById(R.id.txtpamount);
        txtinterest = findViewById(R.id.txtinterest);
        txtyear = findViewById(R.id.txtyear);
        txt1 = findViewById(R.id.txt1);
        txtans = findViewById(R.id.txtans);
        btncal = findViewById(R.id.btncal);

        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double principal = Integer.parseInt(txtpamount.getText().toString());
                double interest = Integer.parseInt(txtinterest.getText().toString());
                double year = Integer.parseInt(txtyear.getText().toString());
                double ans;

                interest = interest / 12 / 100;
                ans = interest * (1 + interest) * year / (1 + interest) * year - 1;
                Toast.makeText(MainActivity.this, "Succsfully", Toast.LENGTH_LONG).show();
                txtans.setText(new DecimalFormat().format(ans));
            }
        });
    }
}