package com.sample.beans;

import com.sample.interfaces.ITeam;
import org.springframework.stereotype.Component;

@Component
public class Juventus implements ITeam {

    @Override
    public String show() {
        return "Juventus";
    }
}
