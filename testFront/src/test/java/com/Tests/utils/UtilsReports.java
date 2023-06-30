package com.Tests.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class UtilsReports {

    private static ExtentSparkReporter spark;
    private static ExtentReports extent;


    public static ExtentSparkReporter getSpark(){
        if(spark==null){
            spark=  new ExtentSparkReporter("Spark.html");
        }
        return  spark;
    }

    public static ExtentReports getExtent(){
        if(extent==null){
            extent= new ExtentReports();
        }

        return  extent;
    }


}
