/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author raunak
 */
public class LabTestWorkRequest extends WorkRequest{
    
    private String testResult;
    private RecyclableWaste recyclableWaste;

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public RecyclableWaste getRecyclableWaste() {
        return recyclableWaste;
    }

    public void setRecyclableWaste(RecyclableWaste recyclableWaste) {
        this.recyclableWaste = recyclableWaste;
    }
    
    
}
