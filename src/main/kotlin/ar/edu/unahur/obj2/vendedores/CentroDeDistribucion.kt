package ar.edu.unahur.obj2.vendedores

class CentroDeDistribucion(val ciudadEsta : Ciudad ) {
    val vendedoresQueTrabaja = mutableListOf<Vendedor>() // Lista de centros de distribucion
    fun agregarVendedor(vendedor: Vendedor){  // NO DEVUELVE NADA
        check (!vendedoresQueTrabaja.contains(vendedor)){
            vendedoresQueTrabaja.add(vendedor)
        }

    }


    fun VendedorEstrella() = vendedoresQueTrabaja.map{ c -> c.puntajeCertificaciones() }.max()


    fun puedeCubrirUnaCiudad(ciudad: Ciudad) = vendedoresQueTrabaja.any{v -> v.puedeTrabajarEn(ciudad)}



    fun vendedorGenerico(vendedor : Vendedor) = (vendedor.certificaciones).any{!it.esDeProducto }
    fun esRobusto() = vendedoresQueTrabaja.any { v-> v.esFirme() }


}



