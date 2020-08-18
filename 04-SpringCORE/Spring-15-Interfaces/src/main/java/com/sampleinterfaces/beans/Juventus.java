package com.sampleinterfaces.beans;

import com.sampleinterfaces.interfaces.ITeam;

public class Juventus implements ITeam {

    @Override
    public String show() {
        return "Juventus";
    }
}
