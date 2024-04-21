// package com.sc.sc.service;

// import com.opencsv.CSVParser;
// import com.opencsv.CSVReader;
// import com.opencsv.CSVReaderBuilder;
// import com.opencsv.exceptions.CsvValidationException;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.multipart.MultipartFile;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.Reader;
// import java.time.LocalDate;
// import java.util.List;

// import com.sc.sc.repository.*;
// import com.sc.sc.model.Status;


// import com.sc.sc.model.Orders;
// import com.sc.sc.model.User;
// import com.sc.sc.model.Product;
// @Service
// public class OrderService {

//     @Autowired
//     private OrdersRepository ordersRepository;

//     public void processOrdersFromCSV(MultipartFile file) throws IOException, CsvException{
//         CSVParser parser = new CSVParser();
//         try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
//              CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build()) {
//             List<String[]> records = csvReader.readAll();
//             for (String[] record : records) {
//                 Long productId = Long.parseLong(record[0]);
//                 Long userId = Long.parseLong(record[1]);
//                 Status status = Status.valueOf(record[2]);
//                 LocalDate expectedDeliveryDate = LocalDate.parse(record[3]);
//                 LocalDate orderedDate = LocalDate.parse(record[4]);

//                 Product product = new Product(productId);
//                 User user = new User(userId);

//                 // Create Order object and save to the database
//                 Orders order = new Orders(product, user, status, expectedDeliveryDate, orderedDate);
//                 ordersRepository.save(order);
//             }
//         } catch (CsvValidationException e) {
//             throw new IOException("Error processing CSV file: " + e.getMessage());
//         }
//     }
// }
