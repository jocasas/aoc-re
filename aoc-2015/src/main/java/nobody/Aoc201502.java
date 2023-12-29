package nobody;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Aoc201502 {

    public int calculateSurfaceArea(int l, int w, int h) {
        int lw = (l * w);
        int wh = (w * h);
        int hl = (h * l);
        int surfArea = (2 * (lw) + 2 * (wh) + 2 * (hl));
        int smallestArea = Math.min(Math.min(lw, wh), hl);
        surfArea += smallestArea;
        return surfArea;
    }

    public int calculateWrappingPapper(String str) {
        String[] lines = str.split("\\n");
        int wrappingPaper = 0;
        for (String line : lines) {
            // Cortar basado en la x en el string
            String[] numbers = line.split("x");

            int l = Integer.parseInt(numbers[0]);
            int w = Integer.parseInt(numbers[1]);
            int h = Integer.parseInt(numbers[2]);

            var sa = calculateSurfaceArea(l, w, h);
            wrappingPaper += sa;
        }
        return wrappingPaper;
    }
    
    public int calculateRibbonPerimeter(int l,int w,int h) {
        int maxDimension = Math.max(l, Math.max(w, h));
        int totalPerimeter = (l+w+h);
        int smallestPerimeter = totalPerimeter - maxDimension;
        int P = 2 * smallestPerimeter;
        return P;
    }
    
    public int bowVolume (int l,int w,int h){
        int V = l*w*h;
        return V;
    }
    
    public int calculateFeetOfRibbon (String str){
        String[] lines = str.split("\\n");
        int feetRibbon = 0;
        for (String line : lines) {
            // Cortar basado en la x en el string
            String[] numbers = line.split("x");

            int l = Integer.parseInt(numbers[0]);
            int w = Integer.parseInt(numbers[1]);
            int h = Integer.parseInt(numbers[2]);

            var P = calculateRibbonPerimeter(l, w, h);
            var V = bowVolume(l,w,h);
            feetRibbon += (P+V);
        }
        return feetRibbon;
    }

    public static void main(String[] args) throws Exception {
        //Código para resolver el problema AOC201502 parte 1
        Aoc201502 aoc = new Aoc201502(); // Instance de Aoc201502
        var str = new String(Files.readAllBytes(Paths.get("aoc-2015/dimensions.txt")));
        var pappersqrfoot = aoc.calculateWrappingPapper(str);
        System.out.println("Feet of paper needed: "+ pappersqrfoot);
        //System.out.println(System.getProperty("user.dir"));
     
        //Código para resolver el problema AOC201502 parte 2        
        var ammountofribbon = aoc.calculateFeetOfRibbon(str);
        System.out.println("Feet of ribbon needed: "+ ammountofribbon);
    }
}
