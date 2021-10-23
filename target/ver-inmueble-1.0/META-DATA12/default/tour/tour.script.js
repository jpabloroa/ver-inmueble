// Variable de control de pasos

var paso = 0;

function interactuar(director) {
    /**
     * 
     */
    switch (director) {
        case 'ini':
            ocultarBoton("tour-button_view_ini");
            mostrarBoton("tour-button_view_bak");
            paso++;
            break;
        case 'der':
            switch (paso) {
                default: paso++;
                    break;
            }
            break;
        case 'cen':
            switch (paso) {
                default: paso++;
                    break;
            }
            break;
        case 'izq':
            switch (paso) {
                default: paso++;
                    break;
            }
            break;
        case 'bak':
            switch (paso) {
                default: paso--;
                    break;
            }
            break;
    }
    /**
     * 
     */
    switch (paso) {
        case 1:
            sesion(
                {
                    image: "",
                    bIzq: {
                        visible: true, title: "", top: "", left: ""
                    },
                    bCen: {
                        visible: true, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: true, title: "", top: "", left: ""
                    }
                });
            break;
        default: alert("La opción ingresada es inválida");
            break;
    }
}
function sesion(Object) { agregarImagen("tour-main-image", "https://drive.google.com/uc?export=view&id=" + Object.image); newButtonConf(Object.bIzq.visible, "tour-button_view_izq", Object.bIzq.title, Object.bIzq.top, Object.bIzq.left); newButtonConf(Object.bCen.visible, "tour-button_view_cen", Object.bCen.title, Object.bCen.top, Object.bCen.left); newButtonConf(Object.bDer.visible, "tour-button_view_der", Object.bDer.title, Object.bDer.top, Object.bDer.left); } function agregarImagen(idImagen, SrcImagen) { document.getElementById(idImagen).setAttribute("src", SrcImagen); } function newButtonConf(validation, idBoton, valorBoton, altoBoton, anchoDerechaBoton) { if (validation) { document.getElementById(idBoton).style.visibility = "visible"; } else { document.getElementById(idBoton).style.visibility = "hidden"; } document.getElementById(idBoton).value = valorBoton; document.getElementById(idBoton).style.top = altoBoton; document.getElementById(idBoton).style.left = anchoDerechaBoton; } function ocultarBoton(idBoton) { document.getElementById(idBoton).style.visibility = "hidden"; } function mostrarBoton(idBoton) { document.getElementById(idBoton).style.visibility = "visible"; }