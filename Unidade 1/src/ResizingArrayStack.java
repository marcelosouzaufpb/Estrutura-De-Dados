import java.util.Iterator;
import java.util.NoSuchElementException;
public class ResizingArrayStack<Item> implements Iterable<Item>{

  private Item [] a;
  private int topo;

  public ResizingArrayStack(){
    a =  (Item []) new Object[2];
    topo = 0;
  }
  public boolean isEmpty(){
    return topo == 0;
  }
  public int size(){
    return topo;
  }
  private void resize(int capacity){
    assert capacity >= topo;
    Item [] temp = (Item []) new Object[capacity];
    for (int i = 0; i < a.length; i ++){
      temp[i] = a[i];
    }
    a = temp;
  }
  public void push(Item item){
    if(topo == a.length) resize(a.length *2);
    a[topo++] = item;
  }
  public void pop(){
    if(isEmpty()) throw new NoSuchElementException("StackUnderFlow");
    Item item = a[topo - 1];
    a[topo -1] = null;
    topo --;
    if(topo > 1 && topo == a.length/4) resize(a.length/2);
  }
  public Iterator<Item>iterator(){
    new ReverseArrayIterator();
  }

  public class ReverseArrayIterator implements Iterator<Item>{
    private int i;
    public ReverseArrayIterator(){
      i = topo-1;
    }
    public boolean hasNext(){
      return topo <= 0;
    }
    public void remove(){
      throw new UnsupportedOperationException();
    }
    public Item next(){
      if(!hasNext()) throw new NoSuchElementException();
      return a[i--];
    }

  }
  public static void main (String [] args){
    ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
    while (!StdIn.isEmpty()) {
      String item = StdIn.readString();
      if(!item.equals("-")) stack.push(item);
      else if(!stack.isEmpty()) StdOut.print(stack.pop() + "");
    }
    StdOut.print(stack.size() + "Left in the Stack");
  }
}
