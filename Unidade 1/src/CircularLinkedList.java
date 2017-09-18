import java.util.ListIterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<Item> implements Iterable<Item>{
  private int n;
  private Node vigia;

  private class Node {
    private Item item;
    private Node ant;
    private Node prox;
  }
  public CircularLinkedList(){
    n = 0;
    vigia = new Node();
    vigia.ant =vigia;
    vigia.prox = vigia;
  }
  public boolean isEmpty(){
    return n == 0;
  }
  public int size(){
    return n;
  }
  public void add(Item i){
    Node last = vigia.ant;
    Node x = new Node();
    x.item = i;
    x.prox = vigia;
    x.ant = last;
    vigia.ant = x;
    last.prox = x;
    n ++;
  }
  public ListIterator<Item> iterator(){
    return new CircularLinkedListIterator();
  }
  private class CircularLinkedListIterator implements ListIterator<Item>{
    private Node current = vigia.prox;
    private Node lastAcessed = null;
    private int index = 0;

    public boolean hasNext(){
      return index < n;
    }
    public boolean hasPrevious(){
      return index > 0;
    }
    public int previousIndex(){
      return index - 1;
    }
    public int nextIndex(){
      return index;
    }
    public Item next(){
      if(!hasNext()) throw new NoSuchElementException();
      lastAcessed = current;
      Item p = current.item;
      current = current.prox;
      index ++;
      return p;
    }
    public Item previous(){
      if(!hasPrevious()) throw new NoSuchElementException();
      current = current.ant;
      index --;
      lastAcessed = current;
      return current.item;
    }
    public void set(Item item){
      if(lastAcessed == null) throw new IllegalStateException();
      lastAcessed.item = item;
    }
    public void remove(){
      if(lastAcessed == null) throw new IllegalStateException();
      Node x = lastAcessed.prox;
      Node y = lastAcessed.ant;
      y.prox = x;
      x.ant = y;
      n--;
      if(lastAcessed == current) current = x;
      else index --;
      lastAcessed = null;
    }
    public void add(Item item){
      Node z = current;
      Node x = current.ant;
      Node y = new Node();
      y.item = item;
      y.prox = z;
      y.ant = x;
      z.ant = y;
      x.prox = y;
      n ++;
      index ++;
      lastAcessed = null;
      }
    }
    public String toString(){
      StringBuilder s = new StringBuilder();
      for(Item i : this){
        s.append(i + " ");
      }
      return s.toString();
    }
}
