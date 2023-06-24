package com.library.controller;

import com.library.dto.TitleDto;
import com.library.exception.TitleNotFoundException;
import com.library.mapper.TitleMapper;
import com.library.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/titles")
@RequiredArgsConstructor
public class TitleController {

    private final TitleService titleService;
    private final TitleMapper titleMapper;

    @GetMapping("/{id}")
    public ResponseEntity<TitleDto> getTitle(@PathVariable("id") long id) throws TitleNotFoundException {
        return ResponseEntity.ok(titleMapper.mapToTitleDto(titleService.getTitle(id)));
    }

    @GetMapping()
    public ResponseEntity<List<TitleDto>> getTitle() {
        return ResponseEntity.ok(titleMapper.mapToTitleDtoList(titleService.getTitle()));
    }

    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTitle(@RequestBody TitleDto titleDto) {
        titleService.createTitle(titleMapper.mapToTitle(titleDto));
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/updateTitle/{id}", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TitleDto> updateTitle(@PathVariable("id") long id, @RequestBody TitleDto titleDto) {
        titleService.updateTitle(id, titleMapper.mapToTitle(titleDto));
        return ResponseEntity.ok(titleMapper.mapToTitleDto(titleService.getTitle(titleDto.getTitleId())));
    }

    @DeleteMapping("/deleteTitle/{id}")
    public ResponseEntity<Void> deleteTitle(@PathVariable("id") long id) throws TitleNotFoundException {
        titleService.deleteTitle(id);
        return ResponseEntity.ok().build();
    }
}
