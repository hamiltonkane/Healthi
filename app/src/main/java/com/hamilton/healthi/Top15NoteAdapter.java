package com.hamilton.healthi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Top15NoteAdapter extends RecyclerView.Adapter<Top15NoteAdapter.Top15NoteHolder> {
    private List<Top15Note> notes = new ArrayList<>();

    @NonNull
    @Override
    public Top15NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top15_note_item, parent, false);
        return new Top15NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Top15NoteHolder holder, int position) {
        Top15Note currentNote = notes.get(position);
        holder.top15TextViewTitle.setText(currentNote.getTitle());
        holder.top15TextViewPriority.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {

        return notes.size();
    }

    public void top15SetNotes(List<Top15Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class Top15NoteHolder extends RecyclerView.ViewHolder {
        private TextView top15TextViewTitle;
        private TextView top15TextViewPriority;

        public Top15NoteHolder(@NonNull View itemView) {
            super(itemView);
            top15TextViewTitle = itemView.findViewById(R.id.text_view_title_top15);
            top15TextViewPriority = itemView.findViewById(R.id.text_view_priority_top15);
        }
    }
}
