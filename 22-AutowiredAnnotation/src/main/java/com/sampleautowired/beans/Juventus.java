package com.sampleautowired.beans;

import com.sampleautowired.interfaces.ITeam;

public class Juventus implements ITeam {

    @Override
    public String show() {
        return "Juventus";
    }
}
