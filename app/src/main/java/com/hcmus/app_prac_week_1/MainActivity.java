package com.hcmus.app_prac_week_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtMSSV, edtClass, edtPlan;
    private RadioGroup radioGroupYear;
    private CheckBox checkMTHTN, checkDT, checkVT;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtMSSV = findViewById(R.id.edtMSSV);
        edtClass = findViewById(R.id.edtClass);
        edtPlan = findViewById(R.id.edtPlan);
        radioGroupYear = findViewById(R.id.radioGroupYear);
        checkMTHTN = findViewById(R.id.checkMTHTN);
        checkDT = findViewById(R.id.checkDT);
        checkVT = findViewById(R.id.checkVT);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String mssv = edtMSSV.getText().toString();
                String className = edtClass.getText().toString();
                String plan = edtPlan.getText().toString();

                int selectedYearId = radioGroupYear.getCheckedRadioButtonId();
                RadioButton selectedYear = findViewById(selectedYearId);
                String year = (selectedYear != null) ? selectedYear.getText().toString() : "Chưa chọn";

                String majors = "";
                if (checkMTHTN.isChecked()) majors += "MT HTN ";
                if (checkDT.isChecked()) majors += "DT ";
                if (checkVT.isChecked()) majors += "VT ";

                String result = "Họ và tên: " + name + "\nMSSV: " + mssv + "\nLớp: " + className +
                        "\nSinh viên năm: " + year + "\nChuyên ngành: " + majors + "\nKế hoạch: " + plan;

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("info", result);
                startActivity(intent);
            }
        });
    }
}
