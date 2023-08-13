package com.example.gymapp2.ui.esercizi1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymapp2.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import static com.example.gymapp2.MainActivity.db;

import com.example.gymapp2.TempDB;
import com.example.gymapp2.databinding.FragmentEsercizi1Binding;
import com.example.gymapp2.esercizio.Esercizio;
import com.example.gymapp2.scheda.Scheda;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Esercizi1Fragment extends Fragment {

    private FragmentEsercizi1Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentEsercizi1Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout layout = root.findViewById(R.id.esercizi1_list);
        int num_esercizi = db.getEsercizi().size();
        ArrayList<Esercizio> esercizi_list = db.getEsercizi();

        ArrayList<View> cards = new ArrayList<>();

        LayoutInflater vi = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for(int i = 0; i < num_esercizi; i++){

            View v = vi.inflate(R.layout.esercizi1_card, null);

            TextView txt = v.findViewById(R.id.nome_esercizio);
            txt.setText(esercizi_list.get(i).getNome());

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(1000,300);
            params.setMargins(0,8,0,8);

            cards.add(v);
            layout.addView(v,params);
        }

        Button button_conferma = root.findViewById(R.id.button_conferma);
        button_conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Scheda scheda;
                ArrayList<Esercizio> esercizi = new ArrayList<>();

                for (View card: cards
                     ) {

                    CheckBox cbx = card.findViewById(R.id.checkbox_card_1);

                    if(cbx.isChecked()){

                        TextInputEditText info1 = card.findViewById(R.id.info_aggiuntive_1);
                        String temp1 = info1.getText().toString();
                        TextInputEditText info2 = card.findViewById(R.id.info_aggiuntive_2);
                        String temp2 = info2.getText().toString();
                        TextInputEditText info3 = card.findViewById(R.id.info_aggiuntive_3);
                        String temp3 = info3.getText().toString();

                        if(temp1.isEmpty() || temp2.isEmpty() || temp3.isEmpty() ){

                            Toast.makeText(getActivity().getApplicationContext(),"Riempire tutti i campi",Toast.LENGTH_SHORT).show();
                            return;

                        }

                        TextView txt = card.findViewById(R.id.nome_esercizio);
                        String nome = txt.getText().toString();

                        Integer sets = Integer.parseInt(temp1);
                        Integer reps = Integer.parseInt(temp2);
                        Double rest = Double.parseDouble(temp3);

                        Esercizio esercizio = new Esercizio(nome,sets,reps,rest);
                        esercizi.add(esercizio);

                    }

                }

                if(esercizi.isEmpty()){
                    Toast.makeText(getActivity().getApplicationContext(),"Nessun esercizio selezionato",Toast.LENGTH_SHORT).show();
                    return;
                }

                TextInputEditText info_nome = root.findViewById(R.id.nome_scheda);
                String temp4 = info_nome.getText().toString();

                if(temp4.isEmpty()){
                    Toast.makeText(getActivity().getApplicationContext(),"Inserire un nome per la scheda",Toast.LENGTH_SHORT).show();
                    return;
                }

                scheda = new Scheda(temp4, esercizi);
                db.addScheda(scheda);

                Toast.makeText(getActivity().getApplicationContext(),"Scheda creata con successo",Toast.LENGTH_SHORT).show();
                Navigation.findNavController(v).navigate(R.id.navigation_allenamenti);
            }
        });

        return root;


    }
}
