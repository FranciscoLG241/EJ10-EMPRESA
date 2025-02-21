open class Persona(val nombre: String, var edad: Int) {


    override fun toString(): String {
        return "Persona = Nombre: $nombre, Edad: $edad"
    }


    fun celebrarCumple(): String{
        edad ++
        return "Feliz cumpleaños $nombre! Ahora tienes $edad años."
    }
}



open class Empleado(nombre: String, edad: Int, val salarioBase: Double, val porcentajeImpuestos: Double = 10.0): Persona(nombre, edad){


    constructor(nombre: String, edad: Int, salarioBase: Int, porcentajeImpuestos: Int = 10) : this(
        nombre, edad, salarioBase.toDouble(), porcentajeImpuestos.toDouble()
    )



    open fun calcularSalario(): Double {
        return if (salarioBase > 0 && porcentajeImpuestos in 0.0..100.0) {
            salarioBase * (1 - porcentajeImpuestos / 100)
        } else {
            0.0
        }
    }


    override fun toString(): String {
        return "Nombre: $nombre, Edad: $edad, Salario: ${"%.2f".format(calcularSalario())}\$"
    }




    fun trabajar(): String{
        return "$nombre está trabajando en la empresa"
    }
}






class Gerente(nombre: String, edad: Int, salarioBase: Double, val bonus: Double, val exentoImpuestos: Boolean = false): Empleado(nombre, edad, salarioBase, 33.99){

    override fun calcularSalario(): Double {
        return if (exentoImpuestos) {
            salarioBase + bonus
        } else {
            salarioBase * (1 - porcentajeImpuestos / 100) + bonus
        }
    }


    override fun toString(): String {
        return super.toString() + ", Bonus: $bonus€, Exento de impuestos: $exentoImpuestos"
    }


    fun administrar(): String {
        return "$nombre está administrando la empresa."
    }
}




fun main() {

    println("\n***INFORMACIÓN PERSONA***")
    val persona = Persona("Julia", 24)
    println(persona.toString())

    println("\n***INFORMACIÓN EMPLEADO***")
    val empleado = Empleado("Ana", 40, 5000)
    println(empleado.toString())
    println(empleado.trabajar())


}