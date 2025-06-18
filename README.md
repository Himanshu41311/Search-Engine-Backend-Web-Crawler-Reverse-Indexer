<h1>🔍 Search Engine with Web Crawler & Reverse Indexer</h1>

<p>
  A modular search engine project built in <strong>Java</strong> using <strong>Spring Boot</strong> and <strong>PostgreSQL</strong>. 
  It consists of two core components:
</p>
<ul>
  <li><strong>Web Crawler</strong>: Extracts clean textual data from websites.</li>
  <li><strong>Reverse Indexer</strong>: Indexes the crawled data for efficient keyword-based search.</li>
</ul>

<h2>🧠 Features</h2>
<ul>
  <li>🌐 <strong>Web Crawler</strong>: Recursively visits URLs and extracts content using JSoup</li>
  <li>🧾 <strong>Content Cleaning</strong>: Filters out JavaScript-heavy, duplicate, or irrelevant pages</li>
  <li>❌ <strong>Stop Word Removal</strong>: Removes common stop words to improve search relevance</li>
  <li>📚 <strong>Reverse Indexing</strong>: Maps keywords to URLs/documents for fast lookup</li>
  <li>💾 <strong>PostgreSQL Integration</strong>: Stores index entries persistently</li>
  <li>🔍 <strong>Search API</strong>: Allows users to query and retrieve matching documents</li>
</ul>

<h2>🏗️ Tech Stack</h2>
<ul>
  <li><strong>Languages</strong>: Java</li>
  <li><strong>Frameworks</strong>: Spring Boot</li>
  <li><strong>Libraries</strong>: JSoup (for HTML parsing)</li>
  <li><strong>Database</strong>: PostgreSQL</li>
  <li><strong>Tools</strong>: Maven, Git</li>
</ul>

<h2>⚙️ Modules</h2>

<h3>1. <code>crawler/</code></h3>
<p>A Spring Boot application that accepts seed URLs, crawls linked pages, and sends parsed content to the indexer.</p>

<h3>2. <code>revindex/</code></h3>
<p>A Java-based reverse indexing system that tokenizes content, removes stop words, stores keyword mappings, and handles user search queries.</p>

<h2>🚀 How It Works</h2>
<ol>
  <li>Start the crawler with seed URLs.</li>
  <li>It extracts clean text from pages and passes it to the indexer.</li>
  <li>The indexer removes stop words and updates the reverse index in PostgreSQL.</li>
  <li>When a user enters a query, relevant pages are returned based on indexed keywords.</li>
</ol>

<h2>📌 Use Cases</h2>
<ul>
  <li>Building custom search engines</li>
  <li>Learning about crawling, indexing, and search ranking</li>
  <li>Practicing backend development with Spring Boot and PostgreSQL</li>
</ul>
