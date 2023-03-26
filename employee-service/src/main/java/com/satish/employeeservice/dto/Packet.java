package com.satish.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Packet<T>{
    private String status;
    private String message;
    private T data;

    public Packet(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
