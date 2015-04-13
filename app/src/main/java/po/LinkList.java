package po;

import java.util.Iterator;

//自定义链表

public class LinkList<E> implements Iterable{
	private class Node<E>{
		Node<E> next;
		E value;

		public Node(E value,Node<E> next){
			this.value=value;
			this.next=next;
		}
        public E getValue(){
            return value;
        }
	}
	private int size=0;
	private Node<E> first;
	private Node<E> last;
	public LinkList(E list[]){
		for(E temp:list)
			insert(temp);
		size=list.length;
	}
	public LinkList(){
		first=null;
		last=null;
	}
	public Node<E> getFirst(){
		return first;
	}
    public Node<E> getLast(){return last;}
    public E getHead(){
        return getFirst().getValue();
    }
    public E getTail(){
        return getLast().getValue();
    }
	public void insert(E e){
		if(first==null){
			first=new Node<E>(e,null);
			last=first;
			size++;
		}
		else{
			last.next=new Node<E>(e,null);
			last=last.next;
			size++;
		}
	}
	public void insert(int index,E e){
		while(index!=0){
			
		}
	}
	public boolean delect(E e){
		if(search(e)==null)return false;
		else{
			Node<E> p=first;
			Node<E> pr=first;
			while(p!=search(e)){
				pr=p;
				p=p.next;
			}
			pr.next=p.next;
			size--;
			return false;
		}
	}
	public Node<E> search(E e){
		Node<E> temp=first;
		while(temp.value!=e&&temp!=null){
			temp=temp.next;
		}
		return temp==null?null:temp;
		
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0?true:false;
	}
	public void makeEmpty(){
		size=0;
		first=null;
		last=null;
	}
    public E getValueAt(int x){
    	Node<E> temp=first;
    	for(int i=0;i<x;i++){
    		temp=temp.next;
    	}
    	return temp.value;
    	
    }
    public void setValueAt(int x,E e){
    	Node<E> temp=first;
    	for(int i=0;i<x;i++){
    		temp=temp.next;
    	}
    	temp.value=e;
    }
    public String toString(){
    	Node<E> temp=first;
    	String result="";
    	while(temp!=null){
    		result=result+","+temp.value.toString();
    		temp=temp.next;
    	}
    	return "#LinkList"+result;
    }



    public Iterator iterator(){
        return new Iterator<E>() {
            int count=0;
            @Override
            public boolean hasNext() {
                return count<size;
            }

            @Override
            public E next() {
                return getValueAt(count++);
            }

            @Override
            public void remove() {

            }
        };}


}
