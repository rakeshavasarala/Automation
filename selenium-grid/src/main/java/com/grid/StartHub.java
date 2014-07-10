package com.grid;

import org.openqa.grid.internal.utils.GridHubConfiguration;
import org.openqa.grid.web.Hub;

/**
 * For some reason myHub.stop() does not seem to stop the hub.
 * It just hangs, no logs nothing.
 */
public class StartHub {

    public static void main(String[] args) throws Exception {


        String[] hubConfigArgs = {"-hubConfig", "/home/dev/rakesh/Automation/selenium-grid/src/main/resources/hubConfig.json"};

        GridHubConfiguration gridHubConfig = GridHubConfiguration.build(hubConfigArgs);
        Hub myHub = new Hub(gridHubConfig);
        myHub.start();

        Thread.sleep(10000);

         System.out.println(myHub.getHost());
         System.out.println(myHub.getPort());
         System.out.println(myHub.getUrl());
         System.out.println(myHub.getRegistrationURL());


        Thread.sleep(10000);

        myHub.stop();


    }


}
