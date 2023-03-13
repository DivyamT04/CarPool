package comm.example.divyamthapliyal.carpool;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class nineActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandablesetAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);
        Intent intent = getIntent();

        listView = (ExpandableListView) findViewById(R.id.ivexp);
        initData();
        listAdapter = new ExpandablesetAdapter(this,listDataHeader, listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("What is Car Pool ?");
        listDataHeader.add("How does Car Pool work ?");
        listDataHeader.add("When and where is Car Pool available ?");
        listDataHeader.add("How to contact a driver ?");
        listDataHeader.add("How can i contact the Car Pool app ?");

        List<String> car = new ArrayList<>();
        car.add("Car pool gives you the opportunity to share your ride with friends, colleagues and environmentally conscious people around you.");

        List<String> car1 = new ArrayList<>();
        car1.add("As a driver, you can share your car with people who are travelling in the same route as you.In this way you can split the travelling cost just by sharing your empty seats. As a passenger, you will enjoy a comfortable and safe trip while avoiding crowded public transport, switching between many options and standing in never-ending lines.");

        List<String> car2 = new ArrayList<>();
        car2.add("Car Pool is available in New Delhi in selected areas ,24 hours.You have to simply check the app to see the drivers available in your area");

        List<String> car3 = new ArrayList<>();
        car3.add("You can call the driver. Driver's complete information is provided already");

        List<String> car4 = new ArrayList<>();
        car4.add("You can mail us at: tdivyam@yahoo.co.in by clicking on contact us link in naivigation menu");

        listHash.put(listDataHeader.get(0), car);
        listHash.put(listDataHeader.get(1), car1);
        listHash.put(listDataHeader.get(2), car2);
        listHash.put(listDataHeader.get(3), car3);
        listHash.put(listDataHeader.get(4), car4);
    }


    }
