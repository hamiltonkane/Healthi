package com.hamilton.healthi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Top15Fragment extends Fragment
{
    private Top15NoteViewModel top15NoteViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View top15View = inflater.inflate(R.layout.fragment_top15, container, false);

        RecyclerView recyclerView = top15View.findViewById(R.id.recycler_view_top15);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        final Top15NoteAdapter top15Adapter = new Top15NoteAdapter();
        recyclerView.setAdapter(top15Adapter);

        top15NoteViewModel = ViewModelProviders.of(this).get(Top15NoteViewModel.class);
        top15NoteViewModel.getTop15AllNotes().observe(this, new Observer<List<Top15Note>>() {
            @Override
            public void onChanged(@Nullable List<Top15Note> notes) {
                top15Adapter.top15SetNotes(notes);
            }
        });

        return top15View;
    }
}
