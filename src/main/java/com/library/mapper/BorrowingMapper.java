package com.library.mapper;

import com.library.domain.Borrowing;
import com.library.dto.BorrowingDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingMapper {
    public Borrowing mapToBorrowing(final BorrowingDto borrowingDto) {
        return new Borrowing(
                borrowingDto.getBorrowingId(),
                borrowingDto.getReaderId(),
                borrowingDto.getCopyId(),
                borrowingDto.getBorrowingDate(),
                borrowingDto.getReturnDate()
        );
    }

    public BorrowingDto mapToBorrowingDto(final Borrowing borrowing) {
        return new BorrowingDto(
                borrowing.getBorrowingId(),
                borrowing.getReaderId(),
                borrowing.getCopyId(),
                borrowing.getBorrowingDate(),
                borrowing.getReturnDate()
        );
    }

    public List<Borrowing> mapToBorrowingList(final List<BorrowingDto> borrowingDtoList) {
        return borrowingDtoList.stream().map(this::mapToBorrowing).collect(Collectors.toList());
    }

    public List<BorrowingDto> mapToBorrowingDtoList(final List<Borrowing> borrowingList) {
        return borrowingList.stream().map(this::mapToBorrowingDto).collect(Collectors.toList());
    }
}
