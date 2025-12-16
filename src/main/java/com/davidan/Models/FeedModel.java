package com.davidan.Models;

public class FeedModel {
    String title;
    String[] paragraph;
    String subreddit;
    String link;
    String imageLink;

    public FeedModel(String title, String subreddit, String[] paragraph, String link, String imageLink) {
        this.title = title;
        this.subreddit = subreddit;
        this.paragraph = paragraph;
        this.link = link;
        this.imageLink = imageLink;
    }

    public FeedModel(String title, String subreddit, String link, String imageLink) {
        this.title = title;
        this.subreddit = subreddit;
        this.link = link;
        this.imageLink = imageLink;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public void setParagraph(String[] paragraph) {
        this.paragraph = paragraph;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public void setLink(String link) {
        this.link = link;
    }




    public String getTitle() {
        return title;
    }


    public String[] getParagraph() {
        return paragraph;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public String getLink() {
        return link;
    }


    public void getInfo() {

    }


}
