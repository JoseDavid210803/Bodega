package com.example.bodega.backend.clases;

public class pair<F, S> {
    private F first;
    private S second;

    public pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
    public F getFirst() {
        return first;
    }
    public void setFirst(F first) {
        this.first = first;
    }
    public S getSecond() {
        return second;
    }
    public void setSecond(S second) {this.second = second;}
}
