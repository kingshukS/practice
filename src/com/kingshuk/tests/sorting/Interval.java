package com.kingshuk.tests.sorting;

public class Interval implements Comparable<Interval> {
    private int start;
    private int end;

    public Interval () {
    }

    public Interval ( int start, int end ) {
        if ( end < start )
            throw new IllegalArgumentException ();
        this.start = start;
        this.end = end;
    }

    public int getStart () {
        return start;
    }

    public void setStart ( int start ) {
        this.start = start;
    }

    public int getEnd () {
        return end;
    }

    public void setEnd ( int end ) {
        this.end = end;
    }

    @Override
    public String toString () {
        return "{" + start +
                ", " + end +
                '}';
    }

    @Override
    public int compareTo ( Interval i ) {
        return this.start - i.start;
    }

    public boolean isCoIncident ( Interval i ) {
        return this.start <= i.end && i.start <= this.end;
    }

    public Interval merge ( Interval i ) {
        Interval interval = new Interval ();
        interval.start = Math.min ( this.start, i.start );
        interval.end = Math.max ( this.end, i.end );
        return interval;
    }
}
