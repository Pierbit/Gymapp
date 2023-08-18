package com.example.gymapp2.ui.dashboard;

import static com.example.gymapp2.MainActivity.db;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gymapp2.R;
import com.example.gymapp2.databinding.FragmentDashboardBinding;
import com.example.gymapp2.fasciaoraria.FasciaOraria;

import org.w3c.dom.Text;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout layout = root.findViewById(R.id.orari_dashboard);
        LayoutInflater vi = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Integer count = db.getFasceorarie().size();
        for(int i = 0; i < count; i++){

            View v = vi.inflate(R.layout.dashboard_card, null);

            FasciaOraria fascia = db.getFasceorarie().get(i);

            TextView txt = v.findViewById(R.id.fascia_oraria);
            txt.setText(fascia.getFascia_oraria());

            TextView txt1 = v.findViewById(R.id.posti_rimasti);
            String temp = fascia.getPosti().toString() + " Posti rimasti";
            txt1.setText(temp);

            Button btn = v.findViewById(R.id.button_prenota_fascia);
            btn.setBackgroundColor(getResources().getColor(R.color.green));
            if(fascia.getPosti() <= 15){
                btn.setBackgroundColor(getResources().getColor(R.color.yellow));
            }
            if(fascia.getPosti() <= 5){
                btn.setBackgroundColor(getResources().getColor(R.color.red));
            }

            btn.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {

                    if(fascia.getPosti() == 0){
                        Toast.makeText(getActivity().getApplicationContext(),"Prenotazione non disponibile",Toast.LENGTH_SHORT).show();
                        return;
                    }

                    fascia.setPosti(fascia.getPosti()-1);
                    String temp = fascia.getPosti().toString() + " Posti rimasti";
                    txt1.setText(temp);

                    if(fascia.getPosti() <= 15){
                        btn.setBackgroundColor(getResources().getColor(R.color.yellow));
                    }
                    if(fascia.getPosti() <= 5){
                        btn.setBackgroundColor(getResources().getColor(R.color.red));
                    }

                    btn.setTextAppearance(R.style.italicText);
                    btn.setTextSize(TypedValue.COMPLEX_UNIT_SP,10);
                    btn.setText("Prenotazione effettuata");
                    btn.setTextColor(getResources().getColor(R.color.darkgrey));
                    v.setEnabled(false);
                    Toast.makeText(getActivity().getApplicationContext(),"Prenotazione effettuata con successo",Toast.LENGTH_SHORT).show();

                }
            });

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(1000,300);
            params.setMargins(0,8,0,8);

            layout.addView(v,params);
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}