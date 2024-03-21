package com.kingshuk.tests.Designpatterns.Behavioral.state;

public class LockedState extends State {

    public LockedState ( Player player ) {
        super ( player );
        player.setPlaying ( false );
    }

    @Override
    String onLock () {
        return "Already Locked...";
    }

    @Override
    String onPlay () {
        player.changeState ( new ReadyState ( player ) );
        return "Ready";
    }

    @Override
    String onNext () {
        return "Locked...";
    }

    @Override
    String onPrevious () {
        return "Locked...";
    }
}
