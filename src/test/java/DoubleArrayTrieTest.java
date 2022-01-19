import darts.DoubleArrayTrie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DoubleArrayTrieTest {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./small.dic"));
        String line;
        List<String> words = new ArrayList<>();
        Set<Character> charset = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            words.add(line);
            // 制作一份码表debug
            for (char c : line.toCharArray()) {
                charset.add(c);
            }
        }
        reader.close();

        // 这个字典如果要加入新词必须按字典序，参考下面的代码
        /*Collections.sort(words);
        BufferedWriter writer = new BufferedWriter(new FileWriter("./data/sorted.dic", false));
        for (String w : words) {
            writer.write(w);
            writer.newLine();
        }*/

        System.out.println("字典词条：" + words.size());

        StringBuilder infoCharsetValue = new StringBuilder();
        for (Character c : charset) {
            infoCharsetValue.append(c.charValue()).append("[").append((int) c).append("] ");
        }

        System.out.println(infoCharsetValue + "\n");

        DoubleArrayTrie dat = new DoubleArrayTrie();
        System.out.println("是否错误: " + dat.build(words));

        List<Integer> integerList = dat.commonPrefixSearch("一举成名天下知");
        for (int index : integerList) {
            System.out.println(words.get(index));
        }
    }
}
