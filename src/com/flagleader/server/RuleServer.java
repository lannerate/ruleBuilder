package com.flagleader.server;

import com.flagleader.a.a.r;
import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.sql.DBCPPool;
import com.flagleader.util.EncryptTransfer;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RuleServer
{
  public static boolean a = false;
  public static ServerSocket b;
  public static b c;
  public static i d;
  static String[] e = null;

  static
  {
    if (ServerProperty.a().c().length() > 0)
      e = ServerProperty.a().c().split(";");
    else
      e = null;
  }

  public static void a()
  {
    try
    {
      if (r.a("ruleengine.rlc"))
        Property.getInstance().setEngineImplement("com.flagleader.engine.impl.SingleRuleEngineFactory");
      else
        Property.getInstance().setEngineImplement("com.flagleader.engine.impl.TestRuleEngineFactory");
      RuleEngineFactory.newInstance();
      a = false;
      b = new ServerSocket(ServerProperty.a().d());
    }
    catch (IOException localIOException1)
    {
      throw localIOException1;
    }
    EngineLogger.getSqlLogger().info(MessageUtil.format("ruleserverstart.text", new String[] { ServerProperty.a().d() }));
    try
    {
      while (!a)
      {
        Socket localSocket = b.accept();
        try
        {
          if (b(localSocket.getInetAddress().getHostAddress()))
          {
            if (ServerProperty.a().e() == 0)
              new o(localSocket, localSocket.getInetAddress().getHostAddress());
            else if (ServerProperty.a().e() == 3)
              new l(localSocket, localSocket.getInetAddress().getHostAddress());
            else if (ServerProperty.a().e() == 4)
              new f(localSocket, localSocket.getInetAddress().getHostAddress());
            else
              new t(localSocket, localSocket.getInetAddress().getHostAddress());
          }
          else
            localSocket.close();
        }
        catch (IOException localIOException2)
        {
          localSocket.close();
        }
      }
    }
    catch (Exception localException)
    {
    }
    finally
    {
      e();
    }
  }

  public static void b()
  {
    try
    {
      Socket localSocket = new Socket(InetAddress.getByName("127.0.0.1"), ServerProperty.a().d());
      PrintWriter localPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(localSocket.getOutputStream())), true);
      if (ServerProperty.a().e() == 0)
      {
        localPrintWriter.println("SHUTDOWNALL");
        localPrintWriter.println("END");
      }
      else
      {
        if (ServerProperty.a().e() == 2)
          localPrintWriter.println(EncryptTransfer.zip("SHUTDOWNALL"));
        else
          localPrintWriter.println(EncryptTransfer.encryptZip("SHUTDOWNALL"));
        localPrintWriter.println("END");
      }
      localSocket.getInputStream().read();
      localSocket.close();
    }
    catch (Exception localException)
    {
      LogFactory.getLog("ruleengine").error(localException.getMessage(), localException);
    }
  }

  public static void c()
  {
    try
    {
      File localFile = new File(FileUtil.getCurrentDir() + File.separator + "logs", "serverlog.txt");
      if (!localFile.getParentFile().exists())
        localFile.getParentFile().mkdirs();
      if (!localFile.exists())
        localFile.createNewFile();
      else if (localFile.length() > 0L)
        try
        {
          FileUtil.copy(localFile, new File(FileUtil.getCurrentDir() + File.separator + "logs" + File.separator + "logs", "server" + g() + ".txt"), true);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
      System.setErr(new PrintStream(new FileOutputStream(localFile)));
      ConsoleHandler localConsoleHandler = new ConsoleHandler();
      localConsoleHandler.setFormatter(new c());
      localConsoleHandler.setLevel(Level.ALL);
      Logger.getLogger("ruleengine").addHandler(localConsoleHandler);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
  }

  public static void main(String[] paramArrayOfString)
  {
    if ((paramArrayOfString.length == 0) || (!paramArrayOfString[0].equalsIgnoreCase("showlog")))
      c();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0].equals("stop")))
    {
      b();
      return;
    }
    d();
    try
    {
      a();
    }
    catch (IOException localIOException)
    {
      LogFactory.getLog("ruleengine").error(localIOException.getMessage(), localIOException);
      return;
    }
  }

  public static void d()
  {
    if (ServerProperty.a().j() == 1)
    {
      c = new b();
      c.start();
    }
  }

  private static String a(String paramString)
  {
    if (new File(FileUtil.getCurrentDir(), paramString).exists())
      return new File(FileUtil.getCurrentDir(), paramString).getAbsolutePath();
    if ((Property.getInstance().getRuleEngineClassDir().length() > 0) && (new File(new File(Property.getInstance().getRuleEngineClassDir()).getParent(), paramString).exists()))
      return new File(new File(Property.getInstance().getRuleEngineClassDir()).getParent(), paramString).getAbsolutePath();
    return paramString;
  }

  private static boolean b(String paramString)
  {
    if ((e != null) && (e.length > 0))
    {
      for (int i = 0; i < e.length; i++)
        if (e[i].equalsIgnoreCase(paramString))
          return true;
      return false;
    }
    return true;
  }

  private static int g()
  {
    File localFile = new File(FileUtil.getCurrentDir() + File.separator + "logs", "logs");
    int i = 0;
    if ((localFile.exists()) && (localFile.isDirectory()))
    {
      String[] arrayOfString = localFile.list();
      for (int j = 0; j < arrayOfString.length; j++)
      {
        if ((!arrayOfString[j].startsWith("server")) || (!arrayOfString[j].endsWith(".txt")))
          continue;
        String str = arrayOfString[j].substring(6, arrayOfString[j].length() - 4);
        if ((str == null) || (!NumberUtil.isParsedDouble(str)))
          continue;
        int k = NumberUtil.getInt(str);
        if (i >= k)
          continue;
        i = k;
      }
    }
    else
    {
      localFile.mkdirs();
    }
    return i + 1;
  }

  public static void e()
  {
    a = true;
    if (c != null)
      c.a = true;
    try
    {
      if (b != null)
        b.close();
    }
    catch (Exception localException)
    {
      LogFactory.getLog("ruleengine").error(localException.getMessage(), localException);
    }
    b = null;
    EngineLogger.getSqlLogger().info(MessageUtil.getString("ruleserverstop.text", "Rule Server Stoped"));
    DBCPPool.getInstance().disposeAll();
  }

  public static i f()
  {
    return d;
  }

  public static void a(i parami)
  {
    d = parami;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.RuleServer
 * JD-Core Version:    0.6.0
 */