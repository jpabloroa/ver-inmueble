window.addEventListener('DOMContentLoaded', (event) => {
    newGalleryImage("-");
    setComponent();
});

var imageStep = 0;

function newGalleryImage(galleryBtnPressed) {
    var url = "galeria?galleryBtnPressed=" + galleryBtnPressed + "&galleryStep=" + imageStep;
    const ajax_request = new XMLHttpRequest();
    ajax_request.open("GET", url, true);
    ajax_request.onreadystatechange = function () {
        if (ajax_request.readyState == 4 && ajax_request.status == 200) {
            let obj = JSON.parse(ajax_request.responseText);
            document.getElementById("gallery-main-title").innerHTML = obj.title;
            document.getElementById("gallery-main-image").setAttribute("src", obj.image);
            document.getElementById("gallery-link-saber_mas").href = obj.link;
            document.getElementById("gallery-next-button").style.visibility = obj.vsb_bnext;
            document.getElementById("gallery-previous-button").style.visibility = obj.vsb_bprevious;
            imageStep = obj.pValue;
        }
    }
    ajax_request.send();
}

function setComponent(){
    document.getElementById("gallery-next-button").innerHTML = '&#10095';
    document.getElementById("gallery-previous-button").innerHTML = '&#10094';
}