package com.indexer.revindex;

import com.indexer.revindex.sp.start;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RevindexApplication {
	public static void main(String[] args) {
		SpringApplication.run(RevindexApplication.class, args);
	}

}
