package comm.example.divyamthapliyal.carpool;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class fourthActivity extends BaseActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    DatabaseReference userRef = myRef.child("Users");
    EditText name,age,from,to,date,time,seat,contact;
    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);


        Intent intent2=getIntent();
        name = (EditText)findViewById(R.id.name);
        age = (EditText)findViewById(R.id.age);
        from = (EditText)findViewById(R.id.from);
        to = (EditText)findViewById(R.id.to);
        date = (EditText)findViewById(R.id.date);
        time = (EditText)findViewById(R.id.time);
        seat = (EditText)findViewById(R.id.seat);
        contact = (EditText)findViewById(R.id.contact);
        button=(Button)findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myname = name.getText().toString().trim();
                String myage = age.getText().toString().trim();
                String myfrom = from.getText().toString().trim();
                String myto = to.getText().toString().trim();
                String mydate = date.getText().toString().trim();
                String mytime = time.getText().toString().trim();
                String myseat = seat.getText().toString().trim();
                String mycontact = contact.getText().toString().trim();
                if(myname.isEmpty()||myage.isEmpty()||myfrom.isEmpty()||myto.isEmpty()||mydate.isEmpty()||mytime.isEmpty()||myseat.isEmpty()||mycontact.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please enter the required field",Toast.LENGTH_LONG).show();
                }
                else
                {
                    HashMap<String , String> userMap = new HashMap<String, String>();
                    userMap.put("Name" , myname);
                    userMap.put("Age" , myage);
                    userMap.put("From" , myfrom);
                    userMap.put("To" , myto);
                    userMap.put("Date" , mydate);
                    userMap.put("Time" , mytime);
                    userMap.put("SeatsAvailable" , myseat);
                    userMap.put("Contact" , mycontact);

                    Task <Void> success = userRef.push().setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Log.i("TAG","completed");
                                Intent intent4 = new Intent(getApplicationContext(), sixthActivity.class);
                                startActivity(intent4);
                            }

                        }
                    });
                }

            }
        });
    }
}
