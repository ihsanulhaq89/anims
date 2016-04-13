package com.sample.animations;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private View container1;
    private View container2;
    private View container3;
    private int count = 0;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private FourthFragment fourthFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container1 = findViewById(R.id.container1);
        container2 = findViewById(R.id.container2);
        container3 = findViewById(R.id.container3);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//        fragmentTransaction.setCustomAnimations(R.anim.slide_down,
//                R.anim.slide_up_exit, R.anim.slide_down,
//                R.anim.slide_up_exit);
        fragmentTransaction.add(R.id.container1, firstFragment, "HELLO");
        fragmentTransaction.add(R.id.container2, secondFragment, "HELLO2");
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        count++;
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            if (count == 2) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slide_down,
                        R.anim.slide_up_exit);
                fragmentTransaction.remove(thirdFragment).commit();
            } else if (count == 1) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                thirdFragment = new ThirdFragment();
                fragmentTransaction.setCustomAnimations(R.anim.fade_in,
                        R.anim.slide_down);
                fragmentTransaction.add(R.id.container1, thirdFragment, "HELLO");
                fragmentTransaction.commit();
                return true;
            } else if (count == 3) {

                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_up_enter,
                                R.anim.slide_up_exit, R.anim.slide_up_enter,
                                R.anim.slide_up_enter)
                        .hide(firstFragment)
                        .add(R.id.container3, new FourthFragment())
                        .commit();
            } else {

                Toast.makeText(this, "End of Animations", Toast.LENGTH_SHORT).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
