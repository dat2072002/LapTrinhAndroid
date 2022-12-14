package com.example.cuocduakithu;

import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    ImageButton ibtnPlay;
    int soDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);

        txtDiem.setText(soDiem + "");
        Play();
    }

    private void EnableCheckBox(){
        cbOne.setEnabled(true);
        cbTwo.setEnabled(true);
        cbThree.setEnabled(true);
    }
    private void DisableCheckBox(){
        cbOne.setEnabled(false);
        cbTwo.setEnabled(false);
        cbThree.setEnabled(false);
    }

    private void AnhXa(){
        txtDiem      = (TextView) findViewById(R.id.textviewDiemSo);
        ibtnPlay     = (ImageButton) findViewById(R.id.buttomPlay);
        cbOne        = (CheckBox) findViewById(R.id.checkboxOne);
        cbTwo        = (CheckBox) findViewById(R.id.checkboxTwo);
        cbThree      = (CheckBox) findViewById(R.id.checkboxThree);
        skOne        = (SeekBar) findViewById(R.id.seekbarOne);
        skTwo        = (SeekBar) findViewById(R.id.seekbarTwo);
        skThree      = (SeekBar) findViewById(R.id.seekbarThree);
    }

    CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
        @Override
        public void onTick(long l) {
            int number = 5;
            Random random = new Random();
            int one = random.nextInt(number);
            int two = random.nextInt(number);
            int three = random.nextInt(number);

            if(skOne.getProgress() >= skOne.getMax()){
                this.cancel();
                ibtnPlay.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "ONE WIN", Toast.LENGTH_SHORT).show();
                if(cbOne.isChecked()){
                    soDiem += 10;
                    Toast.makeText(MainActivity.this, "B???n ??o??n ch??nh x??c", Toast.LENGTH_SHORT).show();
                }else{
                    soDiem -= 10;
                    Toast.makeText(MainActivity.this, "B???n ???? ??o??n sai ", Toast.LENGTH_SHORT).show();
                }
                txtDiem.setText(soDiem + "");
                EnableCheckBox();
            }
            if(skTwo.getProgress() >= skTwo.getMax()){
                this.cancel();
                ibtnPlay.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "TWO WIN", Toast.LENGTH_SHORT).show();
                if(cbTwo.isChecked()){
                    soDiem += 10;
                    Toast.makeText(MainActivity.this, "B???n ??o??n ch??nh x??c", Toast.LENGTH_SHORT).show();
                }else{
                    soDiem -= 10;
                    Toast.makeText(MainActivity.this, "B???n ???? ??o??n sai ", Toast.LENGTH_SHORT).show();
                }
                txtDiem.setText(soDiem + "");
                EnableCheckBox();
            }
            if(skThree.getProgress() >= skThree.getMax()){
                this.cancel();
                ibtnPlay.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "THREE WIN", Toast.LENGTH_SHORT).show();
                if(cbThree.isChecked()){
                    soDiem += 10;
                    Toast.makeText(MainActivity.this, "B???n ??o??n ch??nh x??c", Toast.LENGTH_SHORT).show();
                }else{
                    soDiem -= 10;
                    Toast.makeText(MainActivity.this, "B???n ???? ??o??n sai ", Toast.LENGTH_SHORT).show();
                }
                txtDiem.setText(soDiem + "");
                EnableCheckBox();
            }

            skOne.setProgress(skOne.getProgress() + one);
            skTwo.setProgress(skTwo.getProgress() + two);
            skThree.setProgress(skThree.getProgress() + three);
        }

        @Override
        public void onFinish() {

        }
    };

    private void Play(){

        ibtnPlay = (ImageButton) findViewById(R.id.buttomPlay);
        ibtnPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(cbOne.isChecked() || cbTwo.isChecked() || cbThree.isChecked()){
                skOne.setProgress(0);
                skTwo.setProgress(0);
                skThree.setProgress(0);
                ibtnPlay.setVisibility(View.INVISIBLE);
                countDownTimer.start();

                DisableCheckBox();

            }else{
                    Toast.makeText(MainActivity.this, "Vui L??ng ?????t C?????c Tr?????c!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    //bo check 2,3
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    //bo check 1,3
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    //bo check 1,2
                    cbOne.setChecked(false);
                    cbTwo.setChecked(false);
                }
            }
        });
    }

}