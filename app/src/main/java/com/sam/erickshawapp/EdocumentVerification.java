package com.sam.erickshawapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.button.MaterialButton;

public class EdocumentVerification extends AppCompatActivity {
   MaterialButton eddocumentverification;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edocument_verification);
        eddocumentverification=findViewById(R.id.edvbtn);
        eddocumentverification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DocumentVerified.class));
            }
        });
    }
}