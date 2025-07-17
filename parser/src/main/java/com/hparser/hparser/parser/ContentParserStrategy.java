package com.hparser.hparser.parser;

import org.jsoup.nodes.Element;
import java.util.List;

public interface ContentParserStrategy {

    String parse(Element element);
    
}
