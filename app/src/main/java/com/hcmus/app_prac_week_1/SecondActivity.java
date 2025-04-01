package com.hcmus.app_prac_week_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtResult = findViewById(R.id.txtResult);
        Button btnBack = findViewById(R.id.btnBack);

        String info = getIntent().getStringExtra("info");
        txtResult.setText(info);

        // Xử lý khi bấm nút Quay lại
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng màn hình hiện tại và quay lại MainActivity
            }
        });
    }
}
