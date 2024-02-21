public class Question1 {
    public static void main(String[] args){
    
        // Student s = new Student();
        // s.name = "Talha ";
        // System.out.print("Name of Student is " + s.name);

        // v can access car object because of overriding (Same functions)
        // vechile v = new car();
        // v.print();  
        // vechile v2 = new vechile();
        // v2.print();

// but what if we change one function in car class print to print1 then not accessible because v only access x property not x+y and print1 is y property!
        // vechile v = new car();
        // // not accessbale
        // v.print1();   
        // vechile v2 = new vechile();
        // v2.print();

    }
}

// class vechile {
//     void print(){
//         System.out.println("Base Class");
//     }
// }
// class car extends vechile{
//     void print(){
//         System.out.println("Derived Class ");
//     }
// }
// class vechile {
//     void print(){
//         System.out.println("Base Class");
//     }
// }
// class car extends vechile{
//     void print1(){
//         System.out.println("Derived Class ");
//     }
// }
