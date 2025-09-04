package com.example.repairorder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RepairOrderActivity extends AppCompatActivity {
    double numbers = 0.0;
    TextView subtotalTV, totalTV;
    Button submitB;
    EditText partsET, laborET, paintET, inspectionET, orderET;

    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /*Random gen = new Random();

            double number =  gen.nextDouble();
            String amount  = "$ " + number;
            subtotalTV.setText(amount); */

            String orderTypeVal = orderET.getText().toString();
            Integer OT = Integer.getInteger(orderTypeVal);

            String inspectionVal = inspectionET.getText().toString();
            Double inspectValDouble = Double.parseDouble(inspectionVal);

            String paintVal = paintET.getText().toString();
            Double paintValDouble = Double.parseDouble(paintVal);

            String partsVal = partsET.getText().toString();
            Double partsValDouble = Double.parseDouble(partsVal);

            String laborVal = laborET.getText().toString();
            Double laborValDouble = Double.parseDouble(laborVal);

            double subtotalAmount = laborValDouble + partsValDouble + paintValDouble + inspectValDouble;

            //subtotalTV.setText();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repair_order);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        totalTV = findViewById(R.id.totalAmount);
        submitB = findViewById(R.id.submitButton);
        submitB.setOnClickListener(buttonListener);
        subtotalTV = findViewById(R.id.subtotalAmount);
        orderET = findViewById(R.id.typeInput);
        inspectionET = findViewById(R.id.inspectInput);
        paintET = findViewById(R.id.paintInput);
        partsET = findViewById(R.id.partsInput);
        laborET = findViewById(R.id.laborInput);
    }
}