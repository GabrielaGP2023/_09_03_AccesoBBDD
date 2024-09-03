package com.networks.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@NoArgsConstructor




@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrdenes {
    private int ordenId;
    private int productoId;
    private double precioUnitario;
    private int cantidad;
}
