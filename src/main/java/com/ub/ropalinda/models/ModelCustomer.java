/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.ropalinda.models;

import com.ub.ropalinda.entities.Customer;
import com.ub.ropalinda.utils.commons.Model;

/**
 *
 * @author ulises
 */
public class ModelCustomer extends Model<Customer, String>{
    
    public ModelCustomer() {
        super(Customer.class);        
    }
    
}
