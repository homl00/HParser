package com.hparser.hparser.parser.impl;
import org.jsoup.nodes.Element;
import com.hparser.hparser.parser.ContentParserStrategy;

//parse only text
public class TextParserStrategy implements ContentParserStrategy {
    @Override
    public String parse(Element element) {
        return element.text();
    }
}
