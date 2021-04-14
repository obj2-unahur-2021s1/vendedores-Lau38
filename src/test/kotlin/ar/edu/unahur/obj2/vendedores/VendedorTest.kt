package ar.edu.unahur.obj2.vendedores

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.should
import ar.edu.unahur.obj2.vendedores.ComercioCorresponsal as ComercioCorresponsal1
import ar.edu.unahur.obj2.vendedores.Viajante as Viajante1
import io.kotest.assertions.throwables.shouldThrow as shouldThrow1

class VendedorTest : DescribeSpec({
  val misiones = Provincia(13000000)
  val sanIgnacio = Ciudad(misiones)



  describe("Vendedor fijo") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(ciudadOrigen = obera)

    describe("puedeTrabajarEn") {
      it("su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
    }

    describe("esInfluyenteVendedor") {
      it("no es influyente") {
        vendedorFijo.esInfluyente().shouldBeFalse()
      }
    }
  }

  describe("Viajante") {
    val cordoba = Provincia(10000000)
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante1(listOf(misiones))
    val provinciasHabilitadas : List<Provincia>

    describe("puedeTrabajarEn") {
      it("una ciudad que pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(villaDolores).shouldBeFalse()
      }
    }

    describe("esInfluyenteViajante") {
      it("ProvinciasHabilitadas sumada la poblacion es mayor o igual a 10000000") {
          viajante.esInfluyente().shouldBeTrue()
      }

    }
  }

  describe("ComercioCorresponsal1"){
    val SantaFe = Provincia(30000)
    val rosario =Ciudad(SantaFe)
    val catamarca=Provincia(poblacion = 400000)
    val sanFernando=Ciudad(catamarca)
    val sanJuan=Provincia(poblacion = 35000)
    val sanjuan=Ciudad(sanJuan)
    val Cordoba=Provincia(poblacion = 26000)
    val cordoba=Ciudad(Cordoba)
    val LaPampa=Provincia(poblacion = 39999)
    val santaRosa=Ciudad(LaPampa)
    val LaRioja=Provincia(poblacion = 39999)
    val larioja=Ciudad(LaRioja)

    val comercioC = ComercioCorresponsal1(listOf(rosario,sanFernando,sanjuan,cordoba,santaRosa))
    val comercioC2 = ComercioCorresponsal1(listOf(sanjuan,cordoba))

    describe("puedeTrabajarEn") {
      it("una ciudad en la que tiene sucursal") {
        comercioC.puedeTrabajarEn(rosario).shouldBeTrue()
      }
      it("una ciudad en la que no tiene sucursal") {
        comercioC.puedeTrabajarEn(larioja).shouldBeFalse()
      }
    }

    describe("esInfluyenteComercioCorresponsal") {
      it("debe tener sucursales en al menos 5 ciudades, o bien en al menos 3 provincias") {
        comercioC.esInfluyente().shouldBeTrue()
      }
      it("No tiene 5 ciudades") {
        comercioC2.esInfluyente().shouldBeFalse()
      }

    }
  }
  describe("CentroDeDistribucion"){
    val catamarca=Provincia(poblacion = 400000)
    val sanFernando=Ciudad(catamarca)
    val SantaFe = Provincia(30000)
    val rosario =Ciudad(SantaFe)
    val vendedor1 = VendedorFijo(sanFernando) //CREO VENDEDOR
    val centro = CentroDeDistribucion(sanFernando)

    val centro1 = CentroDeDistribucion(rosario)



    describe("Agregar Vendedor ") {
      it("Agrego vendedor si ya esta en la lista tira error ") {
        centro.vendedoresQueTrabaja.add(vendedor1)
        shouldThrowAny {
          centro.agregarVendedor(vendedor1)
        }
      }
    }

    describe("Puede cubrir una ciudad ") {
      it("Puede cubrir si puede trabajar en esa ciudad ") {
            centro1.puedeCubrirUnaCiudad(rosario).shouldBeFalse()
        }

      }

    describe("Vendedor Generico ") {
      

    }

  }
  })


