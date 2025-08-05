package com.codingdojo.state;

public interface State {

    State nextState();

    String getColors();

    boolean canIGo();
}
