package com.davidan.DataFetchKit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataFetcher {
    private String url;

    private Document content;

    public DataFetcher() {

    }

    void setUrl(String url) {
        this.url = url;
    }

    void setContent() throws Exception {
        if (url == null) {
            throw new Exception("url string is not initialized: DataFetchKit.DataFetcher.setContent()");
        } else {
            this.content = Jsoup.connect(this.url).get();
        }
    }

    void getBlock(String cssquery) throws Exception {
        if (url == null) {
            throw new Exception("url String is not initialized: DataFetchKit.DataFetcher.getBlock()");
        }
        if (content == null) {
            throw new Exception("content Document is not initialized: DataFetchKit.DataFetcher.getBlock()");
        }
        try {
            this.content.select("div[class*=" + cssquery + "]");

            for (Element item : this.content) {

            }

//            Element[] elementArray = new Element[];

            for (Element item : this.content) {

            }


        } catch (Exception e) {
            throw new Exception("failed to get block: DataFetchKit.DataFetcher.getBlock()");
        }
    }

}
