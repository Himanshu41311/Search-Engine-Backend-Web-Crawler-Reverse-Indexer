package com.indexer.revindex.repo;

import com.indexer.revindex.entity.CrawledPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CrawledPageRepository extends JpaRepository<CrawledPage, Long> {
    @Query(value = "SELECT * FROM crawled_pages cp WHERE cp.indexed = false ORDER BY cp.created_at ASC LIMIT 10", nativeQuery = true)
    public List<CrawledPage> get_Data();
}
