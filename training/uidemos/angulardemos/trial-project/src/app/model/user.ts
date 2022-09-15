import { Address } from "./address";


export class User {
  constructor(
    public firstname:string,
    public lastname:string,
    public gender:string,
    public email:string,
    public acceptTerms:boolean,
    public address:Address
){}
}
