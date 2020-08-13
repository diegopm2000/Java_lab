package com.samplestereotypes.beans;

import com.samplestereotypes.interfaces.ITeam;
import org.springframework.stereotype.Component;

@Component
public class Barcelona implements ITeam {

    @Override
    public String show() {
        return "Barcelona";
    }
}
