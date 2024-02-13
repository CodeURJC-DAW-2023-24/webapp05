let btnColor = document.getElementById("colorBtn")


function changeColor(){
    let logo = document.getElementById("logo") 
    let edit = document.getElementById("edit")
    let call = document.getElementById("call")
    let video_call = document.getElementById("video_call")
    let htmlMain = document.getElementById("htmlMain")
    if (htmlMain.classList == "lightTheme"){
        htmlMain.classList = "darkTheme"
        logo.src = "assets/logo-white.png"
        edit.src = "./img/edit-white.png"
        call.src ="./img/telephone-white.png"
        video_call.src = "./img/video_call-white.png"
    }else{
        logo.src = "assets/logo-negro.png"
        edit.src = "./img/edit.png"
        call.src ="./img/telephone.png"
        video_call.src = "./img/video_call.png"
        htmlMain.classList = "lightTheme"
    }
}

