import 'dart:math';

//顶层方法
//Shape shapeFactory(String type){
//    if(type == 'circle') return Circle(3);
//    if(type == 'square') return Square(3);
//    throw 'Can\'t create $type';
//}

abstract class Shape{
    num get area;

    //工厂模式的构造方法
    factory Shape(String type){
        if(type == 'circle') return Circle(2);
        if(type == 'square') return Square(2);
        throw "can't create $type by factory";
    }
}

class Circle implements Shape{
    final num radius;
    Circle(this.radius);
    num get area => pi * pow(radius,2);
}

class Square implements Shape{
    final num side;
    Square(this.side);
    num get area => pow(side,2);
}

//abstract
class CircleMock implements Circle{
    num area;
    num radius;
}

String scream(int length) => "A${'a'*length}h!";
main(){

    try{
        final circle = Shape('circle');//shapeFactory("circle");//Circle(2);
        final square = Shape('square');//shapeFactory('square');//Square(2);
        print(circle.area);
        print(square.area);


        final values = [2,5,6];
        // for(var value in values){
        //    print(scream(value));
        //}
        //lambda
        values.map(scream).forEach(print);

        print('-------------');

        //skip 1 2 3 ... n
        //skip(1) 忽略迭代中第一个值，take(3)会获取接下来的3个值.
        values.skip(1).take(3).map(scream).forEach(print);
    }
    catch(err){
        print(err);
    }
}
