package com.mantra.checkin.SignUp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.mantra.checkin.R;

import java.util.Locale;
import java.util.Set;

public class PhoneNumberActivity extends AppCompatActivity {

    private final String TAG = "PhoneNumberActivity";

    Spinner countrySelectorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        countrySelectorSpinner = (Spinner) findViewById(R.id.spinnerCountryCode);
        ArrayAdapter<String> countryCodesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, LoadAllCountryCodes());
        countrySelectorSpinner.setAdapter(countryCodesAdapter);
    }

    private String[] LoadAllCountryCodes(){
        Set<String> set = PhoneNumberUtil.getInstance().getSupportedRegions();

        String[] arr = set.toArray(new String[set.size()]);

        for (int i = 0; i < set.size(); i++) {
            Locale locale = new Locale("en", arr[i]);
        }

        return arr;
    }
}
