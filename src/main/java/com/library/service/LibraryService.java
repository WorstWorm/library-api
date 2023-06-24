package com.library.service;

import com.library.domain.Borrowing;
import com.library.domain.Copy;
import com.library.enums.CopyStatus;
import com.library.exception.CopyNotFoundException;
import com.library.exception.UserNotFoundException;
import com.library.repository.BorrowingRepository;
import com.library.repository.CopyRepository;
import com.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final CopyRepository copyRepository;
    private final UserRepository userRepository;
    private final BorrowingRepository borrowingRepository;

    public void borrowBook(Long copyId, Long userId) {
        if(copyRepository.findById(copyId).isPresent()) {
            if(userRepository.findById(userId).isPresent()) {
                Borrowing borrowing = new Borrowing(userId, copyId, LocalDate.now());
                borrowingRepository.save(borrowing);

                Copy copy = copyRepository.findById(copyId).get();
                copy.setCopyStatus(CopyStatus.BORROWED);
                copyRepository.save(copy);
            } else {
                throw new UserNotFoundException();
            }
        } else {
            throw new CopyNotFoundException();
        }
    }

    public void returnBook(Long copyId) {
        if(copyRepository.findById(copyId).get().getCopyStatus().equals(CopyStatus.BORROWED)) {
            Copy copy = copyRepository.findById(copyId).get();
            copy.setCopyStatus(CopyStatus.INSTOCK);
            copyRepository.save(copy);

            Borrowing borrowing = borrowingRepository.findBorrowingByCopyId(copyId);
            borrowing.setReturnDate(LocalDate.now());
            borrowingRepository.save(borrowing);
        } else throw new CopyNotFoundException();
    }

    public List<Copy> checkCopiesInStock(Long titleId) {
        List<Copy> copiesOfTitle = copyRepository.findCopiesByTitleId(titleId);
        List<Copy> copiesInStock = new ArrayList<>();
        for(Copy c : copiesOfTitle) {
            if(c.getCopyStatus().equals(CopyStatus.INSTOCK)) {
                copiesInStock.add(c);
            }
        }
        return copiesInStock;
    }

    public void changeStatus(Long copyId, CopyStatus status) {
        if(copyRepository.findById(copyId).isPresent()) {
            Copy copy = copyRepository.findById(copyId).get();
            copy.setCopyStatus(status);
            copyRepository.save(copy);
        } else throw new CopyNotFoundException();
    }
}
