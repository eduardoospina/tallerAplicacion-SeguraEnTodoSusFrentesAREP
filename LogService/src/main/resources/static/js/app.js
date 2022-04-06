var Services = (function () {

    var Url = "https://localhost:34000/"

    function login(idusermame, Passwordid){
        const usuario={user:idusermame,password:Passwordid}
        console.log(usuario);
        axios.post(Url + "/login",usuario).then(res=>{
            console.log(res.data)
            if(res.data == ""){
                window.location.href= 'comprobar.html';
                }
            else{
                alert("El usuario o clave no registrados");
            }
        })
    }

    return {
        login:login,
    };
})();