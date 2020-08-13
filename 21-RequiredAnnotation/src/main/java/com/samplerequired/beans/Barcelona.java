package com.samplerequired.beans;

import com.samplerequired.interfaces.ITeam;

public class Barcelona implements ITeam {

    @Override
    public String show() {
        return "Barcelona";
    }
}
