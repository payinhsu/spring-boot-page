/**
 * CasinoGameService_Balance_ServiceFaultFault_FaultMessage.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:47:34 BST)
 */
package com.poseitech.integration.playngo.ws.client.v1;

import com.poseitech.integration.playngo.ws.client.model.ServiceFaultE;

public class CasinoGameService_Balance_ServiceFaultFault_FaultMessage extends java.lang.Exception {
    private static final long serialVersionUID = 1489388697875L;
    private ServiceFaultE faultMessage;

    public CasinoGameService_Balance_ServiceFaultFault_FaultMessage() {
        super("CasinoGameService_Balance_ServiceFaultFault_FaultMessage");
    }

    public CasinoGameService_Balance_ServiceFaultFault_FaultMessage(
        java.lang.String s) {
        super(s);
    }

    public CasinoGameService_Balance_ServiceFaultFault_FaultMessage(
        java.lang.String s, java.lang.Throwable ex) {
        super(s, ex);
    }

    public CasinoGameService_Balance_ServiceFaultFault_FaultMessage(
        java.lang.Throwable cause) {
        super(cause);
    }

    public void setFaultMessage(
        ServiceFaultE msg) {
        faultMessage = msg;
    }

    public ServiceFaultE getFaultMessage() {
        return faultMessage;
    }
}
