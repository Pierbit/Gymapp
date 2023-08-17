package com.example.gymapp2.ui.orari;

import static com.example.gymapp2.MainActivity.db;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gymapp2.R;
import com.example.gymapp2.databinding.FragmentOrariBinding;
import com.example.gymapp2.fasciaoraria.FasciaOraria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;


public class OrariFragment extends Fragment {

    private FragmentOrariBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentOrariBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        GridLayout layout = root.findViewById(R.id.orari_list);
        LayoutInflater vi = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        TextView txt = root.findViewById(R.id.titolo_orari);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1; // Month is 0-based, so add 1
        int year = calendar.get(Calendar.YEAR);

        String dayStr = String.valueOf(day);
        String monthStr = String.valueOf(month);
        String yearStr = String.valueOf(year);

        String temp = "Orari del: " + dayStr + "/" + monthStr + "/" + yearStr;

        txt.setText(temp);

        ArrayList<FasciaOraria> orari = db.getFasceorarie();

        for (FasciaOraria fascia: orari
             ) {

            View v = vi.inflate(R.layout.orari_card, null);

            TextView txt1 = v.findViewById(R.id.text_fascia_oraria);
            txt1.setText(fascia.getFascia_oraria());

            TextView txt2 = v.findViewById(R.id.textConsiglio);

            if(fascia.getPosti() >= 15){
                String temp1 = "Orario consigliato";
                txt2.setText(temp1);
                v.setBackgroundColor(getResources().getColor(R.color.green));
            } else if(fascia.getPosti() < 15 && fascia.getPosti() >= 5 ){
                String temp1 = "Orario sconsigliato";
                txt2.setText(temp1);
                v.setBackgroundColor(getResources().getColor(R.color.yellow));
            } else if(fascia.getPosti() < 5){
                String temp1 = "Orario fortemente sconsigliato";
                txt2.setText(temp1);
                v.setBackgroundColor(getResources().getColor(R.color.red));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(400,300);
            params.setMargins(135,16,16,16);

            layout.addView(v, params);

        }

        return root;
    }

}
