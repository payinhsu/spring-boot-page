package com.poseitech.integration.playngo.ws.client.model.user;

import com.poseitech.integration.playngo.ws.client.v1.ExtensionMapper;

/**
 * AchievementsSummary bean class
 */
public class AchievementsSummary implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = AchievementsSummary
           Namespace URI = http://playngo.com/v1
           Namespace Prefix = ns3
         */

   /**
    * field for ExternalId
    */
   protected java.lang.String localExternalId;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localExternalIdTracker = false;

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
    * field for Name
    */
   protected java.lang.String localName;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localNameTracker = false;

   /**
    * field for Points
    */
   protected int localPoints;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localPointsTracker = false;

   /**
    * field for Nickname
    */
   protected java.lang.String localNickname;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localNicknameTracker = false;

   public boolean isExternalIdSpecified() {
      return localExternalIdTracker;
   }

   /**
    * Auto generated getter method
    * @return java.lang.String
    */
   public java.lang.String getExternalId() {
      return localExternalId;
   }

   /**
    * Auto generated setter method
    * @param param ExternalId
    */
   public void setExternalId(java.lang.String param) {
      localExternalIdTracker = true;

      this.localExternalId = param;
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

   public boolean isNameSpecified() {
      return localNameTracker;
   }

   /**
    * Auto generated getter method
    * @return java.lang.String
    */
   public java.lang.String getName() {
      return localName;
   }

   /**
    * Auto generated setter method
    * @param param Name
    */
   public void setName(java.lang.String param) {
      localNameTracker = true;

      this.localName = param;
   }

   public boolean isPointsSpecified() {
      return localPointsTracker;
   }

   /**
    * Auto generated getter method
    * @return int
    */
   public int getPoints() {
      return localPoints;
   }

   /**
    * Auto generated setter method
    * @param param Points
    */
   public void setPoints(int param) {
      // setting primitive attribute tracker to true
      localPointsTracker = param != java.lang.Integer.MIN_VALUE;

      this.localPoints = param;
   }

   public boolean isNicknameSpecified() {
      return localNicknameTracker;
   }

   /**
    * Auto generated getter method
    * @return java.lang.String
    */
   public java.lang.String getNickname() {
      return localNickname;
   }

   /**
    * Auto generated setter method
    * @param param Nickname
    */
   public void setNickname(java.lang.String param) {
      localNicknameTracker = true;

      this.localNickname = param;
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
            this, parentQName));
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
                  namespacePrefix + ":AchievementsSummary", xmlWriter);
         } else {
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "type",
                  "AchievementsSummary", xmlWriter);
         }
      }

      if (localExternalIdTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "ExternalId", xmlWriter);

         if (localExternalId == null) {
            // write the nil attribute
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(localExternalId);
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

      if (localNameTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "Name", xmlWriter);

         if (localName == null) {
            // write the nil attribute
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(localName);
         }

         xmlWriter.writeEndElement();
      }

      if (localPointsTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "Points", xmlWriter);

         if (localPoints == java.lang.Integer.MIN_VALUE) {
            throw new org.apache.axis2.databinding.ADBException(
                  "Points cannot be null!!");
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localPoints));
         }

         xmlWriter.writeEndElement();
      }

      if (localNicknameTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "Nickname", xmlWriter);

         if (localNickname == null) {
            // write the nil attribute
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(localNickname);
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
      private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(AchievementsSummary.Factory.class);

      /**
       * static method to create the object
       * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
       *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
       * Postcondition: If this object is an element, the reader is positioned at its end element
       *                If this object is a complex type, the reader is positioned at the end element of its outer element
       */
      public static AchievementsSummary parse(
            javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
         AchievementsSummary object = new AchievementsSummary();

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

                  if (!"AchievementsSummary".equals(type)) {
                     //find namespace for the prefix
                     java.lang.String nsUri = reader.getNamespaceContext()
                           .getNamespaceURI(nsPrefix);

                     return (AchievementsSummary) ExtensionMapper.getTypeObject(nsUri,
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
                        "http://playngo.com/v1", "ExternalId").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "ExternalId").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setExternalId(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
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
                        "http://playngo.com/v1", "Name").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "Name").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
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
                        "http://playngo.com/v1", "Points").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "Points").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if ("true".equals(nillableValue) ||
                     "1".equals(nillableValue)) {
                  throw new org.apache.axis2.databinding.ADBException(
                        "The element: " + "Points" +
                              "  cannot be null");
               }

               java.lang.String content = reader.getElementText();

               object.setPoints(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                     content));

               reader.next();
            } // End of if for expected property start element

            else {
               object.setPoints(java.lang.Integer.MIN_VALUE);
            }

            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            if ((reader.isStartElement() &&
                  new javax.xml.namespace.QName(
                        "http://playngo.com/v1", "Nickname").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "Nickname").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setNickname(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
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
