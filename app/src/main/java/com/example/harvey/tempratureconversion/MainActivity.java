package com.example.harvey.tempratureconversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher,RadioGroup.OnCheckedChangeListener {

    RadioGroup unit;
    EditText value;
    int len;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unit = (RadioGroup) findViewById(R.id.unit);
        unit.setOnCheckedChangeListener(this);

        value = (EditText) findViewById(R.id.editText);
        value.addTextChangedListener(this);
      //  len=value.getText().toString().trim().length();
      //  Toast.makeText(this,String.valueOf(len),3);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {


    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {


    }

    @Override
    public void afterTextChanged(Editable s) {

            calc();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId){

            calc();
    }

    protected void calc(){

        TextView degF=(TextView) findViewById(R.id.radioButton3);
        TextView degC=(TextView) findViewById(R.id.radioButton4);

        double f,c;
        c=0;
        f=0;
        len=value.getText().toString().trim().length();
      //  Toast.makeText(this,String.valueOf(len),1).show();
        if (unit.getCheckedRadioButtonId()==R.id.radioButton2){

          //  degF.setText("华氏");
          //  degC.setText("0");

            
            if (len!=0){
                f=Double.parseDouble(value.getText().toString());
                c=(f-32)*5/9;
            }


        }else if (unit.getCheckedRadioButtonId()==R.id.radioButton){
         //   degC.setText("摄氏");
         //   degF.setText("0");
            if (len!=0){
                c=Double.parseDouble(value.getText().toString());
                f=c*9/5+32;
            }

        }
       // degC.setText(c+"11");
      //  degF.setText(f+"11");
       degC.setText(String.format("%.1f",c)+getResources().getString((R.string.charC)));
         degF.setText(String.format("%.1f",f)+getResources().getString(R.string.charF));


      //  degC.setText(String.valueOf(unit.getCheckedRadioButtonId()));
      //  degF.setText(String.valueOf(R.id.radioButton2));
    }
}
