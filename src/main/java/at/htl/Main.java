package at.htl;

import org.apache.log4j.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class.getSimpleName());
    public static void main(String[] args) {
        String url = "https://en.wikipedia.org/";
        parsehtml(url);
    }

    public static void parsehtml(String url){
        try {
            Document doc = Jsoup.connect(url).get();
            logger.info(doc.title());
            Elements newsHeadlines = doc.select("#mp-itn b a");
            for (Element headline : newsHeadlines) {
                System.out.printf("%s\n\t%s",
                        headline.attr("title"), headline.absUrl("href"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
