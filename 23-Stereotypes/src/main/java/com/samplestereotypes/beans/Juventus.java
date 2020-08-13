package com.samplestereotypes.beans;

import com.samplestereotypes.interfaces.ITeam;
import org.springframework.stereotype.Component;

public class Juventus implements ITeam {

    @Override
    public String show() {
        return "Juventus";
    }
}
