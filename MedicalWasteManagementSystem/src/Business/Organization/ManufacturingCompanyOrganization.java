/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AdminRole;
import Business.Role.ManufacturerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author tejas
 */
public class ManufacturingCompanyOrganization extends Organization{
    public ManufacturingCompanyOrganization() {
        super(Organization.Type.ManufacturingCompany.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new ManufacturerRole());
        return roles;
    } 
}
