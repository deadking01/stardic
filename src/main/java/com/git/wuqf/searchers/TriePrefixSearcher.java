package com.git.wuqf.searchers;

import com.git.wuqf.Dictionary;
import com.git.wuqf.util.datastructures.TrieMap;

import java.util.List;

/**
 * Created by david on 4/5/15.
 */
public class TriePrefixSearcher {
    protected final Dictionary dictionary;
    private final TrieMap<Object> trie = new TrieMap<>();
    private boolean trieInitialized = false;

    public TriePrefixSearcher(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void ensureTrie() {
        if (!trieInitialized) {
            List<String> words = this.dictionary.getWords();
            for (String word : words) {
                trie.put(word, null);
            }
            trieInitialized = true;
        }
    }

    public List<String> search(String prefix) {
        ensureTrie();
        return trie.prefixSearch(prefix);
    }
}
