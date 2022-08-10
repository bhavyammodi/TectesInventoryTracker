import java.util.*;

class customobj {
    int l,r, stock;
    customobj(int l, int r, int stock) {
        // initializing the variables from main
        // function to the global variable of the class
        this.l = l;
        this.r = r;
        this.stock = stock;
    }

}


public class StockDetails {
    customobj arr[];
    void readData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of datasets");
        int n = sc.nextInt();
        arr = new customobj[n];
        System.out.println("Enter Date ranges with stocks");
        for(int i = 0; i < n; i++)
        {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int stock = sc.nextInt();
            arr[i] = new customobj(l,r,stock);
        }
    }

//    public static void main(String[] args) {
//        StockDetails ob = new StockDetails();
//        ob.readData();
//    }
}