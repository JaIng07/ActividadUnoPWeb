package com.project.web.dtos.usuario;

public record UsuarioToSaveDto(
    Long id,
    String nombre,
    String apellido,
    String userName,
    String password,
    String email) {
}
