

post();


async function post(){
    let userName = document.getElementById("userName").textContent;
    let response = await fetch(`/getProfilePost?name=${userName}`);
    let responseObject = await response.json();
    document.getElementById("profilePost").innerHTML = postListsToHTML(responseObject);
}

function postListsToHTML(post){
    let text = "";
    post.forEach(element => {
        text += `<a href="/showSpecificPost/${element.id}"><img class="col-md-1 post" src="/imagePost/${element.id}"/></a>`
    });
    return text;
}












