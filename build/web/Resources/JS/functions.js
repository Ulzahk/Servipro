
function preguntaEliminar(){
    alert("Hola");
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

function formValidation() {

//    if ($('#txtusuario').val()===""){
//        $('#txtusuario').css('border-color','red');} else {
//        $('#txtusuario').css('border-color','green');}
//    };
    var user = document.getElementById('txtusuario').value;
    var pass = document.getElementById('txtpass').value;
    var perfil = document.getElementById('txtperfil').value;

    if (user === "" && pass.length > 0 && perfil.length > 0) {
        document.getElementById('txtusuario').style.borderColor = "#D54324";
        document.getElementById('lblerror').style.color = '#D54324';
        document.getElementById('lblerror').innerHTML = 'Ingrese un usuario válido';
        return false;
    }

    if (pass === "" && user.length > 0 && perfil.length > 0) {
        document.getElementById('txtpass').style.borderColor = "#D54324";
        document.getElementById('lblerror').style.color = '#D54324';
        document.getElementById('lblerror').innerHTML = 'Ingrese una contraseña válida';
        return false;
    }

    if (perfil === "" && user.length > 0 && pass.length > 0) {
        document.getElementById('txtperfil').backgroundColor = "#D54324";
        document.getElementById('lblerror').style.color = '#D54324';
        document.getElementById('txtperfil').style.background = '#D54324';
        document.getElementById('txtperfil').style.hover = '#D54324';
        document.getElementById('lblerror').innerHTML = 'Seleccione un perfil';
                return false;
    }
    
    if (pass === "" && user === ""  && perfil.length > 0) {
        document.getElementById('txtuser').style.borderColor = "#D54324";
        document.getElementById('txtpass').style.borderColor = "#D54324";
        document.getElementById('lblerror').innerHTML = 'Ingrese un usuario y una contraseña válidos';
        return false;
    } 
    
    if (user === "" && pass === "" && perfil.length === "") {
        document.getElementById('txtuser').style.borderColor = "#D54324";
        document.getElementById('txtpass').style.borderColor = "#D54324";
        document.getElementById('lblerror').style.color = '#D54324';
        document.getElementById('txtperfil').style.background = '#D54324';
        document.getElementById('lblerror').innerHTML = 'Ingrese un perfil,usuario y una contraseña válidos';
        return false;
        
    }
    
    else {
        document.getElementById('forminicio').submit();
    }
}
;

