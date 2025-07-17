package com.hparser.hparser.controllers;

import com.hparser.hparser.mappers.TableMapper;
import com.hparser.hparser.services.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import com.hparser.hparser.DTOs.ParseRequestDto;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ParserPageController {

    private final TableMapper tableMapper;
    private final TableService tableService;

    @PostMapping("/uploadColumnData")
    public List<Map<String,Object>> uploadColumnData(@RequestBody ParseRequestDto dto) {
        dto = tableMapper.toDto(dto.getRawCells(),
                dto.getInputColumn(),
                dto.getOutputColumn(),
                dto.getCommand());
        return tableService.createNewSheet(dto);
    }

    @PostMapping("logged/loadSheets")
    public String loadSheets() {
        return null;
    }

    @PostMapping("logged/saveSheets")
    public String saveSheets() {
        return null;
    }

}


