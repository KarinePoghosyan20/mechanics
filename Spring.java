package com.company;

public class Spring {
    double k;

    public Spring() {
        k=1;
    }

    public Spring(double k) {
        this.k = k;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double[] move(double t, double dt, double x0, double v0) {
        double w = Math.sqrt(k);
        double[] coordinates = new double[(int)(Math.ceil(t)/dt)];
        double tVariable = 0;
        for(int i = 0; i < coordinates.length; i++){
            double var = x0*Math.cos(w*tVariable) + (v0/w)*Math.sin(w*tVariable);
            coordinates[i] = var;
            tVariable += dt;
        }
        return coordinates;
    }

    public double[] move(double t, double dt, double x0) {
        double w = Math.sqrt(k);
        double[] coordinates = new double[(int)(Math.ceil(t)/dt)];
        double tVariable = 0;
        for(int i = 0; i < coordinates.length; i++){
            double var = x0*Math.cos(w*tVariable);
            coordinates[i] = var;
            tVariable += dt;
        }
        return coordinates;
    }

    public double[] move(double t0, double t1, double dt, double x0, double v0) {
        double w = Math.sqrt(k);
        double[] coordinates = new double[(int)(Math.ceil(t1-t0)/dt)];
        double tVariable = 0;
        for(int i = 0; i < coordinates.length; i++){
            double var = x0*Math.cos(w*tVariable) + (v0/w)*Math.sin(w*tVariable);
            coordinates[i] = var;
            tVariable += dt;
        }
        return coordinates;
    }

    public double[] move(double t0, double t1, double dt, double x0, double v0, double m) {
        double w = Math.sqrt(k/m);
        double[] coordinates = new double[(int)(Math.ceil(t1-t0)/dt)];
        double tVariable = 0;
        for(int i = 0; i < coordinates.length; i++){
            double var = x0*Math.cos(w*tVariable) + (v0/w)*Math.sin(w*tVariable);
            coordinates[i] = var;
            tVariable += dt;
        }
        return coordinates;
    }

    public Spring inSeries(Spring that) {
        double k = (getK() * that.k) / (getK() + that.k);
        Spring spring = new Spring(k);
        return spring;
    }

    public Spring inParallel(Spring that) {
        double k = (getK() + that.k);
        Spring spring = new Spring(k);
        return spring;
    }

}
