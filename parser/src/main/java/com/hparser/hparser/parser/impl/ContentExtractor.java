package com.hparser.hparser.parser.impl;

import com.hparser.hparser.parser.ContentParserStrategy;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//get content for TextParserStrategy, AttrParserStrategy and UrlParserStrategy
@Component
public class ContentExtractor {

    public List<String> getContent(Document document, String selection, ContentParserStrategy strategy) {
        Elements elements = document.select(selection);
        List<String> content = new ArrayList<>();

        for(Element element : elements) {
            content.add(strategy.parse(element));
        }
        return content;
    }
}
