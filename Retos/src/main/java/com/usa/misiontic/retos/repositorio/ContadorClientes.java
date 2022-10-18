package com.usa.misiontic.retos.repositorio;

import com.usa.misiontic.retos.entities.Clientes;

public class ContadorClientes {
    private Long total;
    private Clientes clientes;

    public ContadorClientes(Long total, Clientes clientes) {
        this.total = total;
        this.clientes = clientes;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClient(Clientes clientes) {
        this.clientes = clientes;
    }

}
