package com.library.mapper;

import com.library.domain.Copy;
import com.library.dto.CopyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyMapper {

    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getCopyId(),
                copyDto.getTitleId(),
                copyDto.getCopyStatus()
        );
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getCopyId(),
                copy.getTitleId(),
                copy.getCopyStatus()
        );
    }

    public List<Copy> mapToCopyList(final List<CopyDto> copyDtoList) {
        return copyDtoList.stream().map(this::mapToCopy).collect(Collectors.toList());
    }

    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList) {
        return copyList.stream().map(this::mapToCopyDto).collect(Collectors.toList());
    }

}
