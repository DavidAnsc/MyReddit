package com.davidan.Models;

public interface model {
    void setTitle(String title);
    void setSubreddit(String subreddit);
    void setParagraph(String[] paragraph);
    void setComments(String[] comments);
    void setLink(String link);
    void setImageLink(String imageLink);

    void getInfo();
    String getTitle();
    String[] getComments();
    String[] getParagraph();
    String getImageLink();
    String getSubreddit();
    String getLink();
}
