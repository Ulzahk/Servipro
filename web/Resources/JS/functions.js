
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

    if (pass === "" && user === "" && perfil.length > 0) {
        document.getElementById('txtuser').style.borderColor = "#D54324";
        document.getElementById('txtpass').style.borderColor = "#D54324";
        document.getElementById('lblerror').innerHTML = 'Ingrese un usuario y una contraseña válidos';
        return false;
    }

    if (user === "" && pass === "" && perfil === "") {
        document.getElementById('txtuser').style.borderColor = "#D54324";
        document.getElementById('txtpass').style.borderColor = "#D54324";
        document.getElementById('lblerror').style.color = '#D54324';
        document.getElementById('txtperfil').style.background = '#D54324';
        document.getElementById('lblerror').innerHTML = 'Ingrese un perfil,usuario y una contraseña válidos';
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

    $('.openBtn').on('click', function () {
        $('.modal-body').load(this.href, function ()
        {
            $('#myModal').modal({show: false});
        });
    });

    // Mostramos y ocultamos submenus
    $('.submenu').click(function () {
        $(this).children('.children').slideToggle();
    });
}


function fpaginacion() {
    $('.openBtn').on('click', function () {
        $('.modal-body').load(this.href, function ()
        {
            $('#myModal').modal({show: false});
        });
    });
}
getPagination('#table-id');
//getPagination('.table-class');
//getPagination('table');

/*					PAGINATION 
 - on change max rows select options fade out all rows gt option value mx = 5
 - append pagination list as per numbers of rows / max rows option (20row/5= 4pages )
 - each pagination li on click -> fade out all tr gt max rows * li num and (5*pagenum 2 = 10 rows)
 - fade out all tr lt max rows * li num - max rows ((5*pagenum 2 = 10) - 5)
 - fade in all tr between (maxRows*PageNum) and (maxRows*pageNum)- MaxRows 
 */


function getPagination(table) {
    var lastPage = 1;

    $('#maxRows')
            .on('change', function (evt) {
                //$('.paginationprev').html(''); // reset pagination

                lastPage = 1;
                $('.pagination')
                        .find('li')
                        .slice(1, -1)
                        .remove();
                var trnum = 0; // reset tr counter
                var maxRows = parseInt($(this).val()); // get Max Rows from select option

                if (maxRows == 5000) {
                    $('.pagination').hide();
                } else {
                    $('.pagination').show();
                }

                var totalRows = $(table + ' tbody tr').length; // numbers of rows
                $(table + ' tr:gt(0)').each(function () {
                    // each TR in  table and not the header
                    trnum++; // Start Counter
                    if (trnum > maxRows) {
                        // if tr number gt maxRows

                        $(this).hide(); // fade it out
                    }
                    if (trnum <= maxRows) {
                        $(this).show();
                    } // else fade in Important in case if it ..
                }); //  was fade out to fade it in
                if (totalRows > maxRows) {
                    // if tr total rows gt max rows option
                    var pagenum = Math.ceil(totalRows / maxRows); // ceil total(rows/maxrows) to get ..
                    //	numbers of pages
                    for (var i = 1; i <= pagenum; ) {
                        // for each page append pagination li
                        $('.pagination #prev')
                                .before(
                                        '<li data-page="' +
                                        i +
                                        '">\
                <button class="btn btn-secondary btn-sm mr-1">' +
                                        i++ +
                                        '<span class="sr-only">(current)</span></button>\
                </li>'
                                        )
                                .show();
                    } // end for i
                } // end if row count > max rows
                $('.pagination [data-page="1"]').addClass('active'); // add active class to the first li
                $('.pagination li').on('click', function (evt) {
                    // on click each page
                    evt.stopImmediatePropagation();
                    evt.preventDefault();
                    var pageNum = $(this).attr('data-page'); // get it's number

                    var maxRows = parseInt($('#maxRows').val()); // get Max Rows from select option

                    if (pageNum == 'prev') {
                        if (lastPage == 1) {
                            return;
                        }
                        pageNum = --lastPage;
                    }
                    if (pageNum == 'next') {
                        if (lastPage == $('.pagination li').length - 2) {
                            return;
                        }
                        pageNum = ++lastPage;
                    }

                    lastPage = pageNum;
                    var trIndex = 0; // reset tr counter
                    $('.pagination li').removeClass('active'); // remove active class from all li
                    $('.pagination [data-page="' + lastPage + '"]').addClass('active'); // add active class to the clicked
                    //$(this).addClass('active');					// add active class to the clicked
                    limitPagging();
                    $(table + ' tr:gt(0)').each(function () {
                        // each tr in table not the header
                        trIndex++; // tr index counter
                        // if tr index gt maxRows*pageNum or lt maxRows*pageNum-maxRows fade if out
                        if (
                                trIndex > maxRows * pageNum ||
                                trIndex <= maxRows * pageNum - maxRows
                                ) {
                            $(this).hide();
                        } else {
                            $(this).show();
                        } //else fade in
                    }); // end of for each tr in table
                }); // end of on click pagination list
                limitPagging();
            })
            .val(5000)
            .change();

    // end of on select change

    // END OF PAGINATION
}
;

function limitPagging() {
    // alert($('.pagination li').length)

    if ($('.pagination li').length > 7) {
        if ($('.pagination li.active').attr('data-page') <= 3) {
            $('.pagination li:gt(5)').hide();
            $('.pagination li:lt(5)').show();
            $('.pagination [data-page="next"]').show();
        }
        if ($('.pagination li.active').attr('data-page') > 3) {
            $('.pagination li:gt(0)').hide();
            $('.pagination [data-page="next"]').show();
            for (let i = (parseInt($('.pagination li.active').attr('data-page')) - 2); i <= (parseInt($('.pagination li.active').attr('data-page')) + 2); i++) {
                $('.pagination [data-page="' + i + '"]').show();

            }

        }
    }
}
;

$(function () {
    // Just to append id number for each row
    $('table tr:eq(0)').prepend('<th> ID </th>');

    var id = 0;

    $('table tr:gt(0)').each(function () {
        id++;
        $(this).prepend('<td>' + id + '</td>');
    });
});

$(document).ready(function () {
    $('#myTable').DataTable({
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
                "colvis": "Visibilidad"
            }
        }
    });
});

