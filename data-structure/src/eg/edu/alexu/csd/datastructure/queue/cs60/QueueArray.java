package eg.edu.alexu.csd.datastructure.queue.cs60;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class QueueArray implements IQueue, IArrayBased {
	Object theArray[];
	int size, max, lastIdx;

	QueueArray(int n) {
		theArray = new Object[10 * n];
		size = 0;
		max = n;
	}

	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if (item == null || size == max)
			throw new RuntimeException("Error");
		if (size == 0) {
			lastIdx = 0;
			theArray[lastIdx] = item;
			size++;
			return;
		}
		theArray[lastIdx + size] = item;
		size++;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (size == 0)
			throw new RuntimeException("Error");
		Object x = theArray[lastIdx];
		theArray[lastIdx] = null;
		lastIdx++;
		size--;
		return x;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
