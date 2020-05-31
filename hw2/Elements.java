package hw2;


public class Elements implements Comparable<Elements>{
		private int a;
		public Elements() {
		}

		public Elements(int a) {
			super();
			this.a = a;
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		@Override
		public int compareTo(Elements elements) {
			int n = 0;
			if(this.a < (elements).getA()) {
				n = -1;
			}
			if (this.a > ( elements).getA()) {
				n = 1;
			}
			return n;
		}

		@Override
		public String toString() {
			return " " + a + " ";
		}
		
		

}
