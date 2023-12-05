package com.example.emicalculator;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends BaseActivity {

    TextInputEditText txtpamount, txtinterest, txtyear;
    Button btncal;

    TextView txt1,txt2,txt3, txtans, txtans2,txtans3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtpamount = findViewById(R.id.txtpamount);
        txtinterest = findViewById(R.id.txtinterest);
        txtyear = findViewById(R.id.txtyear);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt2 = findViewById(R.id.txt3);
        txtans = findViewById(R.id.txtans);
        txtans2 = findViewById(R.id.txtans2);
        txtans3 = findViewById(R.id.txtans3);
        btncal = findViewById(R.id.btncal);

        Print("Welcome");

        btncal.setOnClickListener(this::onClick);
    }

    private void onClick(View view) {
        double principal = Double.parseDouble(Objects.requireNonNull(txtpamount.getText()).toString());
        double interest = Double.parseDouble(txtinterest.getText().toString());
        double mon = Double.parseDouble(txtyear.getText().toString());
        double ans1 = 1;
        double r = interest / (12 *100);

        for (int i = 0;i<mon;i++) {
            ans1 *= (1+r);
        }

        double ans = principal * r * (ans1/(ans1-1));
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(1);
        txtans.setText(df.format(ans));
        double tamt =  ans*mon;
        txtans2.setText(df.format(tamt));
        double iamt = tamt - principal;
        txtans3.setText(df.format(iamt));





        Toast.makeText(MainActivity.this, "Succsfully", Toast.LENGTH_LONG).show();


    }
}