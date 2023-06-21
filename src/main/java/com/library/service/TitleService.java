package com.library.service;

import com.library.domain.Title;
import com.library.exception.TitleNotFoundException;
import com.library.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TitleService {
    private final TitleRepository titleRepository;

    public Title getTitle(Long id) {
        return titleRepository.findById(id).orElseThrow(TitleNotFoundException::new);
    }

    public List<Title> getTitle() {
        return titleRepository.findAll();
    }

    public void createTitle(Title title) {
        titleRepository.save(title);
    }

    public void updateTitle(Long id, Title title)  {
        if(titleRepository.findById(id).isPresent()) {
            Title titleModificated = titleRepository.findById(id).get();
            titleModificated.setTitle(title.getTitle());
            titleModificated.setAuthor(title.getAuthor());
            titleModificated.setPublicationYear(title.getPublicationYear());
            titleRepository.save(titleModificated);
        } else {
            throw new TitleNotFoundException();
        }
    }

    public void deleteTitle(Long id)  {
        if(titleRepository.findById(id).isPresent()) {
            titleRepository.deleteById(id);
        } else {
            throw new TitleNotFoundException();
        }
    }
}