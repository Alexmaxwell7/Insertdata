package com.example.realtimedatabase;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.*;

import java.lang.reflect.Member;

public class MainActivity extends AppCompatActivity {
    EditText a,b;
    Button c,d;
    DatabaseReference reff;
    member Member;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        a=(EditText)findViewById(R.id.a);
        b=(EditText)findViewById(R.id.b);
        c=(Button)findViewById(R.id.c);
        d=(Button)findViewById(R.id.show);
        reff= FirebaseDatabase.getInstance().getReference().child("member");
        Member=new member();
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member.setEmail(a.getText().toString().trim());
                Member.setPassword(b.getText().toString().trim());
                String email = a.getText().toString().trim();
                String password=b.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"enter the email",Toast.LENGTH_LONG).show();
                }
                if(password.length()<6){
                    Toast.makeText(getApplicationContext(),"Enter Must 6 character ",Toast.LENGTH_LONG).show();
                }

                reff.push().setValue(Member);
                Toast.makeText(MainActivity.this, "data successfully insert",Toast.LENGTH_LONG).show();
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reff=FirebaseDatabase.getInstance().getReference().child("member");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String email=dataSnapshot.child("member").getValue().toString();
                        String password=dataSnapshot.child("member").getValue().toString();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

}
