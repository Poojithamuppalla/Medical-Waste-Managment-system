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
public class SalesWorkRequest extends WorkRequest{
     private double decomposableQuantity;
     private DonatingWaste donatingWaste;
     private RecyclableWaste recyclabeWate;
     private String wasteType;

    public double getDecomposableQuantity() {
        return decomposableQuantity;
    }

    public void setDecomposableQuantity(double decomposableQuantity) {
        this.decomposableQuantity = decomposableQuantity;
    }

    public DonatingWaste getDonatingWaste() {
        return donatingWaste;
    }

    public void setDonatingWaste(DonatingWaste donatingWaste) {
        this.donatingWaste = donatingWaste;
    }

    public RecyclableWaste getRecyclabeWate() {
        return recyclabeWate;
    }

    public void setRecyclabeWate(RecyclableWaste recyclabeWate) {
        this.recyclabeWate = recyclabeWate;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }
     
     
     
}
