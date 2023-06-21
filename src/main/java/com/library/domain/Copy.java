package com.library.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "copies")
public class Copy {

    @Id
    @GeneratedValue
    @Column(name = "copy_id", unique = true)
    private Long copyId;

    @Column(name = "title_id")
    private Long titleId;

    @Column(name = "copy_status")
    private String copyStatus;
}
