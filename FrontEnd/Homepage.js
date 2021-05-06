'use strict';

const DIV = document.querySelector("#fighters");
const NAME = document.querySelector("#name");
const AGE = document.querySelector("#age");
const WINS = document.querySelector("#wins");
const LOSSES = document.querySelector("#losses");
const DRAWS = document.querySelector("#draws");
const NO_CONTESTS = document.querySelector("#no-contests");
const ALERT = document.querySelector("#onSuccess");

const printToScreen = (information) => {
    const p = document.createElement("p");
    var edit = document.createElement("BUTTON");
    var del = document.createElement("BUTTON");
    edit.innerHTML = "Edit";
    del.innerHTML = "Delete";
    const text = document.createTextNode(`${information.name} ${information.age} years old, ${information.wins}-${information.losses}-${information.draws} (${information.no_contests})`)
    p.appendChild(text);
    p.appendChild(edit);
    p.appendChild(del);
    DIV.appendChild(p);
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
        .post("https://reqres.in/api/users", obj)
        .then((resp) => {
            console.log(resp);
            printToScreen(obj);
            setTimeout( () => {
                ALERT.removeAttribute("class");
                ALERT.innerHTML = "";
            },3000);
        })
        .catch((err) => console.error(err));
}
