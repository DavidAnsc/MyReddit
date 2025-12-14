package com.davidan;
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi;
import com.davidan.Models.RedditViewModel;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RedditViewModel redditViewModel = new RedditViewModel();
        redditViewModel.setTitleNPara();
        redditViewModel.setSubreddit();
        System.out.println(
                Ansi.ansi().fgRed().a("the text is red").reset()
        );
//        AnsiConsole.out().println("");
    }
}
