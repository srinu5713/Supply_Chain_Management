import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import com.sc.sc.repository.OrdersRepository;
import com.sc.sc.model.Status;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVParser;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import com.sc.sc.model.Orders;
import com.sc.sc.model.Product;
import com.sc.sc.model.User;


@Service
public class OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    public void processOrdersFromCSV(MultipartFile file) throws IOException {
        // Parse the CSV file and save orders to the database
        CSVParser parser = new CSVParser();
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build()) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                // Assuming CSV format: orderId,productId,userId,status,expectedDeliveryDate,orderedDate
                Long orderId = Long.parseLong(record[0]);
                Long productId = Long.parseLong(record[1]);
                Long userId = Long.parseLong(record[2]);
                Status status = Status.valueOf(record[3]);
                LocalDate expectedDeliveryDate = LocalDate.parse(record[4]);
                LocalDate orderedDate = LocalDate.parse(record[5]);

                // Create Order object and save to the database
                Order order = new Order();
                order.setOrderId(orderId);
                order.setProduct(new Product(productId));
                order.setUser(new User(userId));
                order.setStatus(status);
                order.setExpectedDeliveryDate(expectedDeliveryDate);
                order.setOrderedDate(orderedDate);

                ordersRepository.save(order);
            }
        } catch (CsvValidationException e) {
            e.printStackTrace(); // Handle CSV validation error
            throw new IOException("Error processing CSV file");
        }
    }
}
