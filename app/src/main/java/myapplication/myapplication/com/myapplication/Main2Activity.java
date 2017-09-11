package myapplication.myapplication.com.myapplication;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.onClick;
import static junit.runner.Version.id;

public class Main2Activity extends AppCompatActivity {

    private int addQuantity, espressoQuantity, cappuccinoQuantity, latteQuantity, espressoPrice, cappuccinoPrice, lattePrice, normalPrice , totalQuantity= 0;
    TextView price,eachQuantity;
    String espressoText = "", cappuccinoText = "", latteText = "", normalText = "";

    CheckBox checkboxEspresso,checkboxCappuccino,checkboxLatte;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        checkboxEspresso = (CheckBox) findViewById(R.id.checkBox1);
        checkboxCappuccino = (CheckBox) findViewById(R.id.checkBox2);
        checkboxLatte = (CheckBox) findViewById(R.id.checkBox3);
        eachQuantity = (TextView) findViewById(R.id.textView5);
        eachQuantity.setText("");
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void increment_in_order(View view)
    {
        if(checkboxEspresso.isChecked()) {
            espressoQuantity += 1;
            espressoPrice = 50;
            espressoPrice = espressoQuantity*espressoPrice;
            if(espressoQuantity>0)
                espressoText = "Espresso: "+espressoQuantity +"\n";
            else
                espressoText = "";
            display(espressoQuantity);
        }

        else if(checkboxCappuccino.isChecked()) {
            cappuccinoQuantity += 1;
            cappuccinoPrice = 70;
            cappuccinoPrice = cappuccinoPrice*cappuccinoQuantity;
            if(cappuccinoQuantity>0)
               cappuccinoText = "Cappuccino: "+cappuccinoQuantity +"\n";
            else
                cappuccinoText = "";
            display(cappuccinoQuantity);
        }

        else if(checkboxLatte.isChecked()) {
            latteQuantity += 1;
            lattePrice = 90;
            lattePrice = lattePrice*latteQuantity;
            if(latteQuantity>0)
                latteText = "CaféLatte: "+latteQuantity + "\n";
            else
                latteText = "";
            display(latteQuantity);
        }

        else
        {
            addQuantity += 1;
            normalPrice = 20;
            normalPrice = normalPrice*addQuantity;
            if(addQuantity>0)
                normalText = "Regular Coffee: " + addQuantity;
            else
                normalText = "";
            display(addQuantity);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void decrement_in_order(View view)
    {

            if(checkboxEspresso.isChecked() && espressoQuantity>0)
            {
                espressoQuantity -= 1;
                espressoPrice = 50;
                espressoPrice = espressoQuantity*espressoPrice;
                espressoText = "Espresso: "+espressoQuantity +"\n";
                display(espressoQuantity);
            }

            else if(checkboxCappuccino.isChecked() && cappuccinoQuantity>0)
            {
                cappuccinoQuantity -= 1;
                cappuccinoPrice = 70;
                cappuccinoPrice = cappuccinoPrice*cappuccinoQuantity;
                cappuccinoText = "Cappuccino: "+cappuccinoQuantity +"\n";
                display(cappuccinoQuantity);
            }

            else if(checkboxLatte.isChecked() && latteQuantity>0)
            {
                latteQuantity -= 1;
                lattePrice = 90;
                lattePrice = lattePrice*latteQuantity;
                latteText = "CaféLatte: "+latteQuantity + "\n";
                display(latteQuantity);
            }
            else
            {
                if(addQuantity>0) {
                    addQuantity -= 1;
                    normalPrice = 20;
                    normalPrice = normalPrice * addQuantity;
                    normalText = "Regular Coffee: " + addQuantity;
                    display(addQuantity);
                }
            }

    }

    public void Submit(View view)
    {
       if(totalQuantity>0)
       {
           price.clearComposingText();
           price.setText("Name: Peter\nQuantity: "+totalQuantity+"\nTotalPrice: "+price.getText()+"\nThanks! ");

           Intent intent1 = new Intent(Intent.ACTION_VIEW);
           intent1.setData(Uri.parse("geo:47.6,122"));

           if (intent1.resolveActivity(getPackageManager())!= null)
           {startActivity(intent1);}
       }
       else
       {
           Toast.makeText(getApplicationContext(),"Atleast,order 1 coffee!",Toast.LENGTH_LONG).show();
       }
    }



    /**Method to add orders */
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void display(int i)
    {
        TextView quantity = (TextView) findViewById(R.id.textView2);
        i = espressoQuantity + cappuccinoQuantity + latteQuantity + addQuantity;
        totalQuantity = i;
        quantity.setText(""+i);
        eachQuantity.setText(espressoText+cappuccinoText+latteText+normalText);
        displayPrice(i);
    }

    /**Method to display price as per orders**/
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void displayPrice(int i)
    {
        i = espressoPrice+cappuccinoPrice+lattePrice+normalPrice;
        price = (TextView) findViewById(R.id.textView4);
        price.setText("$"+i);
//        price.setText(NumberFormat.getCurrencyInstance().format(i));
    }


    public void onClickChanges(View view) {
        int a = 0;
        if(a>0)
        {}
        else if(checkboxEspresso.isChecked()) {
            checkboxCappuccino.setChecked(false);
            checkboxLatte.setChecked(false);
        }

        else if(checkboxCappuccino.isChecked()) {
            checkboxEspresso.setChecked(false);
            checkboxLatte.setChecked(false);
        }

        else if(checkboxLatte.isChecked()) {
            checkboxEspresso.setChecked(false);
            checkboxCappuccino.setChecked(false);
        }
    }
}
