package com.davidan.Models;

import com.davidan.DataFetchKit.DataFetcherWeb;
import org.jsoup.nodes.Element;
import com.davidan.DataFetchKit.dataDealer;
import org.jsoup.select.Elements;

public class RedditViewModel {
    private final String modelURL = "https://www.reddit.com";
    // <shreddit-post class="">
    private final String articleDec = "shreddit-post[class*='block relative cursor-pointer']";
    // <a id="">
    private final String postTitle = "a[id*='post-title-t3']";
    //
    private final String postComments = "div[class*='md text-14-scalable rounded-2 pb-2xs']";
    //
    private final String postParagraph = "shreddit-post-text-body" + " " + "p";
    //
    private final String postLink = "";
    // <a class="">
    private final String postSubreddit = "a[class*='text-neutral-content whitespace-nowrap']";

    dataDealer dataFetcher;
    public model[] models;
    Element[] modelElements;

    public RedditViewModel() {
        dataFetcher = new DataFetcherWeb();

        try {
            Element[] temp = this.getElements(this.modelURL, this.postTitle);

            this.models = new model[temp.length];

            for (int i= 0; i < temp.length; i ++) {
                this.models[i] = new FeedModel("", "", "", "");
            }
        } catch (Exception _){
            this.models = new model[0];
            System.out.println("failed to initialize models: Models.RedditViewModel()");
        }
    }

    private Element[] getElements(String url, String queryCode) throws Exception {
        dataFetcher.setUrl(url);
        dataFetcher.setContent();
        return dataFetcher.getBlock(queryCode);
    }



    public void setTitleNPara() {
        try {
            Element[] articlesTemp = this.getElements(this.modelURL, this.articleDec);
            Element[] temp = this.getElements(this.modelURL, this.postTitle);

            for (int i= 0; i < temp.length; i ++) {
                this.models[i].setTitle(temp[i].text());
                this.models[i].setLink("https://reddit.com" + articlesTemp[i].attr("permalink"));
                Elements paragraph = articlesTemp[i].select(this.postParagraph);
                if (paragraph.isEmpty()) {
                    String[] tempParagraph = {""};
                    this.models[i].setParagraph(tempParagraph);
                } else {
                    String[] tempParagraph = new String[paragraph.size()];
                    for (int o = 0; o<tempParagraph.length; o++) {
                        tempParagraph[o] = paragraph.get(o).text();
                    }
                    this.models[i].setParagraph(tempParagraph);
                }

                var tempDoc = this.getElements("https://reddit.com" + articlesTemp[i].attr("permalink"), this.postComments);

                var tempFirst = tempDoc[0].select("p");
                String firstComment = "";
                for (var item : tempFirst) {
                    firstComment += item.text() + "\n";
                }
                var tempSecond = tempDoc[1].select("p");
                String secondComment = "";
                for (var item : tempSecond) {
                    secondComment += item.text() + "\n";
                }
                String[] comments = {firstComment, secondComment};

                this.models[i].setComments(comments);


            }
        } catch (Exception _) {
            System.out.println("failed to get title: Models.RedditViewModel.getTitle()");
        }
    }

    public void setSubreddit() {
        try {
            Element[] temp = this.getElements(this.modelURL, this.postSubreddit);

            for (int i= 0; i < temp.length; i ++) {
                this.models[i].setSubreddit(temp[i].text());
            }

        } catch (Exception e) {
            System.out.println("failed to get title: Models.RedditViewModel.getSubreddit()");
        }
    }


    public static void main(String[] args) {
    }
}
