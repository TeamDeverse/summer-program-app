package org.deverse.summer_program.deversesummerprogram;

/**
 * Created by amruss on 7/28/2015.
 */
public class Shifts {
    private String date;
    private String site;
    private int volunteerhours;


    public Shifts(String date, String site, int volunteerhours){
        super();
        this.date= date;
        this.site=site;
        this.volunteerhours=volunteerhours;

    }
    public String getDate(){
        return date;
    }
    public String getSite(){
        return site;
    }
    public int getVolunteerhours(){
        return volunteerhours;
    }

}
