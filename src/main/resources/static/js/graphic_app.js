





async function getData(){
    response = await fetch(`/getAllPosts`)
    responseObj = await response.json()
    names = []
    likes = []
    responseObj.forEach(element => {
        names.push(element.id)
        likes.push(element.likes)
    });

    return data = [
        {
            x:names,
            y:likes,
            type:'bar'
        }

    ]
}

async function plotChart() {
    var data = await getData()
    
    console.log(data)
    console.log(Plotly)

    Plotly.newPlot('plotlyChart', data);
}

plotChart();



