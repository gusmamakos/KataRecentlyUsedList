package com.mamakos;

public class RecentList {
    String[] recentlyUsed;
    int size;
    int numItems;

    public RecentList() {
        this.size = 5;
        this.numItems = 0;
        this.recentlyUsed = new String[this.size];
    }

    public RecentList(int size) {
        this.size = size;
        this.numItems = 0;
        this.recentlyUsed = new String[this.size];
    }

    public void add(String s) {
        if (s == null) return;

        if (exists(s)) {
            delete(getIndex(s));
        }
        if (numItems == size) { // delete oldest
            delete(0);
        }

        this.recentlyUsed[this.numItems] = s;
        this.numItems++;
    }
    private int getIndex(String s){
        for (int i = 0; i < this.recentlyUsed.length; i++) {
            if (this.recentlyUsed[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }
    private void delete(int indexPosition) {
        int items = 0;
        String[] temp = new String[this.size];
        for (int i = 0; i < this.recentlyUsed.length; i++) {
            if ((i != indexPosition) && (this.recentlyUsed[i] != null)) {
                temp[items++] = this.recentlyUsed[i];
            }
        }
        this.recentlyUsed = temp;
        this.numItems = items;
    }

    private boolean exists(String s) {
        if (this.numItems > 0) {
            for (String s1 : this.recentlyUsed) {
                if (s.equals(s1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String get(int index) {
        if((index < 0) || (index > this.numItems - 1)){
            throw new IndexOutOfBoundsException();
        }
        return this.recentlyUsed[(numItems - 1) - index];
    }

    public String[] get() {
        String[] temp = new String[this.numItems];
        int x = 0;
        for (int i = numItems - 1; i >= 0; i--) {
            temp[x++] = this.recentlyUsed[i];
        }
        return temp;
    }
}