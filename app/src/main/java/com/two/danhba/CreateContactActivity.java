package com.two.danhba;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by admin on 5/20/2018.
 */

public class CreateContactActivity extends Activity implements View.OnClickListener {

    private EditText edtName, edtCompany, edtPhone, edtEmail;
    private RadioButton btNam, btNu;
    private Button btnHuy, btnThem;
    private RadioGroup radioGroupCharacter;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private int gioiTinh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        initView();
    }

    private void initView() {
        edtName = (EditText) findViewById(R.id.edt_name);
        edtCompany = (EditText) findViewById(R.id.edt_company);
        edtPhone = (EditText) findViewById(R.id.edt_phone);
        edtEmail = (EditText) findViewById(R.id.edt_email);


        findViewById(R.id.btn_huy).setOnClickListener(this);
        findViewById(R.id.btn_them).setOnClickListener(this);

        this.radioGroupCharacter= (RadioGroup) this.findViewById(R.id.radioGroup_character);
        this.radioButtonMale = (RadioButton) this.findViewById(R.id.bt_nam);
        this.radioButtonFemale  =  (RadioButton)this.findViewById(R.id.bt_nu);


        if (radioButtonFemale.isClickable()){
            gioiTinh = 0;
        }

        if (radioButtonMale.isClickable()){
            gioiTinh = 1;
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_huy:
                onBackPressed();
                break;
            case R.id.btn_them:
                //saveContact();
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("users");

                Contact contact  =new Contact(edtName.getText().toString(),edtCompany.getText().toString(),
                        edtPhone.getText().toString(), edtEmail.getText().toString(), gioiTinh);
                myRef.push().setValue(contact);
                onBackPressed();
                break;
        }
    }
}
