package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"value"
})
public class Feature {

@JsonProperty("name")
private String name;
@JsonProperty("value")
private Integer value;

public Feature() {
	
}
public Feature(Integer value, String name) {
	this.value = value;
	this.name = name;
}

@JsonProperty("name")
public String getName() {
return name;
 }

@JsonProperty("name")
public void setName(String name) {
this.name = name;
 }

@JsonProperty("value")
public Integer getValue() {
return value;
 }

@JsonProperty("value")
public void setValue(Integer value) {
this.value = value;
 }

}
