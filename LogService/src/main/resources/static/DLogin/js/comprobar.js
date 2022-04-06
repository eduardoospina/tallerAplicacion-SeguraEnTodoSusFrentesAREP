var obtenerMath = (function () {

    function obtenerAtan(numero){
        axios.get("/Atan?value="+numero).then(res=>{
            document.getElementById("servicio").innerHTML = "El resultado matematico es: "+JSON.stringify(res.data);
        })
    }
    function obtenersqrt(numero){
            axios.get("/Sqrt?value="+numero).then(res=>{
                document.getElementById("servicio").innerHTML = "El resultado matematico es: "+JSON.stringify(res.data);
            })
        }


    return {
        obteneratan:obtenerAtan,
        obtenersqrt:obtenersqrt
    };
})();