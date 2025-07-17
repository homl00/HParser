package com.hparser.hparser.services;

import com.hparser.hparser.DTOs.ParseRequestDto;
import com.hparser.hparser.enums.DefaultSheetName;
import com.hparser.hparser.enums.MinTableParamsEnum;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TableService {

    public List<Map<String, Object>> createNewSheet(ParseRequestDto dto) {
        Map<String, Object> sheet = Map.of(
                "name",   DefaultSheetName.NAME.getName(),
                "index",  MinTableParamsEnum.INDEX.getParam(),
                "status", MinTableParamsEnum.STATUS.getParam(),
                "row",    MinTableParamsEnum.ROW.getParam(),
                "column", MinTableParamsEnum.COLUMN.getParam(),
                "celldata", dto.getRawCells()
        );
        return List.of(sheet);
    }

    public List<Map<String, Object>> overwriteOutputColumnData(ParseRequestDto dto, List<String> newContent) {
        int columnIndex = dto.getOutputColumn().toUpperCase().charAt(0) - 'A';
        List<Map<String, Object>> rawCells = dto.getRawCells();

        Iterator<String> it = newContent.iterator();
        rawCells.stream()
                .filter(cell -> ((Number) cell.get("c")).intValue() == columnIndex && it.hasNext())
                .forEach(cell -> {
                    String newValue = it.next();
                    @SuppressWarnings("unchecked")
                    Map<String,Object> vMap = (Map<String,Object>) cell.get("v");

                    vMap.put("v", newValue);
                    cell.put("v", vMap);
                    cell.put("m", newValue);
                });
        return rawCells;
    }
}
