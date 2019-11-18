
function preguntaEliminar(){
    alert("Hola");
};

<<<<<<< Updated upstream
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

=======
function formValidation() {

//    if ($('#txtusuario').val()===""){
//        $('#txtusuario').css('border-color','red');} else {
//        $('#txtusuario').css('border-color','green');}
//    };
    var fn = document.getElementById('txtusuario').value;
    if (fn == "") {
//        alert('Por favor escriba el nombre de usuario');
        document.getElementById('txtusuario').style.borderColor = "red";
        return false;
    } else {
        document.getElementById('txtusuario').style.borderColor = "green";

    };
  
     if (/^[0-9]+$/.test(document.getElementById("txtusuario").value)) {
        alert("First Name Contains Numbers!");
        document.getElementById('txtusuario').style.borderColor = "red";
        return false;
    }else{
        document.getElementById('txtusuario').style.borderColor = "green";
    };
};




function bloqueo(){
    alert("Una fuerza misteriosa no te deja avanzar");
};

//window.addEventListener('load',function(){
//   document.getElementById('btniniciar').addEventListener('click', function(){
//       var descripcion_perfil = document.getElementById('txtperfil').value;
//       var id_usuario = document.getElementById('txtusuario').value;
//       var contraseña = document.getElementById('txtpass').value;
//       
//       var bandera= false;
//       
//       if(descripcion_perfil.length>0 && id_usuario.length>0){
//           if(contraseña.length>0){
//              bandera=true; 
//           }
//       }
//       
//       if(bandera){
//           document.getElementById('forminicio').submit();
//       }else{
//           alert("Por favor complete todos los campos");
//       }
//   }); 
//});
>>>>>>> Stashed changes
