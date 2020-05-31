package hw5_18001154;

public interface BinaryTreeInterface<E> {
	E root();		//E là vị trí 
	int size();		//number of node in tree
	boolean isEmpty();
	int numChildren(E p); 	//number of children of element p
							//chỉ có từ 0-2 con
	E parent(E p); 	//return parent of p
	E left(E p); 	//return left child of p
	E right(E p); 	//return right child of p
	E sibling(E p);	//return sibling of p
}
