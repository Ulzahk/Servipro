
function preguntaEliminar() {
    alert("Hola");
}
;


function bloqueo() {
    alert("Una fuerza misteriosa no te deja avanzar");
}
;

function formValidation() {

//    if ($('#txtusuario').val()===""){
//        $('#txtusuario').css('border-color','red');} else {
//        $('#txtusuario').css('border-color','green');}
//    };
    var user = document.getElementById('txtusuario').value;
    var pass = document.getElementById('txtpass').value;

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


    if (pass === "" && user === "") {
        document.getElementById('txtuser').style.borderColor = "#D54324";
        document.getElementById('txtpass').style.borderColor = "#D54324";
        document.getElementById('lblerror').innerHTML = 'Ingrese un usuario y una contraseña válidos';
        return false;
    } else {
        document.getElementById('forminicio').submit();
    }
}
;

function main() {
    var contador = 1;
    $('.menu_bar').click(function () {
        if (contador == 1) {
            $('nav').animate({
                left: '0'
            });
            contador = 0;
        } else {
            contador = 1;
            $('nav').animate({
                left: '-100%'
            });
        }
    });

    // Mostramos y ocultamos submenus
    $('.submenu').click(function () {
        $(this).children('.children').slideToggle();
    });

    $('.openBtn').on('click', function () {
        $('.modal-body').load(this.href, function ()
        {
        });
    });



    $(document).ready(function () {
        $('#myTable').DataTable({
            dom: 'Bfrtip',
            lengthMenu: [
                [5, 10, 25, 50, -1],
                ['5 registros', '10 registros', '25 registros', '50 registros', 'Mostrar Todos']
            ],
            buttons: [
                'pageLength', 'csv', 'excel'
            ],
            language: {"sProcessing": "Procesando...",
                "sLengthMenu": "Mostrar _MENU_ registros",
                "sZeroRecords": "No se encontraron resultados",
                "sEmptyTable": "Ningún dato disponible en esta tabla =(",
                "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                "sInfoPostFix": "",
                "sSearch": "Buscar:",
                "sUrl": "",
                "sInfoThousands": ",",
                "sLoadingRecords": "Cargando...",
                "oPaginate": {
                    "sFirst": "Primero",
                    "sLast": "Último",
                    "sNext": "Siguiente",
                    "sPrevious": "Anterior"
                },
                "oAria": {
                    "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                    "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                },
                "buttons": {
                    "copy": "Copiar",
                    "colvis": "Visibilidad",
                    "pageLength": "Mostrar registros",
                    "csv": "<i class='fas fa-file-csv' style='font-size:17px;' data-toggle='tooltip' title='Haz clic para descargar archivo CSV'></i>",
                    "excel": "<i class='far fa-file-excel' style='font-size:17px;' data-toggle='tooltip' title='Haz clic para descargar archivo Excel'></i>"
                }
            }

        }
        );
    })
}

function selectAll() {
    $(".selectall").click(function () {
        $(".individual").prop("checked", $(this).prop("checked"));
    });
}

function darkMode(){
    const btnSwitch = document.querySelector('#switchT');
    
        document.body.classList.toggle('dark');
        btnSwitch.classList.toggle('active');
}

