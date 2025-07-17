package com.hparser.hparser.parser.impl.downloader;

import com.hparser.hparser.parser.Downloader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class HtmlDownloader implements Downloader {

    public Document getWebPage(String link) {

        try {
            Document document = Jsoup.connect(link).get();
            return document;
        }
        catch(Exception e) {
            //can't to load Web Page?
            return null;
        }
    }

}
