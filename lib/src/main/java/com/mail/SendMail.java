package com.mail;

import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;

import org.apache.log4j.BasicConfigurator;

/**
 * Method to send a email at a certain interval of time by randomly picking (to
 * email , subject text , body text) from the given xls files .
 *
 * @author Vaibhav Jain
 * @Oranization - LPTPL
 */

public class SendMail {

    /**
     * API Key of Spark post used to send email
     * <p>
     * Spark Post Credentials --
     * <p>
     * UserName -- vaibhav.jain@techbirds.in Password -- vaibhav@123
     */

    final static String API_KEY = "c185fd3e9d88b9cbf13c33f9234fd2666e3045d6";

    // time Interval after which want to sent mail again in milli seconds
    final long timeInterval = 3 * 60 * 1000;

    AppData appDataObject;
    mailData mailDataObject;
    String message = "";


    public static void main(String[] args) throws SparkPostException {

        BasicConfigurator.configure();
        Client sparky = new Client(API_KEY);
        DbConnecton connectWithDB = new DbConnecton();
        ReadExcel readExcel = new ReadExcel();


        new SendMail().sendEmail(sparky, connectWithDB, readExcel
        );

//        try {
//            ReadExcel DT = new ReadExcel();
//            DT.readExcel();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    private void sendEmail(Client sparky, DbConnecton connectWithDB,
                           ReadExcel readExcel) {
        try {
            Runnable runnable = new Runnable() {

                public void run() {
                    while (true) {
                        try {

                            appDataObject = connectWithDB.getAppDetails();
                            mailDataObject = readExcel.getMailDetails();

                            if (mailDataObject != null && mailDataObject.getMessage() != null &&
                                    mailDataObject.getSubject() != null &&
                                    appDataObject != null && appDataObject.getAppName() != null
                                    && appDataObject.getEmail() != null) {

                                if (mailDataObject.getMessage().contains("000000"))
                                    message = mailDataObject.getMessage().replaceAll("000000", appDataObject.getAppName());
                                else
                                    message = mailDataObject.getMessage();
                                // Method to send email

                                if (!message.equals("") && !mailDataObject.getSubject().equals("")
                                        && !appDataObject.getEmail().equals("")) {


                                    sparky.sendMessage("business@lptpl.com",      // from  email
                                            appDataObject.getEmail()
                                            ,             // to email
                                            mailDataObject.getSubject(), // subject of email
                                            message,          //
                                            // text of email
                                            "<html><body>" +

                                                    "<p>" + message
                                                    + "</p>"

                                                    + "</body></html>");                                // Html text of email body


                                    System.out.println("Successfully Sent");
                                    connectWithDB.UpdateEntriesInDB(appDataObject.getId(), System.currentTimeMillis() + "");

                                }
                            }

                        } catch (SparkPostException e) {
                            e.printStackTrace();

                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                // Sleep the thread for that much time
                                Thread.sleep(timeInterval);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            };

            // Create a thread
            Thread sendMailThread = new Thread(runnable);

            // Start thread
            sendMailThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}