package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Grabber {
    public FileWriter writer;
    public String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    public String[] years = {"2015","2016","2017","2018"};
    public void InitFile()
    {

        try{
            //char buffer[] = new char[str.length()];
            //str.getChars(0, str.length(),buffer,0);
            writer = new FileWriter("bajlist.txt",true);


        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void WriteToFile(String str)
    {
        System.out.println("Now Writing everything.");
        try {
            writer.write(str);
            writer.flush();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void CleanUp()throws IOException
    {
        writer.close();
    }
    public void Scan(String month,String year, int monthI, int day)
    {
        System.out.println("Scanning!https://overrustlelogs.net/Forsen%20chatlog/"+month+"%20"+year+"/"+year+"-"+monthI+"-"+day+".txt");
        try{
            Document d;
            if(day < 10 && monthI < 10)
                d= Jsoup.connect("https://overrustlelogs.net/Forsen%20chatlog/"+month+"%20"+year+"/"+year+"-0"+monthI+"-0"+day+".txt").get();
            else if(day < 10)
                d= Jsoup.connect("https://overrustlelogs.net/Forsen%20chatlog/"+month+"%20"+year+"/"+year+"-"+monthI+"-0"+day+".txt").get();
            else if (monthI < 10)
                d= Jsoup.connect("https://overrustlelogs.net/Forsen%20chatlog/"+month+"%20"+year+"/"+year+"-0"+monthI+"-"+day+".txt").get();
            else
                d= Jsoup.connect("https://overrustlelogs.net/Forsen%20chatlog/"+month+"%20"+year+"/"+year+"-"+monthI+"-"+day+".txt").get();
            String info = d.body().text();
            WriteToFile(info);
        }catch(Exception e)
        {
            System.out.println("This date doesnt exist!");
        }
    }

    public void StartScan()throws IOException
    {
        InitFile();
        for(int year = 0; year < years.length;year++)
        {
            for(int month = 0; month< months.length; month++){
                for(int day = 1; day <= 31;day++)
                {
                    Scan(months[month],years[year],month+1,day);
                }
            }
        }

        CleanUp();
        System.out.println("Finished");
    }

}