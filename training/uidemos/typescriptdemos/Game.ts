abstract class Game {
    constructor(public GameName:string,
        public gameId:number,
        public origin:string,
        public teamSize:number,
        public type:string,
       ){}
    public showDetails=()=>console.log(`Name ${this.GameName} GameId ${this.gameId} origin ${this.origin}`);
    abstract gameDesc(desc:string):void


}
class Cricket extends Game{
    constructor(public GameName:string,
        public gameId:number,
        public origin:string,
        public teamSize:number,
        public type:string,
        public captain:string
       ){
           super(GameName,gameId,origin,teamSize,type)
       }
       gameDesc=(desc:string):void=> {
        console.log("Captain Name is "+this.captain);
    }
}
 let cricket=new Cricket("crick",1,"eng",11,"outdoor","VK");
 cricket.showDetails();
 cricket.gameDesc("VK");

 class Tennis extends Game{
    constructor(public GameName:string,
        public gameId:number,
        public origin:string,
        public teamSize:number,
        public type:string,
        public captain:string
       ){
           super(GameName,gameId,origin,teamSize,type)
       }
       gameDesc=(desc:string):void=> {
        console.log("Captain Name is "+this.captain);
    }
}
 let tennis=new Tennis("tennis",2,"eng",2,"indoor","MR");
 tennis.showDetails();
 tennis.gameDesc("MR");