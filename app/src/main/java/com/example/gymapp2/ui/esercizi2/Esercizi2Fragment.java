package com.example.gymapp2.ui.esercizi2;

import static com.example.gymapp2.MainActivity.db;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.gymapp2.R;
import com.example.gymapp2.databinding.FragmentEsercizi2Binding;
import com.example.gymapp2.esercizio.Esercizio;
import com.example.gymapp2.scheda.Scheda;

import java.util.ArrayList;

public class Esercizi2Fragment extends Fragment {

    private FragmentEsercizi2Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentEsercizi2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView txt = root.findViewById(R.id.titolo_esercizi2);
        String nome_scheda = db.getScheda_selezionata();
        txt.setText(nome_scheda);

        ArrayList<Scheda> schede = new ArrayList<>();
        LayoutInflater vi = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        schede = db.getSchede();

        LinearLayout layout = root.findViewById(R.id.esercizi2_list);

        for (Scheda s: schede
             ) {

            if(nome_scheda.equals(s.getNome())){

                ArrayList<Esercizio> esercizi = new ArrayList<Esercizio>();
                esercizi = s.getEsercizi();

                for (Esercizio e: esercizi
                     ) {

                    View v = vi.inflate(R.layout.esercizi2_card, null);

                    TextView nome_esercizio = v.findViewById(R.id.nome_esercizio);
                    nome_esercizio.setText(e.getNome());

                    TextView sets = v.findViewById(R.id.textSets);
                    Integer temp = e.getSet();
                    String temp1 = temp.toString() + " Sets";
                    sets.setText(temp1);
                    ImageView image = v.findViewById(R.id.imageSets);
                    image.setImageResource(R.drawable.gym_1_foreground);

                    TextView reps = v.findViewById(R.id.textReps);
                    temp = e.getRipetizioni();
                    temp1 = temp.toString() + " Ripetizioni";
                    reps.setText(temp1);
                    ImageView image1 = v.findViewById(R.id.imageReps);
                    image1.setImageResource(R.drawable.orari_foreground);


                    TextView rest = v.findViewById(R.id.textRest);
                    Double temp2 = e.getRecupero();
                    temp1 = temp2.toString() + " Recupero";
                    rest.setText(temp1);
                    ImageView image2 = v.findViewById(R.id.imageRest);
                    image2.setImageResource(R.drawable.hourglass_foreground);

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(1000,500);
                    params.setMargins(0,8,0,8);

                    layout.addView(v,params);
                }

            }
        }


        return root;

    }

}
