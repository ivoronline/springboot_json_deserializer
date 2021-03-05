package com.ivoronline.springboot_json_deserializer.DTO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = PersonDTODeserializer.class)
public class PersonDTO {
  public String name;
  public Float  height;
}
