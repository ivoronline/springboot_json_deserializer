package com.ivoronline.springboot_json_deserializer.DTO;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class PersonDTODeserializer extends JsonDeserializer<PersonDTO> {

  @Override
  public PersonDTO deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {

    //PREPARE JSON STUFF
    ObjectCodec objectCodec = jsonParser.getCodec();
    JsonNode    node        = objectCodec.readTree(jsonParser);

    //DESERIALIZE PROBLEMATIC JSON PROPERTIES: HEIGHT
    String heightString = node.get("height").asText();
           heightString = heightString.replace(',', '.');   //Convert "1,67" into "1.67"
    Float  height       = Float.parseFloat(heightString);   //Create Float from String

    //CREATE PERSONDTO
    PersonDTO personDTO        = new PersonDTO();
              personDTO.name   = node.get("name").asText();
              personDTO.height = height;

    //RETURN PERSONDTO
    return personDTO;

  }

}
