🔍 Search Engine with Web Crawler & Reverse Indexer
A modular search engine project built in Java using Spring Boot and PostgreSQL. It consists of two core components:

A Web Crawler that extracts clean textual data from websites.

A Reverse Indexer that indexes the crawled data for efficient keyword-based search.

🧠 Features
🌐 Web Crawler: Recursively visits URLs and extracts content using JSoup

🧾 Content Cleaning: Filters out JavaScript-heavy, duplicate, or irrelevant pages

❌ Stop Word Removal: Removes common stop words to improve search relevance

📚 Reverse Indexing: Maps keywords to URLs/documents for fast lookup

💾 PostgreSQL Integration: Stores index entries persistently

🔍 Search API: Allows users to query and retrieve matching documents

🏗️ Tech Stack
Languages: Java

Frameworks: Spring Boot

Libraries: JSoup (for HTML parsing)

Database: PostgreSQL

Tools: Maven, Git

⚙️ Modules
1. crawler/
A Spring Boot application that accepts seed URLs, crawls linked pages, and sends parsed content to the indexer.

2. revindex/
A Java-based reverse indexing system that tokenizes content, removes stop words, stores keyword mappings, and handles user search queries.

🚀 How It Works
Start the crawler with seed URLs.

It extracts clean text from pages and passes it to the indexer.

The indexer removes stop words and updates the reverse index in PostgreSQL.

When a user enters a query, relevant pages are returned based on indexed keywords.

📌 Use Cases
Building custom search engines

Learning about crawling, indexing, and search ranking

Practicing backend development with Spring Boot and PostgreSQL

