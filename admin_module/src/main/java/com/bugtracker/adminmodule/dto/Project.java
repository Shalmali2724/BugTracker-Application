package com.bugtracker.adminmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 

@Data
@NoArgsConstructor
@AllArgsConstructor

 

public class Project {

 

    private long projectId;
    private String projectName;
    private Employee employee;
    private String projectStatus;


 

}
