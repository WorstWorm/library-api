package com.library.mapper;

import com.library.domain.Title;
import com.library.dto.TitleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleMapper {

    public Title mapToTitle(final TitleDto titleDto) {
        return new Title(
                titleDto.getTitleId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublicationYear()
        );
    }

    public TitleDto mapToTitleDto(final Title title) {
        return new TitleDto(
                title.getTitleId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublicationYear()
        );
    }

    public List<Title> mapToTitleList(final List<TitleDto> titleDtoList) {
        return titleDtoList.stream().map(this::mapToTitle).collect(Collectors.toList());
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> titleList) {
        return titleList.stream().map(this::mapToTitleDto).collect(Collectors.toList());
    }
}
