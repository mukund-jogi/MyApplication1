package myapplication.myapplication.com.myapplication;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

import static android.R.attr.start;

public class MainActivity extends AppCompatActivity {

    String[] activityNames = {"OrderCoffee","ScoreCard"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_view,activityNames);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position==0)
                    startActivity(new Intent(MainActivity.this,Main2Activity.class));
                else
                    startActivity(new Intent(MainActivity.this,Main3Activity.class));
            }
        });
    }
}
