package com.Sena.ShoppingCart.Dto;

import com.Sena.ShoppingCart.Entity.Security.User;

import java.util.Optional;

public class ApiResponseDto<T> {
    private Boolean status;
    private T data;
    private String message;
    public ApiResponseDto(String datosGuardados, Optional<User> login, boolean status) {
    }
    public ApiResponseDto(String message, T data, Boolean status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
