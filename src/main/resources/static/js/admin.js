
async function banUser(id){
    let response = await fetch(`/banUser?id=${id}`, {method:"DELETE"})
    let responseObj = await response.json()
    if(responseObj == false){
        alert("Error: User could not delete user")
    }else{
        elimHtmlUser(id)
    }
}

function elimHtmlUser(id){
    document.getElementById(`User_${id}`).remove()
}