package com.company;

import java.io.Serializable;
import java.util.*;

public class MyLinkedList<E>
        extends AbstractSequentialList<E>
        implements List<E>, Deque<E>, Cloneable, Serializable {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedList() {
        size=0;
    }

    public MyLinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    private class Node<E> implements Serializable {
        Node<E> previous;
        Node<E> next;
        E item;

        Node(Node<E> previous, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.previous = previous;
            if(previous!=null){
                previous.next = this;
            }
            if(next!=null){
                next.previous = this;
            }
        }

    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements ListIterator<E> {
        private Node<E> next;
        private Node<E> lastReturned;

        MyListIterator() {
            next = first;
            lastReturned = next;
        }

        MyListIterator(int index){
            next = size==0?null:node(index);
            lastReturned = next;
        }

        @Override
        public boolean hasNext() {
            return next!=null;
        }

        @Override
        public E next() {
            lastReturned = next;
            E e = next.item;
            next = next.next;
            return e;
        }

        @Override
        public boolean hasPrevious() {
            return next!= null;
        }

        @Override
        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            lastReturned = next;
            E e = next.item;
            next = next.previous;
            return e;
        }

        @Override
        public int nextIndex() {
            return indexOf(next);
        }

        @Override
        public int previousIndex() {
            return indexOf(lastReturned);
        }

        @Override
        public void remove() {
            unlink(lastReturned);
        }

        @Override
        public void set(E e) {
            next.item = e;
        }

        @Override
        public void add(E e) {
            if (lastReturned == null)
                linkLast(e);
            else
                linkBefore(e, lastReturned);
        }
    }

    private void linkBefore(E e, Node<E> current) {
        final Node<E> prev = current.previous;
        final Node<E> newNode = new Node<>(prev, e, current);
        current.previous = newNode;
        if (prev == null)
            first = newNode;
        else
            prev.next = newNode;
        size++;
    }


    private void linkFirst(E e) {
        if(size==0){
            first = new Node<E>(null,e,null);
        }else{
            first = new Node<>(null,e,first);
        }
        size++;
    }

    private void linkLast(E e) {
        final Node<E> exLast = last;
        final Node<E> newNode = new Node<>(exLast, e, null);
        last = newNode;
        if (exLast == null)
            first = newNode;
        else
            exLast.next = newNode;
        size++;
    }

    private E unlink(Node<E> node) {
        if (node == null)
            throw new NoSuchElementException();
        final E e = node.item;
        Node<E> next = node.next;
        Node<E> previous = node.previous;
        if(node==first){
            first=next;
            first.previous = null;
        }else if(node==last){
            last=previous;
            last.next=null;
        }else{
            next.previous = previous;
            previous.next = next;
        }
        size--;
        return e;
    }

    @Override
    public void addFirst(E e) {
        linkFirst(e);
    }

    @Override
    public void addLast(E e) {
        linkLast(e);
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E removeFirst() {
        return unlink(first);
    }

    @Override
    public E removeLast() {
        return unlink(last);
    }

    @Override
    public E pollFirst() {
        return first == null ? null : unlink(first);
    }

    @Override
    public E pollLast() {
        return last == null ? null : unlink(last);
    }

    @Override
    public E getFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return first.item;
    }

    @Override
    public E getLast() {
        if(size==1)
            return first.item;
        if (last == null)
            throw new NoSuchElementException();
        return last.item;
    }

    @Override
    public E peekFirst() {
        return first == null ? null : first.item;
    }

    @Override
    public E peekLast() {
        return last == null ? null : first.item;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    @Override
    public boolean remove(Object o) {
        ListIterator<E> listIterator = listIterator();
        while (listIterator.hasNext()){
            E e = listIterator.next();
            if(e.equals(o)){
                listIterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Node<E> x = last; x != null; x = x.previous) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = last; x != null; x = x.previous) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean offer(E e) {
        return add(e);
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E poll() {
        if(size==0)
            return null;
        return removeFirst();
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        if(size==0)
            return null;
        return getFirst();
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    private class DescendingIterator implements Iterator<E>{
        private Node<E> next;
        DescendingIterator(){
            next=last;
        }
        @Override
        public boolean hasNext() {
            return next!=null;
        }

        @Override
        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            E e = next.item;
            next = next.previous;
            return e;
        }
    }

    private Node<E> node(int index) {
        // assert isElementIndex(index);
        if (index < (size >> 1)) {
            Node<E> current = first;
            for (int i = 0; i < index; i++)
                current = current.next;
            return current;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.previous;
            return x;
        }
    }
}
