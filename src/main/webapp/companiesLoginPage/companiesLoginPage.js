var stylesheet0 = document.styleSheets[0];
var stylesheet1 = document.styleSheets[1];

stylesheet1.disabled = true;

// Get the modal
var modal = document.getElementById('id01');


// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
        $("container").style.display = "block";
    }
    //stylesheet0.disabled = true;
    stylesheet1.disabled = false;
}