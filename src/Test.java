import entity.OrderData;
import entity.PositionData;
import entity.ProductData;
import reader.OrderDataReader;
import reader.PositionDataReader;
import reader.ProductsDateReader;

import java.io.IOException;

import java.nio.file.Path;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Есть 3 списка: в ORDERS хранятся ID заказа и дата заказа
 *                в ORDER_ITEMS хранятся ID заказа, ID продукта и количество единиц товара
 *                в PRODUCTS хранятся ID продукта, имя продукта и цена за единицу товара
 *                Вывести  самый продаваемый продук за указанный день
 */

public class Test {
    public static void main(String[] args) throws IOException, ParseException {

        String date = "2021-01-10";

        Path pathOrder = Path.of("resources", "orders.csv");
        Path pathProducts = Path.of("resources", "products.csv");
        Path pathItems = Path.of("resources", "order_items.csv");

        OrderDataReader orderDataReader = new OrderDataReader();
        List<OrderData> orderDataList = orderDataReader.readOrderDataToList(pathOrder);

        ProductsDateReader productsDateReader = new ProductsDateReader();
        List<ProductData> productDataList = productsDateReader.readProductDataToList(pathProducts);

        PositionDataReader positionDataReader = new PositionDataReader();
        List<PositionData> positionDataList = positionDataReader.readPositionDataToList(pathItems);


        HashMap<String, Integer> top5 = showTop5(date, orderDataList, positionDataList, productDataList);
        for (Map.Entry<String, Integer> entry : top5.entrySet()) {
            String productName = entry.getKey();
            int productCost = entry.getValue();
            System.out.println(productName + " : " + productCost);
        }
    }

    public static HashMap<String, Integer> showTop5(String date, List<OrderData> orderDataList, List<PositionData> positionDataList, List<ProductData> productDataList) {
        HashMap<String, Integer> bestOfDay = new HashMap<>();

        for (OrderData orderList : orderDataList) {
            String orderDate = orderList.getOrderDate();
            String dateConvert = orderDate.substring(0, 10);
            if (dateConvert.equals(date)) {
                for (PositionData positionList : positionDataList) {
                    if (orderList.getOrderId().equals(positionList.getOrderId())) {
                        for (ProductData productList : productDataList) {
                            int costOfObject = 0;
                            if (positionList.getProductId().equals(productList.getProductId())) {
                                costOfObject = positionList.getQuantity() * productList.getPricePerUnit();
                                bestOfDay.put(productList.getProductName(), costOfObject);
                            }

                        }
                    }
                }
            }
        }
        Map<String, Integer> top5 = bestOfDay.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(1)
                .collect(Collectors.toMap(key -> key.getKey(), value -> value.getValue()));
        return (HashMap<String, Integer>) top5;
    }
}
































