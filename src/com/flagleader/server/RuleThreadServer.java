package com.flagleader.server;

import com.flagleader.engine.MessageUtil;
import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.util.EncryptTransfer;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.filesystem.FileUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RuleThreadServer
{
  public static boolean a = false;
  public static ServerSocket b;
  public static File c = new File(FileUtil.getCurrentDir(), "rulethreads.xml");
  public static RuleThreadInfos d;
  static String[] e = null;
  public static j f;
  static b g = null;

  public static void a()
  {
    if (c.exists())
      try
      {
        d = (RuleThreadInfos)new q().load(c);
        if (d.getAcceptIPs().length() > 0)
        {
          e = d.getAcceptIPs().split(";");
          return;
        }
        e = null;
      }
      catch (Exception localException)
      {
        LogFactory.getLog("ruleengine").error(localException.getMessage(), localException);
        d = new RuleThreadInfos();
      }
    else
      d = new RuleThreadInfos();
  }

  public static void b()
  {
    try
    {
      Socket localSocket = new Socket(InetAddress.getByName("127.0.0.1"), d.getPort());
      PrintWriter localPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(localSocket.getOutputStream())), true);
      if (d.getStreamtype() == 0)
      {
        localPrintWriter.println("SHUTDOWNALL");
        localPrintWriter.println("END");
      }
      else
      {
        if (d.getStreamtype() == 2)
          localPrintWriter.println(EncryptTransfer.zip("SHUTDOWNALL"));
        else
          localPrintWriter.println(EncryptTransfer.encryptZip("SHUTDOWNALL"));
        localPrintWriter.println("END");
      }
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
      ConsoleHandler localConsoleHandler = new ConsoleHandler();
      localConsoleHandler.setFormatter(new c());
      localConsoleHandler.setLevel(Level.ALL);
      Logger.getLogger("ruleengine").addHandler(localConsoleHandler);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public static void d()
  {
    if (d.isAutoupdate())
    {
      g = new b();
      g.start();
    }
  }

  public static void e()
  {
    try
    {
      if (com.flagleader.a.a.r.a("ruleengine.rlc"))
        Property.getInstance().setEngineImplement("com.flagleader.engine.impl.SingleRuleEngineFactory");
      else
        Property.getInstance().setEngineImplement("com.flagleader.engine.impl.TestRuleEngineFactory");
      RuleEngineFactory.newInstance();
      b = new ServerSocket(d.getPort());
    }
    catch (IOException localIOException1)
    {
      throw localIOException1;
    }
    EngineLogger.getSqlLogger().info(MessageUtil.getString("ruleserverthreadstart.text", "Rule Server Thread Started"));
    try
    {
      while (!a)
      {
        Socket localSocket = b.accept();
        try
        {
          if (b(localSocket.getInetAddress().getHostAddress()))
          {
            if (d.getStreamtype() == 0)
              new r(localSocket, localSocket.getInetAddress().getHostAddress());
            else
              new s(localSocket, localSocket.getInetAddress().getHostAddress());
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
      f();
    }
  }

  public static void main(String[] paramArrayOfString)
  {
    if ((paramArrayOfString.length == 0) || (!paramArrayOfString[0].equalsIgnoreCase("showlog")))
      c();
    try
    {
      a();
    }
    catch (Exception localException)
    {
      LogFactory.getLog("ruleengine").error(localException.getMessage(), localException);
      return;
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0) && (paramArrayOfString[0].equals("stop")))
    {
      b();
      return;
    }
    d();
    try
    {
      e();
    }
    catch (IOException localIOException)
    {
      LogFactory.getLog("ruleengine").error(localIOException.getMessage(), localIOException);
      return;
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

  public static void f()
  {
    d.stopAll();
    a = true;
    if (g != null)
      g.a = true;
    try
    {
      if (b != null)
        b.close();
    }
    catch (Exception localException)
    {
      LogFactory.getLog("ruleengine").error(localException.getMessage(), localException);
    }
    EngineLogger.getSqlLogger().info(MessageUtil.getString("ruleserverthreadstop.text", "Rule Server Thread Stoped"));
  }

  public static j g()
  {
    return f;
  }

  public static void a(j paramj)
  {
    f = paramj;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.server.RuleThreadServer
 * JD-Core Version:    0.6.0
 */