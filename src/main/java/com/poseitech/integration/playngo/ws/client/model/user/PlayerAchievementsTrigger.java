package com.poseitech.integration.playngo.ws.client.model.user;

import com.poseitech.integration.playngo.ws.client.v1.ExtensionMapper;

/**
 * PlayerAchievementsTrigger bean class
 */
public class PlayerAchievementsTrigger implements org.apache.axis2.databinding.ADBBean {
        /* This type was generated from the piece of schema that had
           name = PlayerAchievementsTrigger
           Namespace URI = http://playngo.com/v1
           Namespace Prefix = ns3
         */

   /**
    * field for Time
    */
   protected java.util.Calendar localTime;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localTimeTracker = false;

   /**
    * field for ParentName
    */
   protected java.lang.String localParentName;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localParentNameTracker = false;

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
    * field for GameId
    */
   protected int localGameId;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localGameIdTracker = false;

   /**
    * field for RoundId
    */
   protected long localRoundId;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localRoundIdTracker = false;

   /**
    * field for Spin
    */
   protected int localSpin;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localSpinTracker = false;

   /**
    * field for ResultId
    */
   protected int localResultId;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localResultIdTracker = false;

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
    * field for Count
    */
   protected int localCount;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localCountTracker = false;

   /**
    * field for Nickname
    */
   protected java.lang.String localNickname;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localNicknameTracker = false;

   /**
    * field for FreegameTriggerId
    */
   protected int localFreegameTriggerId;

   /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
   protected boolean localFreegameTriggerIdTracker = false;

   public boolean isTimeSpecified() {
      return localTimeTracker;
   }

   /**
    * Auto generated getter method
    * @return java.util.Calendar
    */
   public java.util.Calendar getTime() {
      return localTime;
   }

   /**
    * Auto generated setter method
    * @param param Time
    */
   public void setTime(java.util.Calendar param) {
      localTimeTracker = true;

      this.localTime = param;
   }

   public boolean isParentNameSpecified() {
      return localParentNameTracker;
   }

   /**
    * Auto generated getter method
    * @return java.lang.String
    */
   public java.lang.String getParentName() {
      return localParentName;
   }

