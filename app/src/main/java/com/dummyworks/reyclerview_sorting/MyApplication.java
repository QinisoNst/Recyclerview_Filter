package com.dummyworks.reyclerview_sorting;

import android.app.Application;
import android.view.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application
{
    public static List<President> presidentList = new ArrayList<>();

    public static int nextId =10;

    Menu menu;


    public MyApplication()
    {
        filletPresidentlist();
    }


    private void filletPresidentlist()
    {
        President p0 = new President(0,"George Washington",1792,"https://upload.wikimedia.org/wikipedia/commons/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President(1,"John Adams",1796,"https://upload.wikimedia.org/wikipedia/commons/0/07/John_Adams_A18236.jpg");
        President p2 = new President(2,"Thomas Jefferson",1804,"https://upload.wikimedia.org/wikipedia/commons/1/1e/Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg");
        President p3 = new President(3,"James Madison",1812,"https://upload.wikimedia.org/wikipedia/commons/1/1e/Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg");
        President p4 = new President(4,"James Monroe",1817,"https://upload.wikimedia.org/wikipedia/commons/1/1d/James_Madison.jpg");
        President p5 = new President(5,"John Quincy Adams",1825,"https://upload.wikimedia.org/wikipedia/commons/4/4f/John_Quincy_Adams_by_Charles_Osgood.jpg");
        President p6 = new President(6,"Andrew Jackson",1829,"https://upload.wikimedia.org/wikipedia/commons/4/43/Andrew_jackson_head.jpg");
        President p7 = new President(7,"Martin Van Buren",1837,"https://upload.wikimedia.org/wikipedia/commons/8/8b/Martin_Van_Buren_circa_1837_crop.jpg");
        President p8 = new President(8,"William Henry Harrison",1841,"https://upload.wikimedia.org/wikipedia/commons/3/34/William_Henry_Harrison_by_James_Reid_Lambdin%2C_1835_crop.jpg");
        President p9 = new President(9,"John Tyler",1841,"https://upload.wikimedia.org/wikipedia/commons/b/b2/John_Tyler_crop.jpg");
        President p10=new President(10,"James K. Polk",1845,"https://upload.wikimedia.org/wikipedia/commons/5/5e/JKP.jpg");

        presidentList.addAll(Arrays.asList(new President[] {p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10}));
    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int sizeId) {
        MyApplication.nextId = sizeId;
    }
}
