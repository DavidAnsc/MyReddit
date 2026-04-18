package com.davidan.Models;

import com.davidan.DataFetchKit.DataFetcherWeb;

import org.jsoup.nodes.Element;
import com.davidan.ANSICodeKit.AnsiKit;
import com.davidan.DataFetchKit.dataDealer;
import org.jsoup.select.Elements;

public class RedditViewModel {
    private final String modelURL = "https://www.reddit.com";
    private final String articleDec = "shreddit-post[class*='block relative cursor-pointer']";
    private final String postTitle = "a[id*='post-title-t3']";
    private final String postParagraph = "shreddit-post-text-body" + " " + "p";
    private final String postSubreddit = "a[class*='text-neutral-content whitespace-nowrap']";



    dataDealer dataFetcher;
    public FeedModel[] models;
    Element[] modelElements;

    public RedditViewModel() {
        dataFetcher = new DataFetcherWeb();

        try {
            Element[] temp = this.getElements(this.modelURL, this.postTitle);

            this.models = new FeedModel[temp.length];

            for (int i= 0; i < temp.length; i ++) {
                this.models[i] = new FeedModel("", "", "", "");
            }
        } catch (Exception a){
            this.models = new FeedModel[0];
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
            }
        } catch (Exception a) {
            System.out.println("failed to get title or paragraph or comments: Models.RedditViewModel.getTitle()");
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

    public void getAnswer(String input) {
        input = input.replace(" ", "").toLowerCase();
        try {
            if (input.isEmpty() || input.equals("q")) {
                System.out.println("Exiting...");
                System.exit(0);
            } else if (Integer.parseInt(input) <= this.models.length && Integer.parseInt(input) > -1) {
                FeedModel model;
                if (Integer.parseInt(input) == 0) {
                    System.out.println("You selected post 1");
                    model = this.models[0];
                } else {
                    System.out.println("You selected post " + input);
                    model = this.models[Integer.parseInt(input) - 1];
                }

                System.out.println("\n");
                AnsiKit.complexPrint(model.getFullParagraph());
            } else {
                throw new Exception("invalid input");
            }
        } catch (Exception a) {
            System.out.println("\ninvalid input\n");
        }
    }
}
