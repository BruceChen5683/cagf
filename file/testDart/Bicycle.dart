class Bicycle{
    int cadence;
    int speed;
    int gear;

    int _age = 0;//must be init, null

    Bicycle(this.cadence,this.speed,this.gear);

    //override not Override  
    @override
    String toString() => "Bicycle: $cadence cadence,$speed speed,$gear gear,$age age";

    int get age => _age;

    void applyBrake(int decrement){
        _age -= decrement;
    }

    void speedUp(int increment){
        _age += increment;
    }

    

}

void main(List<String> args){
    //print(args[0]);
    //print(args.length);
    print("first dart");


    //new is optional
    var bike = new Bicycle(2,0,1);

    bike.speedUp(3);
    print(bike);
    print(bike.cadence);
    

    
    //确定不变的value可以直接使用final 代替var
    final bike2 = Bicycle(1,2,3);
    print(bike2.cadence);

    //bike2 = Bicycle(2,3,4);

    //Error setter not found:'bike2'
    
    print(bike2);
    print(bike2.age);
    bike2.speedUp(5);
    print(bike2);
}
