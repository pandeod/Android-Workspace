package com.lightning.exp1_098;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;
import java.util.zip.Inflater;

public class Chat extends AppCompatActivity {

    private static  final int REQUEST_ENABLE_BT=1;
    private static  final int REQUEST_DISCOVERABLE_BT=2;
    private static  final int REQUEST_FORCE_ENABLE_BT=3;
    BluetoothAdapter mBluetoothAdapter;
    Switch mSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        final LinearLayout itm=findViewById(R.id.item);
        final LinearLayout avl=findViewById(R.id.avail);

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            // Device doesn't support Bluetooth
           showMessage("Alert","Bluetooth not available !");
        }

        mSwitch=findViewById(R.id.bluetooth_switch);

        if(mBluetoothAdapter.isEnabled()) {
           mSwitch.setChecked(true);
            Toast.makeText(this, "Bluetooth is already ON!", Toast.LENGTH_SHORT).show();
            getPaired();
            itm.setVisibility(View.VISIBLE);
            avl.setVisibility(View.VISIBLE);
        }
        else
        {
            Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(i, REQUEST_FORCE_ENABLE_BT);
            itm.setVisibility(View.VISIBLE);
            avl.setVisibility(View.VISIBLE);
        }

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b)
                {
                    if(!mBluetoothAdapter.isEnabled()) {
                        Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(i, REQUEST_ENABLE_BT);
                        itm.setVisibility(View.VISIBLE);
                        avl.setVisibility(View.VISIBLE);
                    }
                }
                else
                {
                    if(mBluetoothAdapter.isEnabled()) {
                        mBluetoothAdapter.disable();
                        showMessage("Alert","Bluetooth is OFF !");
                        itm.setVisibility(View.GONE);
                        avl.setVisibility(View.GONE);
                    }
                }
            }
        });

        Button discover=findViewById(R.id.discover);
        discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mBluetoothAdapter.isDiscovering())
                {
                    if(mBluetoothAdapter.isEnabled())
                    {
                        Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                        startActivityForResult(i,REQUEST_DISCOVERABLE_BT);
                    }
                    else
                    {
                        showMessage("Alert","Turn ON your Bluetooth !");
                    }
                }
            }
        });
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_DISCOVERABLE_BT)
        {
            showMessage("Alert","Now your Bluetooth is discoverable");
        }
        if(requestCode==REQUEST_ENABLE_BT)
        {
            showMessage("Alert","Bluetooth is ON !");
        }
        if(requestCode==REQUEST_FORCE_ENABLE_BT)
        {
            showMessage("Alert","Bluetooth is Turned ON !");
            mSwitch.setChecked(true);
            getPaired();
        }
    }

    public void getPaired()
    {
        Set<BluetoothDevice> devices=mBluetoothAdapter.getBondedDevices();
        for(BluetoothDevice device:devices)
        {
            final String x="Device Name: "+device.getName()+"\nBluetooth Class: "+device.getBluetoothClass()+"\nBond State: "+device.getBondState()+"\nDevice Addr: "+device.getAddress()+"\nDevice UUID: "+device.getUuids();
            final String y=device.getName()+"\n"+device.getBluetoothClass();
            LinearLayout item = findViewById(R.id.item);
            View child = getLayoutInflater().inflate(R.layout.bluetooth_device, null);
            TextView tx=child.findViewById(R.id.device_name);
            tx.setText(y);
            item.addView(child);
            tx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showMessage("Selected Device",x);
                }
            });
        }
    }
}
