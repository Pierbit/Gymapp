package com.example.gymapp2.ui.tutorial;

import static com.example.gymapp2.MainActivity.db;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.gymapp2.R;
import com.example.gymapp2.databinding.FragmentTutorialBinding;
import com.example.gymapp2.esercizio.Esercizio;

public class TutorialFragment extends Fragment {

    private FragmentTutorialBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentTutorialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView txt = root.findViewById(R.id.textTutorial);
        Esercizio esercizio = db.getEsercizio_selezionato();
        String titolo = "Tutorial per: " + esercizio.getNome();
        txt.setText(titolo);

        VideoView vv = root.findViewById(R.id.videoTutorial);
        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);
        vv.setVideoURI(uri);
        MediaController mediaController = new MediaController(getContext());
        vv.setMediaController(mediaController);
        mediaController.setAnchorView(vv);
        vv.requestFocus();
        vv.start();



        return root;
    }

}