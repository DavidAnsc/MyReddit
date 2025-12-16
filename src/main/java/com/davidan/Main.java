package com.davidan;
import static com.davidan.ANSICodeKit.AnsiKit.*;
import com.davidan.Models.RedditViewModel;
import org.fusesource.jansi.Ansi;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RedditViewModel redditViewModel = new RedditViewModel();
        redditViewModel.setTitleNPara();
        redditViewModel.setSubreddit();

//        var object = new Ansi();
//        object = object.fgBrightMagenta();
//        for (int i = 0; i < 50; i++) {
//            System.out.println(object.a("hello; hello").reset());
//        }

        for (var model : redditViewModel.models) {
            System.out.println(DIM + model.getSubreddit() + DIM + RESET);
            print(BLUE + BOLD + model.getTitle() + BOLD + BLUE + RESET);
            if (!model.getParagraph()[0].replace(" ", "").isBlank()) {
                for (var para : model.getParagraph()) {
                    print(para);
                    System.out.println();
                }
            }

            print("Link: " + model.getLink(), "yellow");
            print(BOLD + "\n----------------------\n" + BOLD + RESET, "cyan");
        }
    }
}
