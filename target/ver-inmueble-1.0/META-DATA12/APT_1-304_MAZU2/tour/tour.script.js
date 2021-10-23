// Variable de control de pasos

var paso = 0;

function interactuar(director) {
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
                case 2:
                    paso = 4;
                    break;
                case 3:
                    paso = 6;
                    break;
                case 6:
                    paso = 8;
                    break;
                case 8:
                    paso = 6;
                    break;
                case 9:
                    paso = 8;
                    break;
                case 10:
                    paso = 6;
                    break;
                default: paso++;
                    break;
            }
            break;
        case 'cen':
            switch (paso) {
                case 6:
                    paso = 10;
                    break;
                default: paso++;
                    break;
            }
            break;
        case 'izq':
            switch (paso) {
                case 1:
                    paso = 3;
                    break;
                case 7:
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
    avanzar(paso);
}

function avanzar(Valor) {
    switch (Valor) {
        case 1:
            sesion(
                {
                    image: "1oN3vw_uxTRBGOIWMHuMtvK9Y1kVLIlAK",
                    bIzq: {
                        visible: true, title: "Sala", top: "60%", left: "20%"
                    },
                    bCen: {
                        visible: true, title: "Comedor", top: "50%", left: "40%"
                    },
                    bDer: {
                        visible: true, title: "Cocina", top: "60%", left: "70%"
                    }
                });
            break;
        case 2:
            sesion(
                {
                    image: "1oTHV8XCWNLJibcFUP73AGab_dnAKuYuG",
                    bIzq: {
                        visible: true, title: "Cocina", top: "60%", left: "20%"
                    },
                    bCen: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: true, title: "Sala", top: "60%", left: "70%"
                    }
                });
            break;
        case 3:
            sesion(
                {
                    image: "1vGoPReJO-N2_Btxfn1TJ0UiJw5NCcwZ2",
                    bIzq: {
                        visible: true, title: "Cocina", top: "60%", left: "20%"
                    },
                    bCen: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: true, title: "Hall", top: "60%", left: "70%"
                    }
                });
            break;
        case 4:
            sesion(
                {
                    image: "1t0qVPDfRuRituyOrXusLM597zRWhevVg",
                    bIzq: {
                        visible: true, title: "Zona Lavado", top: "60%", left: "20%"
                    },
                    bCen: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: true, title: "Sala", top: "60%", left: "70%"
                    }
                });
            break;
        case 5:
            sesion(
                {
                    image: "14Etn6L2wvqPsG_gCFVH7pB57vL5oqsrZ",
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
        case 6:
            sesion(
                {
                    image: "1TIXsuprwKg3SgE6QUj6AyMRy0te1Dr7y",
                    bIzq: {
                        visible: true, title: "Baño Social", top: "55%", left: "25%"
                    },
                    bCen: {
                        visible: true, title: "Hab Prin", top: "35%", left: "45%"
                    },
                    bDer: {
                        visible: true, title: "Hab Aux", top: "55%", left: "60%"
                    }
                });
            break;
        case 7:
            sesion(
                {
                    image: "1olfsFWt9gkQZtJl5DP4c0yj6b3CocUri",
                    bIzq: {
                        visible: false, title: "Hall", top: "60%", left: "20%"
                    },
                    bCen: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: true, title: "Hab 3", top: "60%", left: "70%"
                    }
                });
            break;
        case 8:
            sesion(
                {
                    image: "1aCcnsEtF96eUfgAIZo6cumYtADwhyKoL",
                    bIzq: {
                        visible: true, title: "Hab 2", top: "60%", left: "20%"
                    },
                    bCen: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: true, title: "Hall", top: "60%", left: "70%"
                    }
                });
            break;
        case 9:
            sesion(
                {
                    image: "1a6VF5DCxi5i3wFeR1dMZAvINV5YCRyeI",
                    bIzq: {
                        visible: true, title: "Hab Prin", top: "60%", left: "20%"
                    },
                    bCen: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: true, title: "Hab 3", top: "60%", left: "70%"
                    }
                });
            break;
        case 10:
            sesion(
                {
                    image: "13qJljW0sqg9bgwXYRZJHUSrBAHZzCHMv",
                    bIzq: {
                        visible: true, title: "Baño Prin", top: "60%", left: "20%"
                    },
                    bCen: {
                        visible: false, title: "", top: "", left: ""
                    },
                    bDer: {
                        visible: true, title: "Hab 2", top: "60%", left: "70%"
                    }
                });
            break;
        case 11:
            sesion(
                {
                    image: "16qfdwID8Csrcd_BoGh1NPrv6RFvQTpHf",
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
        default: alert("La opción ingresada es inválida");
            break;
    }
}

function sesion(Object) {
    agregarImagen("tour-main-image", "https://drive.google.com/uc?export=view&id=" + Object.image);
    newButtonConf(Object.bIzq.visible, "tour-button_view_izq", Object.bIzq.title, Object.bIzq.top, Object.bIzq.left);
    newButtonConf(Object.bCen.visible, "tour-button_view_cen", Object.bCen.title, Object.bCen.top, Object.bCen.left);
    newButtonConf(Object.bDer.visible, "tour-button_view_der", Object.bDer.title, Object.bDer.top, Object.bDer.left);
} function agregarImagen(idImagen, SrcImagen) { document.getElementById(idImagen).setAttribute("src", SrcImagen); } function newButtonConf(validation, idBoton, valorBoton, altoBoton, anchoDerechaBoton) { if (validation) { document.getElementById(idBoton).style.visibility = "visible"; } else { document.getElementById(idBoton).style.visibility = "hidden"; } document.getElementById(idBoton).value = valorBoton; document.getElementById(idBoton).style.top = altoBoton; document.getElementById(idBoton).style.left = anchoDerechaBoton; } function ocultarBoton(idBoton) { document.getElementById(idBoton).style.visibility = "hidden"; } function mostrarBoton(idBoton) { document.getElementById(idBoton).style.visibility = "visible"; }