package restassuredAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder//позволяет потом создавать объекты без конструктора
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)

public class PetDto { //Data Transfer Object - DTO
//в реквесте много полей, если для них делать геттеры и сеттеры, то получится много кода, поэтому подключили Ломбок
    //Ломбок дает возможность одной аннотацией поставить Геттер

    private String name;
    private String status;
    private long id;
}
