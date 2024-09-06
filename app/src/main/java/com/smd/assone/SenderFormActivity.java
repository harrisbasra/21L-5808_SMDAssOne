package com.smd.assone;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SenderFormActivity extends AppCompatActivity {

    private EditText emailEditText, fullNameEditText, contactInfoEditText, countryEditText, addressEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender_form);

        emailEditText = findViewById(R.id.sender_email);
        fullNameEditText = findViewById(R.id.sender_full_name);
        contactInfoEditText = findViewById(R.id.sender_contact_info);
        countryEditText = findViewById(R.id.sender_country);
        addressEditText = findViewById(R.id.sender_address);
        Button nextButton = findViewById(R.id.btn_next);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    String email = emailEditText.getText().toString();
                    String name = emailEditText.getText().toString();
                    String contact = contactInfoEditText.getText().toString();
                    String country = countryEditText.getText().toString();
                    String address = addressEditText.getText().toString();

                    String senderDetails = "Name: " + name + "\nEmail: " + email + "\nContact: " + contact + "\nCountry: " + country + "\nAddress: " + address;

                    Intent reviewIntent = new Intent(SenderFormActivity.this, ReceiverFormActivity.class);
                    reviewIntent.putExtra("senderDetails", senderDetails);
                    startActivity(reviewIntent);
                }
            }
        });
    }

    private boolean validateInputs() {
        if (TextUtils.isEmpty(emailEditText.getText().toString())) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(fullNameEditText.getText().toString())) {
            Toast.makeText(this, "Please enter your full name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(contactInfoEditText.getText().toString())) {
            Toast.makeText(this, "Please enter your contact information", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(countryEditText.getText().toString())) {
            Toast.makeText(this, "Please enter your country", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(addressEditText.getText().toString())) {
            Toast.makeText(this, "Please enter your address", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
