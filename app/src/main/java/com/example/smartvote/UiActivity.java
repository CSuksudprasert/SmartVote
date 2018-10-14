package com.example.smartvote;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        final Button checkButton = findViewById(R.id.check_button);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText numberEditText = findViewById(R.id.number_editText);
                String num = numberEditText.getText().toString();
                if(numberEditText.length() == 13){
                    String msg = null;
                    if(num.equals("1111111111111"))
                        msg = "คุณเป็นผู้มีสืทธิเลือกตั้ง";

                    else if(num.equals("2222222222222"))
                        msg = "คุณเป็นผู้มีสืทธิเลือกตั้ง";

                    else
                        msg = "คุณไม่มีสิทธิเลือกตั้ง";



                    AlertDialog.Builder dialog = new AlertDialog.Builder(UiActivity.this);
                    dialog.setTitle("ผลการตรวจสอบสิทธิเลือกตั้ง");
                    dialog.setMessage(msg);

                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.setCancelable(false);
                    dialog.show();
                }

                else{
                    String message = "กรุณากรอกหมายเลขบัตรประชาชน 13 หลัก";
                    Toast t = Toast.makeText(UiActivity.this , message, Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });

    }
}
