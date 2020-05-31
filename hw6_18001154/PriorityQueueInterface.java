package hw6_18001154;

public interface PriorityQueueInterface<K, E> {
	public int size();
	public boolean isEmpty();
	public void insert(Entry<K, E> entry);	//them mot entry vao PQ
	public void insert(K k, E e);			//them mot phan tu co key k va gia tri e vao PQ
	public Entry<K, E> removeMin();			//loai phan tu co gia tri nho nhat
	public Entry<K, E> min();				//tra ve phan tu co key nho nhat

}
