package com.main;

import com.tharsis.info.model.StudentModel;
import com.tharsis.info.service.Usuario;
import com.tharsis.info.service.UsuarioService;

/**
 *
 * @author christian
 */
public class NewMain {
    public static void main(String[] args) {
        UsuarioService userService = new UsuarioService();
        Usuario user = userService.getUsuario();
        
        String dni = user.getInformacion("46218219");
        
        if(isNullOrEmpty(dni)){
            System.out.println("Hola");
        }else
            System.out.println("saludo");
        
        
        System.out.println(dni.replaceAll("█", "'"));
        
        System.out.println("PRINT " + dni);
        
    }
    
    public static void removeSeparator(String string) {
        String[] values = string.split("█");
        
        StudentModel studentModel = new StudentModel();
        
        for (int i = 0; i < values.length; i++) {
            studentModel.setDni(values[0]);
            studentModel.setName(values[1]);
            studentModel.setLastName(values[2] + " " + values[3]);
            studentModel.setNumberPhone(values[4]);
            studentModel.setDateBirth(values[5]);
            studentModel.setEmail(values[7]);
            studentModel.setUrlPicture(values[8]);
        }
        
        System.out.println(studentModel.toString());
    }
    
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

}
