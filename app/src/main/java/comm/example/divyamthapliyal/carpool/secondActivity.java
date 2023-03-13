package comm.example.divyamthapliyal.carpool;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class secondActivity extends AppCompatActivity {
    Button submit;
    EditText email;
    EditText pass;
    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this, "Already in", Toast.LENGTH_SHORT).show();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();


        email=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        mAuth = FirebaseAuth.getInstance();


        submit=(Button)findViewById(R.id.button2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), thirdActivity.class);
                startActivity(intent);
            }
        });

    }
    public void onRegister(View view){
        final String myemail=email.getText().toString();
        final String mypass=pass.getText().toString();
        mAuth.createUserWithEmailAndPassword(myemail, mypass)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.i("TAG", "createUserWithEmail:success");
                            Toast.makeText(secondActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            submit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(getApplicationContext(), thirdActivity.class);
                                    startActivity(intent);
                                }
                            });

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(secondActivity.this, "Failure", Toast.LENGTH_SHORT).show();


                        }

                        // ...
                    }
                });
    }
}
