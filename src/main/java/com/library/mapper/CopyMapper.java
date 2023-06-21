package com.library.mapper;

import com.library.domain.Copy;
import com.library.dto.CopyDto;
import com.library.enums.CopyStatus;

import java.util.List;
import java.util.stream.Collectors;

public class CopyMapper {

    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getCopyId(),
                copyDto.getTitleId(),
                copyDto.getCopyStatus().getStatus()
        );
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getCopyId(),
                copy.getTitleId(),
                CopyStatus.valueOf(copy.getCopyStatus())
        );
    }

    public List<Copy> mapToCopyList(final List<CopyDto> copyDtoList) {
        return copyDtoList.stream().map(this::mapToCopy).collect(Collectors.toList());
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList) {
        return copyList.stream().map(this::mapToCopyDto).collect(Collectors.toList());
    }

}
