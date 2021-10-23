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
                case 1:
                    paso = 4;
                    break;
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
                case 1:
                    paso = 3;
                    break;
                case 6:
                    paso--;
                    break;
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
                    image: "1_pvPYCNbAo5XgoubF-nJ7ZV8U_9gOKn6",
                    bIzq: {
                        visible: true, title: "Mueble superior", top: "30%", left: "5%"
                    },
                    bCen: {
                        visible: true, title: "Mueble inferior", top: "50%", left: "40%"
                    },
                    bDer: {
                        visible: true, title: "Acabado baño", top: "60%", left: "85%"
                    }
                });
            break;
        case 2:
            sesion(
                {
                    image: "1VTDCRve5aPTeMP4GvJEfb3qhWFrSYak0",
                    bIzq: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bCen: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: false, title: "", top: "", left: ""
                    }
                });
            break;
        case 3:
            sesion(
                {
                    image: "1GQW0IzrZrSd1DTTY-QMdWftRwf1u11rO",
                    bIzq: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bCen: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: false, title: "", top: "", left: ""
                    }
                });
            break;
        case 4:
            sesion(
                {
                    image: "14fHmrFHmluxAHv1sZDGsmkoc4Oza3efS",
                    bIzq: {
                        visible: true, title: "Espejo ", top: "50%", left: "30%"
                    },
                    bCen: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: false, title: "", top: "", left: ""
                    }
                });
            break;
        case 5:
            sesion(
                {
                    image: "1Ln5OlNSVCQbpHs15kmwawTzMKCCiyAkW",
                    bIzq: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bCen: {
                        visible: true, title: "Acabado armario", top: "50%", left: "50%"
                    },
                    bDer: {
                        visible: false, title: "", top: "", left: ""
                    }
                });
            break;
        case 6:
            sesion(
                {
                    image: "1cItIdI581o2MoyoRfQHpyP0SnsaOIVf-",
                    bIzq: {
                        visible: true, title: "Acabado baño", top: "60%", left: "5%"
                    },
                    bCen: {
                        visible: true, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: true, title: "Acabado puerta", top: "60%", left: "85%"
                    }
                });
            break;
        case 7:
            sesion(
                {
                    image: "1sx1QxsFAKOPNFKSihIuawYs4qmQuXAPS",
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