   /**
    * Auto generated setter method
    * @param param ParentName
    */
   public void setParentName(java.lang.String param) {
      localParentNameTracker = true;

      this.localParentName = param;
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

   public boolean isGameIdSpecified() {
      return localGameIdTracker;
   }

   /**
    * Auto generated getter method
    * @return int
    */
   public int getGameId() {
      return localGameId;
   }

   /**
    * Auto generated setter method
    * @param param GameId
    */
   public void setGameId(int param) {
      localGameIdTracker = true;

      this.localGameId = param;
   }

   public boolean isRoundIdSpecified() {
      return localRoundIdTracker;
   }

   /**
    * Auto generated getter method
    * @return long
    */
   public long getRoundId() {
      return localRoundId;
   }

   /**
    * Auto generated setter method
    * @param param RoundId
    */
   public void setRoundId(long param) {
      localRoundIdTracker = true;

      this.localRoundId = param;
   }

   public boolean isSpinSpecified() {
      return localSpinTracker;
   }

   /**
    * Auto generated getter method
    * @return int
    */
   public int getSpin() {
      return localSpin;
   }

   /**
    * Auto generated setter method
    * @param param Spin
    */
   public void setSpin(int param) {
      localSpinTracker = true;

      this.localSpin = param;
   }

   public boolean isResultIdSpecified() {
      return localResultIdTracker;
   }

   /**
    * Auto generated getter method
    * @return int
    */
   public int getResultId() {
      return localResultId;
   }

   /**
    * Auto generated setter method
    * @param param ResultId
    */
   public void setResultId(int param) {
      localResultIdTracker = true;

      this.localResultId = param;
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
      localPointsTracker = true;

      this.localPoints = param;
   }

   public boolean isCountSpecified() {
      return localCountTracker;
   }

   /**
    * Auto generated getter method
    * @return int
    */
   public int getCount() {
      return localCount;
   }

   /**
    * Auto generated setter method
    * @param param Count
    */
   public void setCount(int param) {
      // setting primitive attribute tracker to true
      localCountTracker = param != java.lang.Integer.MIN_VALUE;

      this.localCount = param;
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

   public boolean isFreegameTriggerIdSpecified() {
      return localFreegameTriggerIdTracker;
   }

   /**
    * Auto generated getter method
    * @return int
    */
   public int getFreegameTriggerId() {
      return localFreegameTriggerId;
   }

   /**
    * Auto generated setter method
    * @param param FreegameTriggerId
    */
   public void setFreegameTriggerId(int param) {
      localFreegameTriggerIdTracker = true;

      this.localFreegameTriggerId = param;
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
                  namespacePrefix + ":PlayerAchievementsTrigger",
                  xmlWriter);
         } else {
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "type",
                  "PlayerAchievementsTrigger", xmlWriter);
         }
      }

      if (localTimeTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "Time", xmlWriter);

         if (localTime == null) {
            // write the nil attribute
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localTime));
         }

         xmlWriter.writeEndElement();
      }

      if (localParentNameTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "ParentName", xmlWriter);

         if (localParentName == null) {
            // write the nil attribute
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(localParentName);
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

      if (localGameIdTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "GameId", xmlWriter);

         if (localGameId == java.lang.Integer.MIN_VALUE) {
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localGameId));
         }

         xmlWriter.writeEndElement();
      }

      if (localRoundIdTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "RoundId", xmlWriter);

         if (localRoundId == java.lang.Long.MIN_VALUE) {
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localRoundId));
         }

         xmlWriter.writeEndElement();
      }

      if (localSpinTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "Spin", xmlWriter);

         if (localSpin == java.lang.Integer.MIN_VALUE) {
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localSpin));
         }

         xmlWriter.writeEndElement();
      }

      if (localResultIdTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "ResultId", xmlWriter);

         if (localResultId == java.lang.Integer.MIN_VALUE) {
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localResultId));
         }

         xmlWriter.writeEndElement();
      }

      if (localPointsTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "Points", xmlWriter);

         if (localPoints == java.lang.Integer.MIN_VALUE) {
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localPoints));
         }

         xmlWriter.writeEndElement();
      }

      if (localCountTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "Count", xmlWriter);

         if (localCount == java.lang.Integer.MIN_VALUE) {
            throw new org.apache.axis2.databinding.ADBException(
                  "Count cannot be null!!");
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localCount));
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

      if (localFreegameTriggerIdTracker) {
         namespace = "http://playngo.com/v1";
         writeStartElement(null, namespace, "FreegameTriggerId",
               xmlWriter);

         if (localFreegameTriggerId == java.lang.Integer.MIN_VALUE) {
            writeAttribute("xsi",
                  "http://www.w3.org/2001/XMLSchema-instance", "nil",
                  "1", xmlWriter);
         } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                  localFreegameTriggerId));
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
      private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(PlayerAchievementsTrigger.Factory.class);

      /**
       * static method to create the object
       * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
       *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
       * Postcondition: If this object is an element, the reader is positioned at its end element
       *                If this object is a complex type, the reader is positioned at the end element of its outer element
       */
      public static PlayerAchievementsTrigger parse(
            javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
         PlayerAchievementsTrigger object = new PlayerAchievementsTrigger();

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

                  if (!"PlayerAchievementsTrigger".equals(type)) {
                     //find namespace for the prefix
                     java.lang.String nsUri = reader.getNamespaceContext()
                           .getNamespaceURI(nsPrefix);

                     return (PlayerAchievementsTrigger) ExtensionMapper.getTypeObject(nsUri,
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
                        "http://playngo.com/v1", "Time").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "Time").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setTime(org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(
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
                        "http://playngo.com/v1", "ParentName").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "ParentName").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setParentName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
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
                        "http://playngo.com/v1", "GameId").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "GameId").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setGameId(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                        content));
               } else {
                  object.setGameId(java.lang.Integer.MIN_VALUE);

                  reader.getElementText(); // throw away text nodes if any.
               }

               reader.next();
            } // End of if for expected property start element

            else {
               object.setGameId(java.lang.Integer.MIN_VALUE);
            }

            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            if ((reader.isStartElement() &&
                  new javax.xml.namespace.QName(
                        "http://playngo.com/v1", "RoundId").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "RoundId").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setRoundId(org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(
                        content));
               } else {
                  object.setRoundId(java.lang.Long.MIN_VALUE);

                  reader.getElementText(); // throw away text nodes if any.
               }

               reader.next();
            } // End of if for expected property start element

            else {
               object.setRoundId(java.lang.Long.MIN_VALUE);
            }

            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            if ((reader.isStartElement() &&
                  new javax.xml.namespace.QName(
                        "http://playngo.com/v1", "Spin").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "Spin").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setSpin(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                        content));
               } else {
                  object.setSpin(java.lang.Integer.MIN_VALUE);

                  reader.getElementText(); // throw away text nodes if any.
               }

               reader.next();
            } // End of if for expected property start element

            else {
               object.setSpin(java.lang.Integer.MIN_VALUE);
            }

            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            if ((reader.isStartElement() &&
                  new javax.xml.namespace.QName(
                        "http://playngo.com/v1", "ResultId").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "ResultId").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setResultId(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                        content));
               } else {
                  object.setResultId(java.lang.Integer.MIN_VALUE);

                  reader.getElementText(); // throw away text nodes if any.
               }

               reader.next();
            } // End of if for expected property start element

            else {
               object.setResultId(java.lang.Integer.MIN_VALUE);
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

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setPoints(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                        content));
               } else {
                  object.setPoints(java.lang.Integer.MIN_VALUE);

                  reader.getElementText(); // throw away text nodes if any.
               }

               reader.next();
            } // End of if for expected property start element

            else {
               object.setPoints(java.lang.Integer.MIN_VALUE);
            }

            while (!reader.isStartElement() && !reader.isEndElement())
               reader.next();

            if ((reader.isStartElement() &&
                  new javax.xml.namespace.QName(
                        "http://playngo.com/v1", "Count").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("", "Count").equals(
                        reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if ("true".equals(nillableValue) ||
                     "1".equals(nillableValue)) {
                  throw new org.apache.axis2.databinding.ADBException(
                        "The element: " + "Count" + "  cannot be null");
               }

               java.lang.String content = reader.getElementText();

               object.setCount(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                     content));

               reader.next();
            } // End of if for expected property start element

            else {
               object.setCount(java.lang.Integer.MIN_VALUE);
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

            if ((reader.isStartElement() &&
                  new javax.xml.namespace.QName(
                        "http://playngo.com/v1", "FreegameTriggerId").equals(
                        reader.getName())) ||
                  new javax.xml.namespace.QName("",
                        "FreegameTriggerId").equals(reader.getName())) {
               nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                     "nil");

               if (!"true".equals(nillableValue) &&
                     !"1".equals(nillableValue)) {
                  java.lang.String content = reader.getElementText();

                  object.setFreegameTriggerId(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(
                        content));
               } else {
                  object.setFreegameTriggerId(java.lang.Integer.MIN_VALUE);

                  reader.getElementText(); // throw away text nodes if any.
               }

               reader.next();
            } // End of if for expected property start element

            else {
               object.setFreegameTriggerId(java.lang.Integer.MIN_VALUE);
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
