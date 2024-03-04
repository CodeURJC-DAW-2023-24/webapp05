

post();


async function post(){
    let userName = document.getElementById("userName").textContent;
    let response = await fetch(`/getProfilePost?name=${userName}`);
    let posts = await response.json();
    let token = document.getElementById("_csrf").value
    response = await fetch("/getMyName")
    let myName = await response.text()
    document.getElementById("profilePost").innerHTML = postListsToHTML(posts, myName);
}

function postListsToHTML(post, userName){
    let text = "";
    post.forEach(element => {
        if(element.author.userName != userName){
            text += `<a><img class="col-md-1 post" src="/imagePost/${element.id}"/></a>`
        }else{
            text += `<a href="/showSpecificPost/${element.id}"><img class="col-md-1 post" src="/imagePost/${element.id}"/></a>`
        }
        
    });
    return text;
}












