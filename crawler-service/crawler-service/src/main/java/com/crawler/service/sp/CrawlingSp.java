package com.crawler.service.sp;

import com.crawler.service.entity.CrawledPage;
import com.crawler.service.repo.CrawledPageRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class CrawlingSp {

    @Autowired
    private CrawledPageRepository repository;

    public Set<String> crawlAndSave(String url) {
        System.out.println("Crawling link  : " + url);
        try {
            Document doc = Jsoup.connect(url).get();
            Set<String> s = NextUrl.extractNextUrls(doc,url);
            String title = doc.title();
            String content = doc.body().text();

            CrawledPage page = new CrawledPage();
            page.setUrl(url);
            page.setTitle(title);
            page.setContent(content);

            repository.save(page);
            System.out.println("added");
            return s;

        } catch (IOException e) {
            // Handle connection issues or invalid URLs
            e.printStackTrace();
            System.out.println("error");
            return new HashSet<>();
        }
    }
}
