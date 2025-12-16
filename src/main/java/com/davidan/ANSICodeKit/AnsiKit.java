package com.davidan.ANSICodeKit;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class AnsiKit {
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String DIM  = "\u001B[2m";
    public static final String BLUE   = "\u001B[34m";

    public static void print(String text, String color) {
        final String colour = color.replace(" ", "").toLowerCase();
        Ansi ansi = Ansi.ansi();
        ansi = ansi.fgBrightGreen();
        switch (colour) {
            case "red" -> ansi = ansi.fgRed();
            case "blue" -> ansi = ansi.fgBrightBlue();
            case "green" -> ansi = ansi.fgGreen();
            case "yellow" -> ansi = ansi.fgYellow();
            case "cyan" -> ansi = ansi.fgCyan();
            case "magenta" -> ansi = ansi.fgMagenta();
            case "black" -> ansi = ansi.fgBlack();
        }
        System.out.println(ansi.a(text).reset());
    }

    public static void print(String text, String color, String background) {
        Ansi ansi = Ansi.ansi();
        final String colour = color.replace(" ", "").toLowerCase();
        switch (colour) {
            case "red" -> ansi = ansi.fgRed();
            case "blue" -> ansi = ansi.fgBlue();
            case "yellow" -> ansi = ansi.fgYellow();
            case "cyan" -> ansi = ansi.fgCyan();
            case "green" -> ansi = ansi.fgGreen();
        }

        final String bg = background.replace(" ", "").toLowerCase();
        switch (bg) {
            case "red" -> ansi = ansi.bgRed();
            case "yellow" -> ansi = ansi.bgYellow();
            case "cyan" -> ansi = ansi.bgCyan();
            case "green" -> ansi = ansi.bgGreen();
        }

        System.out.println(ansi.a(text).reset());
    }

    public static void print(String text) {
        System.out.println(text);
    }
}
