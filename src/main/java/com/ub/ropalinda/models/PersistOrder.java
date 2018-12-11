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

import java.util.List;

/**
 *
 * @author Ulises Beltrán Gómez - beltrangomezulises@gmail.com
 */
public class PersistOrder {

    private String customerMail;
    private int customerAddressId;
    private String paymentMethod;
    private String paymentData;
    private List<OrderLine> lines;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public int getCustomerAddressId() {
        return customerAddressId;
    }

    public void setCustomerAddressId(int customerAddressId) {
        this.customerAddressId = customerAddressId;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

    public static class OrderLine {

        private int garmentId;
        private int quantity;
        private List<Integer> compatibleIds;

        public int getGarmentId() {
            return garmentId;
        }

        public void setGarmentId(int garmentId) {
            this.garmentId = garmentId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public List<Integer> getCompatibleIds() {
            return compatibleIds;
        }

        public void setCompatibleIds(List<Integer> compatibleIds) {
            this.compatibleIds = compatibleIds;
        }

    }

}
