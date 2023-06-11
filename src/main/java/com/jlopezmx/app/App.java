package com.jlopezmx.app;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class App 
{
    
    /**
     *
     */
    static Logger logger = LoggerFactory.getLogger(App.class);
    
    /**
     *
     */
    final static String DESTINATION_FILE_PATH = "page.html";
    
    /**
     *
     */
    final static String SOURCE_TEMPLATE_FILE = "template.vm";
    /**
     *
     */
    static BufferedWriter writer;
    
    /**
     *
     */
    private static final Properties properties = new Properties();
    
    /**
     *
     */
    private static VelocityEngine engine;
    
    /**
     *
     */
    private static Template template;
    
    /**
     *
     */
    private static VelocityContext context;
    
    /**
     *
     * @param args
     */
    public static void main( String[] args )
    {
        try {
    
            // buffer for destination file after parsing complete
            writer = new BufferedWriter(new FileWriter(DESTINATION_FILE_PATH));
            
            // the velocity engine
            engine = new VelocityEngine(engineProperties());
    
            // the raw template file
            template = engine.getTemplate(SOURCE_TEMPLATE_FILE);
    
            // the variables for raw template
            context = configureTemplateVariables();
            
            // the process: merge variables and template: assign result to a file
            template.merge( context , writer);
            
            // write destination file
            writer.flush();
            
            // close writer and bye..
            writer.close();
    
            logger.info("completed: verify your file: {}", DESTINATION_FILE_PATH);
            logger.info("good bye now...");
        }catch (Exception e){

            logger.error(e.toString());
        }
    }
    
    /**
     *
     * @return VelocityContext ctx
     */
    private static VelocityContext configureTemplateVariables() {
    
        logger.info("configuring variables for template");
        
        VelocityContext cxt = new VelocityContext();
        
        cxt.put("adminName", "jlopez.mx");
        cxt.put("applicationName", "ENGINEERING SOFTWARE TRAINING PROGRAM");
        cxt.put("purchaseDate", "2022/07/09");
        cxt.put("expiryDate", "2023/07/09");
        cxt.put("creditOrderNumber", "0000123456");
        cxt.put("numberOfUnusedCreditsExpired", "14");
        
        return cxt;
    }
    /**
     *
     * @return Properties properties
     */
    private static Properties engineProperties(){
    
        logger.info("configuring engine properties");
        
        properties.setProperty("resource.loaders", "class");
        properties.setProperty(
            "resource.loader.class.class",
            "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        
        return properties;
    }
}
