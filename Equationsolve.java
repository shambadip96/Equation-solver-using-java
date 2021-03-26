import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class EquationSolve {


    public static ArrayList<String> BODMAS(String s) {
        ArrayList<String> termsOfEquation = new ArrayList<>();

        //Getting numbers and operators for the equation
        StringTokenizer st = new StringTokenizer(s," ");
        for (Iterator<Object> i = st.asIterator(); i.hasNext(); ){
            termsOfEquation.add((String) i.next());
        }

        //BODMAS - Bracket Off Division Multiplication Addition Subtraction
        //In this video I show only DMAS

        while(termsOfEquation.indexOf("/") != -1){
            double num1 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("/")+1));
            double num2 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("/")-1));
            double answer  = num2 / num1;
            termsOfEquation.set(termsOfEquation.indexOf("/") -1, Double.toString(answer));
            termsOfEquation.remove(termsOfEquation.indexOf("/")+1);
            termsOfEquation.remove(termsOfEquation.indexOf("/"));
        }
        //Now repeat it for * + - in this order

        while(termsOfEquation.indexOf("*") != -1){
            double num1 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("*")+1));
            double num2 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("*")-1));
            double answer  = num2 * num1;
            termsOfEquation.set(termsOfEquation.indexOf("*") -1, Double.toString(answer));
            termsOfEquation.remove(termsOfEquation.indexOf("*") + 1);
            termsOfEquation.remove(termsOfEquation.indexOf("*"));
        }

        while(termsOfEquation.indexOf("+") != -1){
            double num1 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("+")+1));
            double num2 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("+")-1));
            double answer = num2 + num1;
            
            termsOfEquation.set(termsOfEquation.indexOf("+") -1, Double.toString(answer));
            termsOfEquation.remove(termsOfEquation.indexOf("+") + 1);
            termsOfEquation.remove(termsOfEquation.indexOf("+"));
        }

        while(termsOfEquation.indexOf("-") != -1){
            double num1 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("-")+1));
            double num2 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("-")-1));
            double answer  = num2 - num1;
            termsOfEquation.set(termsOfEquation.indexOf("-") -1, Double.toString(answer));
            termsOfEquation.remove(termsOfEquation.indexOf("-") + 1);
            termsOfEquation.remove(termsOfEquation.indexOf("-"));
        }
        return termsOfEquation;
        //Fixing some mistake
        //Now it work correctly
    

    }

    public static void main(String[] args) {
        BODMAS("10 / 5 * 5").forEach(System.out::print);


    }
    
}