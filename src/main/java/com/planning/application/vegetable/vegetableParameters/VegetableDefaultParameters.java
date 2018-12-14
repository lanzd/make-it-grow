package com.planning.application.vegetable.vegetableParameters;

import java.util.Calendar;
import java.util.Date;

public class VegetableDefaultParameters {

    // The default field loss factor is 20 %
    public static Integer DEFAULT_FIELD_LOSS_FACTOR = 20;

    // The default nursery loss factor is 20 %
    public static Integer DEFAULT_NURSERY_LOSS_FACTOR = 20;


    public static Integer GROWING_TIME_SEASON_FACTOR(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return WEEKLY_SEASON_FACTOR[calendar.get(Calendar.WEEK_OF_YEAR)];
    }


    // facteur multiplcatif du temps de pousse par semaine de l'année
    private static Integer[] WEEKLY_SEASON_FACTOR = {
            20, // 1
            20, // 2
            20, // 3
            20, // 4
            20, // 5
            20, // 6
            20, // 7
            20, // 8
            20, // 9
            20, // 10
            20, // 11
            20, // 12
            20, // 13
            20, // 14
            20, // 15
            20, // 16
            20, // 17
            20, // 18
            20, // 19
            20, // 20
            20, // 21
            20, // 22
            20, // 23
            20, // 24
            20, // 26
            20, // 27
            20, // 28
            20, // 29
            20, // 30
            20, // 31
            20, // 32
            20, // 33
            20, // 34
            20, // 35
            20, // 36
            20, // 37
            20, // 38
            20, // 39
            20, // 40
            20, // 41
            20, // 42
            20, // 43
            20, // 44
            20, // 45
            20, // 46
            20, // 47
            20, // 48
            20, // 49
            20, // 50
            20, // 51
            20, // 52
            20 // 53
    };
}
