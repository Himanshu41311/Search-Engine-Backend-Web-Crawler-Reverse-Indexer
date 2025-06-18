package com.crawler.service.repo;//cc

import com.crawler.service.entity.CrawledPage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrawledPageRepository extends JpaRepository<CrawledPage, Long> {
    // You can add custom queries if needed
}
