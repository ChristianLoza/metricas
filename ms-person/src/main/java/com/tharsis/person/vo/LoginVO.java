package com.tharsis.person.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author christian
 */
@Getter
@Setter
@NoArgsConstructor
public class LoginVO {
    private String dni;
    private String password;
}
