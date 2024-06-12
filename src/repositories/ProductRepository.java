package repositories;

import models.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static final String PATH = "src/data/Product.csv";

    public List<Product> getAll(){
        List<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] split = line.split(",");
                products.add(new Product(Integer.parseInt(split[0]),split[1],Integer.parseInt(split[2]),Double.parseDouble(split[3]),split[4]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Product findProductById(int id){
        List<Product> products = getAll();
        for (Product p :
                products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
