package com.git.wuqf;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.zip.DataFormatException;

public class Main {

    public static void main(String[] args) throws IOException, DataFormatException {
	    Dictionary dictionary = Dictionary.fromIfo("C:\\dic\\stardict-oxford-gb-2.4.2\\oxford-gb.ifo");

        String[] words = new String[] {
                "cat",
                "main"
        };
        for (String word : words) {
            long start = System.nanoTime();
            List<String> res = dictionary.searchForWord(word);
            List<String> defines=dictionary.getDefinitions(word);
            long duration = (System.nanoTime() - start) / 1000000;
            System.out.println(String.format("That took %d ms", duration));
        }

        System.out.println();
    }
}
