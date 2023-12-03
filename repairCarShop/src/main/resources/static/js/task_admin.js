import {createTable} from "./utils.js";
import {createElement} from "./utils.js";
import {getRepairCategoryData} from "./utils.js";

const APPROVE_URL = 'http://localhost:8080/api/tasks/approve/'
const GET_TASKS_URL = 'http://localhost:8080/api/tasks'

async function get(url) {
    const response = await fetch(url);
    return response.json();
}

get(GET_TASKS_URL).then(async (response) => {
    await renderAdmin(response)
});

async function renderAdmin(res) {

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
        let repairCategory = getRepairCategoryData(res.repairCategory);

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
            pElemCreated.textContent = "Created on - " + res.created;
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

function approve(id, event) {
    event.preventDefault();
    (async () => {
        await fetch(APPROVE_URL + id, {
            method: 'PATCH'
        })
        get(GET_TASKS_URL).then(async (response) => {
            await renderAdmin(response)
        });
    })();
}

