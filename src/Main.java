import java.util.Arrays;
import java.util.HashMap;
import java.util.*;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        //Write a function that determines which companies had no activity for a given number of days
        //Given Dictionary keyed by company and valued by RSS feed url
        //Hint: Some companies can have more than one RSS Feed

        Hashtable<String, List<String>> map = new Hashtable<String, List<String>>();

        //Directly importing Companies and RSS feed urls
        String[] multipleUrls = {"http://www.espn.com/espn/rss/news", "http://www.espn.com/espn/rss/nfl/news",
                "http://www.espn.com/espn/rss/nba/news"};

        map.put("ESPN", Arrays.asList(multipleUrls));
//        map.put("NY Times", "'https://rss.nytimes.com/services/xml/rss/nyt/World.xml'");
//        map.put("Planet Money", "https://www.npr.org/rss/podcast.php?id=510289");

        System.out.println(map);
    }
}