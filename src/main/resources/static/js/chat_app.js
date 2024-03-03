let btnColor = document.getElementById("colorBtn")
let me = document.getElementById("meXd").textContent
let nowChat = ""

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

async function loadMesaggesOfChat(userName){
    let response = await fetch(`/getChat/${userName}`)
    let responseObj = await response.json()
    if(responseObj != null){
        let txt = loadChatToHTML(responseObj)
        document.getElementById("chattingZone").innerHTML = txt
    }
    nowChat = userName
}

function loadChatToHTML(chatMessages){
    let txt = ""
    chatMessages.forEach(element => {
        if(element.author.name === me){
            txt += ChatMessageToMyHTML(element.comment)
        }else{
            txt += ChatMessageToFrienHTML(element.comment)
        }
    });
    return txt
}

async function sendMessage(){
    let txtInput = document.getElementById("chatMessageInput").value 

    if(txtInput === ""){
        alert("The chats can not be empty")
    }else{
        let token = document.getElementById("_csrf").value

        let response = await fetch(`/sendChatMessage/${nowChat}?txt=${txtInput}`, {method:"PUT" , 
        headers:{
        "Content-Type": "application/json",
        "X-CSRF-Token": token, 
        }})
        let responseObj = await response.json()
        if(responseObj == false){
            alert("Error: Message could not be sent")
        }
        document.getElementById("chattingZone").innerHTML += ChatMessageToMyHTML(txtInput)
    }
}

function ChatMessageToFrienHTML(txtInput){
    return `<div class="my_message">
    <p class="p_message">${txtInput}</p>
  </div>`
}

function ChatMessageToMyHTML(txtInput){
    return `<div class="response_message">
    <p class="p_message">${txtInput}</p>
  </div>`
}