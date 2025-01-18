public class MyString implements Main.Measurable{
    String myString;

    public MyString(String myString){
        this.myString = myString;
    }

    public double getLength(){
        return this.myString.length();
    }

}
