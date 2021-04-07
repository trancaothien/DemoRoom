package com.tct.androidnotes.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tct.androidnotes.R;
import com.tct.androidnotes.model.Note;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    private final List<Note> noteList;

    public NoteListAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }


    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = noteList.get(position);
        if (note != null){
            Date date = new Date(note.getCreationDate());
            @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            holder.txvTitle.setText(note.getTitle());
            holder.txvContent.setText(note.getContent());
            holder.txvCreationDate.setText(df.format(date));
            holder.txvContent.setOnClickListener(view -> {
                holder.txvContent.setMaxLines(10);
                holder.txvCreationDate.setVisibility(View.GONE);
            });
        }
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView txvTitle, txvCreationDate, txvContent;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            txvContent = itemView.findViewById(R.id.txv_content);
            txvTitle = itemView.findViewById(R.id.txv_title);
            txvCreationDate = itemView.findViewById(R.id.txv_creation_date);
        }
    }

}
