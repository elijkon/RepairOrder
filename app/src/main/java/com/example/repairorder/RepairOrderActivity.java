package com.example.repairorder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class RepairOrderActivity extends AppCompatActivity {
    TextView subtotalTV, totalTV, taxTV;
    Button submitB;
    EditText partsET, laborET, paintET, inspectionET, orderET;
    Spinner ordSpinner;


    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String selectedOrderType = parent.getItemAtPosition(position).toString();
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /*Random gen = new Random();

            double number =  gen.nextDouble();
            String amount  = "$ " + number;
            subtotalTV.setText(amount);

            String orderTypeVal = orderET.getText().toString();
            Integer OT = Integer.getInteger(orderTypeVal);
            */

            String inspectionVal = inspectionET.getText().toString();
            Double inspectValDouble = Double.parseDouble(inspectionVal);

            String paintVal = paintET.getText().toString();
            Double paintValDouble = Double.parseDouble(paintVal);

            String partsVal = partsET.getText().toString();
            Double partsValDouble = Double.parseDouble(partsVal);

            String laborVal = laborET.getText().toString();
            Double laborValDouble = Double.parseDouble(laborVal);

            double subtotalAmount = laborValDouble + partsValDouble + paintValDouble + inspectValDouble;
            String subtotalStringAmount = "$ " + subtotalAmount;
            subtotalTV.setText(subtotalStringAmount);

            double taxAmount = subtotalAmount * 0.09;
            String taxTotal = "$ " + taxAmount;
            taxTV.setText(taxTotal);

            double totalAmount = subtotalAmount + taxAmount;
            String total = "$ " + totalAmount;
            totalTV.setText(total);

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
        taxTV = findViewById(R.id.taxAmount);

        submitB = findViewById(R.id.submitButton);
        submitB.setOnClickListener(buttonListener);

        subtotalTV = findViewById(R.id.subtotalAmount);
        //orderET = findViewById(R.id.typeInput);
        inspectionET = findViewById(R.id.inspectInput);
        paintET = findViewById(R.id.paintInput);
        partsET = findViewById(R.id.partsInput);
        laborET = findViewById(R.id.laborInput);

        ordSpinner = findViewById(R.id.orderSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.order_types,
                android.R.layout.simple_spinner_item
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ordSpinner.setAdapter(adapter);


    }
}