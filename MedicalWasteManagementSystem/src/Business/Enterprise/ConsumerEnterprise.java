/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author tejas
 */
public class ConsumerEnterprise extends Enterprise {
     public ConsumerEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Consumer);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
