package com.company;

        import java.util.Scanner;
        import java.io.*;
        import java.io.IOException;
        import org.jsoup.Jsoup;
        import org.jsoup.nodes.Document;
        import org.jsoup.nodes.Element;
        import org.jsoup.select.Elements;


public class Main {

    public static void main(String[] args)throws IOException  {
        Grabber grab = new Grabber();
        grab.StartScan();
        System.out.println("done!");
        //Scanner reader = new Scanner(System.in);
        //System.out.println("Give a game: ");
        //String game = reader.next();

        //System.out.println(d.body().text());
        //Document d=Jsoup.connect("http://store.steampowered.com/app/" + url + "/").cookie("mature_content", "1").cookie("birthtime","0").get();
        //        Document d= Jsoup.connect("https://overrustlelogs.net/Forsen%20chatlog/April%202015/2015-04-14.txt").get();
        //String[] prices = d.select("div.col.search_price.responsive_secondrow").first().text().split("\\s");
       // System.out.println(prices[prices.length-1]);
        //System.out.println(d);
    }
}