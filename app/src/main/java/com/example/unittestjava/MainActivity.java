package com.example.unittestjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.unittestjava.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        mainViewModel = new MainViewModel(new CuboidModel());
        activityMainBinding.btnSave.setOnClickListener(this);
        activityMainBinding.btnCalculateSurfaceArea.setOnClickListener(this);
        activityMainBinding.btnCalculateCircumference.setOnClickListener(this);
        activityMainBinding.btnCalculateVolume.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String length = activityMainBinding.edtLength.getText().toString().trim();
        String width = activityMainBinding.edtWidth.getText().toString().trim();
        String height = activityMainBinding.edtHeight.getText().toString().trim();
        if (TextUtils.isEmpty(length)) {
            activityMainBinding.edtLength.setError("This field cannot be empty");
        } else if (TextUtils.isEmpty(width)) {
            activityMainBinding.edtWidth.setError("This field cannot be empty");
        } else if (TextUtils.isEmpty(height)) {
            activityMainBinding.edtHeight.setError("This field cannot be empty");
        } else {
            double valueLenght = Double.parseDouble(length);
            double valueWidht = Double.parseDouble(width);
            double valueHeight = Double.parseDouble(height);
            if (view.getId() == R.id.btn_save) {
                mainViewModel.save(valueLenght, valueWidht, valueHeight);
                visible();
            } else if (view.getId() == R.id.btn_calculate_circumference) {
                activityMainBinding.tvResult.setText(String.valueOf(mainViewModel.getCircumference()));
                gone();
            } else if (view.getId() == R.id.btn_calculate_surface_area) {
                activityMainBinding.tvResult.setText(String.valueOf(mainViewModel.getSurfaceArea()));
                gone();
            } else if (view.getId() == R.id.btn_calculate_volume) {
                activityMainBinding.tvResult.setText(String.valueOf(mainViewModel.getVolume()));
                gone();
            }
        }
    }

    private void visible() {
        activityMainBinding.btnCalculateVolume.setVisibility(View.VISIBLE);
        activityMainBinding.btnCalculateCircumference.setVisibility(View.VISIBLE);
        activityMainBinding.btnCalculateSurfaceArea.setVisibility(View.VISIBLE);
        activityMainBinding.btnSave.setVisibility(View.GONE);
    }
    private void gone() {
        activityMainBinding.btnCalculateVolume.setVisibility(View.GONE);
        activityMainBinding.btnCalculateCircumference.setVisibility(View.GONE);
        activityMainBinding.btnCalculateSurfaceArea.setVisibility(View.GONE);
        activityMainBinding.btnSave.setVisibility(View.VISIBLE);
    }
}
