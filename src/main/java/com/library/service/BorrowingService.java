package com.library.service;

import com.library.domain.Borrowing;
import com.library.exception.BorrowingNotFoundException;
import com.library.repository.BorrowingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowingService {
    private final BorrowingRepository borrowingRepository;

    public Borrowing getBorrowing(Long id) {
        return borrowingRepository.findById(id).orElseThrow(BorrowingNotFoundException::new);
    }

    public List<Borrowing> getBorrowing() {
        return borrowingRepository.findAll();
    }

    public void createBorrowing(Borrowing borrowing) {
        borrowingRepository.save(borrowing);
    }

    public void updateBorrowing(Long id, Borrowing borrowing)  {
        if(borrowingRepository.findById(id).isPresent()) {
            Borrowing borrowingModificated = borrowingRepository.findById(id).get();
            borrowingModificated.setReaderId(borrowing.getReaderId());
            borrowingModificated.setCopyId(borrowing.getCopyId());
            borrowingModificated.setBorrowingDate(borrowing.getBorrowingDate());
            borrowingModificated.setReturnDate(borrowing.getReturnDate());
            borrowingRepository.save(borrowingModificated);
        } else {
            throw new BorrowingNotFoundException();
        }
    }

    public void deleteBorrowing(Long id)  {
        if(borrowingRepository.findById(id).isPresent()) {
            borrowingRepository.deleteById(id);
        } else {
            throw new BorrowingNotFoundException();
        }
    }
}