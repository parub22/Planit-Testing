package au.com.planittesting.challenge7;

import java.io.FileReader;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

/**
 * This class reads CSV file with headings
 *
 * @author Parbati Budhathoki
 * @Created On May 7, 2022 2:20:54 PM
 */
public class CSVDataReader {

    static final String CSV_FILENAME = "data.csv";  //csv file name

    public static void main(String[] args) {
        try ( ICsvBeanReader beanReader
                = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE)) {
            // the header elements are used to map the values to the bean
            final String[] headers = beanReader.getHeader(true);

            //Sets up the processors
            final CellProcessor[] processors = new CellProcessor[]{
                new NotNull(new ParseInt()), // CustomerId
                new NotNull(), // CustomerName
                new NotNull(), // Country
                new NotNull() // Email
            };
            //print the header at the first line
            for (String header : headers) {
                System.out.print(header + " \t");
            }
            System.out.println("");

            Customer customer;
            while ((customer = beanReader.read(Customer.class, headers, processors)) != null) {
                System.out.println(customer);
            }
        } catch (Exception e) {
            System.out.println("Error in CSV reader: " + e.getMessage());
        }

    }

}
