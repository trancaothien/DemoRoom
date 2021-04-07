package com.tct.androidnotes.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tct.androidnotes.R;
import com.tct.androidnotes.adapter.NoteListAdapter;
import com.tct.androidnotes.database.NoteDatabase;
import com.tct.androidnotes.model.Note;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvNotes;
    private NoteListAdapter noteListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvNotes = findViewById(R.id.rev_notes);
        addNote();
        noteListAdapter = new NoteListAdapter(getAllNote());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvNotes.setLayoutManager(linearLayoutManager);
        rcvNotes.setAdapter(noteListAdapter);
    }

    private List<Note> getAllNote(){
        return NoteDatabase.getInstance(this).criminalDao().getAllNote();
    }

    private void addNote(){
        // Xóa cơ sở dữ liệu trước khi insert
        NoteDatabase.getInstance(this).criminalDao().delete();
        long currentDate = System.currentTimeMillis();
        // insert 10 row vào db
        for (int i = 0; i <= 10; i++){
            Note note = new Note("Note "+ i, "Các dữ liệu ghi chú được đọc lên từ database. Cần tạo số lượng ghi\n" +
                    "chú đủ nhiều để có thể cuộn recyclerview." +i, currentDate);
            NoteDatabase.getInstance(this).criminalDao().insertNote(note);
        }
    }
}