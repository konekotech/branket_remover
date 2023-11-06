package com.konekophysics;

public class Main {
    static void applyBracket(LinkedList list, boolean isParentheses){
        //ヘッドから読み込み直す
        list.initializeToHead();
        //最後の「)」の位置を格納するNodeをつくる
        Node lastBracketEnd = new Node(null);
        //「()」なら先頭，「[]」なら最後尾にlastBracketEndをおく
        char start;
        char end;
        if(isParentheses){
            lastBracketEnd = list.getHead();
            start = '(';
            end = ')';
        }else{
            lastBracketEnd = list.getLastChar();
            start = '[';
            end = ']';
        }
        //探索する「(」の位置を格納するNodeをつくる
        Node beforeBracketStart = new Node(null);
        Node bracketStart = new Node(null);
        Node bracketEnd = new Node(null);
        //「(」を探索
       while(list.getNow().getNext().getData() != null){
            //(がみつかったら，開始位置をblankStartに格納．
            if(list.getNow().getNext().getData() == start){
                beforeBracketStart = list.getNow();
                bracketStart  = list.getNow().getNext();
                while(list.getNow().getData() != null && list.getNow().getData() != end){
                    list.shift();
                }
                //)がみつかったら，終了位置をblankEndに格納
                bracketEnd = list.getNow();
                //挿入
                list.setNow(bracketEnd.getNext());
                beforeBracketStart.setNext(bracketEnd.getNext());
                Node p = lastBracketEnd.getNext();
                lastBracketEnd.setNext(bracketStart);
                bracketEnd.setNext(p);
                lastBracketEnd = bracketEnd;
            }else{
                list.shift();
            }
        }
    }

    public static void main(String[] args) {
        String str = "a[(bc)d]ef(g[hi]j)k";
        //連結リストを作成
        LinkedList list = new LinkedList();
        //データを格納
        for(int i = 0; i < str.length(); i++){
            list.addData(str.charAt(i));
        }
        list.initializeToHead();
        //データを格納
        for(int i = 0; i <= str.length(); i++){
            System.out.println( list.getNow().getData());
            list.shift();
        }
        System.out.println("変換");
        list.initializeToHead();
        applyBracket(list, true);
        list.initializeToHead();
        applyBracket(list, false);
        //データを格納
        list.initializeToHead();
        for(int i = 0; i <= str.length(); i++){
            System.out.println( list.getNow().getData());
            list.shift();
        }
    }
}