package com.indexer.revindex.sp;

import com.indexer.revindex.entity.CrawledPage;
import com.indexer.revindex.entity.RevData;
import com.indexer.revindex.entity.WordUrlInfo;
import com.indexer.revindex.repo.CrawledPageRepository;
import com.indexer.revindex.repo.RevIndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin()
public class start {
    @Autowired
    CrawledPageRepository crawledPageRepository;
    @Autowired
    RevIndexRepository rp;
    @GetMapping("/begin")
    public void star(){
        for(CrawledPage cp : crawledPageRepository.get_Data()){
            String st = Filter.filterContent(cp.getContent());
            System.out.println(st);
            indexer(st, cp.getUrl(),1);
            indexer(st,Filter.filterContent (cp.getTitle()), 0);

            cp.setIndexed(true);
            crawledPageRepository.save(cp);
        }
    }
    public void indexer(String st, String url, int number) {
        String[] words = st.split("\\s+");
        HashMap<String, Double> freqMap = new HashMap<>();

        for (String s : words) {
            freqMap.put(s, freqMap.getOrDefault(s, 0.0) + 1.0 / words.length);
        }

        for (String word : freqMap.keySet()) {
            add(word, url, number, freqMap.get(word));
        }
    }
    public void add(String word, String url, int number, double count) {
        RevData rd = rp.findById(word).orElse(new RevData(word));

        // Check if WordUrlInfo for this url and number exists
        WordUrlInfo existingInfo = null;
        for (WordUrlInfo wui : rd.getWordUrlInfoList()) {
            if (wui.getUrl().equals(url) && wui.getNumberValue() == number) {
                existingInfo = wui;
                break;
            }
        }

        if (existingInfo != null) {
            existingInfo.setDoubleValue(existingInfo.getDoubleValue() + count);
        } else {
            WordUrlInfo wui = new WordUrlInfo(rd, url, number, count);
            rd.getWordUrlInfoList().add(wui);
        }

        rp.save(rd);
    }
}
