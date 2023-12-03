const APPROVE_URL = 'http://localhost:8080/tasks/api/approve/'
const GET_URL = 'http://localhost:8080/tasks/api'

const CATEGORY_IMG = {
    suspension: "/images/suspension.png",
    body: "/images/body-repair.png",
    tire: "/images/tire-repair.png",
    engine: "/images/engine.png"
}
const CATEGORY_TEXT = {
    suspension: "Suspension repair",
    body: "Painting / Body",
    tire: "Tires repair",
    engine: "Engine repair"
}


//TODO REFACTOR Functionality in modules

async function getAllTasks(url) {
    const response = await fetch(url);
    return response.json();
}

getAllTasks(GET_URL).then(async (response) => {
    await render(response)
});

async function render(res) {

    let divToApprove = document.getElementById('toApprove');
    divToApprove.innerHTML = "";

    let pElemToApprove = createElement("p", "box py-3");
    pElemToApprove.textContent = " Waiting for approve...."
    divToApprove.appendChild(pElemToApprove);


    let divApproved = document.getElementById('approved');
    divApproved.innerHTML = "";

    let pElemApproved = createElement("p", "box py-3");
    pElemApproved.textContent = "Approved...."
    divApproved.appendChild(pElemApproved);


    res.forEach(res => {
        let isApproved = res.approved;
        let repairCategory =  getRepairCategoryData(res.repairCategory);

        console.log(repairCategory)
        let divBox = createElement("div", "box");

        let divImgBox = createElement("div", "img-box");

        let imgElem = createElement("img");
        imgElem.src = repairCategory.imgSrc;
        divImgBox.appendChild(imgElem);

        let divDetailBox = createElement("div", "detail-box");

        let hElem = createElement("h5");
        hElem.textContent = repairCategory.text;
        divDetailBox.appendChild(hElem);


        let tableElem = createTable(res);
        divDetailBox.appendChild(tableElem);




        divBox.appendChild(divImgBox);
        divBox.appendChild(divDetailBox);

        if (isApproved) {
            let pElemCreated = createElement("p");
            pElemCreated.textContent ="Created on - " + res.created;
            divDetailBox.appendChild(pElemCreated)
            divApproved.appendChild(divBox);

        } else {

            let aLink = createElement("a");
            aLink.href = "";
            aLink.textContent = "Approve"
            aLink.addEventListener('click', approve.bind(null, res.id));

            divDetailBox.appendChild(aLink);
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

function approve(id, event) {

    event.preventDefault();


    (async () => {
        await fetch(APPROVE_URL + id, {
            method: 'PATCH'
        })
        getAllTasks(GET_URL).then(async (response) => {
            await render(response)
        });
    })();

}

function getRepairCategoryData(repairCategory) {
    let category = {
        imgSrc:"",
        text:""
    };

    switch (repairCategory) {
        case "SUSPENSION":
            category.imgSrc = CATEGORY_IMG.suspension
            category.text = CATEGORY_TEXT.suspension;
            break;
        case "TIRES":
            category.imgSrc = CATEGORY_IMG.tire
            category.text = CATEGORY_TEXT.tire;
            break;
        case "ENGINE":
            category.imgSrc = CATEGORY_IMG.engine
            category.text = CATEGORY_TEXT.engine;
            break;
        case "BODY":
            category.imgSrc = CATEGORY_IMG.body
            category.text = CATEGORY_TEXT.body;
            break;
    }
    return category;
}