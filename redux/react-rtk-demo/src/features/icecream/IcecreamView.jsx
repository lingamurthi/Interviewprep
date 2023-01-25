import React from 'react';
import { useSelector,useDispatch } from 'react-redux';


import {ordered,restocked} from './icecreamSlice'
import { useState } from 'react';
export const IcecreamView = () => {

    const [value,setValue]=React.useState(1);
   const numOfIceCreams= useSelector(state=>state.icecream.numOfIceCreams)

   const dispatch=useDispatch()
    return (
        <div>
            <h2>Number of ice creams {numOfIceCreams}</h2>
            <button onClick={()=>dispatch(ordered())}>Order ice creams</button>
            <input 
            type='number' 
            value={value} 
            onChange={e=>setValue(e.target.value)}/>
            <button onClick={()=>dispatch(restocked(value))}>Restore ice creams</button>
        </div>
    )
}