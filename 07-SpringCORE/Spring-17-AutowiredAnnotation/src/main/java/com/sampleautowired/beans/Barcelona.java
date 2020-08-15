package com.sampleautowired.beans;

import com.sampleautowired.interfaces.ITeam;

public class Barcelona implements ITeam {

    @Override
    public String show() {
        return "Barcelona";
    }
}
