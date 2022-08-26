package com.green.spider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsoupTest {
    /**
     * 获取佩奇电影院的电影
     * @return
     */
    public List<movie> getMovieList() throws IOException {
        List<movie> movieList = new ArrayList<>();
        try {
            // 获取电影资源
            Document document = Jsoup.connect("https://www.peiqi.tv/").get();
            Elements elements = document.select("a[class='module-poster-item module-item']");

            // 封装电影资源
            for (Element element : elements) {
                movie movie = new movie();
                String title = element.attr("title");
                String url = element.attr("href");
                movie.setTitle(title);
                movie.setUrl("https://www.peiqi.tv/"+url);
                movieList.add(movie);
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("获取资源出错：" + e.getMessage());
        }
        // 返回电影资源
        return movieList;
    }
}