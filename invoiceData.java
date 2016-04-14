import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
	
/**
	 * This is a collection of utility methods that define a general API for
	 * interacting with the database supporting this application.
	 *
	 */

public class invoiceData {
	
	private static org.apache.log4j.Logger log = Logger.getLogger(DBObjectsParser.class);
	private static Connection conn = DatabaseConnection.getConnection();

		/**
		 * Method that removes every person record from the database
		 */
	
		public static void removeAllPersons() {
			
	 		try {
	 			String query = "ALTER TABLE customers DROP FOREIGN KEY customers_ibfk_2;"+
	 						   "ALTER TABLE products DROP FOREIGN KEY products_ibfk_1;"+
	 						   "ALTER TABLE invoices DROP FOREIGN KEY invoices_ibfk_2;"+  
	 						   "ALTER TABLE persons DROP FOREIGN KEY persons_ibfk_1;"+
	 						   "ALTER TABLE emails DROP FOREIGN KEY emails_ibfk_1;"+
	 						   "SET SQL_SAFE_UPDATES = 0;"+
							   "DELETE FROM persons;"+
						       "DELETE FROM emails;"+
 							   "SET SQL_SAFE_UPDATES = 1;";
	 		
	 			PreparedStatement ps = null;
	 			ps = conn.prepareStatement(query);
	 			
		 	}catch(SQLException e){	
		 		log.error("SQLException: ", e);
				throw new RuntimeException(e);
		 	}
		}

		/**
		 * Removes the person record from the database corresponding to the
		 * provided <code>personCode</code>
		 * @param personCode
		 */
		
		public static void removePerson(String personCode) {}
		
		/**
		 * INSERT INTO table_name (column1,column2,column3,...)
		 * VALUES (value1,value2,value3,...);
		 * 
		 * Method to add a person record to the database with the provided data. 
		 * @param personCode
		 * @param firstName
		 * @param lastName
		 * @param street
		 * @param city
		 * @param state
		 * @param zip
		 * @param country
		 */
		public static void addPerson(String personCode, String firstName, String lastName, 
				String street, String city, String state, String zip, String country) {
		}
		
		/**
		 * Adds an email record corresponding person record corresponding to the
		 * provided <code>personCode</code>
		 * @param personCode
		 * @param email
		 */
		public static void addEmail(String personCode, String email) {
		}
		
		/**
		 * Method that removes every customer record from the database
		 */
		public static void removeAllCustomers() {
		}

		public static void addCustomer(String customerCode, String type, String primaryContactPersonCode, String name, 
				String street, String city, String state, String zip, String country) {
		}

		/**
		 * Removes all product records from the database
		 */
		public static void removeAllProducts() {}

		/**
		 * Removes a particular product record from the database corresponding to the
		 * provided <code>productCode</code>
		 * @param assetCode
		 */
		public static void removeProduct(String productCode) {}

		/**
		 * Adds an equipment record to the database with the
		 * provided data.  
		 */
		public static void addEquipment(String productCode, String name, Double pricePerUnit) {}
		
		/**
		 * Adds an license record to the database with the
		 * provided data.  
		 */
		public static void addLicense(String productCode, String name, double serviceFee, double annualFee) {}

		/**
		 * Adds an consultation record to the database with the
		 * provided data.  
		 */
		public static void addConsultation(String productCode, String name, String consultantPersonCode, Double hourlyFee) {}
		
		/**
		 * Removes all invoice records from the database
		 */
		public static void removeAllInvoices() {}
		
		/**
		 * Removes the invoice record from the database corresponding to the
		 * provided <code>invoiceCode</code>
		 * @param invoiceCode
		 */
		public static void removeInvoice(String invoiceCode) {}
		
		/**
		 * Adds an invoice record to the database with the given data.  
		 */
		public static void addInvoice(String invoiceCode, String customerCode, String salesPersonCode) {}
		
		/**
		 * Adds a particular equipment (corresponding to <code>productCode</code> to an 
		 * invoice corresponding to the provided <code>invoiceCode</code> with the given
		 * number of units
		 */
		public static void addEquipmentToInvoice(String invoiceCode, String productCode, int numUnits) {}
		
		/**
		 * Adds a particular equipment (corresponding to <code>productCode</code> to an 
		 * invoice corresponding to the provided <code>invoiceCode</code> with the given
		 * begin/end dates
		 */
		public static void addLicenseToInvoice(String invoiceCode, String productCode, String startDate, String endDate) {}

		/**
		 * Adds a particular equipment (corresponding to <code>productCode</code> to an 
		 * invoice corresponding to the provided <code>invoiceCode</code> with the given
		 * number of billable hours.
		 */
		public static void addConsultationToInvoice(String invoiceCode, String productCode, double numHours) {}
	}