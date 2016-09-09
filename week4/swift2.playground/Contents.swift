

class Counter {
    var count = 0
    func incrementBy(amount: Int, num: Int){
        count=count+amount*num
    }
}

let myCounter=Counter()
myCounter.count
myCounter.incrementBy(10, num: 2)
myCounter.count

//class

class Vehicle {
    var wheelNum = 4
    var speed = 55
    var mpg = 20
    let tankCapacity = 20
    var name : String?
    func changeSpeed(amount: Int){
        speed = speed + amount
    }
    func changeEfficiency(speed newSpeed: Int, mpg newmpg: Int){
        speed = newSpeed
        mpg = newmpg
    }
    
    //initializers
    init(vehicleName vname: String){
        name = vname
    }
    init(){
    }
}

//object

let myJeep = Vehicle()
myJeep.mpg
myJeep.speed

//methods

myJeep.changeSpeed(10)
myJeep.speed
myJeep.changeEfficiency(speed: 35, mpg: 25)
myJeep.speed
myJeep.mpg

//initialization

let myHybrid = Vehicle(vehicleName: "Prius")
myHybrid.name

if myHybrid.name != nil {
    print(myHybrid.name!)
}

//inheritance

class Bicycle : Vehicle {
    var reflectors : Bool
    init(_ ref: Bool){
        reflectors=ref
        super.init()
    }
}
var bike = Bicycle(false)
bike.wheelNum
bike.wheelNum = 2
bike.wheelNum

bike.reflectors

//arrays

var myList = [String]()
var shoppingList=["cereal", "milk"]
print(shoppingList[0])
shoppingList.append("bread")

if shoppingList.isEmpty{
    print("there's nothing you need")
} else {
    print("You need \(shoppingList.count)" + " items")
}

let item = shoppingList.removeLast()
shoppingList.insert("coffee", atIndex:0)
let juice=shoppingList.removeAtIndex(1)

for item in shoppingList{
    print(item)
}

//dictionaries

var newList=[String:String]()
var classes:[String: String]=["4120":"MAD", "3000":"Code"]
classes["3000"]
classes["2000"]="MIT"
classes.count

classes.updateValue("Mobile App Dev", forKey: "4120")
classes.removeValueForKey("3000")

for (num, name) in classes{
    print("\(num): \(name)")
}






