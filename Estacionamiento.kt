import java.util.concurrent.TimeUnit
import kotlin.math.abs

class Estacionamiento (){

    val capacidadEstacionamiento = 25
    private var setAutos: MutableSet <Triple<Vehiculo, Long, Boolean>> = mutableSetOf()

    // Función para estacionar un auto
    fun estacionarAuto(auto: Vehiculo, ingreso:Long, socio:Boolean) {
        var triple = Triple(auto, ingreso, socio)
        if(checkCapacidad()) {
            setAutos.add(triple)
        } else {
            print("No es posible estacionar el auto, no hay capacidad")
        }
    }

    // Función para remover un auto
    fun removerAuto(patente: String) {
        val auto = setAutos.find { it.first.patente == patente }
        val costoEstacionamiento = calcularCostoAlRetirar(auto)
        print("El valor de su estadia es: $costoEstacionamiento")
        auto?.let { setAutos.remove(it) }

    }

    // Función para mostrar la lista de vehículos estacionados
    fun mostrarListaAutos() {
        setAutos.forEach { println(it.toString()) }
    }

    // Función para buscar un auto por patente
    fun buscarAutoPorPatente(patente: String) {
        val auto = setAutos.find { it.first.patente == patente }
        if (auto != null) {
            print(auto.toString())
        } else {
            println("No se encontró ningún vehículo con esa placa.")
        }
    }

    // Función para contar el número de vehículos estacionados
    fun contarAutosEstacionados(): Int {
        return setAutos.size
    }

    // Función para calcular el costo total del estacionamiento

    /*
    fun calcularCostoTotal(): Double {
        // TODO: Falta realizar la ganancia total del dia
    }
    */
    fun calcularCostoAlRetirar(triple: Triple<Vehiculo, Long, Boolean>?): Double {

        when(triple?.first?.tipo){
            Vehiculo.tipoVehiculo.CAMIONETA.toString() -> return calcularTiempoDeEstadia(1300, triple.second, triple.third)
            Vehiculo.tipoVehiculo.AUTO.toString() -> return calcularTiempoDeEstadia(1000, triple.second, triple.third)
            Vehiculo.tipoVehiculo.BICICLETA.toString() -> return calcularTiempoDeEstadia(400, triple.second, triple.third)
            Vehiculo.tipoVehiculo.MOTO.toString() -> return calcularTiempoDeEstadia(800, triple.second, triple.third)
        }
        return 0.0
    }

    fun calcularTiempoDeEstadia(modificador: Int, entrada: Long, socio:Boolean): Double{
        val fechaSalida = System.currentTimeMillis()

        val duration = abs(entrada - fechaSalida)
        val days = TimeUnit.MILLISECONDS.toDays(duration)
        val hours = TimeUnit.MILLISECONDS.toHours(duration)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(duration)

        var resultado:Long =0
        if(days>0.0)
        {
            resultado = days/24
            print("Resultado Dias $resultado")
        }
        if(hours > 0.0)
        {
             resultado += hours
            print("Resultado Horas $resultado")
        }
        if(minutes > 0 )
        { resultado++
            print("Resultado Minutos $resultado")
        }
        if(seconds > 0)
        {
            resultado ++
            print("Resultado Segundos $resultado")
        }

        resultado = (resultado * modificador)
        if(socio)
        {
            val descuento = resultado * 0.5
            resultado -= descuento.toLong()
        }

        return resultado.toDouble()
    }

    fun checkCapacidad(): Boolean {
        return contarAutosEstacionados() < capacidadEstacionamiento
    }
}