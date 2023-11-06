package com.konekophysics;

public class Node {
    //現在の要素の値
    private Character data;
    //次の要素のaddress
    private Node next = null;
    //コンストラクタ
    Node(Character d) {this.data=d;}

    public Character getData() {
        return this.data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
