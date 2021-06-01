public class Calculator {
    private double result;
    private double num1;
    private double num2;
    private char operator;

    public Calculator() {}

    public void setOperandOne(double input){
        this.num1 = input;
    }
    public void setOperandTwo(double input){
        this.num2 = input;
    }
    public void setOperation(char input){
        this.operator = input;
    }
    public void performOperation(){
        if(this.operator == '+') {
            result = num1 + num2;
        }
        if(this.operator == '-') {
            result = num1 - num2;
        }
    }

    public void getResults() {
        System.out.println(result);
    }

}