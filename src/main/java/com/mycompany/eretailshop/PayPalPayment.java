/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eretailshop;

/**
 *
 * @author Jasminkumar thummar
 */
public class PayPalPayment implements Payment {

    @Override
    public boolean processPayment(double amount) {
        return loginToPayPal();
    }

    public boolean loginToPayPal() {
        return true;
    }
}
