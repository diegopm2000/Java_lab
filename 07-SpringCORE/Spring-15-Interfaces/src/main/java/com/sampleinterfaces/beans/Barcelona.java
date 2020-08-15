package com.sampleinterfaces.beans;

import com.sampleinterfaces.interfaces.ITeam;

public class Barcelona implements ITeam {

    @Override
    public String show() {
        return "Barcelona";
    }
}
