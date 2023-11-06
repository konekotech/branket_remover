package com.konekophysics;

public class LinkedList {
    private Node head;

    private Node tail;
    private Node now;

    LinkedList(){
         this.head = new Node(null);
        this.head.setNext(new Node(null));
         this.now = this.head.getNext();
         this.tail = this.head;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getNow() {
        return this.now;
    }

    public void setNow(Node now) {
        this.now = now;
    }

    public Node getLastChar() {
        Node p = this.getHead();
        while(p.getNext().getData() != null){
            p = p.getNext();
        }
        return p;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    //データを末尾に加える
    public void addData(Character c){
        this.now.setData(c);
        this.now.setNext(new Node(null));
        this.now = this.now.getNext();
        this.tail = this.now;
    }

    //データをシフトする
    public void shift(){
        if(this.now.getNext() != null){
            //現在位置を書き換え
            this.now = this.now.getNext();
        }
    }

    public void initializeToHead(){
        this.now = this.head;
    }
}
