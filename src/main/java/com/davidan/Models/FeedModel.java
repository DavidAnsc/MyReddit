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


    public String getNormalParagraph() {
        if (this.paragraph[0].replace(" ", "").isBlank()) {
            return "";
        }
        String paragraphTemp = this.paragraph[0];
        var temp = paragraphTemp.substring(0, Math.min(this.paragraph[0].length(), 200));

        for (int x = temp.length(); x > -1; x--) {
            if (paragraphTemp.charAt(x) == ' ') {
                return paragraphTemp.substring(0, x) + "...";
            }
        }

        return "";

    }

    public String getFullParagraph() {
        StringBuilder fullPara = new StringBuilder();
        final var paraTemp = this.paragraph[0];
        if (paraTemp.isBlank()) {
            return "NO PARAGRAPH AVAILABLE";
        }
        for (String para : this.paragraph) {
            fullPara.append(para).append("\n\n");
        }
        return fullPara.toString();
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
