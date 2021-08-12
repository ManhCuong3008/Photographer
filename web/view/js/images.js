
function dropDown() {
    var navLink = document.getElementsByClassName("nav-link");
    if(navLink[1].classList[1] !== "show"){
        navLink[1].style.display = "block";
        navLink[1].classList.add("show");
    }else{
        navLink[1].style.display = "none";
        navLink[1].classList.remove("show");
    }
}
