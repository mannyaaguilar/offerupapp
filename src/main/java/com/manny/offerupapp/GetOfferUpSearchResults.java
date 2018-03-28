package com.manny.offerupapp;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;

@Controller
public class GetOfferUpSearchResults{
    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect("https://offerup.com/#offers").userAgent("Mozilla/59.0.1").get();
            Elements temp =doc.select("div.item-info-title");

            int i=0;
            for(Element titleList:temp)
            {
                i++;
                System.out.println(i+ " "+ titleList.getElementsByTag("a").first().text());
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Document doc = Jsoup.connect("https://offerup.com/#offers").userAgent("Mozilla/59.0.1").get();
            Elements temp2 =doc.select("div.item-info-price");

            int i=0;
            for(Element priceList:temp2)
            {
                i++;
                System.out.println(i+ " "+ priceList.getElementsByAttribute("class").first().text());
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Document doc = Jsoup.connect("https://offerup.com/#offers").userAgent("Mozilla/59.0.1").get();
            Elements temp3 =doc.select("div.item-info-title");

            int i=0;
            for(Element detailsList:temp3)
            {
                i++;
                System.out.println(i+ " "+ detailsList.getElementsByAttribute("href").first());
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
