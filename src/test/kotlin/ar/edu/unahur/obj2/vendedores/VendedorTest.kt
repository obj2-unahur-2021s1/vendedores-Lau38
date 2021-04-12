package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.should
import ar.edu.unahur.obj2.vendedores.ComercioCorresponsal as ComercioCorresponsal1
import ar.edu.unahur.obj2.vendedores.Viajante as Viajante1

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
    val comercioC = ComercioCorresponsal1(listOf(rosario))
    describe("puedeTrabajarEn") {
      it("una ciudad en la que tiene sucursal") {
        comercioC.puedeTrabajarEn(rosario).shouldBeTrue()
      }
    }
  }
  })


