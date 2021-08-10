package lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/* json-схема

    "data": {
        "id": 2,
        "email": "janet.weaver@reqres.in",
        "first_name": "Janet",
        "last_name": "Weaver",
                это игнорировать аннотацией-->"avatar": "https://reqres.in/img/faces/2-image.jpg"
    }
*/

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LombokUser {
    private Integer id;
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;
}