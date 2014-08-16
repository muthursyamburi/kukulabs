package com.kukulabs.dilip.areacalc;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MyActivity extends ActionBarActivity {

    Button btnAddIt, btnRestart;
    EditText txtA, txtB, txtC;
    TextView lblTotal, lblArea;
    Double a, b, c, totalArea, area;
    Integer clickedArea, clickedTotal;
    DecimalFormat df3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        btnAddIt = (Button) findViewById(R.id.btnAddIt);
        btnRestart = (Button) findViewById(R.id.btnRestart);
        lblArea = (TextView) findViewById(R.id.lblArea);
        lblTotal = (TextView) findViewById(R.id.lblTotal);
        txtA = (EditText) findViewById(R.id.txtA);
        txtB = (EditText) findViewById(R.id.txtB);
        txtC = (EditText) findViewById(R.id.txtC);
        df3 = new DecimalFormat("#0.000");

        clickedArea=clickedTotal=0;
        a = b = c = totalArea = area = 0.0;
        formatContent(lblArea, clickedArea, "Area=", area);
        formatContent(lblTotal, clickedTotal, "Total=", totalArea);

        txtA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                txtA.setBackgroundColor(getResources().getColor(android.R.color.white));
                txtB.setBackgroundColor(getResources().getColor(android.R.color.white));
                txtC.setBackgroundColor(getResources().getColor(android.R.color.white));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int ret = isValid();
                if(ret==0) {
                    area=0.0;
                    formatContent(lblArea, clickedArea, "Area=", area);
                    return;
                }
                else if(ret>0)
                {
                    calcArea();
                }
                else
                {
                    txtA.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    area=0.0;
                    lblArea.setText("Wrong Value!");
                }

            }
        });

        txtB.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                txtA.setBackgroundColor(getResources().getColor(android.R.color.white));
                txtB.setBackgroundColor(getResources().getColor(android.R.color.white));
                txtC.setBackgroundColor(getResources().getColor(android.R.color.white));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int ret = isValid();
                if(ret==0) {
                    area=0.0;
                    formatContent(lblArea, clickedArea, "Area=", area);
                    return;
                }
                else if(ret>0)
                {
                    calcArea();
                }
                else
                {
                    txtB.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    area=0.0;
                    lblArea.setText("Wrong Value!");
                }
            }
        });

        txtC.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                txtA.setBackgroundColor(getResources().getColor(android.R.color.white));
                txtB.setBackgroundColor(getResources().getColor(android.R.color.white));
                txtC.setBackgroundColor(getResources().getColor(android.R.color.white));
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int ret = isValid();
                if(ret==0) {
                    area=0.0;
                    formatContent(lblArea, clickedArea, "Area=", area);
                    return;
                }
                else if(ret>0)
                {
                    calcArea();
                }
                else
                {
                    txtC.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    area=0.0;
                    lblArea.setText("Wrong Value!");
                }

            }
        });

        lblArea.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!lblArea.getText().toString().equals("Wrong Value!")) {
                    clickedArea = (clickedArea == 1) ? 0 : 1;
                    formatContent(lblArea, clickedArea, "Area=", area);
                }
            }
        });

        lblTotal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedTotal = (clickedTotal == 1) ? 0 : 1;
                formatContent(lblTotal, clickedTotal, "Total=", totalArea);
            }
        });

        btnAddIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalArea += area;
                formatContent(lblTotal, clickedTotal, "Total=", totalArea);
                txtA.requestFocus();
                txtA.setText("");
                txtB.setText("");
                txtC.setText("");
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new KL_DialogYesNo().Confirm(MyActivity.this, "Confirmation", "Sure to clear the Total value also?", "Yes", "No", yesProc(), noProc());
            }
        });
    }

    public Runnable yesProc() {
        return new Runnable() {
            public void run() {
                a = b = c = totalArea = area = 0.0;
                formatContent(lblArea, clickedArea, "Area=", area);
                formatContent(lblTotal, clickedTotal, "Total=", totalArea);
                txtA.setText("");
                txtB.setText("");
                txtC.setText("");
                txtA.requestFocus();
            }
        };

    }

    public Runnable noProc()  {
        return new Runnable() {
          public void run() {
              // Nothing to do here :)
          }
        };
    }
    private void formatContent(TextView lbl, Integer cnt, String cap, Double val)
    {
        if(cnt == 1)
            lbl.setText(cap+df3.format(val));
        else
            lbl.setText(cap+val.toString());
    }

    private int isValid()
    {
        if(txtA.getText().toString().isEmpty() || txtB.getText().toString().isEmpty() || txtC.getText().toString().isEmpty())
            return 0;
        a = Double.parseDouble(txtA.getText().toString());
        b = Double.parseDouble(txtB.getText().toString());
        c= Double.parseDouble(txtC.getText().toString());
        if( a > b && a > c)
            return (((b+c) > a) ? 1 : -1);
        else if(b > c && b > a)
            return (((a+c) > b) ? 1 : -1);
        else
            return (((a+b) > c) ? 1 : -1);
    }

    private void calcArea()
    {
        Double s;
        s = (a+b+c)/2;
        area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        formatContent(lblArea, clickedArea, "Area=", area);
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
