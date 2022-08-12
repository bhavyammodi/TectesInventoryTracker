import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class dateObj {
    Date a, b;
    int stock;
    SimpleDateFormat sdf;

    dateObj() throws ParseException {
        sdf = new SimpleDateFormat("yyyy/MM/dd");
        a = sdf.parse("3000/12/31");
        b = sdf.parse("3000/12/31");
        stock = 0;
    }

    dateObj(String a, String b, int stock) throws ParseException {
        sdf = new SimpleDateFormat("yyyy/MM/dd");
        this.a = sdf.parse(a);
        this.b = sdf.parse(b);
        this.stock = stock;
    }
}
