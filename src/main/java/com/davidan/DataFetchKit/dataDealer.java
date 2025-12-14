package com.davidan.DataFetchKit;

import org.jsoup.nodes.Element;

public interface dataDealer {
    void setUrl(String url);
    void setContent() throws Exception;
    Element[] getBlock(String cssquery) throws Exception;
}
