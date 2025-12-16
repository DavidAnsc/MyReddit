package com.davidan.ANSICodeKit;

import org.fusesource.jansi.Ansi;

public class AnsiKit {
    public static void print(String text, String color) {
        final String colour = color.replace(" ", "").toLowerCase();
        if (colour.equals("red")) {
            System.out.println(
                    Ansi.ansi().fgRed().a("the text is red").reset()
            );
        } else if (colour.equals("blue")) {
            System.out.println(
                    Ansi.ansi().fgBlue().a("the text is red").reset()
            );
        } else if (colour.equals("green")) {
            System.out.println(
                    Ansi.ansi().fgGreen().a("the text is red").reset()
            );
        } else {
            System.out.println(text);
        }
    }

    public static void print(String text, String color, String background) {
        var item = Ansi.ansi();
        final String colour = color.replace(" ", "").toLowerCase();
        switch (colour) {
            case "red" -> item.fgRed();
            case "blue" -> item.fgBlue();
            case "yellow" -> item.fgYellow();
            case "cyan" -> item.fgCyan();
            case "green" -> item.fgGreen();
        }

        switch (background) {
            case "red" -> item.bgRed();
            case "yellow" -> item.bgYellow();
            case "cyan" -> item.bgCyan();
            case "blue" -> item.bgBrightCyan();
            case "green" -> item.bgGreen();
        }

        System.out.println(
                item.a(text).reset()
        );
    }

    public static void print(String text) {
        System.out.println(text);
    }
}
