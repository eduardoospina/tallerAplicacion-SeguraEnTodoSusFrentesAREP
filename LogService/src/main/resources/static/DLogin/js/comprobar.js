var obtenerMath = (function () {
    function obtenerAtan(){
        axios.get("/LoginVerificado/servicio").then(res=>{
            document.getElementById("servicio").innerHTML = "La fecha y hora actual es: "+res.data;
        })
    }
    function obtenersqrt(){
            axios.get("/LoginVerificado/servicio").then(res=>{
                document.getElementById("servicio").innerHTML = "La fecha y hora actual es: "+res.data;
            })
        }


    return {
        obtenerFecha:obtenerFecha,

    };
})();