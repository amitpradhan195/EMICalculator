package com.example.a170171_emi;

public class EMICalculation {
    private Double emi;

    EMICalculation(double amt, float ratePercent, float time){
        float rate = (ratePercent/100)/12;
        float month = time*12;
        emi = (amt * rate * Math.pow(1 + rate, month)) / (Math.pow(1 + rate,month) - 1);
    }

    Double getEmi(){
        return emi;
    }
}
