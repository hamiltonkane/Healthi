package com.hamilton.healthi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AllFragment extends Fragment
{
    private AllNoteViewModel allNoteViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View allView = inflater.inflate(R.layout.fragment_all, container, false);

        RecyclerView recyclerView = allView.findViewById(R.id.recycler_view_all);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        final AllNoteAdapter allAdapter = new AllNoteAdapter();
        recyclerView.setAdapter(allAdapter);

        allNoteViewModel = ViewModelProviders.of(this).get(AllNoteViewModel.class);
        allNoteViewModel.getAllAllNotes().observe(this, new Observer<List<AllNote>>() {
            @Override
            public void onChanged(@Nullable List<AllNote> notes) {
                allAdapter.allSetNotes(notes);
            }
        });

        return allView;
    }
}
