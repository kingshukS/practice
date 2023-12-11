package com.kingshuk.tests.Designpatterns.Behavioral.state;

public class PlayingState extends State{

    public PlayingState(Player player) {
        super(player);
        player.setPlaying(true);
    }

    @Override
    String onLock() {
        player.changeState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Stop playing";
    }

    @Override
    String onPlay() {
        player.changeState(new ReadyState(player));
        return "Paused...";
    }

    @Override
    String onNext() {
        return player.nextTrack();
    }

    @Override
    String onPrevious() {
        return player.previousTrack();
    }
}
