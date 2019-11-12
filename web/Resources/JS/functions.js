
function preguntaEliminar(){
    alert("Hola");
};

window.addEventListener('load',function(){
   document.getElementById('btniniciar').addEventListener('click', function(){
       var descripcion_perfil = document.getElementById('txtperfil').value;
       var id_usuario = document.getElementById('txtusuario').value;
       var contraseña = document.getElementById('txtpass').value;
       
       var bandera= false;
       
       if(descripcion_perfil.length>0 && id_usuario.length>0){
           if(contraseña.length>0){
              bandera=true; 
           }
       }
       
       if(bandera){
           document.getElementById('forminicio').submit();
       }else{
           alert("Por favor complete todos los campos");
       }
   }); 
});
