package com.rohitparmar.mpboardeducation.scienceClass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rohitparmar.mpboardeducation.MainActivity;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.User;
import com.rohitparmar.mpboardeducation.regDone;

import java.util.HashMap;
import java.util.Map;

public class prescienceSubActivity extends AppCompatActivity {
    private String Category1, Medium1;
    EditText nameReg , PhoneReg , AddressRef, addPercent;
    Button SubmitReg;
    TextView textNote;
    MaterialTextView availableText,detailCard;
    FirebaseFirestore db;
    ProgressDialog dialog1,dialog2;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescience_sub);
        Spinner addTeacherCategorys = (Spinner)findViewById(R.id.spinner);
        Spinner Spinner2 = (Spinner)findViewById(R.id.spinner2);
        nameReg = findViewById(R.id.nameReg);
        PhoneReg = findViewById(R.id.phoneReg);
        textNote = findViewById(R.id.textnote);
        AddressRef = findViewById(R.id.addReg);
        addPercent = findViewById(R.id.addPercent);
        SubmitReg = findViewById(R.id.submitReg);
        availableText = findViewById(R.id.availableSub);



        FirebaseFirestore database = FirebaseFirestore.getInstance();

        db = FirebaseFirestore.getInstance();
        dialog1 = new ProgressDialog(this);
        dialog1.setMessage("Submitting...");
        dialog2 = new ProgressDialog(this);
        getSupportActionBar().hide();


        availableText.setBackgroundResource(R.drawable.textboxtransparent);

        database.collection("Changeable").document("fee").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user = documentSnapshot.toObject(User.class);
                availableText.setText(String.valueOf(user.getFee()));

            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Stream,android.R.layout.simple_spinner_dropdown_item);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       addTeacherCategorys.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Medium,android.R.layout.simple_spinner_dropdown_item);
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       Spinner2.setAdapter(adapter2);

        addTeacherCategorys.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Category1 = addTeacherCategorys.getSelectedItem().toString();// yaha pr value store hogi jo admin select karega

                String cat1 =  Category1;
                if ( cat1.equals("10th")){
                    database.collection("AvailableSub").document("10th").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            user = documentSnapshot.toObject(User.class);
                            availableText.setText(String.valueOf(user.getSubject()));
                            availableText.setBackgroundResource(R.drawable.green_box);
                            addPercent.setVisibility(View.GONE);



                            //binding.currentCoins.setText(user.getCoins() + "");
                        }
                    });
                }else  if ( cat1.equals("12th Commerce")){
                    database.collection("AvailableSub").document("12th Commerce").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            user = documentSnapshot.toObject(User.class);
                            availableText.setText(String.valueOf(user.getSubject()));
                            addPercent.setVisibility(View.VISIBLE);
                            availableText.setBackgroundResource(R.drawable.green_box);
                            //binding.currentCoins.setText(user.getCoins() + "");
                        }
                    });
                }else  if ( cat1.equals("12th Science")){
                    database.collection("AvailableSub").document("12th Science").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            user = documentSnapshot.toObject(User.class);
                            availableText.setText(String.valueOf(user.getSubject()));
                            availableText.setBackgroundResource(R.drawable.green_box);
                            addPercent.setVisibility(View.VISIBLE);
                            //binding.currentCoins.setText(user.getCoins() + "");
                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Medium1 = Spinner2.getSelectedItem().toString();// yaha pr value store hogi jo admin select karega
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        SubmitReg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String tenthPer = addPercent.getText().toString();
                String NameReg = nameReg.getText().toString();
                String phoneReg = PhoneReg.getText().toString();
                String AddressReg = AddressRef.getText().toString();
              if (NameReg.isEmpty() || phoneReg.isEmpty() || AddressReg.isEmpty() ){
                  Toast.makeText(prescienceSubActivity.this, "fill the form...", Toast.LENGTH_SHORT).show();
              } else {

                  String avt = availableText.getText().toString();
                  new AlertDialog.Builder(prescienceSubActivity.this)

                          .setMessage( avt + " fees 199/month , 3 day free classes")
                          .setCancelable(false)
                          .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {

                                  dialog1.show();
                                  Map<String, Object> loveCal = new HashMap<>(); //questionMap
                                  loveCal.put("Name", NameReg);
                                  loveCal.put("Number", phoneReg);
                                  loveCal.put("Stream", Category1);
                                  loveCal.put("Medium", Medium1);
                                  loveCal.put("Address", AddressReg);
                                  loveCal.put("PercentTenth", tenthPer);
                                  loveCal.put("timeStamp", Timestamp.now());

                                  String docPhone = phoneReg;

                                  db.collection("Requests")
                                          .document(docPhone)
                                          .set(loveCal).addOnCompleteListener(new OnCompleteListener<Void>() {
                                      @Override
                                      public void onComplete(@NonNull Task<Void> task) {
                                          dialog1.dismiss();

                                          if (task.isSuccessful()) {
                                              Intent intent = new Intent( prescienceSubActivity.this, regDone.class);
                                              startActivity(intent);
                                              finish();
                                          }
                                      }

                                  }).addOnFailureListener(new OnFailureListener() {
                                      @Override
                                      public void onFailure(@NonNull Exception e) {
                                          dialog.dismiss();
                                          Toast.makeText(prescienceSubActivity.this, "failed", Toast.LENGTH_LONG).show();
                                      }
                                  });
                              }
                          })
                          .setNegativeButton("No", new DialogInterface.OnClickListener() {
                              @Override
                              public void onClick(DialogInterface dialog, int which) {
                                  dialog.dismiss();
                              }
                          }).show();

              }
            }


    });
    }

}