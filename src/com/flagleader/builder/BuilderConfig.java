package com.flagleader.builder;

import com.flagleader.database.ConnectionFactory;
import com.flagleader.util.filesystem.FileUtil;
import com.flagleader.util.filesystem.StreamUtil;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.apache.commons.lang.SystemUtils;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

public class BuilderConfig
{
  private static BuilderConfig a = null;
  private static final String b = "builder.conf";
  private File c = null;
  private String d = "Tahoma";
  private int e = 11;
  private int f = 0;
  private Font g = null;
  private boolean h = true;
  private long i = 60L;
  private String j = "";
  private String k = "";
  private String l = "";
  private int m = 80;
  private String n = "tomcat/logs/stdout.log";
  private String o = "";
  private String p = FileUtil.getCurrentDir();
  private String q = "";
  private String r = "";
  private boolean s = false;
  private boolean t = true;
  private boolean u = true;
  private long v = 60L;
  private String w = "email.flagleader.com";
  private String x = "tech@flagleader.com";
  private String y = "qizheng123";
  private String z = "tech@flagleader.com";
  private String A = "Visual Rules Solution";
  private String B = "sale@flagleader.com";
  private String C = "sale";

  private BuilderConfig()
  {
    if ((BuilderConfig.class.getClassLoader() != null) && (BuilderConfig.class.getClassLoader().getResource("engine.conf") != null) && (new File(BuilderConfig.class.getClassLoader().getResource("engine.conf").getPath()).getParentFile() != null) && (new File(BuilderConfig.class.getClassLoader().getResource("engine.conf").getPath()).getParentFile().getName().equalsIgnoreCase("classes")))
      this.p = new File(BuilderConfig.class.getClassLoader().getResource("engine.conf").getPath()).getParentFile().getParent();
    else
      this.p = FileUtil.getCurrentDir();
    this.q = (this.p + File.separator + "samples");
    a();
  }

  public static BuilderConfig getInstance()
  {
    if (a == null)
      a = new BuilderConfig();
    return a;
  }

