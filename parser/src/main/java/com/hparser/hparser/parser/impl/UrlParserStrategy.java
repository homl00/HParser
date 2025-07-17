package com.hparser.hparser.parser.impl;

import org.jsoup.nodes.Element;
import com.hparser.hparser.parser.ContentParserStrategy;

// Parse URL if command ended with "a"
public class UrlParserStrategy implements ContentParserStrategy {
    @Override
    public String parse(Element element) {
        return element.absUrl("href");
    }
}
