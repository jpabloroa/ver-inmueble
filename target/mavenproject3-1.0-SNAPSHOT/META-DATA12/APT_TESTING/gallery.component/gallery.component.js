window.addEventListener('DOMContentLoaded', (event) => {
    newGalleryImage("ini");
});

function newGalleryImage(param) {
    var url = "galeria?param=" + param;
    const ajax_request = new XMLHttpRequest();
    ajax_request.open("GET", url, true);
    ajax_request.onreadystatechange = function () {
        if (ajax_request.readyState == 4 && ajax_request.status == 200) {
            let obj = JSON.parse(ajax_request.responseText);
            document.getElementById("gallery-main-title").innerHTML = obj.title;
            document.getElementById("gallery-main-image").setAttribute("src", obj.image);
            document.getElementById("gallery-next-button").style.visibility = obj.vsb_bnext;
            document.getElementById("gallery-previous-button").style.visibility = obj.vsb_bprevious;
        }
    }
    ajax_request.send();
}