package com.algaworks.algalog.api.mapping;

import com.algaworks.algalog.api.dto.OccurenceDto;
import com.algaworks.algalog.domain.model.Occurrence;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OccurenceMapper {
    private ModelMapper modelMapper;

    public OccurenceDto toDto(Occurrence occurrence) {
        return modelMapper.map(occurrence, OccurenceDto.class);
    }

    public List<OccurenceDto> toList(List<Occurrence> occurrences) {
        return occurrences.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
