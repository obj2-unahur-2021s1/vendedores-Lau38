package ar.edu.unahur.obj2.vendedores

class CentroDeDistribucion(val vendedoresQueTrabaja : List<Vendedor> , val ciudadEsta : Ciudad ) {
    val centroDeDistribu = mutableListOf<Vendedor>() // Lista de centros de distribucion
    fun agregarVendedor(vendedor: Vendedor){  // NO DEVUELVE NADA
        check (centroDeDistribu.contains(vendedor)){
            "EL VENDEDOR YA ESTA RESGISTRADO EN EL CENTRO"
        }
        centroDeDistribu.add(vendedor)
    }

}