package ar.edu.unahur.obj2.vendedores


class Certificacion (val esDeProducto: Boolean, val puntaje: Int)

 abstract class Vendedor {
  // Acá es obligatorio poner el tipo de la lista, porque como está vacía no lo puede inferir.
  // Además, a una MutableList se le pueden agregar elementos
  val certificaciones = mutableListOf<Certificacion>()

  // Lo definimos abstracto porque se va a usar segun que vendedor sea.
  abstract fun esInfluyente() : Boolean

  // Definimos el método abstracto.
  // Como no vamos a implementarlo acá, es necesario explicitar qué devuelve.
  // Devuelve un booleano
  abstract fun puedeTrabajarEn(ciudad: Ciudad): Boolean



  // En las funciones declaradas con = no es necesario explicitar el tipo
  // Devuelve un booleang
  fun esVersatil() =
    certificaciones.size >= 3
      && this.certificacionesDeProducto() >= 1
      && this.otrasCertificaciones() >= 1

  // Si el tipo no está declarado y la función no devuelve nada, se asume Unit (es decir, vacío)
  //Hace una accion
  fun agregarCertificacion(certificacion: Certificacion) { // Hace una accion
    certificaciones.add(certificacion)
  }
  //Devuelve un booleano
  fun esFirme() = this.puntajeCertificaciones() >= 30 // Devuelve un booleano Int

  fun certificacionesDeProducto() = certificaciones.count { it.esDeProducto }
  fun otrasCertificaciones() = certificaciones.count { !it.esDeProducto }

  fun puntajeCertificaciones() = certificaciones.sumBy { c -> c.puntaje }
}

// En los parámetros, es obligatorio poner el tipo
 class VendedorFijo(val ciudadOrigen: Ciudad) : Vendedor() {
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean { // Devuelve un booleano
    return ciudad == ciudadOrigen
  }

  override fun esInfluyente(): Boolean { // Devuelve falso porque el VendedorFijo no es influyente
    return false
  }
}

// A este tipo de List no se le pueden agregar elementos una vez definida
 class Viajante(val provinciasHabilitadas: List<Provincia>) : Vendedor() {


  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean { // Devuelve un booleano
    return  provinciasHabilitadas.contains(ciudad.provincia)
  }



  override fun esInfluyente(): Boolean { // Devuelve un booleano
     return (provinciasHabilitadas.sumBy { it.poblacion } ) >= 10000000

  }
}

 class ComercioCorresponsal(val ciudades: List<Ciudad> ) : Vendedor() {
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean { // Devuelve un booleano
    return ciudades.contains(ciudad)
  }

 fun provinciasDondeTieneSucursal() = ciudades.map({it.provincia }).toSet()

  override fun esInfluyente() = (ciudades.toSet().size >=5) or (provinciasDondeTieneSucursal().size >=3)



}


