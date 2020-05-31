package hw3;

import java.io.BufferedReader;
import java.io.FileReader;

public class WordCountEx {
	public static void main(String[] args) throws Exception{
		SimpleArrayList<WordCount> wordcounts = new SimpleArrayList<WordCount>();
		FileReader file = new FileReader("E:\\Java Code\\Code\\src\\hw3\\text.txt");
		BufferedReader bf = new BufferedReader(file);
		int data;
		String tmp = "";
		while((data = bf.read()) != -1) {
			if(data == (int)(' ')) {
				WordCount x = new WordCount(tmp);
				if(wordcounts.isContain(x)) {
					int index= wordcounts.indexOf(x);
					x = wordcounts.get(index);
					x.setCount(x.getCount() + 1);
					wordcounts.set(index, x);
				}
				else {
					wordcounts.add(x);
				}
				tmp = "";
			}
			else {
				tmp = tmp + (char)data;
			}
		}
		bf.close();
		file.close();
		for(WordCount x : wordcounts) {
			System.out.println(x.toString());
		}
	}

}
