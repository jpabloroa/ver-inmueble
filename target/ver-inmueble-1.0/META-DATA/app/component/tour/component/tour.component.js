window.addEventListener('DOMContentLoaded', (event) => {
    newTourImage("-");
});

var imageStep = 0;

/**
 * 
 * @param {string} tourBtnPressed 
 */
function newTourImage(tourBtnPressed) {
    var url = "recorrido-virtual?tourBtnPressed=" + tourBtnPressed + "&tourStep=" + imageStep;
    const ajax_request = new XMLHttpRequest();
    ajax_request.open("GET", url, true);
    ajax_request.onreadystatechange = function () {
        if (ajax_request.readyState == 4 && ajax_request.status == 200) {
            let obj = JSON.parse(ajax_request.responseText);
            document.getElementById("tour-main-title").innerHTML = obj.title;
            document.getElementById("tour-main-image").setAttribute("src", obj.image);
            for (var i = 0; i < obj.bntProp.length; i++) {
                agregarBoton(obj.bntProp[i].id, "", obj.bntProp[i].visibility, obj.bntProp[i].top, obj.bntProp[i].left);
            }
            imageStep = obj.pValue;
        }
    }
    ajax_request.send();
}

/**
     * 
     * Función "agregarBoton()"
     * 
     * Modifica el valor de los atributos "visibility",
     * "value", "top" y "left" del elemento especificado
     * 
     * @param {string} idBoton -> Recibe como parámetro el
     * identificador del elemento a modificar
     * @param {string} valorBoton -> Recibe como parámetro el 
     * valor que tendrá el elemento
     * @param {string} altoBoton -> Recibe como parámetro la 
     * distancia con respecto al borde superior html 
     * @param {string} anchoDerechaBoton -> Recibe como parámetro la 
     * distancia con respecto al borde izquierdo html 
     * 
     * @return void -> No devuelve acción alguna
     */
function agregarBoton(idBoton, valorBoton, esVisible, altoBoton, anchoDerechaBoton) {
    var boton = document.getElementById(idBoton);
    boton.value = valorBoton;
    if (esVisible) {
        boton.style.visibility = "visible";
    } else {
        boton.style.visibility = "hidden";
    }
    boton.style.top = altoBoton;
    boton.style.left = anchoDerechaBoton;
}