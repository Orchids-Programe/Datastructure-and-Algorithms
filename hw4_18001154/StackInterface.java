package hw4_18001154;

public interface StackInterface<E> extends Iterable<E> {
	public void push(E elements);
	public E pop();
	public boolean isEmpty();
	public E top();

	

}
