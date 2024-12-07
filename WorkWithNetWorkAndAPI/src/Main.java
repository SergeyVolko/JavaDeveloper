import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        NetUtils netUtils = new NetUtils();
        List<Stock> stocks = netUtils.getStocks();
        stocks.sort((o1, o2) -> Float.compare(o1.getValue(), o2.getValue()));
        System.out.printf("The cheapest one was on %s with value %f\n", stocks.get(0).getDate(),
                stocks.get(0).getValue());
        System.out.printf("The most expansive one was on %s with value %f\n",
                stocks.get(stocks.size() - 1).getDate(),
                stocks.get(stocks.size() - 1).getValue());
    }
}
