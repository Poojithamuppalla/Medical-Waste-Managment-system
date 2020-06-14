/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.List;

/**
 *
 * @author tejas
 */
public class SegregationTestWorkResult extends WorkRequest{
    private String wasteType;
    private double decomposableQuantity;
    private RecyclableWaste recyclableWaste;    
    private DonatingWaste donatingWaste;

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }
   
    public double getDecomposableQuantity() {
        return decomposableQuantity;
    }

    public void setDecomposableQuantity(double decomposableQuantity) {
        this.decomposableQuantity = decomposableQuantity;
    }

    public RecyclableWaste getRecyclableWaste() {
        return recyclableWaste;
    }

    public void setRecyclableWaste(RecyclableWaste recyclableWaste) {
        this.recyclableWaste = recyclableWaste;
    }

    public DonatingWaste getDonatingWaste() {
        return donatingWaste;
    }

    public void setDonatingWaste(DonatingWaste donatingWaste) {
        this.donatingWaste = donatingWaste;
    }

   
    
    @Override
    public String toString() {
        return  wasteType ;
    }
    
    
    
}
