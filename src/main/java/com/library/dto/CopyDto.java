package com.library.dto;

import com.library.enums.CopyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CopyDto {

    private Long copyId;
    private Long titleId;
    private CopyStatus copyStatus;
}
