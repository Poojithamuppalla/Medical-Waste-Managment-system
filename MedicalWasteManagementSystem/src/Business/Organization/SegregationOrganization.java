/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.SegregatorRole;
import java.util.ArrayList;

/**
 *
 * @author Rishvita
 */
public class SegregationOrganization extends Organization{
    public SegregationOrganization() {
        super(Organization.Type.Segregation.getValue());
    }

    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new SegregatorRole());
        return roles;
    } 
}
