const redux=require('redux')
const createStore=redux.createStore
const bindActionCreators=redux.bindActionCreators
const combineReducers=redux.combineReducers

const applyMiddleware=redux.applyMiddleware
const reduxLogger=require('redux-logger')  //middleware
const logger=reduxLogger.createLogger()


const CAKE_ORDERED='CAKE_ORDERED'
const CAKE_RESTORED='CAKE_RESTORED'


const ICECREAM_ORDERED='ICECREAM_ORDERED'
const ICECREAM_RESTORED='ICECREAM_RESTORED'
function orderCake()
{
return{
    type:CAKE_ORDERED,
    quantity:1,
}
}

function restoreCake(qty=1)
{
    return{
        type:CAKE_RESTORED,
        quantity:qty

    }
}

function orderIceCream(qty=1)
{
    return{
        type:ICECREAM_ORDERED,
        quantity:qty
    }
}

function restoreIceCream(qty=1)
{
    return{
        type:ICECREAM_RESTORED,
        quantity:qty
    }
}
// const initialState={
// numOfCakes:10,
// anotherProperty:0,
// numOfIceCreams:20
// }

const initialCakeState={
    numOfCakes:10
}

const initialIceCreamState={
    numOfIceCreams:20
}
const cakeReducer= (state=initialCakeState,action)=>{

    switch(action.type)
    {
       case CAKE_ORDERED:
        return {
            ...state,
            numOfCakes:state.numOfCakes-1
        }
        case CAKE_RESTORED:
            return{
                ...state,
                numOfCakes:state.numOfCakes+action.quantity
            }
        default:
            return state
    }
}




const iceCreamReducer= (state=initialIceCreamState,action)=>{

    switch(action.type)
    {
     case ICECREAM_ORDERED:
                return {
                    ...state,
                    numOfIceCreams:state.numOfIceCreams-1
                }
    case ICECREAM_RESTORED:
                    return{
                        ...state,
                        numOfIceCreams:state.numOfIceCreams+action.quantity
                    }

    case CAKE_ORDERED:
        return{
            ...state,
            numOfIceCreams:state.numOfIceCreams-1
        }
    default:
            return state
    }
}


const rootReducer=combineReducers({
    cake:cakeReducer,
    iceCream:iceCreamReducer
})

const store=createStore(rootReducer, applyMiddleware(logger))

//const store = createStore(rootReducer)
console.log("Initial state", store.getState());

const unsubscribe=store.subscribe(()=>{
    console.log("Updated state", store.getState());
})

// store.dispatch(orderCake())
// store.dispatch(orderCake())
// store.dispatch(orderCake())
// store.dispatch(restoreCake(3))

const actions=bindActionCreators({orderCake,restoreCake,orderIceCream,restoreIceCream},store.dispatch);

actions.orderCake()
actions.orderCake()
actions.orderCake()
actions.restoreCake(3)


actions.orderIceCream()
actions.orderIceCream()
actions.restoreIceCream(2)

unsubscribe()