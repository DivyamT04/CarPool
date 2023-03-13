package comm.example.divyamthapliyal.carpool;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
 Button getStarted;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerlayout = (DrawerLayout)findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout,R.string.open,R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.aboutus){
                    Toast.makeText(MainActivity.this , "About Us", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(getApplicationContext(), seventhActivity.class);
                    startActivity(intent2);

                }
                else if(id == R.id.contactus){
                    Toast.makeText(MainActivity.this , "Contact Us", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(getApplicationContext(), eightActivity.class);
                    startActivity(intent3);
                }
                else if(id == R.id.queries){
                    Toast.makeText(MainActivity.this , "Queries", Toast.LENGTH_SHORT).show();
                    Intent intent4 = new Intent(getApplicationContext(), nineActivity.class);
                    startActivity(intent4);
                }
                return true;

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getStarted=(Button)findViewById(R.id.button);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), secondActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }


}
