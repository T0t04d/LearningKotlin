class Vehiculo (var marca:String,
                var patente: String,
                var modelo: String,
                var duenio: String,
                var color: String,
                var tipo: String) {

    enum class tipoVehiculo {AUTO, CAMIONETA, MOTO, BICICLETA}

    override fun toString(): String {
        return "Auto(patente='$patente', modelo='$modelo', duenio='$duenio', color='$color', marca='$marca')"
    }

    fun seleccionarTipo(input: Int) {
        when(input){
            1-> this.tipo= tipoVehiculo.AUTO.toString()
            2-> this.tipo=  tipoVehiculo.BICICLETA.toString()
            3-> this.tipo=  tipoVehiculo.MOTO.toString()
            4-> this.tipo=  tipoVehiculo.CAMIONETA.toString()
        }
    }
}