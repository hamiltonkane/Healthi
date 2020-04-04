package com.hamilton.healthi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AllNoteAdapter extends RecyclerView.Adapter<AllNoteAdapter.AllNoteHolder> {
    private List<AllNote> notes = new ArrayList<>();

    @NonNull
    @Override
    public AllNoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_note_item, parent, false);
        return new AllNoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AllNoteHolder holder, int position) {
        AllNote currentNote = notes.get(position);
        holder.allTextViewTitle.setText(currentNote.getTitle());
    }

    @Override
    public int getItemCount() {

        return notes.size();
    }

    public void allSetNotes(List<AllNote> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class AllNoteHolder extends RecyclerView.ViewHolder {
        private TextView allTextViewTitle;

        public AllNoteHolder(@NonNull View itemView) {
            super(itemView);
            allTextViewTitle = itemView.findViewById(R.id.text_view_title_all);
        }
    }
}
