package com.smd.assone;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiverFormActivity extends AppCompatActivity {

    private EditText emailEditText, fullNameEditText, contactInfoEditText, countryEditText, addressEditText;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_form);

        emailEditText = findViewById(R.id.receiver_email);
        fullNameEditText = findViewById(R.id.receiver_full_name);
        contactInfoEditText = findViewById(R.id.receiver_contact_info);
        countryEditText = findViewById(R.id.receiver_country);
        addressEditText = findViewById(R.id.receiver_address);
        nextButton = findViewById(R.id.btn_next);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    String email = emailEditText.getText().toString();
                    String name = emailEditText.getText().toString();
                    String contact = contactInfoEditText.getText().toString();
                    String country = countryEditText.getText().toString();
                    String address = addressEditText.getText().toString();

                    String receiverDetails = "Name: " + name + "\nEmail: " + email + "\nContact: " + contact + "\nCountry: " + country + "\nAddress: " + address;


                    Intent intent = getIntent();
                    String senderDetails = intent.getStringExtra("senderDetails");

                    Intent reviewIntent = new Intent(ReceiverFormActivity.this, ReviewActivity.class);
                    reviewIntent.putExtra("senderDetails", senderDetails);
                    reviewIntent.putExtra("receiverDetails", receiverDetails);
                    startActivity(reviewIntent);
                }
            }
        });
    }

    // Validate input fields to ensure all are filled in
    private boolean validateInputs() {
        if (TextUtils.isEmpty(emailEditText.getText().toString())) {
            Toast.makeText(this, "Please enter receiver's email", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(fullNameEditText.getText().toString())) {
            Toast.makeText(this, "Please enter receiver's full name", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(contactInfoEditText.getText().toString())) {
            Toast.makeText(this, "Please enter receiver's contact information", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(countryEditText.getText().toString())) {
            Toast.makeText(this, "Please enter receiver's country", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(addressEditText.getText().toString())) {
            Toast.makeText(this, "Please enter receiver's address", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
