package com.hparser.hparser.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hparser.hparser.DTOs.ParseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@ControllerAdvice
@RequiredArgsConstructor
public class TableMapper {

    private final ObjectMapper objectMapper;

    public List<String> selectInputCells(List<Map<String, Object>> rawCells, String inputColumn) {
        int columnIndex = inputColumn.toUpperCase().charAt(0) - 'A';
        return rawCells.stream()
                .filter(m -> ((Number) m.get("c")).intValue() == columnIndex)
                .map(m -> {
                    @SuppressWarnings("unchecked")
                    Map<String,Object> vMap = (Map<String,Object>) m.get("v");
                    return vMap.get("v").toString();
                })
                .collect(Collectors.toList());
    }

    public ParseRequestDto toDto(
            List<Map<String,Object>> rawCells,
            String inputColumn,
            String outputColumn,
            String command){
        List<String> inputCellsData = selectInputCells(rawCells, inputColumn);
        return ParseRequestDto.builder()
                .rawCells(rawCells)
                .inputCellsData(inputCellsData)
                .inputColumn(inputColumn)
                .outputColumn(outputColumn)
                .command(command)
                .build();
    }

}
