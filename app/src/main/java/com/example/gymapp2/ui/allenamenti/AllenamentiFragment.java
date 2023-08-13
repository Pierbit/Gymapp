package com.example.gymapp2.ui.allenamenti;

import static com.example.gymapp2.MainActivity.db;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.gymapp2.R;
import com.example.gymapp2.databinding.FragmentAllenamentiBinding;
import com.example.gymapp2.databinding.FragmentDashboardBinding;
import com.example.gymapp2.esercizio.Esercizio;
import com.example.gymapp2.scheda.Scheda;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class AllenamentiFragment extends Fragment {

    private AllenamentiViewModel allenamentiViewModel;
    private FragmentAllenamentiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        allenamentiViewModel =
                new ViewModelProvider(this).get(com.example.gymapp2.ui.allenamenti.AllenamentiViewModel.class);

        binding = FragmentAllenamentiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout layout = root.findViewById(R.id.allenamenti_list);

        ArrayList<Scheda> schede = db.getSchede();
        int count = schede.size();

        LayoutInflater vi = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for(int i = 0; i < count; i++){

            View v = vi.inflate(R.layout.allenamenti_card, null);

            TextView text = v.findViewById(R.id.textView5);
            text.setText(schede.get(i).getNome());

            TextView text1 = v.findViewById(R.id.textView6);
            String temp = schede.get(i).getNum_esercizi() + " Allenamenti";
            text1.setText(temp);

            ImageView image = v.findViewById(R.id.imageView);
            image.setImageResource(R.drawable.allenamenti_foreground);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(1000,300);
            params.setMargins(0,8,0,8);

            layout.addView(v,params);

        }

        Button button = root.findViewById(R.id.button_creascheda);
        button.setTextColor(getResources().getColor(R.color.black));
        button.setBackgroundColor(getResources().getColor(R.color.grey));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(v).navigate(R.id.navigation_esercizi1);
                return;
            }
        });

        Button button1 = root.findViewById(R.id.button_creascheda_auto);
        button1.setTextColor(getResources().getColor(R.color.black));
        button1.setBackgroundColor(getResources().getColor(R.color.grey));
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View v1 = vi.inflate(R.layout.allenamenti_card, null);

                ArrayList<Esercizio> esercizi_temp = new ArrayList<>();
                Random rand = new Random();
                int x = rand.nextInt(9) + 1;
                for(int j = 0; j < x; j++){
                    esercizi_temp.add(db.getEsercizi().get(j));
                }
                Scheda scheda = new Scheda("Scheda generata", esercizi_temp);
                db.addScheda(scheda);

                TextView text = v1.findViewById(R.id.textView5);
                text.setText(scheda.getNome());

                TextView text1 = v1.findViewById(R.id.textView6);
                String temp = scheda.getNum_esercizi() + " Allenamenti";
                text1.setText(temp);

                ImageView image = v1.findViewById(R.id.imageView);
                image.setImageResource(R.drawable.allenamenti_foreground);

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(1000,300);
                params.setMargins(0,8,0,8);

                layout.addView(v1,params);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}