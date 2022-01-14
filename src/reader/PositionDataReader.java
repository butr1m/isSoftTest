package reader;

import entity.PositionData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PositionDataReader {
    public List<PositionData> readPositionDataToList(Path path) throws IOException {
        List<PositionData> positionDataList = new ArrayList<>();
        List<String> stringList = Files.readAllLines(path);
        for (String line : stringList) {
            String[] words = line.split(",");
            String orderId = words[0];
            String productId = words[1];
            int quantity = Integer.parseInt(words[2]);
            PositionData positionData = new PositionData(orderId, productId, quantity);
            positionDataList.add(positionData);
        }
        return positionDataList;
    }

}
