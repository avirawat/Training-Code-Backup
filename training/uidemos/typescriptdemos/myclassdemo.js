var Student = /** @class */ (function () {
    function Student(studentName, studentId, department, city) {
        var _this = this;
        if (city === void 0) { city = 'Banglore'; }
        this.studentName = studentName;
        this.studentId = studentId;
        this.department = department;
        this.city = city;
        this.printDetails = function () {
            console.log(_this.studentName);
            console.log(_this.city);
            console.log(_this.studentId);
            console.log(_this.department);
        };
        this.showHobbies = function () {
            var hobbies = [];
            for (var _i = 0; _i < arguments.length; _i++) {
                hobbies[_i] = arguments[_i];
            }
            hobbies.forEach(function (hobby) { return console.log(hobby); });
        };
    }
    return Student;
}());
var student = new Student('Ram', 10);
student.printDetails();
student.showHobbies('sports', 'music');
var student = new Student('Ram', 10, 'CSE', 'Hyd');
student.printDetails();
student.showHobbies('sports', 'music', 'dance');
