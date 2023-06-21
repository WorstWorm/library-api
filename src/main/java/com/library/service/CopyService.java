package com.library.service;

import com.library.domain.Copy;
import com.library.exception.CopyNotFoundException;
import com.library.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CopyService {
    private final CopyRepository copyRepository;

    public Copy getCopy(Long id) {
        return copyRepository.findById(id).orElseThrow(CopyNotFoundException::new);
    }

    public List<Copy> getCopy() {
        return copyRepository.findAll();
    }

    public void createCopy(Copy copy) {
        copyRepository.save(copy);
    }

    public void updateCopy(Long id, Copy copy)  {
        if(copyRepository.findById(id).isPresent()) {
            Copy copyModificated = copyRepository.findById(id).get();
            copyModificated.setTitleId(copy.getTitleId());
            copyModificated.setCopyStatus(copy.getCopyStatus());
            copyRepository.save(copyModificated);
        } else {
            throw new CopyNotFoundException();
        }
    }

    public void deleteCopy(Long id)  {
        if(copyRepository.findById(id).isPresent()) {
            copyRepository.deleteById(id);
        } else {
            throw new CopyNotFoundException();
        }
    }
}