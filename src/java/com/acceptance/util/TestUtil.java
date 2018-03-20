package com.acceptance.util;

import java.util.GregorianCalendar;

public class TestUtil {

    public int getTableLengthById(String tableId)
    {
        return 0;
    }


    public static String randomDate()
    {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2010);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        return (gc.get(gc.DAY_OF_MONTH)+"/"+(gc.get(gc.MONTH) + 1) +"/"+gc.get(gc.YEAR));
    }

    public static int randBetween(int start, int end)
    {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public static String dateSplitter(String str)
    {
        String a[]=str.split("[^0-9]+");
        String s="";
        for(int i=a.length-3;i<a.length;i++)
        {
            s+=a[i];
            if(i+1==a.length)
            { }
            else
            {
                s+="/";
            }
        }
        return s;
    }

}
