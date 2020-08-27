package com.example.dailyapp.RecyclerViewAdapter;

/**
 * Created by Mohammmed Alsudani on 26-Jan-19.
 * for more visit http://materialuiux.com
 */

public class Itam {
    String Title;
    String Body;
    String Date;
    public int likecount = 0;
    public boolean like ;
    public int commentCount = 0;


    public Itam() {
        // Default constructor required
    }

    public Itam(String Title, String Body, String Date, int likecount , int commentCount ,boolean like ) {
        this.Title = Title;
        this.Body = Body;
        this.Date = Date;
        this.like = like;
        this.likecount = likecount;
        this.commentCount = commentCount;

    }


}
