package com.example.demo73;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txtu, txtp;
    Button btnlogoin, btncancel;
    TextView tvkq;
    CheckBox chk;
    List<Object> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtu = findViewById(R.id.demo73txtu);
        txtp = findViewById(R.id.demo73txtp);
        btncancel = findViewById(R.id.demo73btncancel);
        btnlogoin = findViewById(R.id.buttondemo73btnlogin);
        tvkq = findViewById(R.id.demo73tv1);
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        list = readpassword();
        if(list.size()>0){
            txtu.setText(list.get(0).toString());
            txtp.setText(list.get(1).toString());
            chk.setChecked((boolean) list.get(2));
        }
        btnlogoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = txtu.getText().toString();
                String p = txtp.getText().toString();
                if(u.equals("")||p.equals("")){
                    tvkq.setText("Khong duoc de trong");
                    return;
                }else if(u.equalsIgnoreCase("admin")&&
                        p.equalsIgnoreCase("admin")){
                    tvkq.setText("Login thanh cong");
                    return;

                }          else {
                    tvkq.setText("sai mat khau");
                    return;
                }  }
        });
    }

    void savePassword(String u, String p, boolean status) {
        SharedPreferences s = getSharedPreferences("Tu", MODE_PRIVATE);
        SharedPreferences.Editor editor = s.edit();
        if (status == false) {
            editor.clear();
        } else {
            editor.putString("u", u);
            editor.putString("p", p);
            editor.putBoolean("chk", status);
        }
        editor.commit();
    }

    List<Object> readpassword()

    {
        List<Object> ls = new ArrayList<>();
        SharedPreferences s = getSharedPreferences("Tu", MODE_PRIVATE);
        ls.add(s.getString("u",""));
        ls.add(s.getString("p",""));
        ls.add(s.getBoolean("chk",false));
        return ls;
    }

}