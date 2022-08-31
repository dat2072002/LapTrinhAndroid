package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etChieuCao, etCanNang;
    RadioButton rbNam, rbNu;
    Button btnTinhBMI;
    TextView txtChiso,txtNhanxet;
    double chiSo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etChieuCao = findViewById(R.id.et_chieucao);
        etChieuCao = findViewById(R.id.et_cannang);
        rbNam = findViewById(R.id.rb_nam);
        rbNu = findViewById(R.id.rb_nu);
        btnTinhBMI = findViewById(R.id.btn_tinh);
        txtChiso = findViewById(R.id.txt_ketqua);
        txtNhanxet = findViewById(R.id.txt_nhanxet);

        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double chieuCao = Double.parseDouble(etChieuCao.getText().toString()) / 100;
                double canNang = Double.parseDouble(etCanNang.getText().toString());
                chiSo = Math.round((canNang/Math.pow(chieuCao,2))*10.0)/10.0;
                if (rbNam.isChecked()){
                    if(chiSo < 18.5){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn cần bổ sung thêm dinh dưỡng");
                    }
                    else if(chiSo >= 18.5 && chiSo <= 24.9){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn có chỉ số BMI bình thường");
                    }
                    else if(chiSo > 25 && chiSo <= 29.9){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn đang ở giai đoạn tiền béo phì/béo phì mức độ thấp");
                    }
                    else if(chiSo >= 30 && chiSo <= 34.9 ){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn đang ở béo phì độ I");
                    }
                    else if(chiSo >= 35 && chiSo <= 39.9 ){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn đang ở béo phì độ II");
                    }
                    if(chiSo == 40){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn đang ở béo phì độ III");
                    }

                }
                else if(rbNu.isChecked()){
                    if(chiSo < 18.5){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn cần bổ sung thêm dinh dưỡng");
                    }
                    else if(chiSo >= 18.5 && chiSo <= 22.9){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn có chỉ số BMI bình thường");
                    }
                    else if(chiSo == 23){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn đang bị thừa cân");
                    }
                    else if(chiSo > 23 && chiSo <= 24.9){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn đang ở giai đoạn tiền béo phì/béo phì mức độ thấp");
                    }
                    else if(chiSo >= 25 && chiSo <= 29.9 ){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn đang ở béo phì độ I");
                    }
                    else if(chiSo >= 30 && chiSo <= 39.9 ){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn đang ở béo phì độ II");
                    }
                    else if(chiSo == 40){
                        txtChiso.setText(String.valueOf(chiSo));
                        txtNhanxet.setText("Bạn đang ở béo phì độ III");
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Vui lòng chọn giới tính!",
                    Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}