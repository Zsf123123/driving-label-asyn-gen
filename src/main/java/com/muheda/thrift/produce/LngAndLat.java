/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.muheda.thrift.produce;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-04-18")
public class LngAndLat implements org.apache.thrift.TBase<LngAndLat, LngAndLat._Fields>, java.io.Serializable, Cloneable, Comparable<LngAndLat> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("LngAndLat");

  private static final org.apache.thrift.protocol.TField DEVICE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("deviceId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField LNG_FIELD_DESC = new org.apache.thrift.protocol.TField("lng", org.apache.thrift.protocol.TType.DOUBLE, (short)2);
  private static final org.apache.thrift.protocol.TField LAT_FIELD_DESC = new org.apache.thrift.protocol.TField("lat", org.apache.thrift.protocol.TType.DOUBLE, (short)3);
  private static final org.apache.thrift.protocol.TField TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("time", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new LngAndLatStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new LngAndLatTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable String deviceId; // required
  public double lng; // required
  public double lat; // required
  public @org.apache.thrift.annotation.Nullable String time; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DEVICE_ID((short)1, "deviceId"),
    LNG((short)2, "lng"),
    LAT((short)3, "lat"),
    TIME((short)4, "time");

    private static final java.util.Map<String, _Fields> byName = new java.util.HashMap<String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DEVICE_ID
          return DEVICE_ID;
        case 2: // LNG
          return LNG;
        case 3: // LAT
          return LAT;
        case 4: // TIME
          return TIME;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __LNG_ISSET_ID = 0;
  private static final int __LAT_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DEVICE_ID, new org.apache.thrift.meta_data.FieldMetaData("deviceId", org.apache.thrift.TFieldRequirementType.DEFAULT,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LNG, new org.apache.thrift.meta_data.FieldMetaData("lng", org.apache.thrift.TFieldRequirementType.DEFAULT,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.LAT, new org.apache.thrift.meta_data.FieldMetaData("lat", org.apache.thrift.TFieldRequirementType.DEFAULT,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.TIME, new org.apache.thrift.meta_data.FieldMetaData("time", org.apache.thrift.TFieldRequirementType.DEFAULT,
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(LngAndLat.class, metaDataMap);
  }

  public LngAndLat() {
  }

  public LngAndLat(
    String deviceId,
    double lng,
    double lat,
    String time)
  {
    this();
    this.deviceId = deviceId;
    this.lng = lng;
    setLngIsSet(true);
    this.lat = lat;
    setLatIsSet(true);
    this.time = time;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public LngAndLat(LngAndLat other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetDeviceId()) {
      this.deviceId = other.deviceId;
    }
    this.lng = other.lng;
    this.lat = other.lat;
    if (other.isSetTime()) {
      this.time = other.time;
    }
  }

  public LngAndLat deepCopy() {
    return new LngAndLat(this);
  }

  @Override
  public void clear() {
    this.deviceId = null;
    setLngIsSet(false);
    this.lng = 0.0;
    setLatIsSet(false);
    this.lat = 0.0;
    this.time = null;
  }

  @org.apache.thrift.annotation.Nullable
  public String getDeviceId() {
    return this.deviceId;
  }

  public LngAndLat setDeviceId(@org.apache.thrift.annotation.Nullable String deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  public void unsetDeviceId() {
    this.deviceId = null;
  }

  /** Returns true if field deviceId is set (has been assigned a value) and false otherwise */
  public boolean isSetDeviceId() {
    return this.deviceId != null;
  }

  public void setDeviceIdIsSet(boolean value) {
    if (!value) {
      this.deviceId = null;
    }
  }

  public double getLng() {
    return this.lng;
  }

  public LngAndLat setLng(double lng) {
    this.lng = lng;
    setLngIsSet(true);
    return this;
  }

  public void unsetLng() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LNG_ISSET_ID);
  }

  /** Returns true if field lng is set (has been assigned a value) and false otherwise */
  public boolean isSetLng() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LNG_ISSET_ID);
  }

  public void setLngIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LNG_ISSET_ID, value);
  }

  public double getLat() {
    return this.lat;
  }

  public LngAndLat setLat(double lat) {
    this.lat = lat;
    setLatIsSet(true);
    return this;
  }

  public void unsetLat() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LAT_ISSET_ID);
  }

  /** Returns true if field lat is set (has been assigned a value) and false otherwise */
  public boolean isSetLat() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LAT_ISSET_ID);
  }

  public void setLatIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LAT_ISSET_ID, value);
  }

  @org.apache.thrift.annotation.Nullable
  public String getTime() {
    return this.time;
  }

  public LngAndLat setTime(@org.apache.thrift.annotation.Nullable String time) {
    this.time = time;
    return this;
  }

  public void unsetTime() {
    this.time = null;
  }

  /** Returns true if field time is set (has been assigned a value) and false otherwise */
  public boolean isSetTime() {
    return this.time != null;
  }

  public void setTimeIsSet(boolean value) {
    if (!value) {
      this.time = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable Object value) {
    switch (field) {
    case DEVICE_ID:
      if (value == null) {
        unsetDeviceId();
      } else {
        setDeviceId((String)value);
      }
      break;

    case LNG:
      if (value == null) {
        unsetLng();
      } else {
        setLng((Double)value);
      }
      break;

    case LAT:
      if (value == null) {
        unsetLat();
      } else {
        setLat((Double)value);
      }
      break;

    case TIME:
      if (value == null) {
        unsetTime();
      } else {
        setTime((String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public Object getFieldValue(_Fields field) {
    switch (field) {
    case DEVICE_ID:
      return getDeviceId();

    case LNG:
      return getLng();

    case LAT:
      return getLat();

    case TIME:
      return getTime();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case DEVICE_ID:
      return isSetDeviceId();
    case LNG:
      return isSetLng();
    case LAT:
      return isSetLat();
    case TIME:
      return isSetTime();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof LngAndLat)
      return this.equals((LngAndLat)that);
    return false;
  }

  public boolean equals(LngAndLat that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_deviceId = true && this.isSetDeviceId();
    boolean that_present_deviceId = true && that.isSetDeviceId();
    if (this_present_deviceId || that_present_deviceId) {
      if (!(this_present_deviceId && that_present_deviceId))
        return false;
      if (!this.deviceId.equals(that.deviceId))
        return false;
    }

    boolean this_present_lng = true;
    boolean that_present_lng = true;
    if (this_present_lng || that_present_lng) {
      if (!(this_present_lng && that_present_lng))
        return false;
      if (this.lng != that.lng)
        return false;
    }

    boolean this_present_lat = true;
    boolean that_present_lat = true;
    if (this_present_lat || that_present_lat) {
      if (!(this_present_lat && that_present_lat))
        return false;
      if (this.lat != that.lat)
        return false;
    }

    boolean this_present_time = true && this.isSetTime();
    boolean that_present_time = true && that.isSetTime();
    if (this_present_time || that_present_time) {
      if (!(this_present_time && that_present_time))
        return false;
      if (!this.time.equals(that.time))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetDeviceId()) ? 131071 : 524287);
    if (isSetDeviceId())
      hashCode = hashCode * 8191 + deviceId.hashCode();

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(lng);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(lat);

    hashCode = hashCode * 8191 + ((isSetTime()) ? 131071 : 524287);
    if (isSetTime())
      hashCode = hashCode * 8191 + time.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(LngAndLat other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetDeviceId()).compareTo(other.isSetDeviceId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeviceId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deviceId, other.deviceId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLng()).compareTo(other.isSetLng());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLng()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lng, other.lng);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLat()).compareTo(other.isSetLat());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLat()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lat, other.lat);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTime()).compareTo(other.isSetTime());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTime()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.time, other.time);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("LngAndLat(");
    boolean first = true;

    sb.append("deviceId:");
    if (this.deviceId == null) {
      sb.append("null");
    } else {
      sb.append(this.deviceId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("lng:");
    sb.append(this.lng);
    first = false;
    if (!first) sb.append(", ");
    sb.append("lat:");
    sb.append(this.lat);
    first = false;
    if (!first) sb.append(", ");
    sb.append("time:");
    if (this.time == null) {
      sb.append("null");
    } else {
      sb.append(this.time);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class LngAndLatStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public LngAndLatStandardScheme getScheme() {
      return new LngAndLatStandardScheme();
    }
  }

  private static class LngAndLatStandardScheme extends org.apache.thrift.scheme.StandardScheme<LngAndLat> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, LngAndLat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DEVICE_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.deviceId = iprot.readString();
              struct.setDeviceIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LNG
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.lng = iprot.readDouble();
              struct.setLngIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LAT
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.lat = iprot.readDouble();
              struct.setLatIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.time = iprot.readString();
              struct.setTimeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, LngAndLat struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.deviceId != null) {
        oprot.writeFieldBegin(DEVICE_ID_FIELD_DESC);
        oprot.writeString(struct.deviceId);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(LNG_FIELD_DESC);
      oprot.writeDouble(struct.lng);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(LAT_FIELD_DESC);
      oprot.writeDouble(struct.lat);
      oprot.writeFieldEnd();
      if (struct.time != null) {
        oprot.writeFieldBegin(TIME_FIELD_DESC);
        oprot.writeString(struct.time);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class LngAndLatTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public LngAndLatTupleScheme getScheme() {
      return new LngAndLatTupleScheme();
    }
  }

  private static class LngAndLatTupleScheme extends org.apache.thrift.scheme.TupleScheme<LngAndLat> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, LngAndLat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetDeviceId()) {
        optionals.set(0);
      }
      if (struct.isSetLng()) {
        optionals.set(1);
      }
      if (struct.isSetLat()) {
        optionals.set(2);
      }
      if (struct.isSetTime()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetDeviceId()) {
        oprot.writeString(struct.deviceId);
      }
      if (struct.isSetLng()) {
        oprot.writeDouble(struct.lng);
      }
      if (struct.isSetLat()) {
        oprot.writeDouble(struct.lat);
      }
      if (struct.isSetTime()) {
        oprot.writeString(struct.time);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, LngAndLat struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.deviceId = iprot.readString();
        struct.setDeviceIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.lng = iprot.readDouble();
        struct.setLngIsSet(true);
      }
      if (incoming.get(2)) {
        struct.lat = iprot.readDouble();
        struct.setLatIsSet(true);
      }
      if (incoming.get(3)) {
        struct.time = iprot.readString();
        struct.setTimeIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

