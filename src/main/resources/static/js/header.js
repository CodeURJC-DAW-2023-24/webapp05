
async function loadUserSearch(){
    let userTxt = document.getElementById("userSearch").value 
    let response = await fetch(`/getUserForSearch?name=${userTxt}`)
    let responseObj = await response.json()
    putSugestionsInDrop(responseObj)
}

function putSugestionsInDrop(users){
    let txt = ""
    users.forEach(element => {
        txt += `<a href="/profile?name=${element.name}">${element.name}</a>`
    });
    document.getElementById("headerSearchInput").innerHTML += txt
}