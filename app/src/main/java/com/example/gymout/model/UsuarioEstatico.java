package com.example.gymout.model;

import com.example.gymout.classes.Aluno;
import com.example.gymout.classes.Usuario;

public class UsuarioEstatico {

    public static Aluno aluno;
    public static Usuario professor;

    public static Usuario getUsuario(){
        if(aluno != null){
            return UsuarioEstatico.aluno;
        }else{
            return UsuarioEstatico.professor;
        }
    }

}
