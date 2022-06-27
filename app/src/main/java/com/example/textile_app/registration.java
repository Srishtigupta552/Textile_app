package com.example.textile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class registration extends AppCompatActivity {

    TextView firmname1,gst1,firstname1,lastname1,email1,phonenumber1,password1,cpassword1,pancard1,address1,pincode1,login1;
    Button regbtn;

    EditText DobEt, DoaEt;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firmname1 = findViewById(R.id.FirmEt);
        gst1 = findViewById(R.id.GstEt);
        firstname1 = findViewById(R.id.FirstNameEt);
        lastname1 = findViewById(R.id.LastNameEt);
        email1 = findViewById(R.id.emailEt);
        phonenumber1 = findViewById(R.id.PhoneEt);
        password1 = findViewById(R.id.PasswordEt);
        cpassword1 = findViewById(R.id.cpasswordEt);
        pancard1 = findViewById(R.id.PanEt);
        address1 = findViewById(R.id.addressEt);
        pincode1 = findViewById(R.id.PinEt);

        DobEt = (EditText) findViewById(R.id.DobEt);
        DoaEt = (EditText) findViewById(R.id.DoaEt);

        // perform click event on edit text
        DobEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog

                datePickerDialog = new DatePickerDialog(registration.this,R.style.my_dialog_theme, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        DobEt.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        // perform click event on edit text
        DoaEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(registration.this,R.style.my_dialog_theme,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                DoaEt.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        // login1 = findViewById(R.id.login1);
        regbtn = findViewById(R.id.registerBtn);


        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firmname = firmname1.getText().toString();
                String gst = gst1.getText().toString();
                String firstname = firstname1.getText().toString();
                String lastname = lastname1.getText().toString();
                String email = email1.getText().toString();
                String phonenumber = phonenumber1.getText().toString();
                String password = password1.getText().toString();
                String cpassword = cpassword1.getText().toString();
                String pancard = pancard1.getText().toString();
                String address = address1.getText().toString();
                String pincode = pincode1.getText().toString();
                String dob = DobEt.getText().toString();
                String doa = DoaEt.getText().toString();


                String type = "Registration";

                rfunction function1 = new rfunction(registration.this);
                function1.execute(type,firmname,gst,firstname,lastname,email,phonenumber, password,cpassword,pancard,address,pincode,dob,doa);

                // Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

            }
        });

   /*     login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(registration.this,MainActivity.class);
                startActivity(intent);
            }
        });
*/
    }
}