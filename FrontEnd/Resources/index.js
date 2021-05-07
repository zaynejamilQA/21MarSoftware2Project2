'use strict';

const DIV = document.querySelector("#fighters");
const NAME = document.querySelector("#name");
const AGE = document.querySelector("#age");
const WINS = document.querySelector("#wins");
const LOSSES = document.querySelector("#losses");
const DRAWS = document.querySelector("#draws");
const NO_CONTESTS = document.querySelector("#no-contests");

const printToScreen = (information) => {
    console.log(information);
    const p = document.createElement("p");
    p.id = information.id;
    var edit = document.createElement("BUTTON");
    edit.className = "btn btn-success edit";
    var del = document.createElement("BUTTON");
    del.className = "btn btn-danger del";
    del.onclick = ()=>{
      deleteFighterInsert(information.id);  
    }
    edit.innerHTML = "Edit";
    del.innerHTML = "Delete";
    const text = document.createTextNode(`${information.name} ${information.age} years old, ${information.wins}-${information.losses}-${information.draws} (${information.no_contests})`)
    p.appendChild(text);
    p.appendChild(edit);
    p.appendChild(del);
    DIV.appendChild(p);
}

const deleteFighterInsert=(id)=>{
    axios.delete(`http://localhost:8080/remove/${id}`, {"Headers":{
        "Access-Control-Allow-Origin":"*"
    }})
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
        .post("http://localhost:8080/create", obj)
        .then((resp) => {
            console.log(resp);
            printToScreen(resp.data);
        })
        .catch((err) => console.error(err));
}

// Axios get .. get all .then printtoscreen