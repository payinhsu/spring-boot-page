/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.4  Built on : Oct 21, 2016 (10:48:01 BST)
 */

package com.poseitech.integration.playngo.ws.client.v1;

import com.poseitech.integration.playngo.ws.client.model.*;
import com.poseitech.integration.playngo.ws.client.model.appendix.Currency;
import com.poseitech.integration.playngo.ws.client.model.appendix.Money;
import com.poseitech.integration.playngo.ws.client.model.user.*;

/**
 * ExtensionMapper class
 */
@SuppressWarnings({ "unchecked", "unused" })
public class ExtensionMapper {
   public static java.lang.Object getTypeObject(
         java.lang.String namespaceURI, java.lang.String typeName,
         javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "PlayerAchievementsTrigger".equals(typeName)) {
         return PlayerAchievementsTrigger.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "ErrorCode".equals(typeName)) {
         return ErrorCode.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "ArrayOfAchievementsSummary".equals(typeName)) {
         return ArrayOfAchievementsSummary.Factory.parse(reader);
      }

      if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(
            namespaceURI) && "duration".equals(typeName)) {
         return CasinoGameServiceStub.Duration.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "AchievementsTrigger".equals(typeName)) {
         return AchievementsTrigger.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "AchievementConfiguration".equals(typeName)) {
         return AchievementConfiguration.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "OpenGameId".equals(typeName)) {
         return OpenGameId.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "ArrayOfOpenGameId".equals(typeName)) {
         return ArrayOfOpenGameId.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "AchievementFilterType".equals(typeName)) {
         return AchievementFilterType.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "ArrayOfAchievementConfiguration".equals(typeName)) {
         return ArrayOfAchievementConfiguration.Factory.parse(reader);
      }

      if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(
            namespaceURI) && "char".equals(typeName)) {
         return CasinoGameServiceStub._char.Factory.parse(reader);
      }

      if ("http://schemas.microsoft.com/2003/10/Serialization/".equals(
            namespaceURI) && "guid".equals(typeName)) {
         return CasinoGameServiceStub.Guid.Factory.parse(reader);
      }

      if ("http://schemas.datacontract.org/2004/07/Microsoft.Practices.EnterpriseLibrary.Validation.Integration.WCF".equals(
            namespaceURI) && "ValidationDetail".equals(typeName)) {
         return ValidationDetail.Factory.parse(reader);
      }

      if ("http://schemas.datacontract.org/2004/07/Microsoft.Practices.EnterpriseLibrary.Validation.Integration.WCF".equals(
            namespaceURI) &&
            "ArrayOfValidationDetail".equals(typeName)) {
         return ArrayOfValidationDetail.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "GameUser".equals(typeName)) {
         return GameUser.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "ServiceFault".equals(typeName)) {
         return ServiceFault.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "AchievementsSummary".equals(typeName)) {
         return AchievementsSummary.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "Currency".equals(typeName)) {
         return Currency.Factory.parse(reader);
      }

      if ("http://www.microsoft.com/practices/EnterpriseLibrary/2007/01/wcf/validation".equals(
            namespaceURI) && "ValidationFault".equals(typeName)) {
         return ValidationFault.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "Money".equals(typeName)) {
         return Money.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "ArrayOfAchievementsTrigger".equals(typeName)) {
         return ArrayOfAchievementsTrigger.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "ArrayOfPlayerAchievementsTrigger".equals(typeName)) {
         return ArrayOfPlayerAchievementsTrigger.Factory.parse(reader);
      }

      if ("http://schemas.microsoft.com/2003/10/Serialization/Arrays".equals(
            namespaceURI) && "ArrayOfint".equals(typeName)) {
         return CasinoGameServiceStub.ArrayOfint.Factory.parse(reader);
      }

      if ("http://playngo.com/v1".equals(namespaceURI) &&
            "UserBalance".equals(typeName)) {
         return UserBalance.Factory.parse(reader);
      }

      throw new org.apache.axis2.databinding.ADBException(
            "Unsupported type " + namespaceURI + " " + typeName);
   }
}
