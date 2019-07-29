import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.*;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("ESPN Publish Dates");
        System.out.println(readRSS("https://www.espn.com/espn/rss/news"));
        System.out.println("=======================" + "\n");
        System.out.println("NY Times Publish Dates");
        System.out.println(readRSS("https://rss.nytimes.com/services/xml/rss/nyt/World.xml"));

        //Write a function that determines which companies had no activity for a given number of days
        //Given Dictionary keyed by company and valued by RSS feed url
        //Hint: Some companies can have more than one RSS Feed

        Hashtable<String, List<String>> map = new Hashtable<>();

        //Directly importing Companies and RSS feed urls
        String[] multipleUrls = {"http://www.espn.com/espn/rss/news", "http://www.espn.com/espn/rss/nfl/news",
                "http://www.espn.com/espn/rss/nba/news"};
        String[] singleUrl = {"https://rss.nytimes.com/services/xml/rss/nyt/World.xml"};

        map.put("ESPN", Arrays.asList(multipleUrls));
        map.put("NY Times", Arrays.asList(singleUrl));
//        map.put("Planet Money", "https://www.npr.org/rss/podcast.php?id=510289");

        System.out.println("ESPN RSS Feeds:" + map.get("ESPN"));
        System.out.println("NY Times RSS Feeds:" + map.get("NY Times"));
//        System.out.println(map.get("ESPN"));

//        System.out.println(map.values());
        //Prints the first element in the list
//        System.out.println(multipleUrls[1]);
    }


    @Nullable
    public static String readRSS(String urlAddress){
        try {
            URL rssUrl = new URL(urlAddress);
            //openStream() to get a stream from which you can read the contents of the URL
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
            System.out.println(in);
            String pubDate = "";
            String line;
            while ((line = in.readLine()) != null) {
                int dateEndIndex = 0;
                int dateStartIndex = 0;
                while (dateStartIndex >= 0) {
                    dateStartIndex = line.indexOf("<pubDate>", dateEndIndex);
                    if (dateStartIndex >= 0) {
                        dateEndIndex = line.indexOf("</pubDate>", dateStartIndex);
                        pubDate += line.substring(dateStartIndex + "<pubDate>".length(), dateEndIndex) + "\n";
                    }
                }
            }
            in.close();
            return pubDate;
        } catch (MalformedURLException ue){
            System.out.println("Malformed URL");
        } catch (IOException ioe){
            System.out.println("Something went wrong");
        }
        return null;
    }

}

