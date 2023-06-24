package com.library.controller;

import com.library.dto.CopyDto;
import com.library.enums.CopyStatus;
import com.library.exception.CopyNotFoundException;
import com.library.exception.UserNotFoundException;
import com.library.mapper.CopyMapper;
import com.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class LibraryController {

    private final LibraryService libraryService;
    private final CopyMapper copyMapper;

    @PostMapping("/borrow/{copyId}/{userId}")
    public ResponseEntity<Void> borrowBook(@PathVariable("copyId") Long copyId, @PathVariable("userId") Long userId) {
        libraryService.borrowBook(copyId, userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/return/{copyId}")
    public ResponseEntity<Void> returnBook(@PathVariable("copyId") Long copyId) {
        libraryService.returnBook(copyId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/stock/{titleId}")
    public ResponseEntity<List<CopyDto>> checkCopiesInStock(@PathVariable("titleId") Long titleId) {
        return ResponseEntity.ok(copyMapper.mapToCopyDtoList(libraryService.checkCopiesInStock(titleId)));
    }

    @PutMapping("/status/{copyId}/{status}")
    public ResponseEntity<Void> changeStatus(@PathVariable("copyId") Long copyId, @PathVariable("status") CopyStatus status) {
        libraryService.changeStatus(copyId, status);
        return ResponseEntity.ok().build();
    }
}
