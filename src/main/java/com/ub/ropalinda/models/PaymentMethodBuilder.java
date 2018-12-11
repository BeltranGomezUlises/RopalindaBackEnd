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

import com.ub.ropalinda.utils.PaymentService;
import com.ub.ropalinda.utils.validation.InvalidValueException;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class PaymentMethodBuilder {

    public static PaymentMethod build(byte methodType, String data) throws InvalidValueException {
        PaymentMethod paymentMethod = null;
        switch (methodType) {
            case 0:
                paymentMethod = new Deposit(data);
                break;
            case 1:
                paymentMethod = new Card(data);
                break;
        }
        return paymentMethod;
    }

    public static class Deposit extends PaymentMethod {

        public Deposit(String data) {
            super(data);
        }

        @Override
        public void validate() throws InvalidValueException {
            //ignore
        }

        @Override
        public void sendMail(String mail) {
        }

    }

    public static class Card extends PaymentMethod {

        public Card(String data) {
            super(data);
        }

        @Override
        public void validate() throws InvalidValueException {
            this.setReference(PaymentService.validate(this));
        }

        @Override
        public void sendMail(String mail) {
        }

    }

    public static abstract class PaymentMethod {

        private String data;
        private String reference;

        public PaymentMethod(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public abstract void validate() throws InvalidValueException;

        public abstract void sendMail(String mail);

    }

}
