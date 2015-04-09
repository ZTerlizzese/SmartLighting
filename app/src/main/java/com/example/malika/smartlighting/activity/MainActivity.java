package com.example.malika.smartlighting.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.malika.smartlighting.R;

public class MainActivity extends ActionBarActivity implements ConnectFragment.ConnectInterface, Dashboard.DashboardInterface {

    /////////////
    //Variables//
    /////////////

    //Fragments
    FragmentManager manager;
    ConnectFragment connect;
    Dashboard dashboard;

    //Objects
    SmartClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        manager = getFragmentManager();
        client = null;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {

            if(connect == null)
                connect = new ConnectFragment();

            //this is what adds fragments to this activity's layout
            //can be used to add multiple fragments, just make sure there a container for each of them
            FragmentTransaction trans = manager.beginTransaction();

            //container for fragment, new fragment
            trans.add(R.id.frame1, connect);
            trans.commit();

        }
    }

    public void connected(SmartClient client)
    {
        //Save client
        this.client = client;

        //Create Dashboard fragment
        dashboard = new Dashboard();
        dashboard.client = client;

        //switch
        FragmentTransaction trans = manager.beginTransaction();
        //container for fragment, new fragment
        trans.replace(R.id.frame1, dashboard);
        trans.commit();
    }

    public void schedule()
    {

    }


}
