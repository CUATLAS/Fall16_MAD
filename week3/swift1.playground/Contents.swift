//variables

var message : String = "hi"
let classMax : Int = 20

var age : Int
age=20

var name = "Aileen"
var firstName="Aileen"
name="Pierce"

print("Who am I?")
print("\(firstName)")
print("\(firstName)"+"\(age)")
print("\(firstName)" + " \(name)")

let a = 42
let b = 0.123
let c = Double(a) + b

//tuples

let violet = ("#EE82EE", 238, 130, 238)
print("Violet is \(violet.0)")
let (hex, red, green, blue) = violet
print("Violet is \(hex)")

//conditionals

if age < 21 {
    print("you are young")
}
    else {
    print("you're not so young")
}

switch age{
    case 0...5: print("You're a wee bitty one")
    case 6...21: print("Enjoy school")
    case 22...55: print("Welcome the real world")
default: print("I don't know what you're doing")
}

//loops

for i in 0...age {
        print("\(i)")
}

//optionals

var score : Int?
print("score is \(score)")
score=80
print(score)
print("score is \(score!)")

if score != nil {
    print("The score is \(score!)")
}

if let currentScore = score {
    print("My current score is \(currentScore)")
}

let newScore :Int! = 95
print("My new score is \(newScore)")

//functions

func sayHi(){
    print("Hi")
}

sayHi()

func sayHello (first: String, last: String){
    print("Hi \(first) \(last)")
}

sayHello("Bill", last: "Adams")

func sayWhat(firstName first:String, lastName last: String){
        print("what \(first) \(last)?")
}

sayWhat(firstName: "bill", lastName: "Adams")


func sayWho(firstName : String, lastName : String) -> String {
                return "Who" + firstName + " " + lastName + "?"
}

let msg2=sayWho("Jim", lastName: "Adams")
print(msg2)








