package com.app.ht.model;

import com.bluelinelabs.logansquare.JsonMapper;
import com.bluelinelabs.logansquare.LoganSquare;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unsafe,unchecked")
public final class AppointmentDateSlot$$JsonObjectMapper extends JsonMapper<AppointmentDateSlot> {
  private static final JsonMapper<TimingSlot> COM_APP_HT_MODEL_TIMINGSLOT__JSONOBJECTMAPPER = LoganSquare.mapperFor(TimingSlot.class);

  @Override
  public AppointmentDateSlot parse(JsonParser jsonParser) throws IOException {
    AppointmentDateSlot instance = new AppointmentDateSlot();
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
  public void parseField(AppointmentDateSlot instance, String fieldName, JsonParser jsonParser) throws IOException {
    if ("afternoon".equals(fieldName)) {
      if (jsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
        ArrayList<TimingSlot> collection1 = new ArrayList<TimingSlot>();
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
          TimingSlot value1;
          value1 = COM_APP_HT_MODEL_TIMINGSLOT__JSONOBJECTMAPPER.parse(jsonParser);
          collection1.add(value1);
        }
        instance.setAfternoon(collection1);
      } else {
        instance.setAfternoon(null);
      }
    } else if ("evening".equals(fieldName)) {
      if (jsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
        ArrayList<TimingSlot> collection1 = new ArrayList<TimingSlot>();
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
          TimingSlot value1;
          value1 = COM_APP_HT_MODEL_TIMINGSLOT__JSONOBJECTMAPPER.parse(jsonParser);
          collection1.add(value1);
        }
        instance.setEvening(collection1);
      } else {
        instance.setEvening(null);
      }
    } else if ("morning".equals(fieldName)) {
      if (jsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
        ArrayList<TimingSlot> collection1 = new ArrayList<TimingSlot>();
        while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
          TimingSlot value1;
          value1 = COM_APP_HT_MODEL_TIMINGSLOT__JSONOBJECTMAPPER.parse(jsonParser);
          collection1.add(value1);
        }
        instance.setMorning(collection1);
      } else {
        instance.setMorning(null);
      }
    }
  }

  @Override
  public void serialize(AppointmentDateSlot object, JsonGenerator jsonGenerator, boolean writeStartAndEnd) throws IOException {
    if (writeStartAndEnd) {
      jsonGenerator.writeStartObject();
    }
    final List<TimingSlot> lslocalafternoon = object.getAfternoon();
    if (lslocalafternoon != null) {
      jsonGenerator.writeFieldName("afternoon");
      jsonGenerator.writeStartArray();
      for (TimingSlot element1 : lslocalafternoon) {
        if (element1 != null) {
          COM_APP_HT_MODEL_TIMINGSLOT__JSONOBJECTMAPPER.serialize(element1, jsonGenerator, true);
        }
      }
      jsonGenerator.writeEndArray();
    }
    final List<TimingSlot> lslocalevening = object.getEvening();
    if (lslocalevening != null) {
      jsonGenerator.writeFieldName("evening");
      jsonGenerator.writeStartArray();
      for (TimingSlot element1 : lslocalevening) {
        if (element1 != null) {
          COM_APP_HT_MODEL_TIMINGSLOT__JSONOBJECTMAPPER.serialize(element1, jsonGenerator, true);
        }
      }
      jsonGenerator.writeEndArray();
    }
    final List<TimingSlot> lslocalmorning = object.getMorning();
    if (lslocalmorning != null) {
      jsonGenerator.writeFieldName("morning");
      jsonGenerator.writeStartArray();
      for (TimingSlot element1 : lslocalmorning) {
        if (element1 != null) {
          COM_APP_HT_MODEL_TIMINGSLOT__JSONOBJECTMAPPER.serialize(element1, jsonGenerator, true);
        }
      }
      jsonGenerator.writeEndArray();
    }
    if (writeStartAndEnd) {
      jsonGenerator.writeEndObject();
    }
  }
}
