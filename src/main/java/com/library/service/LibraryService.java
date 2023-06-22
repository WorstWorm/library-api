package com.library.service;

import com.library.domain.Borrowing;
import com.library.domain.Copy;
import com.library.exception.BorrowingNotFoundException;
import com.library.exception.CopyNotFoundException;
import com.library.exception.UserNotFoundException;
import com.library.repository.BorrowingRepository;
import com.library.repository.CopyRepository;
import com.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
                copy.setCopyStatus("borrowed");
                copyRepository.save(copy);
            } else {
                throw new UserNotFoundException();
            }
        } else {
            throw new CopyNotFoundException();
        }
    }

    public void returnBook(Long copyId) {
        if(copyRepository.findById(copyId).get().getCopyStatus().equals("borrowed")) {
            Copy copy = copyRepository.findById(copyId).get();
            copy.setCopyStatus("in stock");
            copyRepository.save(copy);

            List<Borrowing> borrowings = borrowingRepository.findAll();
            for(Borrowing b : borrowings) {
                if(b.getCopyId() == copyId) {
                    b.setReturnDate(LocalDate.now());
                    borrowingRepository.save(b);
                }
            }
        } else throw new CopyNotFoundException();
    }
}
