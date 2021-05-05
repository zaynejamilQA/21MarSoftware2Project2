'use strict';

const DIV = document.querySelector("#people");
const NAME = document.querySelector("#name");
const AGE = document.querySelector("#age");
const WINS = document.querySelector("#wins");
const LOSSES = document.querySelector("#losses");
const DRAWS = document.querySelector("#draws");
const NO_CONTESTS = document.querySelector("#no-contests");
const ALERT = document.querySelector("#onSuccess");

axios
    .get("https://reqres.in/api/users")
    .then((response)=>{
        console.log(response);
        for(let data of response.data.data){
            printToScreen(data);
        }
    })
    .catch((err) =>{
        console.error(err);
    });


const printToScreen = (information) => {
    // <p> </p>
    const p = document.createElement("p");
    // Text: <firstname> <lastname> <email>
    const text = document.createTextNode(`${information.first_name} ${information.last_name}, ${information.email}`)
    // <p> <firstname> <lastname> <email> </p>
    p.appendChild(text);

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

    // Create the object
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
            ALERT.setAttribute("class", "alert alert-success");
            ALERT.innerHTML = "User has been successfully created!";
            setTimeout( () => {
                ALERT.removeAttribute("class");
                ALERT.innerHTML = "";
            },3000);
        })
        .catch((err) => console.error(err));
}

const PARAMS = new URLSearchParams(window.location.search);

for(const val of PARAMS.values()){
    console.log(val);
}

const id = PARAMS.get("id");
const UNAME = PARAMS.get("name");

alert(`The ID in the searchbar is: ${id}, NAME: ${UNAME}`);