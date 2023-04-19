package com.swj.tp05registmember;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name;
    RadioGroup rg_gender;
    RadioGroup rg_city;
    EditText phone01, phone02, phone03;
    CheckBox cb_email,  cb_phone, cb_visit, cb_sms;
    Button btn_regist;
    TextView tv_member_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        rg_gender = findViewById(R.id.rg_gender);
        rg_city = findViewById(R.id.rg_city);
        phone01 = findViewById(R.id.phone01);
        phone02 = findViewById(R.id.phone02);
        phone03 = findViewById(R.id.phone03);
        cb_email = findViewById(R.id.cb_email);
        cb_phone = findViewById(R.id.cb_phone);
        cb_visit = findViewById(R.id.cb_visit);
        cb_sms = findViewById(R.id.cb_sms);
        btn_regist = findViewById(R.id.btn_regist);
        tv_member_list = findViewById(R.id.tv_member_list);

        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "";
                RadioButton rb_gender =
                        findViewById(rg_gender.getCheckedRadioButtonId());
                RadioButton rb_city =
                        findViewById(rg_city.getCheckedRadioButtonId());
                s += name.getText().toString() + " ";
                s += rb_gender.getText().toString() + " ";
                s += rb_city.getText().toString() + " ";
                s += phone01.getText().toString() + "-";
                s += phone02.getText().toString() + "-";
                s += phone03.getText().toString() + " ";

                if(cb_email.isChecked())
                    s += cb_email.getText().toString() + ",";

                if(cb_phone.isChecked())
                    s += cb_phone.getText().toString() + ",";

                if(cb_visit.isChecked())
                    s += cb_visit.getText().toString() + ",";

                if(cb_sms.isChecked())
                    s += cb_sms.getText().toString();

                if(s.charAt(s.length()-1) == ',')
                    s = s.substring(0, s.length()-1);

                s += "\n";

                tv_member_list.append(s);
            }
        });

        phone01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 3) phone02.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        phone02.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(
                    CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 4) phone03.requestFocus();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
}