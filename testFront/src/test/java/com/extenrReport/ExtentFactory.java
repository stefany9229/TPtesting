package com.extenrReport;

import com.aventstack.extentreports.ExtentReports;

public  class ExtentFactory {

    public ExtentFactory() {
    }

    public static ExtentReports getIstance() {
        ExtentReports extent = new ExtentReports();
        extent.setSystemInfo("Selenium Versio","4.9.1");
        extent.setSystemInfo("OS","Windows");
        return  extent;

    }
}
