package the_mass.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        String url = "http://www.zhsme.gov.cn/main/toMainIndex";

        Document document = Jsoup.connect(url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.10 Safari/537.36")
                .get();

        // Jsoup.parse(new URL(url), 3000).select("a");

        //System.out.println(document);

        System.out.println(document.select("title").text());

        Element element = document.selectFirst(".news-list ul li a");
        System.out.println(element.attr("href"));

    }
}
