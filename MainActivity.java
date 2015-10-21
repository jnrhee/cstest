package com.example.jrhee.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private EditText mInText;
    private TextView mOutText;

    private HashSet<Integer> hs = new HashSet<Integer>();
    private HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        boolean ret = hs.add(2);
        Log.v("JOON", "ret = "+ret);
        ret = hs.add(2);
        Log.v("JOON", "ret = "+ret);
        ret = hs.add(3);
        Log.v("JOON", "ret = "+ret);
        ret = hs.add(4);
        Log.v("JOON", "ret = "+ret);

        String outs = "";

        Iterator<Integer> it = hs.iterator();

        while (it.hasNext())
            outs += " "+it.next();

        Log.v("JOON", outs);

        hm.put(1, 11);
        hm.put(2, 11);
        hm.put(3, 12);
        hm.put(4, 13);
        Collection<Integer> co = hm.values();

        outs = "";
        it = co.iterator();
        while (it.hasNext())
            outs += " "+it.next();
        Log.v("JOON", outs);

        Permute pm = new Permute();
        pm.printAllPermute();

        Nodes nlist = new Nodes();
        for (int i=0;i<10;i++) {
            //Node n = new Node((int)(Math.random()*100));
            Node n = new Node(i);
            nlist.insert(n);
            Log.v("JOON", "----------------------");
        }
        nlist.preOrderPrint();
        nlist.inOrderPrint();
        nlist.postOrderPrint();

        mInText = (EditText) findViewById(R.id.textInput);
        mOutText = (TextView) findViewById(R.id.textOutput);

        mInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInText.setText("");
                mOutText.setText("");
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOutText.setText(mInText.getText());
            }
        });

        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
