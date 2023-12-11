package com.kingshuk.tests.Designpatterns.Behavioral.state;

public class ReadyState extends State{

    public ReadyState(Player player) {
        super(player);
    }

    @Override
    String onLock() {
        player.changeState(new LockedState(player));
        return "Locked...";
    }

    @Override
    String onPlay() {
        String action = player.startPlayback();
        player.changeState(new PlayingState(player));
        return action;
    }

    @Override
    String onNext() {
        return "Not Playing Yet...";
    }

    @Override
    String onPrevious() {
        return "Not Playing Yet...";
    }
}
