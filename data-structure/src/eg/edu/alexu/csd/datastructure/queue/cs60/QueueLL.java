package eg.edu.alexu.csd.datastructure.queue.cs60;

import eg.edu.alexu.csd.datastructure.linkedList.cs60_75.DoubleLinkedList;
import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 * @author Mohamed Mashaal.
 *
 */
public class QueueLL implements IQueue, ILinkedBased {
  /**
   * the DLL Used.
   */
  private DoubleLinkedList list = new DoubleLinkedList();

  @Override
  public void enqueue(final Object item) {
    // TODO Auto-generated method
    // stub
    list.add(0, item);
  }

  @Override
  public Object dequeue() {
    // TODO Auto-generated method
    // stub
    final Object x = list.get(list.size() - 1);
    list.remove(list.size() - 1);
    return x;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method
    // stub
    if (list.size() == 0) {
      return true;
    }
    return false;
  }

  @Override
  public int size() {
    // TODO Auto-generated method
    // stub
    return list.size();
  }

}
