package com.sample.beans;

import com.sample.interfaces.ITeam;

public class Juventus implements ITeam {

    @Override
    public String show() {
        return "Juventus";
    }
}
