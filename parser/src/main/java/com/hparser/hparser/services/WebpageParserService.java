package com.hparser.hparser.services;

import com.hparser.hparser.DTOs.ParseRequestDto;
import com.hparser.hparser.parser.impl.ContentExtractor;
import com.hparser.hparser.parser.impl.TextParserStrategy;
import com.hparser.hparser.parser.impl.downloader.HtmlDownloader;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WebpageParserService {

    private HtmlDownloader htmlDownloader;
    private ContentExtractor contentExtractor;

    public List<List<String>> parseWebpages(ParseRequestDto dto) {
        String command = dto.getCommand();
        List<String> cellsData = dto.getInputCellsData();
        List<List<String>> webPageContent = new ArrayList<>();

        for (String link : cellsData) {
            Document html = htmlDownloader.getWebPage(link);
            List<String> content = contentExtractor.getContent(html, command, new TextParserStrategy());
            webPageContent.add(content);
        }

        return webPageContent;
    }

}


