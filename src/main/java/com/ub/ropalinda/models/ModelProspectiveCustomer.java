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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ub.ropalinda.entities.Customer;
import com.ub.ropalinda.entities.ProspectiveCustomer;
import com.ub.ropalinda.utils.UtilsJWT;
import com.ub.ropalinda.utils.UtilsJson;
import com.ub.ropalinda.utils.UtilsMail;
import com.ub.ropalinda.utils.UtilsMail.ModelSendActivationCode;
import com.ub.ropalinda.utils.UtilsSecurity;
import com.ub.ropalinda.utils.commons.Model;
import com.ub.ropalinda.utils.commons.reponses.AccessDeniedException;
import com.ub.ropalinda.utils.commons.reponses.UniqueException;
import com.ub.ropalinda.utils.validation.*;
import static com.ub.ropalinda.utils.validation.UtilsValidation.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;
import javax.persistence.EntityManager;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class ModelProspectiveCustomer
        extends Model<ProspectiveCustomer, String> {

    public ModelProspectiveCustomer() {
        super(ProspectiveCustomer.class);
    }

    /**
     * Validates the creation of new prospective customer
     *
     * @param t model to evaluate
     * @throws com.ub.ropalinda.utils.validation.InvalidValueException
     */
    public void validateProspective(ProspectiveCustomer t) throws InvalidValueException {
        isEmailAndNotNull(t.getMail(), "correo electrónico");
        isPhone(t.getPhone(), "teléfono");
        containsSpecialCharacterAndNotNull(t.getName(), "nombre");
        containsSpecialCharacterAndNotNull(t.getFatherLastName(), "apellido paterno");
        containsSpecialCharacterAndNotNull(t.getMotherLastName(), "apellido materno");

        ProspectiveCustomer prospectiveCustomerExisting = this.findById(t.getMail());
        if (prospectiveCustomerExisting != null) {
            if (prospectiveCustomerExisting.getActive()) {
                throw new InvalidValueException("Ya cuenta con una "
                        + "solicitud para ser cliente de Ropalinda, espere "
                        + "nuestra aceptación por correo electrónico");
            } else {
                throw new InvalidValueException("Usted fué rechazado para "
                        + "ser cliente de Ropalinda, lo sentimos");
            }
        }
        
        Customer customer = this.createEm().find(Customer.class, t.getMail());
        if (customer != null) {
            throw new InvalidValueException("Usted ya tiene una cuenta");
        }
    }

    /**
     * Creates the token for requesting to be a customer in ropalinda
     *
     * @param req prospective customer requesting
     * @return token for request activation code
     * @throws JsonProcessingException
     */
    public String customerRequest(ProspectiveCustomer req)
            throws JsonProcessingException, EmailException, MalformedURLException {
        String code = UUID.randomUUID().toString().substring(0, 10);
        ModelSendActivationCode msac = new UtilsMail.ModelSendActivationCode(req, code);
        String token = UtilsJWT.tokenWithData(UtilsJson.write(msac));
        UtilsMail.sendActivationCode("smtp.googlemail.com", 465,
                "ubg700@gmail.com", "toString24", "ubg700@gmail.com",
                req.getMail(), code);

        return token;
    }

    /**
     * Activates the prospective customer request
     *
     * @param token token with request
     * @param code activation code
     * @throws java.io.IOException
     * @throws com.ub.ropalinda.utils.commons.reponses.UniqueException
     * @throws com.ub.ropalinda.utils.validation.InvalidValueException
     * @throws com.ub.ropalinda.utils.commons.reponses.AccessDeniedException
     */
    public void customerActivation(String token, String code)
            throws IOException, UniqueException, InvalidValueException, AccessDeniedException {
        ModelSendActivationCode msac
                = UtilsJson.read(UtilsJWT.getSubject(token), ModelSendActivationCode.class);
        if (msac.getCode().equals(code)) {
            ProspectiveCustomer pc = msac.getPros();
            pc.setPass(UtilsSecurity.encodeSHA256(pc.getPass()));
            this.persist(pc);
        } else {
            throw new InvalidValueException("El código no es correcto");
        }
    }

    public void reject(String email) throws InvalidValueException, UniqueException {
        UtilsValidation.isEmailAndNotNull(email);
        ProspectiveCustomer pc = this.findById(email);
        if (pc == null) {
            throw new InvalidValueException("No existe el cliente prospecto");
        }
        pc.setActive(false);
        this.update(pc);        
    }

    public void accept(String email) throws InvalidValueException, UniqueException {
        UtilsValidation.isEmailAndNotNull(email);
        EntityManager em = this.createEm();
        ProspectiveCustomer pc = em.find(ProspectiveCustomer.class, email);
        if (pc == null) {
            throw new InvalidValueException("No existe el cliente");
        }
        Customer c = new Customer(email, pc.getPass(), pc.getName(), pc.getFatherLastName(), pc.getMotherLastName(), pc.getPhone(), pc.getBirthday(), true);        
                
        em.getTransaction().begin();
        em.persist(c);
        em.remove(pc);                
        em.getTransaction().commit();                                
    }

}
