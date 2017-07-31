package com.poseitech.integration.playngo.ws.client.model.user;

import com.poseitech.integration.playngo.ws.client.v1.ExtensionMapper;

/**
 * GetAchievementSummary bean class
 */
public class GetAchievementSummary implements org.apache.axis2.databinding.ADBBean {
   public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName("http://playngo.com/v1",
         "GetAchievementSummary", "ns3");

   /**
    * field for FromDate
    */
   protected java.util.Calendar localFromDate;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localFromDateTracker = false;

   /**
    * field for ToDate
    */
   protected java.util.Calendar localToDate;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localToDateTracker = false;

   /**
    * field for AchievementName
    */
   protected java.lang.String localAchievementName;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localAchievementNameTracker = false;

   /**
    * field for BrandId
    */
   protected java.lang.String localBrandId;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localBrandIdTracker = false;

   /**
    * field for Take
    */
   protected int localTake;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localTakeTracker = false;

   public boolean isFromDateSpecified() {
      return localFromDateTracker;
   }

   /**
    * Auto generated getter method
    * @return java.util.Calendar
    */
   public java.util.Calendar getFromDate() {
      return localFromDate;
   }

   /**
    * Auto generated setter method
    * @param param FromDate
    */
   public void setFromDate(java.util.Calendar param) {
      localFromDateTracker = param != null;

      this.localFromDate = param;
   }

   public boolean isToDateSpecified() {
      return localToDateTracker;
   }

   /**
    * Auto generated getter method
    * @return java.util.Calendar
    */
   public java.util.Calendar getToDate() {
      return localToDate;
   }

   /**
    * Auto generated setter method
    * @param param ToDate
    */
   public void setToDate(java.util.Calendar param) {
      localToDateTracker = param != null;

      this.localToDate = param;
   }

   public boolean isAchievementNameSpecified() {
      return localAchievementNameTracker;
   }

   /**
    * Auto generated getter method
    * @return java.lang.String
    */
   public java.lang.String getAchievementName() {
      return localAchievementName;
   }

   /**
    * Auto generated setter method
    * @param param AchievementName
    */
   public void setAchievementName(java.lang.String param) {
      localAchievementNameTracker = true;

      this.localAchievementName = param;
   }

   public boolean isBrandIdSpecified() {
      return localBrandIdTracker;
   }

   /**
    * Auto generated getter method
    * @return java.lang.String
    */
   public java.lang.String getBrandId() {
      return localBrandId;
   }

   /**
    * Auto generated setter method
    * @param param BrandId
    */
   public void setBrandId(java.lang.String param) {
      localBrandIdTracker = true;

      this.localBrandId = param;
   }

   public boolean isTakeSpecified() {
      return localTakeTracker;
   }

   /**
    * Auto generated getter method
    * @return int
    */
   public int getTake() {
      return localTake;
   }

   /**
    * Auto generated setter method
    * @param param Take
    */
   public void setTake(int param) {
      localTakeTracker = true;

      this.localTake = param;
   }

   /**
    *
    * @param parentQName
    * @param factory
    * @return org.apache.axiom.om.OMElement
    */
   public org.apache.axiom.om.OMElement getOMElement(
         final javax.xml.namespace.QName parentQName,
         final org.apache.axiom.om.OMFactory factory)
         throws org.apache.axis2.databinding.ADBException {
      return factory.createOMElement(new org.apache.axis2.databinding.ADBDataSource(
            this, MY_QNAME));
   }

   public void serialize(final javax.xml.namespace.QName parentQName,
         javax.xml.stream.XMLStreamWriter xmlWriter)
         throws javax.xml.stream.XMLStreamException,
         org.apache.axis2.databinding.ADBException {
      serialize(parentQName, xmlWriter, false);
   }

