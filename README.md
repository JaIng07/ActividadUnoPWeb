Actividad #1 Programación Web 2024-1
Realizado por Nelson Martínez y Javier Figueroa

En el actual proyecto desarrollado con SpringBoot estamos implementando una pequeña base de datos,
la cual consta de 4 tablas (Usuarios, Mensajes, Sugerencias, Partidas), las cuales están relacionadas 
de la siguiente forma:

Usuarios -> Sugerencias: 1:N
--------------------------------------------------------------------------------------------------------
Usuarios -> Mensajes: 1:N
--------------------------------------------------------------------------------------------------------
Usuarios -> Partidas: N:M
--------------------------------------------------------------------------------------------------------
