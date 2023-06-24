package com.library.controller;

import com.library.dto.CopyDto;
import com.library.exception.CopyNotFoundException;
import com.library.mapper.CopyMapper;
import com.library.service.CopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/copies")
@RequiredArgsConstructor
public class CopyController {

    private final CopyService copyService;
    private final CopyMapper copyMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CopyDto> getCopy(@PathVariable("id") long id) throws CopyNotFoundException {
        return ResponseEntity.ok(copyMapper.mapToCopyDto(copyService.getCopy(id)));
    }

    @GetMapping()
    public ResponseEntity<List<CopyDto>> getCopy() {
        return ResponseEntity.ok(copyMapper.mapToCopyDtoList(copyService.getCopy()));
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCopy(@RequestBody CopyDto copyDto) {
        copyService.createCopy(copyMapper.mapToCopy(copyDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/updateCopy/{id}", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CopyDto> updateCopy(@PathVariable("id") long id, @RequestBody CopyDto copyDto) {
        copyService.updateCopy(id, copyMapper.mapToCopy(copyDto));
        return ResponseEntity.ok(copyMapper.mapToCopyDto(copyService.getCopy(copyDto.getCopyId())));
    }

    @DeleteMapping("/deleteCopy/{id}")
    public ResponseEntity<Void> deleteCopy(@PathVariable("id") long id) throws CopyNotFoundException {
        copyService.deleteCopy(id);
        return ResponseEntity.ok().build();
    }
}
