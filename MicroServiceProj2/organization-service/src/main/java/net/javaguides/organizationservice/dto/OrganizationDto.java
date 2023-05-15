package net.javaguides.organizationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

    private  Long id;

    private  String organizationName;
    private String organizationDescription;

    private String organizationCode;
    //automatically give current date and time to db

    private LocalDateTime createdDate;

}
