/*
package configuration;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Component
public class Hosts {

   // protected static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Hosts.class);

    private static String plcUKSite;
    private static String plcUSSite;
    private static String plcGlobalSite;
    private static String plcCaSite;
    private static String plcDel;
    private static String plcEdi;
    private static String plcProdDel;
    private static String plcProdEdi;

    private static String westlawBase;
    private static String westlawPrefix;
    private static String westlawLabs;

    private static String cobaltBase;
    private static String cobaltDomain;

    private static String cdiUrl;

    private static Properties runProps;
    private static File baseUserDir = new File(System.getProperty("user.dir"));
    private static File iRunConfigFile = new File(baseUserDir + "/AutoTests/src/test/resources/runConfig.properties");
    private static File mRunConfigFile = new File(baseUserDir + "/src/test/resources/runConfig.properties");

    static {
        loadRunConfigProps();
        setUpEnvironments();
    }

    public String getPlcProdDel() {
        return plcProdDel;
    }

    public String getPlcProdEdi() {
        return plcProdEdi;
    }

    public String getPlcUKSite() {
        return plcUKSite;
    }

    public String getPlcUSSite() {
        return plcUSSite;
    }

    public String getPlcGlobalSite() {
        return plcGlobalSite;
    }

    public String getPlcCanadaSite() {
        return plcCaSite;
    }

    public String getPlcDel() {
        return plcDel;
    }

    public String getPlcEdi() {
        return plcEdi;
    }

    public String getWestlawBase() {
        return westlawBase;
    }

    public String getWestlawPrefix() {
        return westlawPrefix;
    }

    public String getWestlawLabs() {
        return westlawLabs;
    }

    public String getCobaltBase() {
        return cobaltBase;
    }

    public String getCobaltDomain() {
        return cobaltDomain;
    }

    public String getCdiUrl() {
        return cdiUrl;
    }

    */
/**
     * Calls loadProps() to load the run config properties
     *//*

    public static void loadRunConfigProps() {
        runProps = new Properties();
        try {
            //LOG.info("Loading the properties as proj root /src:");
            loadProps(runProps, mRunConfigFile);
        } catch (IOException e) {
            try {
                //LOG.info("No prop file found, trying load the properties as proj root /src:");
                loadProps(runProps, iRunConfigFile);
            } catch (IOException e1) {
                System.out.println("IOException " + e.getMessage());
            }
        }
    }

    */
/**
     * Loads in the properties file
     *
     * @param props
     * @param file
     * @throws java.io.IOException
     *//*

    public static void loadProps(Properties props, File file) throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            props.load(fis);
        } finally {
            if (null != fis) {
                fis.close();
            }
        }
    }

    */
/**
     * Sets up the following environments from the properties file
     * <p>
     * plc UK site
     * plc USA site
     * plc Global site
     * plc Canada site
     * plc Del site
     * plc Edi site
     * Westlaw base
     * Westlaw prefix
     * cobalt prefix
     * cobalt domain
     * cdi url
     * </p>
     *//*

    public static void setUpEnvironments() {
        System.out.println("SETTING UP THE ENVIRONMENT ");
        plcUKSite = runProps.getProperty("dUK");
        plcUSSite = runProps.getProperty("dUS");
        plcGlobalSite = runProps.getProperty("dGlobal");
        plcCaSite = runProps.getProperty("dCanada");

        plcDel = runProps.getProperty("plcDel");
        plcEdi = runProps.getProperty("plcEdi");
        plcProdDel = runProps.getProperty("plcProdDel");
        plcProdEdi = runProps.getProperty("plcProdEdi");

        westlawBase = runProps.getProperty("westlawBase");
        westlawPrefix = runProps.getProperty("westlawPrefix");

        cobaltBase = runProps.getProperty("cobaltBase");
        cobaltDomain = runProps.getProperty("cobaltDomain");

        cdiUrl = runProps.getProperty("cdiUrl");

        System.out.println("COMPLETED ENVIRONMENT SETUP ");
    }

}
*/
