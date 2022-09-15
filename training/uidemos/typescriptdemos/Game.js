var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Game = /** @class */ (function () {
    function Game(GameName, gameId, origin, teamSize, type) {
        var _this = this;
        this.GameName = GameName;
        this.gameId = gameId;
        this.origin = origin;
        this.teamSize = teamSize;
        this.type = type;
        this.showDetails = function () { return console.log("Name " + _this.GameName + " GameId " + _this.gameId + " origin " + _this.origin); };
    }
    return Game;
}());
var Cricket = /** @class */ (function (_super) {
    __extends(Cricket, _super);
    function Cricket(GameName, gameId, origin, teamSize, type, captain) {
        var _this = _super.call(this, GameName, gameId, origin, teamSize, type) || this;
        _this.GameName = GameName;
        _this.gameId = gameId;
        _this.origin = origin;
        _this.teamSize = teamSize;
        _this.type = type;
        _this.captain = captain;
        _this.gameDesc = function (desc) {
            console.log("Captain Name is " + _this.captain);
        };
        return _this;
    }
    return Cricket;
}(Game));
var cricket = new Cricket("crick", 1, "eng", 11, "outdoor", "VK");
cricket.showDetails();
cricket.gameDesc("VK");
var Tennis = /** @class */ (function (_super) {
    __extends(Tennis, _super);
    function Tennis(GameName, gameId, origin, teamSize, type, captain) {
        var _this = _super.call(this, GameName, gameId, origin, teamSize, type) || this;
        _this.GameName = GameName;
        _this.gameId = gameId;
        _this.origin = origin;
        _this.teamSize = teamSize;
        _this.type = type;
        _this.captain = captain;
        _this.gameDesc = function (desc) {
            console.log("Captain Name is " + _this.captain);
        };
        return _this;
    }
    return Tennis;
}(Game));
var tennis = new Tennis("tennis", 2, "eng", 2, "indoor", "MR");
tennis.showDetails();
tennis.gameDesc("MR");
