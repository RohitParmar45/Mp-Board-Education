package com.rohitparmar.mpboardeducation.scienceClass.scienceui.previous;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.scienceClass.Biology.BioPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.Chemistry.ChemPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.EnglishGen.EngGenAPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.EnglishSpec.EngSpecPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.Maths.MathsPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.Physics.PhyPrevious;


public class PreviousFragment extends Fragment implements View.OnClickListener {

    private MaterialCardView physics, chemistry, maths, bio, englishspecial, englishgeneral;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_previous, container, false);

        physics = view.findViewById(R.id.twenty);
        chemistry = view.findViewById(R.id.nineteen);
        maths = view.findViewById(R.id.eighteen);
        bio = view.findViewById(R.id.seventeen);
        englishspecial = view.findViewById(R.id.sixteen);
        englishgeneral = view.findViewById(R.id.fifteen);

        physics.setOnClickListener(this);
        chemistry.setOnClickListener(this);
        maths.setOnClickListener(this);
        bio.setOnClickListener(this);
        englishspecial.setOnClickListener(this);
        englishgeneral.setOnClickListener(this);

        return  view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.twenty:
                Intent intent = new Intent(getContext(), PhyPrevious.class);
                startActivity(intent);

                break;
            case R.id.nineteen:
                Intent intent1 = new Intent(getContext(), ChemPrevious.class);
                startActivity(intent1);
                break;
            case R.id.eighteen:
                Intent intent2 = new Intent(getContext(), MathsPrevious.class);
                startActivity(intent2);
                break;
            case R.id.seventeen:
                Intent intent3 = new Intent(getContext(), BioPrevious.class);
                startActivity(intent3);
                break;
            case R.id.sixteen:
                Intent intent4 = new Intent(getContext(), EngSpecPrevious.class);
                startActivity(intent4);
                break;
                case R.id.fifteen:
                    Intent intent5 = new Intent(getContext(), EngGenAPrevious.class);
                    startActivity(intent5);
                break;

        }

    }
}