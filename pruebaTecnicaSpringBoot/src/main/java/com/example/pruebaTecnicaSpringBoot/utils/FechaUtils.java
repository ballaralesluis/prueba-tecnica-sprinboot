package com.example.pruebaTecnicaSpringBoot.utils;

import java.time.LocalDate;

public class FechaUtils {
    public static boolean validarFechas(LocalDate salida, LocalDate llegada) {
        return salida != null && llegada != null && !llegada.isBefore(salida);
    }
}
