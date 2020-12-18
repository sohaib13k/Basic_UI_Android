package com.sohaibkhan.uichallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button buttonPickImage, buttonRegister;
    private EditText editTextName, editTextEmail, editTextPassword, editTextPassword2;
    private CheckBox checkBoxLicense;
    private TextView textView, textView2, textView3, textView4;
    private ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initViews();

        buttonPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Still learning!!😬", Toast.LENGTH_SHORT).show();
            }
        });

        userRegister();

    }

    private void initViews() {
        buttonPickImage = findViewById(R.id.button_pickImage);
        buttonRegister = findViewById(R.id.button_register);

        editTextName = findViewById(R.id.editTextPersonName);
        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPassword2 = findViewById(R.id.editTextPassword2);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        checkBoxLicense = findViewById(R.id.checkBoxLicense);

        parent = findViewById(R.id.parent);
    }

    private void userRegister() {
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = true;
                hideWarningText();
                if (editTextName.getText().toString().equals("")) {
                    check = false;
                    textView.setVisibility(View.VISIBLE);
                }
                if (editTextEmail.getText().toString().equals("")) {
                    check = false;
                    textView2.setVisibility(View.VISIBLE);
                }
                if (editTextPassword.getText().toString().equals("")) {
                    check = false;
                    textView3.setVisibility(View.VISIBLE);
                }
                if (editTextPassword2.getText().toString().equals("")) {
                    check = false;
                    textView4.setText("Re-enter password");
                    textView4.setVisibility(View.VISIBLE);
                } else if (!editTextPassword2.getText().toString().equals(editTextPassword.getText().toString())) {
                    textView4.setText("Password doesn't match!");
                    textView4.setVisibility(View.VISIBLE);
                } else if (!checkBoxLicense.isChecked() && check) {
                    hideWarningText();
                    checkBoxLicense.setTextColor(-65536);

                    Toast.makeText(MainActivity.this, "Kindly accept license agreement", Toast.LENGTH_SHORT).show();
                } else if (check) {
                    hideWarningText();
                    checkBoxLicense.setTextColor(-16777216);
                    showSnackbar();
                }
            }
        });
    }

    private void showSnackbar() {
        Snackbar.make(parent, "Registration Successful!", BaseTransientBottomBar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editTextName.setText("");
                        editTextEmail.setText("");
                        editTextPassword.setText("");
                        editTextPassword2.setText("");
                        checkBoxLicense.setChecked(false);
                    }
                }).show();
    }

    private void hideWarningText() {
        textView.setVisibility(View.GONE);
        textView2.setVisibility(View.GONE);
        textView3.setVisibility(View.GONE);
        textView4.setVisibility(View.GONE);
    }
}
