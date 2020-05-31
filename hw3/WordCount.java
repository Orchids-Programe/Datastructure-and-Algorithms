package hw3;

public class WordCount extends LinkedList<WordCount>{
	private String word = null;
	private int count =0;
	public WordCount(String word) {
		this.word = word;
		this.count = 1;
	}

	public WordCount(String word, int count) {
		super();
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		WordCount other = (WordCount) obj;
		return this.word.equals(other.word);
	}

	@Override
	public String toString() {
		return "WordCount [" + word + "=" + count + "]";
	}
	
}
