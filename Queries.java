public class Queries extends StockDetails {
    void StockRanges(customobj arr[]) {
        int pref[] = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            pref[arr[i].l] += arr[i].stock;
            if (arr[i].r != -1) // no end date case
                pref[arr[i].r + 1] -= arr[i].stock;
        }
        int prev = -1;
        int sum = 0;
        for (int i = 1; i < 10000; i++) {
            if (i > 0) pref[i] += pref[i - 1];
            if (prev == -1 && pref[i] != 0) {
                prev = i;
                sum = pref[i];
            }
        }
        for (int i = prev; i < 10000; i++) {
            if (sum != pref[i]) {
                System.out.println("From " + prev + " to " + (i - 1) + ", Stock = " + sum);
                sum = pref[i];
                prev = i;
            }
        }
        if (sum != 0)
            System.out.println("From " + prev + " to present, Stock = " + sum);
    }

    public static void main(String[] args) {
        StockDetails ob = new StockDetails();
        ob.readData();
        Queries ob2 = new Queries();
        ob2.StockRanges(ob.arr);
    }
}