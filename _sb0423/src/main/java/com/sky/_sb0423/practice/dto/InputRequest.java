package com.sky._sb0423.practice.dto;

import lombok.Data;


import javax.validation.constraints.*;

@Data
public class InputRequest {
//    @NotEmpty
    @NotBlank

    private String name;
    @NotNull(message = "숫자 2자리까지만 입력하시오.")
    @Min(18)
    private Integer age;
    @Pattern(regexp = "^[0-9]{3}[-]+[0-9]{4}[-]+[0-9]{4}$", message = "000-0000-0000")
    private String phone;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "이메일 형식으로 입력")
    private String email;
    @NotEmpty
    private String addr;

}
