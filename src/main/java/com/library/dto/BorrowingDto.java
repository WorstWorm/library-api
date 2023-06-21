package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BorrowingDto {
    private Long borrowingId;
    private Long readerId;
    private Long copyId;
    private LocalDate borrowingDate;
    private LocalDate returnDate;
}
