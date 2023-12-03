const APPROVE_URL = 'http://localhost:8080/tasks/api/approove/'

async function getAllTasks(url) {
    const response = await fetch(url);
    return response.json();
}

getAllTasks('http://localhost:8080/tasks/api').then((response) => {
    render(response)
});

function render(res) {

    let divToApprove = document.getElementById('toApprove');

    let divApproved = document.getElementById('approved');


    res.forEach(res => {
        let isApproved = res.approved;

        let divBox = createElement("div", "box");

        let divImgBox = createElement("div", "img-box");

        let imgElem = createElement("img");
        imgElem.src = "/images/body-repair.png"; // TODO diferent images for category
        divImgBox.appendChild(imgElem);

        let divDetailBox = createElement("div", "detail-box");

        let hElem = createElement("h5");
        hElem.textContent = "Painting / Body" // TODO get text for category
        divDetailBox.appendChild(hElem);


        let tableElem = createTable(res);
        divDetailBox.appendChild(tableElem);

        let aLink = createElement("a");
        aLink.href = "";
        aLink.textContent = "Approve link"
        aLink.addEventListener('click', approve );

        divDetailBox.appendChild(aLink);


        divBox.appendChild(divImgBox);
        divBox.appendChild(divDetailBox);

        if (isApproved) {
            divApproved.appendChild(divBox);
        } else {
            divToApprove.appendChild(divBox);
        }


    })

}


function createElement(tagName, className) {


    let elem = document.createElement(tagName);
    if (className) {
        elem.className = className;
    }

    return elem;

}

function createTable(res) {


    let table = createElement("table", "table table-sm table-dark");

    let thData = ["#", "Client", "Vehicle", "Brand", "Model", "Year", "Color"];

    let theadElem = document.createElement("thead");
    let trElem = document.createElement("tr");

    thData.forEach(col => {
        let thElem = document.createElement("th");
        thElem.scope = "col";
        thElem.textContent = col;
        trElem.appendChild(thElem);
    })

    theadElem.appendChild(trElem);

    table.appendChild(theadElem);

    let tbodyElem = document.createElement("tbody");


    let trElemTBody = document.createElement("tr");


    let thElem = document.createElement("th");
    thElem.scope = "row";
    thElem.textContent = res.id;

    let clientData =
        [res.ownerName,
            res.vehicleCategory,
            res.vehicleBrand,
            res.vehicleModel,
            res.vehicleYear,
            res.vehicleColor];

    trElemTBody.appendChild(thElem);

    clientData.forEach(data => {
        let tdElem = document.createElement("td");
        tdElem.textContent = data;
        trElemTBody.appendChild(tdElem);
    })

    tbodyElem.appendChild(trElemTBody);
    table.appendChild(tbodyElem);


    return table;

}

function approve(event) {
    event.preventDefault();
}