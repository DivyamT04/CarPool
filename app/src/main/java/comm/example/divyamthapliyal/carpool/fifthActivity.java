package comm.example.divyamthapliyal.carpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class fifthActivity extends BaseActivity {
    FirebaseDatabase database ;
    DatabaseReference myRef ;
    ArrayList<String> arrayList;
    ListView list ;
    ArrayAdapter<String> arrayAdapter;
    Users users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        Intent intent2 = getIntent();
        users = new Users( );
        list = (ListView) findViewById(R.id.List);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Users");
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this , R.layout.user_info,R.id.userInfo,arrayList);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    users = ds.getValue(Users.class);
                    arrayList.add("Name:"+users.getName().toString()+"\n"+"From:"+users.getFrom().toString()+"\n"+"To:"+users.getTo().toString()+"\n"+"Time:"+users.getTime().toString()+"\n"+"Seats Available:"+users.getSeatsAvailable().toString()+"\n"+"Contact no. :"+users.getContact().toString());

                }
                list.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
