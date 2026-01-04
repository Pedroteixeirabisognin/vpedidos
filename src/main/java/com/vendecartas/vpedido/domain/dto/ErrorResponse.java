package com.vendecartas.vpedido.domain.dto;

public record ErrorResponse(int status, String error, String mensage) {}
