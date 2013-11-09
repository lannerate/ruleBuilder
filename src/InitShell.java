import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class InitShell
{
  public static void main(String[] paramArrayOfString)
  {
    String str1 = ";";
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
      str1 = paramArrayOfString[0];
    String str2 = "";
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 1))
      str2 = paramArrayOfString[1];
    String str3 = "start.bat";
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 2))
      str3 = paramArrayOfString[2];
    StringBuffer localStringBuffer = new StringBuffer("java -Xms40m -Xmx1024m -classpath ./classes");
    localStringBuffer.append(str1);
    File localFile = new File("lib");
    Object localObject;
    if (localFile.exists())
    {
      localObject = localFile.listFiles();
      for (int i = 0; i < localObject.length; i++)
        localStringBuffer.append("./lib/").append(localObject[i].getName()).append(str1);
    }
    localStringBuffer.append(" ").append(str2);
    try
    {
      localObject = new File(str3);
      ((File)localObject).createNewFile();
      FileOutputStream localFileOutputStream = new FileOutputStream((File)localObject, false);
      localFileOutputStream.write(localStringBuffer.toString().getBytes());
      localFileOutputStream.close();
      System.out.print("OK!\n");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     InitShell
 * JD-Core Version:    0.6.0
 */