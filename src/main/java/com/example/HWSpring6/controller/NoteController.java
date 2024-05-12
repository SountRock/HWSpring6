package com.example.HWSpring6.controller;

import com.example.HWSpring6.model.Note;
import com.example.HWSpring6.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class NoteController {
    private final NoteRepository repo;

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        repo.save(note);

        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Note>> findAll(){
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable("id") Long id){
        Optional<Note> temp = repo.findById(id);
        if(temp.isPresent()){
            return new ResponseEntity<>(temp.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> changeById(@PathVariable("id") Long id, @RequestBody Note note){
        Optional<Note> temp = repo.findById(id);
        if(!temp.isPresent()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        Note tempNote = temp.get();
        tempNote.setTitle(note.getTitle());
        tempNote.setText(note.getText());

        repo.save(tempNote);

        return new ResponseEntity<>(repo.findById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        Optional<Note> temp = repo.findById(id);
        if(!temp.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repo.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
