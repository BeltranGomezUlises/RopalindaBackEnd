package com.ub.ropalinda.models;

import com.ub.ropalinda.entities.ProspectiveCustomer;
import com.ub.ropalinda.utils.UtilsSecurity;
import com.ub.ropalinda.utils.commons.Model;
import com.ub.ropalinda.utils.commons.reponses.UniqueException;
import java.security.InvalidParameterException;

/**
 *
 * @author ulises
 */
public class ModelProspectiveCustomer
        extends Model<ProspectiveCustomer, String> {

    public ModelProspectiveCustomer() {
        super(ProspectiveCustomer.class);
    }

    @Override
    public ProspectiveCustomer persist(ProspectiveCustomer t)
            throws UniqueException {
        validateProspective(t);
        t.setPass(UtilsSecurity.encodeSHA256(t.getPass()));
        return super.persist(t);
    }

    /**
     * Validates the creation of new prospective customer
     *
     * @param t model to evaluate
     */
    private void validateProspective(ProspectiveCustomer t) {
        String mail = t.getMail();
        if (mail == null || mail.isEmpty()) {
            throw new InvalidParameterException("Email is needed");
        }
        ProspectiveCustomer prospectiveCustomerExisting = this.findById(mail);
        if (prospectiveCustomerExisting != null) {
            if (prospectiveCustomerExisting.getActive()) {
                throw new InvalidParameterException("Ya cuenta con una "
                        + "solicitud para ser cliente de Ropalinda, espere "
                        + "nuestra aceptación por correo electrónico");
            } else {
                throw new InvalidParameterException("Usted fué rechazado para "
                        + "ser cliente de Ropalinda, lo sentimos");
            }
        }
    }

}
