package com.library.controller;

import com.library.dto.BorrowingDto;
import com.library.exception.BorrowingNotFoundException;
import com.library.mapper.BorrowingMapper;
import com.library.service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/borrowings")
@RequiredArgsConstructor
public class BorrowingController {

    private final BorrowingService borrowingService;
    private final BorrowingMapper borrowingMapper;

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingDto> getBorrowing(@PathVariable("id") long id) throws BorrowingNotFoundException {
        return ResponseEntity.ok(borrowingMapper.mapToBorrowingDto(borrowingService.getBorrowing(id)));
    }

    @GetMapping()
    public ResponseEntity<List<BorrowingDto>> getBorrowing() {
        return ResponseEntity.ok(borrowingMapper.mapToBorrowingDtoList(borrowingService.getBorrowing()));
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBorrowing(@RequestBody BorrowingDto borrowingDto) {
        borrowingService.createBorrowing(borrowingMapper.mapToBorrowing(borrowingDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/updateBorrowing/{id}", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BorrowingDto> updateBorrowing(@PathVariable("id") long id, @RequestBody BorrowingDto borrowingDto) throws BorrowingNotFoundException {
        borrowingService.updateBorrowing(id, borrowingMapper.mapToBorrowing(borrowingDto));
        return ResponseEntity.ok(borrowingMapper.mapToBorrowingDto(borrowingService.getBorrowing(borrowingDto.getBorrowingId())));
    }

    @DeleteMapping("/deleteBorrowing/{id}")
    public ResponseEntity<Void> deleteBorrowing(@PathVariable("id") long id) throws BorrowingNotFoundException {
        borrowingService.deleteBorrowing(id);
        return ResponseEntity.ok().build();
    }
}