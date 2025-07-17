package com.hparser.hparser.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParseRequestDto {

    @JsonProperty("inputCellsData")
    @NotNull
    private List<String> inputCellsData;

    @JsonProperty("rawCells")
    @NotNull
    private List<Map<String, Object>> rawCells;

    @JsonProperty("overwrittenCells")
    @NotNull
    private List<Map<String, Object>> overwrittenCells;

    @JsonProperty("inputColumn")
    @NotNull
    private String inputColumn;

    @JsonProperty("outputColumn")
    @NotNull
    private String outputColumn;

    @JsonProperty("command")
    @NotNull
    private String command;
}

