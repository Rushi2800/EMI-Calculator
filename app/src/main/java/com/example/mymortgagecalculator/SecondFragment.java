package com.example.mymortgagecalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mymortgagecalculator.databinding.FragmentSecondBinding;

import java.text.BreakIterator;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private EditText mortgage_amount;
    private EditText interest_amount;
    private EditText tenure_time;
    private TextView EMI_amount;
    private Button calculate_button;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mortgage_amount = view.findViewById(R.id.mortgage_amount);
        interest_amount = view.findViewById(R.id.interest_amount);
        tenure_time = view.findViewById(R.id.tenure_time);
        EMI_amount = view.findViewById(R.id.EMI_amount);

        calculate_button = view.findViewById(R.id.calculate_button);
        calculate_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //get the mortgage value
               // mortgage_amount = view.findViewById(R.id.mortgage_amount);
                double mortgage_temp = Double.parseDouble(mortgage_amount.getText().toString());

                //get the interest value
                //interest_amount = view.findViewById(R.id.interest_amount);
                double interest_temp = Double.parseDouble(interest_amount.getText().toString());

                //get the tenure value
               // tenure_time = view.findViewById(R.id.tenure_time);
                double tenure_temp = Double.parseDouble(tenure_time.getText().toString());
                //getting the EMI result
                //EMI_amount = view.findViewById(R.id.EMI_amount);
                double EMI_temp = Double.parseDouble(tenure_time.getText().toString());

                double EMI;
                interest_temp=interest_temp/(12*100);



                EMI=((mortgage_temp*interest_temp*Math.pow(1+interest_temp,(tenure_temp*12)))/(Math.pow(1+interest_temp,(tenure_temp*12))-1));


                EMI_amount.setText(String.valueOf(EMI));

            }



        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}