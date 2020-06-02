package com.codingforfun.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openxava.util.PropertiesReader;
import org.openxava.util.XavaResources;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

public class InvoicingPreferences {
    private final static String FILE_PROPERTIES = "invoicing.properties";
    private static Log log = LogFactory.getLog(InvoicingPreferences.class);
    private static Properties properties;  // store the properties here;

    private static Properties getProperties() {
        if(properties == null ) {  // lazy initialization
            PropertiesReader reader = new PropertiesReader(InvoicingPreferences.class, FILE_PROPERTIES);
            try {
                properties = reader.get();
            }catch (IOException e) {
                log.error(XavaResources.getString("properties_file_error", FILE_PROPERTIES), e);
                properties = new Properties();
            }

        }

        return properties;
    }

    public static BigDecimal getDefaultVatPercentage() {   //The only public method
        return new BigDecimal(getProperties().getProperty("defaultVatPercentage"));

    }

}
