import java.text.ParseException;
import java.util.*;

public class dateWisePartitions extends dateObj {

    dateWisePartitions(String a, String b, int stock) throws ParseException {
        super(a, b, stock);
    }

    class separateDates {
        Date a;
        int index;
        boolean isStart;
        int stock;

        separateDates(Date a, int index, boolean isStart, int stock) {
            this.a = a;
            this.index = index;
            this.isStart = isStart;
            this.stock = stock;
        }
    }

    class res {
        Date a, b;
        int stock;
        Set<Integer> indices;

        res(Date a, Date b, int stock, Set<Integer> indices) {
            this.a = a;
            this.b = b;
            this.stock = stock;
            this.indices = indices;
        }
    }

    void separator(List<dateObj> dates) {
        List<separateDates> sep = new ArrayList<separateDates>();
        for (int index = 0; index < dates.size(); index++) {
            separateDates temp = new separateDates(dates.get(index).a, index, true, dates.get(index).stock);
            sep.add(temp);
            temp = new separateDates(dates.get(index).b, index, false, dates.get(index).stock);
            sep.add(temp);
        }
// // Checking purposes
//        for (int index = 0; index < sep.size(); index++) {
//            System.out.println("a = " + sdf.format(sep.get(index).a) + " isStart = " + sep.get(index).isStart + " index = " + sep.get(index).index);
//        }
        sep.sort((o1, o2) -> {
            if (o1.a.after(o2.a))
                return 1;
            else if (o1.a.equals(o2.a) && o1.isStart == true)
                return 1;
            else
                return -1;

        });
// // Checking purposes
//        System.out.println("After sorting\n");
//        for (int index = 0; index < sep.size(); index++) {
//            System.out.println("a = " + sdf.format(sep.get(index).a) + " isStart = " + sep.get(index).isStart + " index = " + sep.get(index).index);
//        }
        Date prev = null;
        int sum = 0;
        List<res> result = new ArrayList<res>();
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < sep.size(); i++) {
            if (prev == null) {
                prev = sep.get(i).a;
                s.add(sep.get(i).index);
                sum = sep.get(i).stock;
            } else {
                if (prev.equals(sep.get(i).a) == false) {
                    result.add(new res(prev, sep.get(i).a, sum, s));
                    prev = sep.get(i).a;
                }
                if (sep.get(i).isStart == true) {
                    sum += sep.get(i).stock;
                    s.add(i);
                } else {
                    sum -= sep.get(i).stock;
                    s.remove(i);
                }
            }
        }
        for(int i = 0; i < result.size(); i++)
        {
            System.out.println("From " + sdf.format(result.get(i).a) + " to " + sdf.format(result.get(i).b) + ", Stock = "+ result.get(i).stock);
        }
    }

    public static void main(String args[]) throws ParseException {
        List<dateObj> dates = new ArrayList<dateObj>();
        dates.add(new dateObj("2022/01/01", "2022/01/03", 5));
        dates.add(new dateObj("2022/01/01", "2022/01/05", 10));
        dates.add(new dateObj("2022/01/03", "2022/01/05", 7));
        dates.add(new dateObj("2022/01/02", "2022/01/04", 6));
        dateWisePartitions ob = new dateWisePartitions("3000/01/01", "3000/01/05", 0);
        ob.separator(dates);
    }
}
