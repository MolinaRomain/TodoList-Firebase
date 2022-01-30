package com.ynov.todolist_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.text.DateFormat;
import java.util.Date;

public class AddTask extends AppCompatActivity {

    private DatabaseReference reference;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private String onlineUserID;

    private Button btn_cancel;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        onlineUserID = mUser.getUid();
        reference = FirebaseDatabase.getInstance().getReference().child("user_tasks").child(onlineUserID);

        btn_cancel = findViewById(R.id.CancelBtn);
        btn_cancel.setOnClickListener(view -> finish());

        final EditText name = findViewById(R.id.name_task);
        final EditText description = findViewById(R.id.description_task);

        btn_save = findViewById(R.id.saveBtn);
        btn_save.setOnClickListener((v)->{
            String id = reference.push().getKey();
            String tName = name.getText().toString().trim();
            String tDescription = description.getText().toString().trim();
            String date = DateFormat.getDateInstance().format(new Date());

            if(TextUtils.isEmpty(tName)){
                name.setError("Nom Requis");
            }else{
                Task newTask = new Task(id, tName, tDescription, date);

                reference.child(id).setValue(newTask).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull com.google.android.gms.tasks.Task<Void> newTask) {
                        if (newTask.isSuccessful()){
                            Toast.makeText(AddTask.this, "Tâche ajouté", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        }
                        else {
                            String error = newTask.getException().toString();
                            Toast.makeText(AddTask.this, "Error :" + error, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}