package comm.example.divyamthapliyal.carpool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thirdActivity extends BaseActivity {
Button driver;
Button passenger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Intent intent=getIntent();
        driver=(Button)findViewById(R.id.button3);
        passenger=(Button)findViewById(R.id.button4);
        passenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), fifthActivity.class);
                startActivity(intent2);
            }
        });

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), fourthActivity.class);
                startActivity(intent2);
            }
        });


    }
}
