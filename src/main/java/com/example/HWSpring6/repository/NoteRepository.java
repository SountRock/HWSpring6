package com.example.HWSpring6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.HWSpring6.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {}
