package com.library.controller;

import com.library.dto.BorrowingDto;
import com.library.service.BorrowingService;
import com.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;

    @PostMapping("/borrow/{copyId}/{userId}")
    public ResponseEntity<Void> borrowBook(@PathVariable("copyId") Long copyId, @PathVariable("userId") Long userId) {
        libraryService.borrowBook(copyId, userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/return/{copyId}")
    public ResponseEntity<Void> returnBook(@PathVariable("copyId") Long copyId) {
        libraryService.returnBook(copyId);
        return ResponseEntity.ok().build();
    }
}