  private void a()
  {
    Properties localProperties = null;
    try
    {
      localProperties = new Properties();
      File localFile = new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "builder.conf");
      if (localFile.exists())
      {
        localProperties.load(new FileInputStream(localFile));
        this.c = localFile;
      }
      else if (BuilderConfig.class.getClassLoader().getResource("builder.conf") != null)
      {
        localProperties.load(BuilderConfig.class.getClassLoader().getResourceAsStream("builder.conf"));
        this.c = localFile;
        localFile.getParentFile().mkdirs();
      }
      this.h = new Boolean(localProperties.getProperty("autosave", "true")).booleanValue();
      setAutosaveTime(Long.parseLong(localProperties.getProperty("autosaveTime", "60")));
      setDemoKey(localProperties.getProperty("demoKey", this.j));
      this.k = localProperties.getProperty("userName", this.k);
      this.l = localProperties.getProperty("licenseKey", this.l);
      this.q = localProperties.getProperty("projPath", this.q);
      this.s = new Boolean(localProperties.getProperty("firstLogin", "false")).booleanValue();
      this.t = new Boolean(localProperties.getProperty("loadDefault", "true")).booleanValue();
      this.w = localProperties.getProperty("emailServer", this.w);
      this.x = localProperties.getProperty("emailUser", this.x);
      this.y = ConnectionFactory.decrypt(localProperties.getProperty("emailPasswd", "3rJHpofQIy/Tv/y2l8OShKEZ8a3alNI/ZndukVoup8A="));
      this.z = localProperties.getProperty("emailAuthor", this.z);
      this.A = localProperties.getProperty("emailAuthorName", this.A);
      this.B = localProperties.getProperty("emailTo", this.B);
      this.C = localProperties.getProperty("emailToName", this.C);
      this.n = localProperties.getProperty("tomcatLogFile", this.n);
      this.r = localProperties.getProperty("updateUrl", this.r);
      this.d = localProperties.getProperty("fontname", this.d);
      this.e = Integer.parseInt(localProperties.getProperty("fontheight", String.valueOf(this.e)));
      this.f = Integer.parseInt(localProperties.getProperty("fontstyle", String.valueOf(this.f)));
      this.g = new Font(null, this.d, this.e, this.f);
      this.m = Integer.parseInt(localProperties.getProperty("compositeBuffer", "80"));
      this.u = new Boolean(localProperties.getProperty("autoCheckVersion", "true")).booleanValue();
      setAutoCheckVersionTime(Long.parseLong(localProperties.getProperty("autoCheckVersionTime", "60")));
      if (this.m > 100)
        this.m = 100;
      if (this.m < 20)
        this.m = 20;
    }
    catch (Exception localException)
    {
    }
  }

  public void save()
  {
    Properties localProperties = null;
    try
    {
      localProperties = new Properties();
      if (this.c == null)
        this.c = new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "builder.conf");
      if (!this.c.exists())
        this.c.createNewFile();
      localProperties.setProperty("autosave", new Boolean(this.h).toString());
      localProperties.setProperty("userName", this.k);
      localProperties.setProperty("licenseKey", this.l);
      localProperties.setProperty("demoKey", this.j);
      localProperties.setProperty("autosaveTime", new Long(this.i).toString());
      localProperties.setProperty("tomcatLogFile", this.n);
      localProperties.setProperty("projPath", this.q);
      localProperties.setProperty("updateUrl", this.r);
      localProperties.setProperty("emailServer", this.w);
      localProperties.setProperty("emailUser", this.x);
      localProperties.setProperty("emailPasswd", ConnectionFactory.encrypt(this.y));
      localProperties.setProperty("emailAuthor", this.z);
      localProperties.setProperty("emailAuthorName", this.A);
      localProperties.setProperty("emailTo", this.B);
      localProperties.setProperty("emailToName", this.C);
      localProperties.setProperty("firstLogin", new Boolean(this.s).toString());
      localProperties.setProperty("loadDefault", new Boolean(this.t).toString());
      localProperties.setProperty("autoCheckVersion", new Boolean(this.u).toString());
      localProperties.setProperty("autoCheckVersionTime", new Long(this.v).toString());
      localProperties.setProperty("compositeBuffer", this.m);
      localProperties.setProperty("fontname", this.g.getFontData()[0].getName());
      localProperties.setProperty("fontheight", String.valueOf(this.g.getFontData()[0].getHeight()));
      localProperties.setProperty("fontstyle", String.valueOf(this.g.getFontData()[0].getStyle()));
      localProperties.store(new FileOutputStream(this.c), "Business Rule Builder Config File");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void setAutosaveTime(long paramLong)
  {
    this.i = paramLong;
  }

  public boolean isAutosave()
  {
    return this.h;
  }

  public long getAutosaveTime()
  {
    return this.i;
  }

  public void setAutosave(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }

  public String getDemoKey()
  {
    return this.j;
  }

  public String getLicenseKey()
  {
    return this.l;
  }

  public String getUserName()
  {
    return this.k;
  }

  public void setDemoKey(String paramString)
  {
    this.j = paramString;
  }

  public void setLicenseKey(String paramString)
  {
    this.l = paramString;
  }

  public void setUserName(String paramString)
  {
    this.k = paramString;
  }

  public int getCompositeBuffer()
  {
    return this.m;
  }

  public void setCompositeBuffer(int paramInt)
  {
    this.m = paramInt;
  }

  public String getTempPath()
  {
    if (this.o.length() == 0)
    {
      if (new File(this.p + File.separator + "temp").exists())
        return this.p + File.separator + "temp";
      try
      {
        File localFile = new File(SystemUtils.JAVA_IO_TMPDIR, "dimages.jar");
        StreamUtil.pump(BuilderConfig.class.getClassLoader().getResource("dimages.jar").openStream(), new FileOutputStream(localFile));
        jarExtracting(SystemUtils.JAVA_IO_TMPDIR, localFile.getPath());
        setTempPath(SystemUtils.JAVA_IO_TMPDIR);
      }
      catch (Exception localException)
      {
        return SystemUtils.JAVA_IO_TMPDIR;
      }
    }
    return this.o;
  }

  public static void jarExtracting(String paramString1, String paramString2)
  {
    int i1 = 2048;
    BufferedOutputStream localBufferedOutputStream = null;
    BufferedInputStream localBufferedInputStream = null;
    JarEntry localJarEntry = null;
    JarFile localJarFile = null;
    Enumeration localEnumeration = null;
    try
    {
      localJarFile = new JarFile(paramString2);
      localEnumeration = localJarFile.entries();
      while (localEnumeration.hasMoreElements())
      {
        localJarEntry = (JarEntry)localEnumeration.nextElement();
        if (localJarEntry.isDirectory())
        {
          new File(paramString1 + localJarEntry.getName()).mkdirs();
        }
        else
        {
          localBufferedInputStream = new BufferedInputStream(localJarFile.getInputStream(localJarEntry));
          byte[] arrayOfByte = new byte[i1];
          FileOutputStream localFileOutputStream = new FileOutputStream(paramString1 + localJarEntry.getName());
          localBufferedOutputStream = new BufferedOutputStream(localFileOutputStream, i1);
          int i2;
          while ((i2 = localBufferedInputStream.read(arrayOfByte, 0, i1)) != -1)
            localBufferedOutputStream.write(arrayOfByte, 0, i2);
          localBufferedOutputStream.flush();
          localBufferedOutputStream.close();
          localBufferedInputStream.close();
        }
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      try
      {
        if (localBufferedOutputStream != null)
        {
          localBufferedOutputStream.flush();
          localBufferedOutputStream.close();
        }
        if (localBufferedInputStream != null)
          localBufferedInputStream.close();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
    finally
    {
      try
      {
        if (localBufferedOutputStream != null)
        {
          localBufferedOutputStream.flush();
          localBufferedOutputStream.close();
        }
        if (localBufferedInputStream != null)
          localBufferedInputStream.close();
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
      }
    }
  }

  public String getTomcatLogFile()
  {
    return this.n;
  }

  public void setTomcatLogFile(String paramString)
  {
    this.n = paramString;
  }

  public Font getTextFont()
  {
    return this.g;
  }

  public void setTextFont(Font paramFont)
  {
    this.g = paramFont;
    save();
  }

  public String getProjPath()
  {
    return this.q;
  }

  public void setProjPath(String paramString)
  {
    this.q = paramString;
  }

  public void setTempPath(String paramString)
  {
    this.o = paramString;
  }

  public boolean isFirstLogin()
  {
    return this.s;
  }

  public void setFirstLogin(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  public boolean isLoadDefault()
  {
    return this.t;
  }

  public void setLoadDefault(boolean paramBoolean)
  {
    this.t = paramBoolean;
  }

  public String getUpdateUrl()
  {
    return this.r;
  }

  public void setUpdateUrl(String paramString)
  {
    this.r = paramString;
  }

  public boolean isAutoCheckVersion()
  {
    return this.u;
  }

  public void setAutoCheckVersion(boolean paramBoolean)
  {
    this.u = paramBoolean;
  }

  public long getAutoCheckVersionTime()
  {
    return this.v;
  }

  public void setAutoCheckVersionTime(long paramLong)
  {
    this.v = paramLong;
  }

  public String getEmailServer()
  {
    return this.w;
  }

  public void setEmailServer(String paramString)
  {
    this.w = paramString;
  }

  public String getEmailUser()
  {
    return this.x;
  }

  public void setEmailUser(String paramString)
  {
    this.x = paramString;
  }

  public String getEmailPasswd()
  {
    return this.y;
  }

  public void setEmailPasswd(String paramString)
  {
    this.y = paramString;
  }

  public String getEmailAuthor()
  {
    return this.z;
  }

  public void setEmailAuthor(String paramString)
  {
    this.z = paramString;
  }

  public String getEmailAuthorName()
  {
    return this.A;
  }

  public void setEmailAuthorName(String paramString)
  {
    this.A = paramString;
  }

  public String getEmailTo()
  {
    return this.B;
  }

  public void setEmailTo(String paramString)
  {
    this.B = paramString;
  }

  public String getEmailToName()
  {
    return this.C;
  }

  public void setEmailToName(String paramString)
  {
    this.C = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.BuilderConfig
 * JD-Core Version:    0.6.0
 */