package org.deverse.summer_program.deversesummerprogram;

/**
 * Created by amruss on 7/29/2015.
 */
public class Badges {

    private String Badge_Name;
    private int IconID;

    public Badges(String Badge_Name, int IconId){
        super();
        this.Badge_Name=Badge_Name;
        this.IconID=IconId;

    }
    public String getBadge_Name(){
        return Badge_Name;
    }

    public int getIconID(){
        return IconID;
    }
}
