package com.example.dilip.fuelefficiency;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MyActivity extends Activity {

    EditText txtOdo, txtPPGa, txtTotGa;
    TextView lblTotPrice, lblDate;
    Button btnSave;
    TabHost tabHost;

    List<Fuel> FuelEntries = new ArrayList<Fuel>();
    ListView fuelListView;

    DecimalFormat dfTotAmount = new DecimalFormat("$#0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        txtOdo = (EditText) findViewById(R.id.txtOdo);
        txtPPGa = (EditText) findViewById(R.id.txtPrice);
        txtTotGa = (EditText) findViewById(R.id.txtTotGallons);
        btnSave = (Button) findViewById(R.id.btnSave);
        lblTotPrice = (TextView) findViewById(R.id.lblTotAmount);
        lblDate=(TextView) findViewById(R.id.lblDate);
        fuelListView = (ListView) findViewById(R.id.listView);
        lblTotPrice.setText("Total Amount: 0.00");
        setDate();

        tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("entry");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("ENTRY");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("values");
        tabSpec.setContent(R.id.tab2);
        tabSpec.setIndicator("VALUES");
        tabHost.addTab(tabSpec);

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                if(s.equals("entry"))
                    setDate();
            }
        });

        txtOdo.addTextChangedListener( new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                btnSave.setEnabled(!txtOdo.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtPPGa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                lblTotPrice.setText(getTot());
            }
        });

        txtTotGa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                lblTotPrice.setText(getTot());
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFuelEntry(lblDate.getText().toString(), txtOdo.getText().toString(), txtPPGa.getText().toString(), txtTotGa.getText().toString());
                populateList();
                Toast.makeText(getApplicationContext(), "Successfully added!", Toast.LENGTH_SHORT).show();
                txtTotGa.setText("");
                txtPPGa.setText("");
                txtOdo.setText("");
                setDate();
                txtOdo.requestFocus();
            }
        });

    }

    private void populateList() {
        ArrayAdapter<Fuel> adapter = new FuelListAdapter();
        fuelListView.setAdapter(adapter);

    }
    private void addFuelEntry(String dtFuelledDate, String sOdoReading, String sPricePerGa, String sTotalFuel) {
            FuelEntries.add(new Fuel(dtFuelledDate, sOdoReading, sPricePerGa, sTotalFuel));
    }

    private class FuelListAdapter extends ArrayAdapter<Fuel> {
        public FuelListAdapter() {
            super (MyActivity.this, R.layout.listview_item, FuelEntries);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if(view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);

            Fuel currentFuel = FuelEntries.get(position);

            TextView date = (TextView) view.findViewById(R.id.txtListDate);
            date.setText(currentFuel.get_dtFuelledDate());

            DecimalFormat df = new DecimalFormat("##,##,###");
            TextView odoReading = (TextView) view.findViewById(R.id.txtListOdoReading);
            odoReading.setText(df.format(Double.parseDouble(currentFuel.get_sOdoReading())));

            df = new DecimalFormat("$##0.0#");
            TextView pricePerGa = (TextView) view.findViewById(R.id.txtListPPGa);
            pricePerGa.setText(df.format(Double.parseDouble(currentFuel.get_sPricePerGa())));

            df = new DecimalFormat("##0.00");
            TextView totFuel = (TextView) view.findViewById(R.id.txtListTotalGallons);
            totFuel.setText(df.format(Double.parseDouble(currentFuel.get_sTotalFuel())));
            df = null;

            TextView totalAmount = (TextView) view.findViewById(R.id.txtListTotalAmount);
            Double totAmt = Double.parseDouble(currentFuel.get_sPricePerGa()) * Double.parseDouble(currentFuel.get_sTotalFuel());
            totalAmount.setText(dfTotAmount.format(totAmt));
            return view;
        }
    }

    private void setDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dt = new Date();
        lblDate.setText(dateFormat.format(dt));
    }
    private String getTot()
    {
        String s1 = txtPPGa.getText().toString().trim();
        String s2 = txtTotGa.getText().toString().trim();
        Double d1 = Double.parseDouble(s1.isEmpty() ? "1" : s1);
        Double d2 = Double.parseDouble(s2.isEmpty() ? "1" : s2);
        return "Total Amount: "+ ((s1.isEmpty() && s2.isEmpty()) ? "0.00" : dfTotAmount.format(d1 * d2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
