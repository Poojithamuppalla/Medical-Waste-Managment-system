/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author tejas
 */
public class RecyclableWaste {
    private int numberOfSyringes = 0;
    private int numberOfPlasticDisposables = 0;
    private int numberOfXRayFilms = 0;
    private int numberOfBPCuffAndBulbs = 0;
    private String status;

    public int getNumberOfSyringes() {
        return numberOfSyringes;
    }

    public void setNumberOfSyringes(int numberOfSyringes) {
        this.numberOfSyringes = numberOfSyringes;
    }

    public int getNumberOfPlasticDisposables() {
        return numberOfPlasticDisposables;
    }

    public void setNumberOfPlasticDisposables(int numberOfPlasticDisposables) {
        this.numberOfPlasticDisposables = numberOfPlasticDisposables;
    }

    public int getNumberOfXRayFilms() {
        return numberOfXRayFilms;
    }

    public void setNumberOfXRayFilms(int numberOfXRayFilms) {
        this.numberOfXRayFilms = numberOfXRayFilms;
    }

    public int getNumberOfBPCuffAndBulbs() {
        return numberOfBPCuffAndBulbs;
    }

    public void setNumberOfBPCuffAndBulbs(int numberOfBPCuffAndBulbs) {
        this.numberOfBPCuffAndBulbs = numberOfBPCuffAndBulbs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
