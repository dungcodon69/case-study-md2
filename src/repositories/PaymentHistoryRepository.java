package repositories;

import models.PaymentHistory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PaymentHistoryRepository {
    private static final String PATH = "src/data/PaymentHistory.csv";

    public void writeFile(PaymentHistory paymentHistory){
        try {
            FileWriter fileWriter = new FileWriter(PATH,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String p  = paymentHistory.toString();
            bufferedWriter.write(paymentHistory.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
