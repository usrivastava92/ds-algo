package az.practice;

import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SearchSuggestionsSystem {

    public static void main(String[] args) {
        String[][] products = {{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, {"havana"}, {"bags", "baggage", "banner", "box", "cloths"}, {"havana"}};
        String[] searchWords = {"mouse", "havana", "bags", "tatiana"};
        String[][][] outputs = {{{"mobile", "moneypot", "monitor"}, {"mobile", "moneypot", "monitor"}, {"mouse", "mousepad"}, {"mouse", "mousepad"}, {"mouse", "mousepad"}}, {{"havana"}, {"havana"}, {"havana"}, {"havana"}, {"havana"}, {"havana"}}, {{"baggage", "bags", "banner"}, {"baggage", "bags", "banner"}, {"baggage", "bags"}, {"bags"}}, {{}, {}, {}, {}, {}, {}, {}}};
        SearchSuggestionsSystem searchSuggestionsSystem = new SearchSuggestionsSystem();
        IntStream.range(0, products.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(products[i]) + " searchWord : " + searchWords[i]);
            List<List<String>> output = searchSuggestionsSystem.suggestedProducts(products[i], searchWords[i]);
            System.out.println("Output : " + output);
            System.out.println("Expected : " + Arrays.deepToString(outputs[i]));
            Assert.assertEquals(ArrayUtils.asList(outputs[i]), output);
        });
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (searchWord == null) {
            return Collections.emptyList();
        }
        List<List<String>> ans = new ArrayList<>();
        SortedTrie trie = new SortedTrie();
        for (String product : products) {
            trie.add(product.toCharArray());
        }
        int len = searchWord.length();
        for (int i = 0; i < len; i++) {
            ans.add(trie.get(searchWord.substring(0, i + 1), 3));
        }
        return ans;
    }

    private static final class SortedTrie {

        private char data;
        private final SortedTrie[] charArr;
        private boolean isLeaf;

        public SortedTrie() {
            this.charArr = new SortedTrie[26];
        }


        public SortedTrie(char data) {
            this.data = data;
            this.charArr = new SortedTrie[26];
        }

        public void add(char[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }
            SortedTrie curr = this;
            for (int i = 0; i < arr.length; i++) {
                char element = arr[i];
                int index = arr[i] - 'a';
                if (curr.charArr[index] == null) {
                    curr.charArr[index] = new SortedTrie(element);
                }
                curr = curr.charArr[index];
                if (i == arr.length - 1) {
                    curr.isLeaf = true;
                }
            }
        }

        public List<String> get(String prefix, int limit) {
            SortedTrie curr = this;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (curr.charArr[index] == null) {
                    return Collections.emptyList();
                }
                curr = curr.charArr[index];
            }
            List<String> ans = new ArrayList<>();
            get(curr, prefix, ans, limit);
            StringBuilder sb = new StringBuilder();
            return ans;
        }

        public void get(SortedTrie trie, String path, List<String> list, final int limit) {
            if (trie.isLeaf) {
                if (list.size() >= limit) {
                    return;
                }
                list.add(path);
            }
            for (int i = 0; i < 26; i++) {
                if (trie.charArr[i] != null) {
                    get(trie.charArr[i], path + trie.charArr[i].data, list, limit);
                }
            }
        }

    }

}
