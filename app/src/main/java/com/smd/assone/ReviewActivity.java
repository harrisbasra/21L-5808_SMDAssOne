package com.smd.assone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        TextView senderInfo = findViewById(R.id.sender_info);
        TextView receiverInfo = findViewById(R.id.receiver_info);
        FloatingActionButton fabEditSender = findViewById(R.id.fab_edit_sender);

        // Retrieve the data passed from the SenderFormActivity and ReceiverFormActivity
        Intent intent = getIntent();
        String senderDetails = intent.getStringExtra("senderDetails");
        String receiverDetails = intent.getStringExtra("receiverDetails");

        // Display the data in the TextViews
        senderInfo.setText(senderDetails);
        receiverInfo.setText(receiverDetails);

        // Set up the FAB to navigate back to the SenderFormActivity
        fabEditSender.setOnClickListener(v -> {
            Intent editIntent = new Intent(ReviewActivity.this, SenderFormActivity.class);
            startActivity(editIntent);
        });
    }
}
