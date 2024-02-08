let btnColor = document.getElementById("colorBtn")


function changeColor(){
    let logo = document.getElementById("logo") 
    let htmlMain = document.getElementById("htmlMain")
    if (htmlMain.classList == "lightTheme"){
        htmlMain.classList = "darkTheme"
        logo.src = "assets/logo-white.png"
    }else{
        logo.src = "assets/logo-negro.png"
        htmlMain.classList = "lightTheme"
    }
}

