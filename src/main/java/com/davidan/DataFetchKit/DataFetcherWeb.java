package com.davidan.DataFetchKit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class DataFetcherWeb implements dataDealer {
    private String url;

    private Document content;

    public DataFetcherWeb() {

    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setContent() throws Exception {
        if (url == null) {
            throw new Exception("url string is not initialized: DataFetchKit.DataFetcher.setContent()");
        } else {
            this.content = Jsoup.connect(this.url).get();
        }
    }

    @Override
    public Element[] getBlock(String cssquery) throws Exception {
        if (url == null) {
            throw new Exception("url String is not initialized: DataFetchKit.DataFetcher.getBlock()");
        }
        if (content == null) {
            throw new Exception("content Document is not initialized: DataFetchKit.DataFetcher.getBlock()");
        }
        try {
            Elements elements = this.content.select(cssquery);

            Element[] elementArray = new Element[elements.size()];

            int count = 0;
            for (Element item : elements) {
                elementArray[count] = item;
                count ++;
            }

            return elementArray;

        } catch (Exception e) {
            throw new Exception("failed to get block: DataFetchKit.DataFetcher.getBlock()");
        }
    }
}
