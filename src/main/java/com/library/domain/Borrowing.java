package com.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "borrowings")
public class Borrowing {

    @Id
    @GeneratedValue
    @Column(name = "borrowing_id", unique = true)
    private Long borrowingId;

    @Column(name = "reader_id")
    private Long readerId;

    @Column(name = "copy_id")
    private Long copyId;

    @Column(name = "borrowing_date")
    private LocalDate borrowingDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    public Borrowing(Long readerId, Long copyId, LocalDate borrowingDate) {
        this.readerId = readerId;
        this.copyId = copyId;
        this.borrowingDate = borrowingDate;
    }
}
