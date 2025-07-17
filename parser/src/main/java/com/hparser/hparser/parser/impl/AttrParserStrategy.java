package com.hparser.hparser.parser.impl;

import com.hparser.hparser.parser.ContentParserStrategy;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Element;

@RequiredArgsConstructor
public class AttrParserStrategy implements ContentParserStrategy {

    private final String attributeName;

    @Override
    public String parse(Element element) {
        return element.attr(attributeName);
    }
}

