package com.rohitparmar.mpboardeducation.Premium.LoginPage;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignIn extends AppCompatActivity {
    EditText nameReg  , PhoneReg ;
    Button SubmitReg;
    FirebaseFirestore db;
    ProgressDialog dialog1,dialog2;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        nameReg = findViewById(R.id.nameReg);
        PhoneReg = findViewById(R.id.phoneReg);
        SubmitReg = findViewById(R.id.submitReg);




        FirebaseFirestore database = FirebaseFirestore.getInstance();

        db = FirebaseFirestore.getInstance();
        dialog1 = new ProgressDialog(this);
        dialog1.setMessage("Submitting...");
        dialog2 = new ProgressDialog(this);
        getSupportActionBar().hide();


        database.collection("AvailableSub").document("PaymentGateway").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user = documentSnapshot.toObject(User.class);
            }
        });

        SubmitReg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String valid = "0";
                String NameReg = nameReg.getText().toString();
                String phoneReg = PhoneReg.getText().toString();
                if (NameReg.isEmpty() || phoneReg.length()!= 10){
                    Toast.makeText(SignIn.this, "Something went wrong...", Toast.LENGTH_SHORT).show();
                } else {

                    new AlertDialog.Builder(SignIn.this)
                            .setMessage( "Are you want to register for premium course 2023" + "")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    List<String> val = new ArrayList<>();
                                    val.add("0");
                                    val.add("0");
                                    val.add("0");
                                    val.add("0");
                                    val.add("0");
                                    val.add("0");
                                    val.add("0");
                                    val.add("0");
                                    val.add("0");
                                    val.add("0");
                                    val.add("0");
                                    dialog1.show();
                                    Map<String, Object> loveCal = new HashMap<>(); //questionMap
                                    loveCal.put("name", NameReg);
                                    loveCal.put("subject", phoneReg);
                                    loveCal.put("fee", valid);
                                    loveCal.put("timeStamp", Timestamp.now());
                                    loveCal.put("val", val);






                                    db.collection("PremiumStudents")
                                            .document(phoneReg)
                                            .set(loveCal).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    dialog1.dismiss();
                                                    if (task.isSuccessful()) {

                                                        SharedPreferences shrd = getSharedPreferences("credential" , MODE_PRIVATE);
                                                        SharedPreferences.Editor editor = shrd.edit();
                                                        Toast.makeText(SignIn.this, " mobile no. "+ phoneReg, Toast.LENGTH_SHORT).show();
                                                        editor.putString("mobileNo" ,phoneReg);
                                                        editor.apply();

                                                        Intent intent = new Intent( SignIn.this, regDone.class);
                                                        startActivity(intent);
                                                        finish();
                                                    }
                                                }

                                            }).addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    dialog.dismiss();
                                                    Toast.makeText(SignIn.this, "failed", Toast.LENGTH_LONG).show();
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