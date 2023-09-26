import java.time.LocalDateTime

fun main(args: Array<String>) {

    var estacionamiento = Estacionamiento()

    while(true) {
        println("\n--- Menú ---")
        println("1. Estacionar un vehículo")
        println("2. Quitar un vehículo")
        println("3. Mostrar lista de vehículos estacionados")
        println("4. Buscar vehículo por placa")
        println("5. Mostrar costo total del estacionamiento")
        println("6. Salir")
        print("Ingrese su opción: ")

        when(readlnOrNull()?.toIntOrNull()) {
            1 -> {
                print("Ingrese la marca: ")
                val marca = readlnOrNull() ?:""
                print("Ingrese la patente: ")
                val patente = readlnOrNull() ?:""
                print("Ingrese el modelo: ")
                val modelo = readlnOrNull() ?:""
                print("Ingrese el nombre del duenio: ")
                val duenio = readlnOrNull() ?:""
                print("Ingrese el color: ")
                val color = readlnOrNull() ?:""
                print("Ingrese tipo de vehiculo: ")

                val auto = Vehiculo(marca, patente, modelo, duenio, color, seleccionarTipoVehiculo())
                print("¿Es usted socio?")
                val horaIngreso = System.currentTimeMillis()
                estacionamiento.estacionarAuto(auto, horaIngreso, seleccionarSocio())
            }
            2 -> {
                print("Ingrese la patente del Vehiculo a remover")
                val patente = readlnOrNull() ?: ""
                estacionamiento.removerAuto(patente)
            }
            3 -> {
                print("--- Vehiculos estacionados ---")
                estacionamiento.mostrarListaAutos()
            }
            4 -> {
                print("Ingrese la patente del Vehiculo a buscar: ")
                val patente = readlnOrNull() ?: ""
                estacionamiento.buscarAutoPorPatente(patente)
            }
            /*
            5 -> {
                println("\nCosto total del estacionamiento: $${estacionamiento.calcularCostoTotal()}")
            }
            */
            6 -> {
                break
            }
            else -> {
                println("Ingrese una opcion valida")
            }
        }
    }

}

fun seleccionarTipoVehiculo():String {
    while(true) {
        println("\n--- Menú ---")
        println("1. Auto")
        println("2. Bicicleta")
        println("3. Moto")
        println("4. Camioneta")
        println("5. Salir")
        print("Ingrese su opción: ")

        when(readlnOrNull()?.toIntOrNull()) {
            1 -> return Vehiculo.tipoVehiculo.AUTO.toString()
            2 -> return Vehiculo.tipoVehiculo.BICICLETA.toString()
            3 -> return Vehiculo.tipoVehiculo.MOTO.toString()
            4 -> return Vehiculo.tipoVehiculo.CAMIONETA.toString()
            5 -> {
                break
            }
            else -> {
                println("Ingrese una opcion valida")
                return ""
            }
        }
    }
    return TODO("Provide the return value")
}

fun seleccionarSocio():Boolean {
    while(true){
        println("\n---Menu---")
        println("1. Si")
        println("2. No")
        println("3. Salir")

        when(readlnOrNull()?.toIntOrNull()){
            1 -> return true
            2 -> return false
            3 -> break
            else -> println("Ingrese una opcion valida")
        }
    }
    return false
}

