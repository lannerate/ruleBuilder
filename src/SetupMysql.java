import com.flagleader.builder.Init;
import com.flagleader.util.Environment;
import com.flagleader.util.filesystem.FileUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class SetupMysql
{
  public static final String a = System.getProperty("line.separator");

  public void a(String paramString)
  {
    try
    {
      Environment localEnvironment = new Environment();
      String str1 = localEnvironment.getProperty("SystemRoot");
      System.out.println("---------- Visual Rules Setup ----------");
      System.out.println("SystemRoot: " + str1);
      System.out.println(" ");
      System.out.print("Setting my.ini ... ");
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0; i < paramString.length(); i++)
      {
        char c = paramString.charAt(i);
        if (c == '\\')
          localStringBuffer.append('/');
        else
          localStringBuffer.append(c);
      }
      File localFile = new File(str1 + "\\" + "my.ini");
      localFile.createNewFile();
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile, false);
      localFileOutputStream.write(("[mysqld]" + a).getBytes());
      localFileOutputStream.write(("basedir=" + localStringBuffer + "/" + a).getBytes());
      localFileOutputStream.write(("datadir=" + localStringBuffer + "/data/" + a).getBytes());
      localFileOutputStream.write(("default-character-set=gbk" + a).getBytes());
      localFileOutputStream.close();
      System.out.print("OK!\n");
      Process localProcess = null;
      BufferedReader localBufferedReader = null;
      System.out.print("Stopping MySql Service ... ");
      localProcess = Runtime.getRuntime().exec("net stop mysql");
      System.out.print("OK!\n");
      localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      String str2 = "";
      while ((str2 = localBufferedReader.readLine()) != null)
        System.out.println(str2);
      System.out.print("Removing MySql Service ... ");
      localProcess = Runtime.getRuntime().exec(paramString + "\\bin\\mysqld --remove");
      System.out.print("OK!\n");
      localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      str2 = "";
      while ((str2 = localBufferedReader.readLine()) != null);
      System.out.print("Installing MySql Service ... ");
      localProcess = Runtime.getRuntime().exec(paramString + "\\bin\\mysqld --install");
      System.out.print("OK!\n");
      localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      str2 = "";
      while ((str2 = localBufferedReader.readLine()) != null);
      System.out.print("Starting MySql Service ... ");
      localProcess = Runtime.getRuntime().exec("net start mysql");
      Init.a();
      System.out.print("OK!\n");
      localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      str2 = "";
      while ((str2 = localBufferedReader.readLine()) != null)
        System.out.println(str2);
      System.out.print("Done! ");
      System.exit(0);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public static void main(String[] paramArrayOfString)
  {
    SetupMysql localSetupMysql = new SetupMysql();
    String str = "";
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      str = str + paramArrayOfString[i];
      if (i == paramArrayOfString.length - 1)
        continue;
      str = str + " ";
    }
    if (str.length() == 0)
      str = FileUtil.getCurrentDir() + File.separator + "mysql";
    localSetupMysql.a(str);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     SetupMysql
 * JD-Core Version:    0.6.0
 */