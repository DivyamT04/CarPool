package comm.example.divyamthapliyal.carpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class eightActivity extends AppCompatActivity {
    EditText editTextto,editTextsubject,editTextmessage;
    Button button;
    String to , subject,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);
        final Intent intent=getIntent();
        editTextto=(EditText)findViewById(R.id.editTo);
        editTextsubject=(EditText)findViewById(R.id.editsubject);
        editTextmessage=(EditText)findViewById(R.id.editmessage);
        button  = (Button)findViewById(R.id.btnsend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String(to));
                intent.putExtra(Intent.EXTRA_SUBJECT , subject);
                intent.putExtra(Intent.EXTRA_TEXT , message);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"select email sending apps"));

            }


        });


    }
    private void GetData() {
        to = editTextto.getText().toString();
        message= editTextmessage.getText().toString();
        subject = editTextsubject.getText().toString();
    }
}
