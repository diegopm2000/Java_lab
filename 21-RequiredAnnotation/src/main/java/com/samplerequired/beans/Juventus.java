package com.samplerequired.beans;

import com.samplerequired.interfaces.ITeam;

public class Juventus implements ITeam {

    @Override
    public String show() {
        return "Juventus";
    }
}
