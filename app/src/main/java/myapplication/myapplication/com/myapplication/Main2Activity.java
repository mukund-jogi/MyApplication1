package myapplication.myapplication.com.myapplication;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private int addQuantity=0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void increment_in_order(View view)
    {
        addQuantity+=1;
        display(addQuantity);
        displayPrice(addQuantity * 10);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void decrement_in_order(View view)
    {
        if(addQuantity>0)
        {
            addQuantity -= 1;
            display(addQuantity);
            displayPrice(addQuantity * 10);
        }
    }

    public void Submit(View view)
    {
       if(addQuantity>0)
       {
           Toast.makeText(getApplicationContext(),"Your order is placed for :"+addQuantity+" coffee",Toast.LENGTH_LONG).show();
       }
       else
       {
           Toast.makeText(getApplicationContext(),"Atleast,order 1 coffee!",Toast.LENGTH_LONG).show();
       }
    }

    /**Method to add orders */
    private void display(int i)
    {
        TextView quantity = (TextView) findViewById(R.id.textView2);
        quantity.setText(""+i);
    }

    /**Method to display price as per orders**/
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void displayPrice(int i)
    {
        TextView price = (TextView) findViewById(R.id.textView4);
        price.setText("$"+price);
//        price.setText(NumberFormat.getCurrencyInstance().format(i));
    }

}
