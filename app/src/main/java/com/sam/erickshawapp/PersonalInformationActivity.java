package com.sam.erickshawapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class PersonalInformationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    MaterialButton confirmbtn;
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference rootRef;
    EditText name, fathername, dateofbirth, mailid, mobileno, aadharnumber, pannumber, currentaddress, whatsappnumber, pincode, category;

    Spinner gender;
    Spinner spino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String[] gender = {"Male", "Female",
        };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
        getSupportActionBar().hide();
        spino = findViewById(R.id.genderspinner);
        spino.setOnItemSelectedListener(this);
        confirmbtn = findViewById(R.id.confirmbtn);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        name = findViewById(R.id.name);
        fathername = findViewById(R.id.fathername);
        dateofbirth = findViewById(R.id.dateofbirth);
        mailid = findViewById(R.id.mailid);
        mobileno = findViewById(R.id.mobileno);
        aadharnumber = findViewById(R.id.aadharno);
        pannumber = findViewById(R.id.panno);
        currentaddress = findViewById(R.id.currentaddress);
        whatsappnumber = findViewById(R.id.whatsappno);
        pincode = findViewById(R.id.pincode);
        category = findViewById(R.id.category);
        rootRef = FirebaseDatabase.getInstance().getReference();

          status1();




        confirmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*             startActivity(new Intent(getApplicationContext(), Applicationform.class));*/
                postpersonaldetails(name.getText().toString().trim(), fathername.getText().toString().trim(), dateofbirth.getText().toString().trim(), spino.getSelectedItem().toString().trim(), mailid.getText().toString().trim(), mobileno.getText().toString().trim(), aadharnumber.getText().toString().trim(), pannumber.getText().toString().trim(), currentaddress.getText().toString().trim(), whatsappnumber.getText().toString().trim(), pincode.getText().toString().trim(), category.getText().toString());
            }
        });


        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                gender);

        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);


        spino.setAdapter(ad);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void postpersonaldetails(String Name, String FatherName, String DateofBirth, String Gender, String MailId, String MobileNo, String AadharNumber, String PANNumber, String CurrentAddress, String WhatsappAdress, String Pincode, String Category) {


        HashMap<String, Object> obj = new HashMap<>();
        obj.put("Name", Name);
        obj.put("FatherName", FatherName);
        obj.put("DateofBirth", DateofBirth);
        obj.put("Gender", Gender);
        obj.put("MailId", MailId);
        obj.put("MobileNo", MobileNo);
        obj.put("AaadharNumber", AadharNumber);
        obj.put("PanNumber", PANNumber);
        obj.put("CurrentAddress", CurrentAddress);
        obj.put("WhatsappAddress", WhatsappAdress);
        obj.put("Pincode", Pincode);
        obj.put("Category", Category);


        database.getReference().child(mAuth.getUid()).child("Personalinfo").updateChildren(obj).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(@NonNull Void unused) {

            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(@NonNull Void unused) {

            }
        });

        if (mAuth.getCurrentUser() != null) {
            PersInfoModel persInfoModel1 = new PersInfoModel(name.getText().toString().trim(), fathername.getText().toString().trim(), dateofbirth.getText().toString().trim(), spino.getSelectedItem().toString().trim(), mailid.getText().toString().trim(), mobileno.getText().toString().trim(), aadharnumber.getText().toString().trim(), pannumber.getText().toString().trim(), currentaddress.getText().toString().trim(), whatsappnumber.getText().toString().trim(), pincode.getText().toString().trim(), category.getText().toString());


            database.getReference().child(FirebaseAuth.getInstance().getUid()).child("Personalinfo").setValue(persInfoModel1).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {


                }
            });


        } else {
            Intent intent = new Intent(getApplicationContext(), PersonalInformationActivity.class);
            startActivity(intent);
        }


    }

    private void status1() {
        rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.hasChild(FirebaseAuth.getInstance().getUid())) {

                    database.getReference().child(mAuth.getUid()).child("Personalinfo").
                            addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    PersInfoModel bankInfoModel = snapshot.getValue(PersInfoModel.class);
                                    String Name = bankInfoModel.getName();
                                    if(Name.equals(""))
                                    {

                                    }
                                    else
                                    {
                                        startActivity(new Intent(getApplicationContext(),Applicationform.class));
                                    }


                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


                } else {

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


}