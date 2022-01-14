package reader;

import entity.ProductData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductsDateReader {
    public List<ProductData> readProductDataToList(Path path) throws IOException {
        List<ProductData> productDataList = new ArrayList<>();
        List<String> stringList = Files.readAllLines(path);
        for (String line : stringList) {
            String[] words = line.split(",");
            String productId = words[0];
            String productName = words[1];
            int pricePerUnit = Integer.parseInt(words[2]);
            ProductData productData = new ProductData(productId, productName, pricePerUnit);
            productDataList.add(productData);
        }
        return productDataList;
    }
}
