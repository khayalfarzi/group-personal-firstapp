package az.coders.grouppersonal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    public int objectId;
    public String districtId;
    public String name;
    public String nameEn;
    public String state;
    public String typeName;
}