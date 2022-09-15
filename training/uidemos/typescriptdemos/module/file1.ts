
export var greeting='Helo world';

export function greet() {
        anyMethod();
        console.log('exported')
}
//similiar to private
function anyMethod() {
    console.log('cpnfidential -not exported')
}
export class Product {
    constructor(public itemName:string,
                public price:number){ }

                getinfo =() => {
                    console.log(`${this.itemName} is of price ${this.price}`)
                }
}
