'use strict';

const DIV = document.querySelector("#fighters");
const NAME = document.querySelector("#name");
const AGE = document.querySelector("#age");
const WINS = document.querySelector("#wins");
const LOSSES = document.querySelector("#losses");
const DRAWS = document.querySelector("#draws");
const NO_CONTESTS = document.querySelector("#no-contests");

const UDIV = document.querySelector("#update-fighters");
const UNAME = document.querySelector("#update-name");
const UAGE = document.querySelector("#update-age");
const UWINS = document.querySelector("#update-wins");
const ULOSSES = document.querySelector("#update-losses");
const UDRAWS = document.querySelector("#update-draws");
const UNO_CONTESTS = document.querySelector("#update-no-contests");
const UID = document.querySelector("#update-id");

const SEARCHNAME = document.querySelector("#searchName");

const printToScreen = (information) => {
    console.log(information);
    const p = document.createElement("p");
    p.id = information.id;
    var edit = document.createElement("BUTTON");
    edit.className = "btn btn-success edit";
    var del = document.createElement("BUTTON");
    del.className = "btn btn-danger del";
    del.onclick = () => {
        deleteFighterInsert(information.id);
    }
    edit.setAttribute("data-bs-toggle", "modal");
    edit.setAttribute("data-bs-target", "#updateAFighter")
    edit.onclick = () => {
        editMethod(information.id);
    }
    edit.innerHTML = "Edit";
    del.innerHTML = "Delete";
    const text = document.createTextNode(`${information.name} ${information.age} years old, ${information.wins}-${information.losses}-${information.draws} (${information.no_contests})`)
    p.appendChild(text);
    p.appendChild(edit);
    p.appendChild(del);
    DIV.prepend(p);
}

const deleteFighterInsert = (id) => {
    axios.delete(`http://localhost:8080/remove/${id}`, {
        "Headers": {
            "Access-Control-Allow-Origin": "*"
        }
    })
        .then((resp) => {
            console.log(resp);
            window.location.reload();
        })
        .catch((err) => console.error(err));
}

const editMethod = (id) => {
    axios.get(`http://localhost:8080/getOne/${id}`)
        .then((resp) => {
            UNAME.value = resp.data.name;
            UAGE.value = resp.data.age;
            UWINS.value = resp.data.wins;
            ULOSSES.value = resp.data.losses;
            UDRAWS.value = resp.data.draws;
            UNO_CONTESTS.value = resp.data.no_contests;
            UID.value = resp.data.id;
        })
}
const updateFighter = () => {
    const UID_VALUE = UID.value;
    const UNAME_VALUE = UNAME.value;
    const UAGE_VALUE = UAGE.value;
    const UWINS_VALUE = UWINS.value;
    const ULOSSES_VALUE = ULOSSES.value;
    const UDRAWS_VALUE = UDRAWS.value;
    const UNO_CONTESTS_VALUE = UNO_CONTESTS.value;

    console.log(`${UNAME_VALUE}, ${UAGE_VALUE} ${UWINS_VALUE}-${ULOSSES_VALUE}-${UDRAWS_VALUE} (${UNO_CONTESTS_VALUE})`);

    let obj = {
        name: UNAME_VALUE,
        age: UAGE_VALUE,
        wins: UWINS_VALUE,
        losses: ULOSSES_VALUE,
        draws: UDRAWS_VALUE,
        no_contests: UNO_CONTESTS_VALUE
    };

    axios.put(`http://localhost:8080/update/${UID_VALUE}`, obj, {
        "Headers": {
            "Access-Control-Allow-Origin": "*"
        }
    })
        .then((resp) => {
            console.log(resp);
            window.location.reload();
        })
        .catch((err) => console.error(err));
}

const createUser = () => {

    const NAME_VALUE = NAME.value;
    const AGE_VALUE = AGE.value;
    const WINS_VALUE = WINS.value;
    const LOSSES_VALUE = LOSSES.value;
    const DRAWS_VALUE = DRAWS.value;
    const NO_CONTESTS_VALUE = NO_CONTESTS.value;

    console.log(`${NAME_VALUE}, ${AGE_VALUE} ${WINS_VALUE}-${LOSSES_VALUE}-${DRAWS_VALUE} (${NO_CONTESTS_VALUE})`);


    let obj = {
        name: NAME_VALUE,
        age: AGE_VALUE,
        wins: WINS_VALUE,
        losses: LOSSES_VALUE,
        draws: DRAWS_VALUE,
        no_contests: NO_CONTESTS_VALUE
    };

    axios
        .post("http://localhost:8080/create", obj, {
            "Headers": {
                "Access-Control-Allow-Origin": "*"
            }
        })
        .then((resp) => {
            console.log(resp);
            printToScreen(resp.data);
        })
        .catch((err) => console.error(err));
}

const searchFighterByName = () => {
    const SEARCHNAME_VALUE = SEARCHNAME.value;
    axios
        .get(`http://localhost:8080/getByName/${SEARCHNAME_VALUE}`, {
            "Headers": {
                "Access-Control-Allow-Origin": "*"
            }
        })
        .then((resp) => {
            console.log(resp);
            addSearchedFighter(resp.data);
        })
        .catch((err) => console.error(err));
}

const addSearchedFighter=(data)=>{
    NAME.value = data.name;
    AGE.value = data.age;
    WINS.value = data.wins;
    LOSSES.value = data.losses;
    DRAWS.value = data.draws;
    NO_CONTESTS.value = data.no_contests;
    alert(`${NAME_VALUE}, ${AGE_VALUE} ${WINS_VALUE}-${LOSSES_VALUE}-${DRAWS_VALUE} (${NO_CONTESTS_VALUE})`);
}

// Axios get .. get all .then printtoscreen
axios
    .get("http://localhost:8080/getAll", {
        "Headers": {
            "Access-Control-Allow-Origin": "*"
        }
    })
    .then((resp) => {
        console.log(resp);
        for (let i = 0; i <= resp.data.length; i++)
            printToScreen(resp.data[i]);
    })
    .catch((err) => console.error(err));