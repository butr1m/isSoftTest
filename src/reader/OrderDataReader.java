package reader;

import entity.OrderData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OrderDataReader {
    public List<OrderData> readOrderDataToList(Path path) throws IOException {
        List<OrderData> orderDataList = new ArrayList<>();
        List<String> stringList = Files.readAllLines(path);
        for (String line : stringList) {
            String[] words = line.split(",");
            String orderId = words[0];
            String dateTime = words[1];
            OrderData orderData = new OrderData(orderId, dateTime);
            orderDataList.add(orderData);
        }
        return orderDataList;
    }
}
