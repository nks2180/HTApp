package com.app.ht.model;

import com.bluelinelabs.logansquare.JsonMapper;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings("unsafe,unchecked")
public final class TimingSlot$$JsonObjectMapper extends JsonMapper<TimingSlot> {
  @Override
  public TimingSlot parse(JsonParser jsonParser) throws IOException {
    TimingSlot instance = new TimingSlot();
    if (jsonParser.getCurrentToken() == null) {
      jsonParser.nextToken();
    }
    if (jsonParser.getCurrentToken() != JsonToken.START_OBJECT) {
      jsonParser.skipChildren();
      return null;
    }
    while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
      String fieldName = jsonParser.getCurrentName();
      jsonParser.nextToken();
      parseField(instance, fieldName, jsonParser);
      jsonParser.skipChildren();
    }
    return instance;
  }

  @Override
  public void parseField(TimingSlot instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("end_time".equals(fieldName)) {
      instance.setEndTime(jsonParser.getValueAsString(null));
    } else if ("is_booked".equals(fieldName)) {
      instance.setIsBooked(jsonParser.getValueAsBoolean());
    } else if ("is_expired".equals(fieldName)) {
      instance.setIsExpired(jsonParser.getValueAsBoolean());
    } else if ("slot_id".equals(fieldName)) {
      instance.setSlotId(jsonParser.getValueAsInt());
    } else if ("start_time".equals(fieldName)) {
      instance.setStartTime(jsonParser.getValueAsString(null));
    }
  }

  @Override
  public void serialize(TimingSlot object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    if (object.getEndTime() != null) {
      jsonGenerator.writeStringField("end_time", object.getEndTime());
    }
    jsonGenerator.writeBooleanField("is_booked", object.isIsBooked());
    jsonGenerator.writeBooleanField("is_expired", object.isIsExpired());
    jsonGenerator.writeNumberField("slot_id", object.getSlotId());
    if (object.getStartTime() != null) {
      jsonGenerator.writeStringField("start_time", object.getStartTime());
    }
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
