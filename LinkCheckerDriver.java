import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class LinkCheckerDriver
{
    static ArrayList<String> report = new ArrayList<String>();
    static String base;

    static void generateReport() throws Exception
    {
        write("\n--------------------------");
        write("LINKS NEEDS YOUR ATTENTION:");
        write("--------------------------\n");
        for (String link : report)
        {
            write(link);
        }
        write("\n--------------------------");
        write("\tEND OF REPORT");
        write("--------------------------");
    } // end of generateReport

    //**********************************************

    static String getReasonCode(int code)
    {
        String reason;

        switch (code)
        {
        case 200:
            reason = "ON";
            break;
        case 301:
            reason = "ON - Redirecting"; //Moved Permanently
            break;
        case 302:
            reason = "ON - Redirecting"; //"Found";
            break;
        case 400:
            reason = "Bad Request";
            break;
        case 403:
            reason = "Forbidden";
            break;
        case 404:
            reason = "Not Found";
            break;
        case 408:
            reason = "Request Timeout";
            break;
        case 500:
            reason = "Internal Server Error";
            break;
        case 502:
            reason = "Bad Gateway";
            break;
        case 504:
            reason = "Gateway Timeout";
            break;
        case 505:
            reason = "HTTP Version Not Supported";
            break;
        default:
            reason = "Error, Reason code-" + code;
        }// end of switch
        return reason;
    } // end of getReasonCode

    //**********************************************

    static String getResponseCode(String urlString) throws MalformedURLException, IOException
    {
        String status;

        urlString = urlString.charAt(0) == '/' ? base + urlString : urlString;
        //        if (urlString.indexOf("http://") < 0 && urlString.indexOf("https://") < 0)
        //        {
        //            urlString = urlString.charAt(0) == '/' ? base + urlString : base + "/" + urlString;
        //        }

        try
        {
            URL u = new URL(urlString);
            HttpURLConnection huc = (HttpURLConnection) u.openConnection();
            huc.setRequestMethod("GET");
            huc.connect();
            status = getReasonCode(huc.getResponseCode());
        } catch (Exception err)
        {
            status = "Error - ";
        }
        if (!status.equals("ON") && !status.equals("ON - Redirecting"))
        {
            report.add(urlString);
        }
        return status;
    } // end of getResponse

    //**********************************************

    public static void main(String[] args) throws Exception
    {
        Scanner stdIn = new Scanner(System.in);
        write("Please enter a full link to check: ");
        String linkToCheck = stdIn.next();
        write("Checking the following link: " + linkToCheck);
        base = linkToCheck.substring(0, linkToCheck.indexOf("/", linkToCheck.indexOf(".")));
        System.out.println("base=\"" + base + "\"");

        write("\nStatus | Links");
        write("-----------------------------------------");

        URL url = new URL(linkToCheck);
        Reader reader = new InputStreamReader((InputStream) url.getContent());
        new ParserDelegator().parse(reader, new LinkPage(), true);
        generateReport();
    } // end of main

    //**********************************************

    static void write(String content) throws IOException
    {
        System.out.println(content);
        File file = new File("C:\\Data\\link_status_report.txt");

        if (!file.exists())
        {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content + "\n");
        bw.close();
    } // end of write
} // end of Driver Class

//**********************************************

class LinkPage extends HTMLEditorKit.ParserCallback
{
    @Override
    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos)
    {
        String link;
        if (t == HTML.Tag.A)
        {
            link = a.getAttribute(HTML.Attribute.HREF).toString();

            if (link.indexOf("javascript:") == -1 && (link.indexOf("http://") > -1 || link.indexOf("https://") > -1))
            {
                try
                {
                    Driver.write(Driver.getResponseCode(link) + "     | " + link);
                } catch (Exception e)
                {
                    try
                    {
                        Driver.write("I can't find this link: " + link);
                    } catch (IOException e1)
                    {
                        e1.printStackTrace();
                    }
                }
            }
        }
    } // end of handleStartTag
} // end of LinkPage class
