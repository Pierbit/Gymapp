package com.example.gymapp2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.gymapp2.R;
import com.example.gymapp2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ScrollView scroll = binding.ScrollView01;
        scroll.setBackgroundColor(getResources().getColor(R.color.grey));

        Button button = binding.buttonFasce;
        button.setBackgroundColor(getResources().getColor(R.color.grey));

        CalendarView calendar = binding.calendarView;
        calendar.setBackgroundColor(getResources().getColor(R.color.grey));

        Toolbar bar = binding.toolbar2;
        bar.setBackgroundColor(getResources().getColor(R.color.grey));

        Button btn = root.findViewById(R.id.button_fasce);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.navigation_orari);
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