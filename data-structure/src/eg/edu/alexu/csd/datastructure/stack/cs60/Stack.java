package eg.edu.alexu.csd.datastructure.stack.cs60;

import eg.edu.alexu.csd.datastructure.linkedList.cs60_75.DoubleLinkedList;
import eg.edu.alexu.csd.datastructure.stack.IStack;

public class Stack implements IStack {
	private DoubleLinkedList List = new DoubleLinkedList();

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		List.add(index, element);
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		Object x = List.get(List.size() - 1);
		List.remove(List.size() - 1);
		return x;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return List.get(List.size() - 1);
	}

	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
		List.add(element);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (List.size() == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return List.size();
	}

}
