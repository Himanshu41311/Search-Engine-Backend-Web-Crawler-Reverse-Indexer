package com.crawler.service.sp;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class NextUrl {
    public static Set<String> extractNextUrls(Document doc, String baseUrl) {
        Set<String> nextUrls = new HashSet<>();

        // Get all anchor tags with href attribute
        Elements anchorTags = doc.select("a[href]");

        for (Element element : anchorTags) {
            String link = element.attr("href");

            // Skip empty or invalid links
            if (link.isEmpty() || link.startsWith("javascript:") || link.startsWith("#")) {
                continue;
            }

            // Convert relative links to absolute URLs
            String absoluteUrl = resolveUrl(baseUrl, link);
            if (!absoluteUrl.isEmpty()) {
                nextUrls.add(absoluteUrl);
            }
        }

        return nextUrls;
    }
    private static String resolveUrl(String baseUrl, String relativeUrl) {
        try {
            URL base = new URL(baseUrl);
            URL resolved = new URL(base, relativeUrl);
            return resolved.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
