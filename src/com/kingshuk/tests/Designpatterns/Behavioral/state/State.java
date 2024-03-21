package com.kingshuk.tests.Designpatterns.Behavioral.state;

public abstract class State {

    Player player;

    public State ( Player player ) {
        this.player = player;
    }

    abstract String onLock ();

    abstract String onPlay ();

    abstract String onNext ();

    abstract String onPrevious ();
}
