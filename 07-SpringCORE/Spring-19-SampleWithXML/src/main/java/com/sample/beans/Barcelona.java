package com.sample.beans;

import com.sample.interfaces.ITeam;
import org.springframework.stereotype.Component;

@Component
public class Barcelona implements ITeam {

    @Override
    public String show() {
        return "Barcelona";
    }
}
