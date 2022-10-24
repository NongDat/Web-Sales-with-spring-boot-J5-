package com.poly.modelDTO;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    
    private Integer id;
    @NotBlank
    private String name;
//    @NotEmpty
    private String image;
    @NotNull
    @DecimalMin("4")
    private Double price;
    @NotEmpty
    String createDate ;
    private Boolean available;
    @NotEmpty
    private String categoryId;
}
