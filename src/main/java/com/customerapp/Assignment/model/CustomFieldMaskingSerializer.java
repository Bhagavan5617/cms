package com.customerapp.Assignment.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/*
 * public class CustomFieldMaskingSerializer extends JsonSerializer<String> {
 * 
 * @Override public void serialize(String value, JsonGenerator gen,
 * SerializerProvider serializers) throws IOException { // Implement your logic
 * to mask the sensitive data String maskedValue = maskSensitiveData(value);
 * gen.writeString(maskedValue); }
 * 
 * private String maskSensitiveData(String value) { if (value == null ||
 * value.isEmpty()) { return value; }
 * 
 * int visibleChars = Math.min(value.length(), 4); int maskedLength =
 * value.length() - visibleChars;
 * 
 * StringBuilder maskedValue = new StringBuilder(); for (int i = 0; i <
 * maskedLength; i++) { maskedValue.append('*'); }
 * 
 * maskedValue.append(value.substring(value.length() - visibleChars));
 * 
 * return maskedValue.toString(); } }
 */