   public void serialize(final javax.xml.namespace.QName parentQName,
         javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
         throws javax.xml.stream.XMLStreamException,
         org.apache.axis2.databinding.ADBException {
      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(),
            xmlWriter);

      if (serializeType) {
         java.lang.String namespacePrefix = registerPrefix(xmlWriter,
               "http://playngo.com/v1");

         if ((namespacePrefix != null) &&
               (namespacePrefix.trim().length() > 0)) {
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "type",
                  namespacePrefix + ":GetAchievementSummary", xmlWriter);
         } else {
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "type",
                  "GetAchievementSummary", xmlWriter);
         }
      }

      if (localFromDateTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "FromDate", xmlWriter);

         if (localFromDate == null) {
            // write the nil attribute
            throw new org.apache.axis2.databinding.ADBException(
                  "FromDate cannot be null!!");
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localFromDate));
         }

         xmlWriter.writeEndElement();
      }

      if (localToDateTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "ToDate", xmlWriter);

         if (localToDate == null) {
            // write the nil attribute
            throw new org.apache.axis2.databinding.ADBException(
                  "ToDate cannot be null!!");
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localToDate));
         }

         xmlWriter.writeEndElement();
      }

      if (localAchievementNameTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "AchievementName", xmlWriter);

         if (localAchievementName == null) {
            // write the nil attribute
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(localAchievementName);
         }

         xmlWriter.writeEndElement();
      }

      if (localBrandIdTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "BrandId", xmlWriter);

         if (localBrandId == null) {
            // write the nil attribute
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(localBrandId);
         }

         xmlWriter.writeEndElement();
      }

      if (localTakeTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "Take", xmlWriter);

         if (localTake == java.lang.Integer.MIN_VALUE) {
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localTake));
         }

         xmlWriter.writeEndElement();
      }

      xmlWriter.writeEndElement();
   }

   private static java.lang.String generatePrefix(
         java.lang.String namespace) {
      if (namespace.equals("http://playngo.com/v1")) {
         return "ns3";
      }

      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
   }

   /**
    * Utility method to write an element start tag.
    */
   private void writeStartElement(java.lang.String prefix,
         java.lang.String namespace, java.lang.String localPart,
         javax.xml.stream.XMLStreamWriter xmlWriter)
         throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

      if (writerPrefix != null) {
         xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
         if (namespace.length() == 0) {
            prefix = "";
         } else if (prefix == null) {
            prefix = generatePrefix(namespace);
         }

         xmlWriter.writeStartElement(prefix, localPart, namespace);
         xmlWriter.writeNamespace(prefix, namespace);
         xmlWriter.setPrefix(prefix, namespace);
      }
   }

   /**
    * Util method to write an attribute with the ns prefix
    */
   private void writeAttribute(java.lang.String prefix,
         java.lang.String namespace, java.lang.String attName,
         java.lang.String attValue,
         javax.xml.stream.XMLStreamWriter xmlWriter)
         throws javax.xml.stream.XMLStreamException {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

      if (writerPrefix != null) {
         xmlWriter.writeAttribute(writerPrefix, namespace, attName,
               attValue);
      } else {
         xmlWriter.writeNamespace(prefix, namespace);
         xmlWriter.setPrefix(prefix, namespace);
         xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
   }

   /**
    * Util method to write an attribute without the ns prefix
    */
   private void writeAttribute(java.lang.String namespace,
         java.lang.String attName, java.lang.String attValue,
         javax.xml.stream.XMLStreamWriter xmlWriter)
         throws javax.xml.stream.XMLStreamException {
      if (namespace.equals("")) {
         xmlWriter.writeAttribute(attName, attValue);
      } else {
         xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace),
               namespace, attName, attValue);
      }
   }

   /**
    * Util method to write an attribute without the ns prefix
    */
   private void writeQNameAttribute(java.lang.String namespace,
         java.lang.String attName, javax.xml.namespace.QName qname,
         javax.xml.stream.XMLStreamWriter xmlWriter)
         throws javax.xml.stream.XMLStreamException {
      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

      if (attributePrefix == null) {
         attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }

      java.lang.String attributeValue;

      if (attributePrefix.trim().length() > 0) {
         attributeValue = attributePrefix + ":" + qname.getLocalPart();
      } else {
         attributeValue = qname.getLocalPart();
      }

      if (namespace.equals("")) {
         xmlWriter.writeAttribute(attName, attributeValue);
      } else {
         registerPrefix(xmlWriter, namespace);
         xmlWriter.writeAttribute(attributePrefix, namespace, attName,
               attributeValue);
      }
   }

   /**
    *  method to handle Qnames
    */
   private void writeQName(javax.xml.namespace.QName qname,
         javax.xml.stream.XMLStreamWriter xmlWriter)
         throws javax.xml.stream.XMLStreamException {
      java.lang.String namespaceURI = qname.getNamespaceURI();

      if (namespaceURI != null) {
         java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

         if (prefix == null) {
            prefix = generatePrefix(namespaceURI);
            xmlWriter.writeNamespace(prefix, namespaceURI);
            xmlWriter.setPrefix(prefix, namespaceURI);
         }

         if (prefix.trim().length() > 0) {
            xmlWriter.writeCharacters(prefix + ":" +
                  org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
         } else {
            // i.e this is the default namespace
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  qname));
         }
      } else {
         xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
               qname));
      }
   }

   private void writeQNames(javax.xml.namespace.QName[] qnames,
         javax.xml.stream.XMLStreamWriter xmlWriter)
         throws javax.xml.stream.XMLStreamException {
      if (qnames != null) {
         // we have to store this data until last moment since it is not possible to write any
         // namespace data after writing the charactor data
         java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
         java.lang.String namespaceURI = null;
         java.lang.String prefix = null;

         for (int i = 0; i < qnames.length; i++) {
            if (i > 0) {
               stringToWrite.append(" ");
            }

            namespaceURI = qnames[i].getNamespaceURI();

            if (namespaceURI != null) {
               prefix = xmlWriter.getPrefix(namespaceURI);

               if ((prefix == null) || (prefix.length() == 0)) {
                  prefix = generatePrefix(namespaceURI);
                  xmlWriter.writeNamespace(prefix, namespaceURI);
                  xmlWriter.setPrefix(prefix, namespaceURI);
               }

               if (prefix.trim().length() > 0) {
                  stringToWrite.append(prefix).append(":")
                        .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                              qnames[i]));
               } else {
                  stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qnames[i]));
               }
            } else {
               stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                     qnames[i]));
            }
         }

         xmlWriter.writeCharacters(stringToWrite.toString());
      }
   }

   /**
    * Register a namespace prefix
    */
   private java.lang.String registerPrefix(
         javax.xml.stream.XMLStreamWriter xmlWriter,
         java.lang.String namespace)
         throws javax.xml.stream.XMLStreamException {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);

      if (prefix == null) {
         prefix = generatePrefix(namespace);

         javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

         while (true) {
            java.lang.String uri = nsContext.getNamespaceURI(prefix);

            if ((uri == null) || (uri.length() == 0)) {
               break;
            }

            prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
         }

         xmlWriter.writeNamespace(prefix, namespace);
         xmlWriter.setPrefix(prefix, namespace);
      }

      return prefix;
   }

   /**
    *  Factory class that keeps the parse method
    */
   public static class Factory {
      private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(GetAchievementSummary.Factory.class);

      /**
       * static method to create the object
       * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
       *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
       * Postcondition: If this object is an element, the reader is positioned at its end element
       *                If this object is a complex type, the reader is positioned at the end element of its outer element
       */
      public static GetAchievementSummary parse(
            javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
         GetAchievementSummary object = new GetAchievementSummary();

         int event;
         javax.xml.namespace.QName currentQName = null;
         java.lang.String nillableValue = null;
         java.lang.String prefix = "";
         java.lang.String namespaceuri = "";

         try {
            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            currentQName = reader.getName();

            if (reader.getAttributeValue(
                  "http://www.w3.org/2001/XMLSchema-instance",
                  "type") != null) {
               java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "type");

               if (fullTypeName != null) {
                  java.lang.String nsPrefix = null;

                  if (fullTypeName.indexOf(":") > -1) {
                     nsPrefix = fullTypeName.substring(0,
                           fullTypeName.indexOf(":"));
                  }

                  nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                  java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                        ":") + 1);

                  if (!"GetAchievementSummary".equals(type)) {
                     //find namespace for the prefix
                     java.lang.String nsUri = reader.getNamespaceContext()
                           .getNamespaceURI(nsPrefix);

                     return (GetAchievementSummary) ExtensionMapper.getTypeObject(nsUri,
                           type, reader);
                  }
               }
            }

            // Note all attributes that were handled. Used to differ normal attributes
            // from anyAttributes.
            java.util.Vector handledAttributes = new java.util.Vector();

            reader.next();

            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            if ((reader.isStartElement() &&
                  new javax.xml.namespace.QName(
                        "http://playngo.com/v1", "FromDate").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "FromDate").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if ("true".equals(nillableValue) ||
                     "1".equals(nillableValue)) {
                  throw new org.apache.axis2.databinding.ADBException(
                        "The element: " + "FromDate" +
                              "  cannot be null");
               }

               java.lang.String content = reader.getElementText();

               object.setFromDate(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(
                     content));

               reader.next();
            } // End of if for expected property start element

            else {
            }

            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            if ((reader.isStartElement() &&
                  new javax.xml.namespace.QName(
                        "http://playngo.com/v1", "ToDate").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "ToDate").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if ("true".equals(nillableValue) ||
                     "1".equals(nillableValue)) {
                  throw new org.apache.axis2.databinding.ADBException(
                        "The element: " + "ToDate" +
                              "  cannot be null");
               }

               java.lang.String content = reader.getElementText();

               object.setToDate(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(
                     content));

               reader.next();
            } // End of if for expected property start element

            else {
            }

            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            if ((reader.isStartElement() &&
                  new javax.xml.namespace.QName(
                        "http://playngo.com/v1", "AchievementName").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "AchievementName").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setAchievementName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        content));
               } else {
                  reader.getElementText(); // throw away text nodes if any.
               }

               reader.next();
            } // End of if for expected property start element

            else {
            }

            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            if ((reader.isStartElement() &&
                  new javax.xml.namespace.QName(
                        "http://playngo.com/v1", "BrandId").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "BrandId").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setBrandId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        content));
               } else {
                  reader.getElementText(); // throw away text nodes if any.
               }

               reader.next();
            } // End of if for expected property start element

            else {
            }

            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            if ((reader.isStartElement() &&
                  new javax.xml.namespace.QName(
                        "http://playngo.com/v1", "Take").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "Take").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setTake(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                        content));
               } else {
                  object.setTake(java.lang.Integer.MIN_VALUE);

                  reader.getElementText(); // throw away text nodes if any.
               }

               reader.next();
            } // End of if for expected property start element

            else {
               object.setTake(java.lang.Integer.MIN_VALUE);
            }

            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            if (reader.isStartElement()) {
               // 2 - A start element we are not expecting indicates a trailing invalid property
               throw new org.apache.axis2.databinding.ADBException(
                     "Unexpected subelement " + reader.getName());
            }
         } catch (javax.xml.stream.XMLStreamException e) {
            throw new java.lang.Exception(e);
         }

         return object;
      }
   } //end of factory class
}
