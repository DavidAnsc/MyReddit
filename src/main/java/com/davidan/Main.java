package com.davidan;
import static com.davidan.ANSICodeKit.AnsiKit.*;
import com.davidan.Models.RedditViewModel;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RedditViewModel redditViewModel = new RedditViewModel();
        redditViewModel.setTitleNPara();
        redditViewModel.setSubreddit();

        for (var model : redditViewModel.models) {
            print(model.getSubreddit(), "yellow");
            print(model.getTitle());
            for (var para : model.getParagraph()) {
                print("| " + para);
                print("");
            }

            print("Link: " + model.getLink(), "cyan");
            System.out.println("\n----------------------\n");
        }
    }
}
