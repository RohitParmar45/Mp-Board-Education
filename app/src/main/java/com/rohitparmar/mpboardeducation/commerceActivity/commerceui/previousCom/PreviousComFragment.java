package com.rohitparmar.mpboardeducation.commerceActivity.commerceui.previousCom;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.commerceActivity.commerceui.Accountancy.AccPrevious;
import com.rohitparmar.mpboardeducation.commerceActivity.commerceui.BusinessStudy.BussPrevious;
import com.rohitparmar.mpboardeducation.commerceActivity.commerceui.Economics.EcoPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.EnglishGen.EngGenAPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.EnglishSpec.EngSpecPrevious;


public class PreviousComFragment extends Fragment implements View.OnClickListener {

    private TextView businessstudy, economics, accountancy, englishspeciala, englishgenerala;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View view =  inflater.inflate(R.layout.fragment_previous_com, container, false);


        businessstudy = view.findViewById(R.id.twentya);
        economics = view.findViewById(R.id.nineteena);
        accountancy = view.findViewById(R.id.eighteena);
        englishspeciala = view.findViewById(R.id.sixteena);
        englishgenerala = view.findViewById(R.id.fifteena);

        businessstudy.setOnClickListener(this);
        economics.setOnClickListener(this);
        accountancy.setOnClickListener(this);
        englishspeciala.setOnClickListener(this);
        englishgenerala.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.twentya:
                Intent intent = new Intent(getContext(), BussPrevious.class);
                startActivity(intent);

                break;
            case R.id.nineteena:
                Intent intent1 = new Intent(getContext(), EcoPrevious.class);
                startActivity(intent1);
                break;
            case R.id.eighteena:
                Intent intent2 = new Intent(getContext(), AccPrevious.class);
                startActivity(intent2);
                break;

            case R.id.sixteena:
                Intent intent4 = new Intent(getContext(), EngSpecPrevious.class);
                startActivity(intent4);
                break;
            case R.id.fifteena:
                Intent intent5 = new Intent(getContext(), EngGenAPrevious.class);
                startActivity(intent5);
                break;

        }
    }
}