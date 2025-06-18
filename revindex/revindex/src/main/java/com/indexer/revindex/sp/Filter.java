package com.indexer.revindex.sp;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Filter {
    // Set of common stop words (you can expand this list based on your needs)
    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList(
            "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", "any", "are", "aren't", "aren", "as", "at",
            "be", "because", "been", "before", "being", "below", "between", "both", "but", "by", "can", "can't", "cannot", "could", "couldn't",
            "couldnt", "did", "didn't", "didnt", "do", "does", "doesn't", "doesnt", "doing", "don't", "don't", "dont", "down", "during", "each",
            "few", "for", "from", "further", "had", "hadn't", "hadnt", "has", "hasn't", "hasnt", "have", "haven't", "haven", "having", "he", "he's",
            "he", "he'll", "he'll", "her", "here", "here's", "here", "here's", "hers", "herself", "he's", "he'll", "i", "i'm", "i've", "i'll", "i'll",
            "i'd", "i'd", "if", "i'll", "i", "i'll", "is", "isn't", "it", "it'll", "it's", "its", "it'll", "it's", "it'll", "it", "i've", "i'm",
            "let", "let's", "may", "may", "must", "mustn't", "mustnt", "need", "needn't", "neednt", "needn't", "needn't", "not", "of", "off",
            "on", "once", "only", "or", "other", "ought", "oughtn't", "oughtnt", "our", "ours", "ourselves", "out", "over", "own", "same", "shall",
            "shan't", "shan", "shant", "she", "she's", "she", "she'll", "should", "shouldn't", "shouldnt", "so", "so", "some", "such", "than",
            "that", "that's", "that'll", "that", "that's", "that's", "that", "that'll", "the", "the", "than", "that", "the", "this", "to",
            "too", "under", "until", "up", "very", "was", "wasn't", "wasnt", "we", "we're", "we've", "we'll", "we'll", "we'd", "we'd",
            "we'll", "we'll", "we've", "were", "weren't", "werent", "what", "what's", "what", "what's", "what's", "when", "when's", "when",
            "where", "where's", "where", "where's", "which", "while", "why", "why's", "why", "why's", "with", "won't", "won't",
            "won", "won't", "you", "you're", "you've", "you'll", "you'll", "you'd", "you'd", "you'll", "you're", "you'd", "your",
            "yourself", "yourselves", "you", "your", "you'll", "yourself", "yourselves", "your", "you're", "you", "you've", "yours",
            "yourself", "yourselves", "about", "above", "across", "after", "again", "against", "all", "almost", "also", "although", "always",
            "among", "amongst", "amount", "an", "and", "another", "any", "anybody", "anyone", "anything", "anyway", "anyways", "anywhere",
            "are", "aren't", "aren", "aren't", "around", "as", "at", "be", "because", "been", "before", "being", "below", "between", "both",
            "but", "by", "can't", "cannot", "could", "couldn't", "couldnt", "did", "didn't", "didnt", "do", "does", "doesn't", "doesnt",
            "doing", "don't", "don't", "dont", "down", "during", "each", "few", "for", "from", "further", "had", "hadn't", "hadnt", "has",
            "hasn't", "hasnt", "have", "haven't", "haven", "having", "he", "he's", "he", "he'll", "he'll", "her", "here", "here's", "here",
            "here's", "hers", "herself", "he's", "he'll", "how", "how's", "how", "how's", "howsoever", "hereafter", "herein", "hereup",
            "herewith", "he'll", "i", "i'm", "i've", "i'll", "i'll", "i'd", "i'd", "if", "i'll", "i", "i'll", "it", "it'll", "it's", "its",
            "it'll", "it's", "it'll", "it", "i've", "i'm", "let", "let's", "may", "may", "might", "mightn't", "mightnt", "must", "mustn't",
            "mustnt", "need", "needn't", "neednt", "needn't", "needn't", "not", "of", "off", "on", "once", "only", "or", "other", "ought",
            "oughtn't", "oughtnt", "our", "ours", "ourselves", "out", "over", "own", "same", "shall", "shan't", "shan", "shant", "she",
            "she's", "she", "she'll", "should", "shouldn't", "shouldnt", "so", "so", "some", "somebody", "someone", "something", "sometime",
            "somewhere", "such", "than", "that", "that's", "that'll", "that", "that's", "that", "that'll", "the", "the", "than", "that",
            "the", "this", "to", "too", "under", "until", "up", "very", "was", "wasn't", "wasnt", "we", "we're", "we've", "we'll", "we'll",
            "we'd", "we'd", "we'll", "we'll", "we've", "were", "weren't", "werent", "what", "what's", "what", "what's", "what's", "when",
            "when's", "when", "where", "where's", "where", "where's", "which", "while", "why", "why's", "why", "why's", "with", "won't",
            "won't", "won", "won't", "you", "you're", "you've", "you'll", "you'll", "you'd", "you'd", "you'll", "you're", "you'd", "your",
            "yourself", "yourselves", "you", "your", "you'll", "yourself", "yourselves", "your", "you're", "you", "you've", "yours",
            "yourself", "yourselves", "your", "you", "yourself", "yourselves", "yourselves"
    ));


    // Function to filter out stop words and punctuation
    public static String filterContent(String content) {
        if (content == null || content.isEmpty()) {
            return "";
        }

        // Convert content to lowercase
        content = content.toLowerCase();

        // Remove punctuation (non-alphanumeric characters)
        content = content.replaceAll("[^a-zA-Z0-9\\s]", "");

        // Tokenize content into words
        String[] words = content.split("\\s+");

        StringBuilder filteredContent = new StringBuilder();

        for (String word : words) {
            // Skip stop words
            if (!STOP_WORDS.contains(word) && !word.isEmpty()) {
                filteredContent.append(word).append(" ");
            }
        }

        // Return filtered content as a single string
        return filteredContent.toString().trim();
    }
}

