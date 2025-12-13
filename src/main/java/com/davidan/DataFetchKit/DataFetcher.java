package com.davidan.DataFetchKit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.crypto.Data;

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

    Element[] getBlock(String cssquery, String type) throws Exception {
        if (url == null) {
            throw new Exception("url String is not initialized: DataFetchKit.DataFetcher.getBlock()");
        }
        if (content == null) {
            throw new Exception("content Document is not initialized: DataFetchKit.DataFetcher.getBlock()");
        }
        try {
            Elements elements = this.content.select(type + "[id*=" + cssquery + "]");


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


//    public static void main(String[] args) {
//        DataFetcher item = new DataFetcher();
//
//        item.setUrl("https://docs.wpilib.org/en/stable/index.html");
//        try {
//            item.setContent();
//            Element[] blocks = item.getBlock("first-robotics-competition-control", "section");
//
//            for (Element block : blocks) {
//                System.out.println(block.text());
//            }
//
//        } catch (Exception e) {
//            System.out.println("fuck");
//        }
//
//
//    }
}
