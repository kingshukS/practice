package com.kingshuk.tests.graph;

import java.util.TreeSet;

public class DijkstraSet {
    public static void main(String[] args) {
        TreeSet<Pair> set = new TreeSet<>((x,y) ->x.distance == y.distance? x.node - y.node: x.distance-y.distance);
        set.add(new Pair(1,2));
        set.remove(new Pair(1,2));
        System.out.println(set);
    }

    static class Pair{
        int node, distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
