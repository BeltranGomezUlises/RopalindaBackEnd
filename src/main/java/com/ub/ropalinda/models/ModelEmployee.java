/*
 * Copyright (C) 2018 Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.ub.ropalinda.models;

import com.ub.ropalinda.entities.Employee;
import com.ub.ropalinda.utils.UtilsJWT;
import com.ub.ropalinda.utils.UtilsSecurity;
import com.ub.ropalinda.utils.commons.Model;
import com.ub.ropalinda.utils.commons.reponses.UniqueException;
import com.ub.ropalinda.utils.validation.InvalidValueException;
import com.ub.ropalinda.utils.validation.UtilsValidation;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class ModelEmployee extends Model<Employee, String> {

    public static final String LOGIN_FAIL_MESSAGE = "Usuario y/o contraseña inválido";

    public ModelEmployee() {
        super(Employee.class);
    }

    public Map<String, Object> login(String mail, String pass) throws InvalidValueException {
        UtilsValidation.isEmptyAndNotNull(mail, "mail");
        UtilsValidation.isEmptyAndNotNull(pass, "pass");

        Employee emp = this.findById(mail);
        if (emp == null) {
            throw new InvalidValueException(LOGIN_FAIL_MESSAGE);
        }
        String encodedPass = UtilsSecurity.encodeSHA256(pass);
        if (!emp.getPass().equals(encodedPass)) {
            throw new InvalidValueException(LOGIN_FAIL_MESSAGE);
        }
        String token = UtilsJWT.token(emp.objectPK());
        Map<String, Object> map = new HashMap<>();
        map.put("employee", emp);
        map.put("token", token);
        return map;
    }

    @Override
    public Employee persist(Employee t) throws UniqueException, InvalidValueException {
        UtilsValidation.isPhoneAndNotNull(t.getPhone(), "teléfono");
        UtilsValidation.isEmailAndNotNull(t.getMail(), "correo");
                
        t.setPass(UtilsSecurity.encodeSHA256(t.getPass()));        
        return super.persist(t); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Employee t) throws UniqueException, InvalidValueException{
        Employee emp = this.findById(t.getMail());
        t.setPass(emp.getPass());
        super.update(t); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
