class Point{
    //final const
    final int x;
    final int y;
    
    //Constructor is marked 'const' so all fields must be final.
    const Point(this.x,this.y);

}

class Rectangle{
    Point point;
    int width;
    int height;

    //默认值必须是在编译期 确定的常量
    Rectangle({this.point = const Point(0,0), this.width = 0, this.height = 0});

    //string {point.x}
    @override
    String toString() => "Point:(${point.x}-${point.y}, width:$width, height:$height)";
}
void main(List<String> args){
    var point = Point(10,20);
    print(point);


    Rectangle rectangle2 = Rectangle();
    Rectangle rectangle1 = Rectangle(point:const Point(10,10),width:1,height:1);
    
    print(rectangle2);
    print(rectangle1);
    
}
