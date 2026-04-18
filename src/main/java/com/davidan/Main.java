package com.davidan;
import static com.davidan.ANSICodeKit.AnsiKit.*;

import com.davidan.ANSICodeKit.AnsiKit;
import com.davidan.Models.RedditViewModel;

import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RedditViewModel redditViewModel = new RedditViewModel();
        redditViewModel.setTitleNPara();
        redditViewModel.setSubreddit();


        for (var model : redditViewModel.models) {
            complexPrint(DIM + model.getSubreddit() + DIM + RESET);
            complexPrint(BLUE + BOLD + model.getTitle() + BOLD + BLUE + RESET);

            complexPrint(model.getNormalParagraph());

            complexPrint("Link: " + model.getLink(), "yellow");
            complexPrint(BOLD + "\n----------------------\n" + BOLD + RESET, "cyan");
        }

        while (true) {
            final var input = scan(scanner);
            redditViewModel.getAnswer(input);
        }
    }
}
