package com.geek.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author geek
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class User {

    private String name;
    private Integer age;

}
