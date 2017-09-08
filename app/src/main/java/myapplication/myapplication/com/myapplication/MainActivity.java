package myapplication.myapplication.com.myapplication;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    String[] activityNames = {"OrderCoffee","ScoreCard","","","",""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_view,activityNames);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
    }
}
