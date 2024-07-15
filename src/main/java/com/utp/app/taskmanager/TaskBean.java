package com.utp.app.taskmanager;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class TaskBean implements Serializable {
    private String name;
    private String email;

    // Constructor por defecto (necesario para beans gestionados)
    public TaskBean() {
    }

    // Métodos getter y setter para name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Métodos getter y setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método para manejar la acción del formulario (submit)
    public void submit() {
        // Lógica para manejar el envío del formulario
        System.out.println("Nombre: " + name);
        System.out.println("Correo Electrónico: " + email);
    }
}