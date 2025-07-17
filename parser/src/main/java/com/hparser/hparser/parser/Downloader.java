package com.hparser.hparser.parser;

import org.jsoup.nodes.Document;

public interface Downloader {

    public Document getWebPage(String link);

}
