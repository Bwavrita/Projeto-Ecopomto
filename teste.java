
import java.util.Scanner;

import Interface.Interface;

public class teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Interface inter = new Interface();
        inter.inter(scan);
        scan.close();
    }
}
