package com.davidan.Models;

public class FeedModel implements model {
    String title;
    String[] paragraph;
    String subreddit;
    String[] comments;
    String link;
    String imageLink;

    public FeedModel(String title, String subreddit, String[] paragraph, String[] comments, String link, String imageLink) {
        this.title = title;
        this.subreddit = subreddit;
        this.paragraph = paragraph;
        this.comments = comments;
        this.link = link;
        this.imageLink = imageLink;
    }

    public FeedModel(String title, String subreddit, String link, String imageLink) {
        this.title = title;
        this.subreddit = subreddit;
        this.link = link;
        this.imageLink = imageLink;
    }



    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setComments(String[] comments) {
        this.comments = comments;
    }

    @Override
    public void setParagraph(String[] paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    @Override
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public void setLink(String link) {
        this.link = link;
    }




    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String[] getComments() {
        return comments;
    }

    @Override
    public String[] getParagraph() {
        return paragraph;
    }

    @Override
    public String getImageLink() {
        return imageLink;
    }

    @Override
    public String getSubreddit() {
        return subreddit;
    }

    @Override
    public String getLink() {
        return link;
    }


    @Override
    public void getInfo() {

    }


}
