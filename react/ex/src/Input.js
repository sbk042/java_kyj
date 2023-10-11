import { useState } from "react";

function Input({inputEvent}){
    return(
        <input type="text" onChange={inputEvent}></input>
    )
}

export default Input;