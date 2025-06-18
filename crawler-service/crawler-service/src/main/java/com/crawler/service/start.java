package com.crawler.service;

import com.crawler.service.sp.CrawlingSp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin()
public class start {

    private static final Logger logger = LoggerFactory.getLogger(start.class);

    @Autowired
    CrawlingSp csp;

    @Autowired
    ResourceLoader resourceLoader;

    @PostMapping("/start")
    public ResponseEntity<String> startCrawling() {
        try {
            // Load seeds.txt from resources
            Resource resource = resourceLoader.getResource("classpath:seeds.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8));

            Set<String> nextUrls = new HashSet<>();
            String url;
            while ((url = reader.readLine()) != null) {
                url = url.trim();
                if (!url.isEmpty()) {
                    logger.info("Starting to crawl seed URL: {}", url);
                    nextUrls.addAll(csp.crawlAndSave(url));
                }
            }
            System.out.println(nextUrls.size());
            StringBuilder responseMessage = new StringBuilder("Crawling started for seeds.Total web site covered is : "+nextUrls.size()+"\n");
            for (String next : nextUrls) {
                responseMessage.append("Next: ").append(next).append("\n");
                csp.crawlAndSave(next);
            }

            return ResponseEntity.ok(responseMessage.toString());
        } catch (Exception e) {
            logger.error("Error while reading seeds or crawling", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
}
