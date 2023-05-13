
package com.rogadev.portfolio.configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class FormatearDate {
    
    public static LocalDate parsString (String fechaString){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate fecha = LocalDate.parse(fechaString, formato); 
        return fecha;
    }

}
