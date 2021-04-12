package ar.edu.unahur.obj2.vendedores

class CentroDeDistribucion(val vendedoresQueTrabaja : List<Vendedor> , val ciudadEsta : Ciudad ) {
    val centroDeDistribu = mutableListOf<Vendedor>() // Lista de centros de distribucion
    fun agregarVendedor(vendedor: Vendedor){  // NO DEVUELVE NADA
        check (centroDeDistribu.contains(vendedor)){
            "EL VENDEDOR YA ESTA RESGISTRADO EN EL CENTRO"
        }
        centroDeDistribu.add(vendedor)
    }
    fun VendedorEstrella(vendedor : Vendedor) = vendedor.puntajeCertificaciones()

    fun puedeCubrirUnaCiudad(ciudad: Ciudad) = vendedoresQueTrabaja.any{v -> v.puedeTrabajarEn(ciudad)}
    fun vendedorGenerico(vendedor : Vendedor) = (vendedor.certificaciones).any{!it.esDeProducto }
    fun esRobusto() = vendedoresQueTrabaja.any { v-> v.esFirme() }
}

