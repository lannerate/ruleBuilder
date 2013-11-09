package com.flagleader.a.a;

import com.flagleader.engine.RuleService;
import com.flagleader.engine.impl.RuleServletFactory;
import com.flagleader.repository.d.u;
import com.flagleader.sql.DBConfig;
import com.flagleader.util.DateUtil;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.Key;
import com.flagleader.util.PBE;
import com.flagleader.util.filesystem.FileUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public final class r
{
  private static int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private static final int e = 4;
  private static final int f = 8;
  private static final int g = 16;
  private static String h = "";
  private static long i = 0L;
  private static final int j = 76518;
  private static final byte[] k = f("B9D3D59EBC8A7992");
  private static final byte[] l = f("04192CAD73BC3BE5");
  private static final byte[] m = f("01ABB943837E94A2");
  private static String n = "";
  public static String[] a;

  public static void a(String paramString1, String paramString2)
  {
    try
    {
      RuleServletFactory localRuleServletFactory = new RuleServletFactory("http://www.flagleader.com:8080/rules/servlet/readrule.servlet");
      RuleService localRuleService = localRuleServletFactory.getRuleService();
      localRuleService.put("id", paramString1);
      localRuleService.put("comp", paramString2);
      localRuleService.execute("rules.blackids");
      n = localRuleService.getString("blackids");
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static synchronized boolean a(String paramString)
  {
    URL localURL = r.class.getClassLoader().getResource(paramString);
    if (localURL == null)
      return false;
    String str1 = "DES";
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(localURL.openStream());
      byte[] arrayOfByte1 = new byte[a(localURL)];
      localBufferedInputStream.read(arrayOfByte1);
      localBufferedInputStream.close();
      SecureRandom localSecureRandom = new SecureRandom();
      DESKeySpec localDESKeySpec = new DESKeySpec(m);
      SecretKeyFactory localSecretKeyFactory = SecretKeyFactory.getInstance(str1);
      SecretKey localSecretKey = localSecretKeyFactory.generateSecret(localDESKeySpec);
      Cipher localCipher = Cipher.getInstance(str1);
      localCipher.init(2, localSecretKey, localSecureRandom);
      byte[] arrayOfByte2 = localCipher.doFinal(arrayOfByte1);
      String str2 = new String(localCipher.doFinal(Key.getCodeByte(DBConfig.defaultPBE.decrypt(new String(arrayOfByte2, "UTF-8")))), "UTF-8");
      if (str2.startsWith("flagleader rule engine :"))
      {
        a = str2.substring("flagleader rule engine :".length()).split(";");
        if ((!a[6].equals("OEM")) && (!c(a[7])))
        {
          EngineLogger.getEngineLogger().error(u.a("osnotmath.error", new String[] { System.getProperty("os.name"), a[7] }));
          return false;
        }
        if ((a.length > 10) && (a[10] != null) && (a[10].length() > 0))
        {
          if (!a[10].equalsIgnoreCase(j()))
          {
            EngineLogger.getEngineLogger().error("the machine code is not match. this code is " + j());
            return false;
          }
          if (Integer.parseInt(a[8]) * 4 < Runtime.getRuntime().availableProcessors())
          {
            EngineLogger.getEngineLogger().error("the cup number is exceed " + Integer.parseInt(a[8]) * 4);
            return false;
          }
        }
        if (n.indexOf(a[0] + ",") < 0)
        {
          if (DateUtil.yearMonthDay(new Date()) > 20120308)
          {
            if (a[9].equals("unlimited"))
              return true;
            if ((DateUtil.parseDate(a[9], "yyyyMMdd").getTime() > System.currentTimeMillis()) && (DateUtil.parseDate(a[9], "yyyyMMdd").getTime() - System.currentTimeMillis() < 31536000000L))
            {
              EngineLogger.getEngineLogger().warning(u.a("traildate.warn", new String[] { a[9] }));
              return true;
            }
            EngineLogger.getEngineLogger().error(u.a("trailexpired.error"));
          }
        }
        else
          EngineLogger.getEngineLogger().error(u.a("licensecopied.error", new String[] { a[0] }));
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }

  private static boolean c(String paramString)
  {
    String str = System.getProperty("os.name").toLowerCase();
    if (str.equalsIgnoreCase(paramString))
      return true;
    if (str.startsWith("windows"))
    {
      if ((str.indexOf("server") > 0) || (str.indexOf("2003") > 0))
        return paramString.equalsIgnoreCase("Windows 2003");
      return paramString.equalsIgnoreCase("Windows 7");
    }
    return false;
  }

  public static String a()
  {
    return u.a("localSystem.info", new String[] { b(), j() });
  }

  public static String b()
  {
    int i1 = Runtime.getRuntime().availableProcessors() / 4;
    if (i1 == 0)
      return "1";
    return String.valueOf(i1);
  }

  public static String c()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (a != null)
    {
      String str = "";
      if (a[9].equals("unlimited"))
        str = u.a("unlimited.info");
      else
        try
        {
          str = DateFormat.getDateInstance(1).format(DateUtil.parseDate(a[9], "yyyyMMdd"));
        }
        catch (Exception localException1)
        {
          str = a[9];
        }
      if (a.length > 10)
        localStringBuffer.append(u.a("licenseregister.info", new String[] { a[1], a[6], str, a[7], a[8], a[10] })).append(FileUtil.newline);
      else
        localStringBuffer.append(u.a("licenseregister.info", new String[] { a[1], a[6], str, a[7], a[8], j() })).append(FileUtil.newline);
      if ((!a[6].equals("OEM")) && (!c(a[7])))
        localStringBuffer.append(u.a("osnotmath.error", new String[] { System.getProperty("os.name"), a[7] }));
      if ((a.length > 10) && (a[10] != null) && (a[10].length() > 0))
      {
        if (!a[10].equalsIgnoreCase(j()))
          localStringBuffer.append("the machine code is not match. this code is " + j());
        if (Integer.parseInt(a[8]) * 4 < Runtime.getRuntime().availableProcessors())
          localStringBuffer.append("the cup number is exceed " + Integer.parseInt(a[8]) * 4);
      }
      if (n.indexOf(a[0] + ",") < 0)
      {
        if (DateUtil.yearMonthDay(new Date()) > 20120308)
          try
          {
            if ((a[9].equals("unlimited")) || ((DateUtil.parseDate(a[9], "yyyyMMdd").getTime() > System.currentTimeMillis()) && (DateUtil.parseDate(a[9], "yyyyMMdd").getTime() - System.currentTimeMillis() < 31536000000L)))
              break label539;
            localStringBuffer.append(u.a("trailexpired.error"));
          }
          catch (Exception localException2)
          {
          }
      }
      else
        localStringBuffer.append(u.a("licensecopied.error", new String[] { a[0] }));
      label539: return localStringBuffer.toString();
    }
    return u.a("nolicense.error");
  }

  public static long d()
  {
    long l1 = i - new Date().getTime();
    if (l1 < 0L)
      return 0L;
    return a(l1);
  }

  public static boolean e()
  {
    return b <= 2;
  }

  public static boolean f()
  {
    return b == 4;
  }

  public static boolean g()
  {
    return b == 8;
  }

  public static boolean h()
  {
    return b == 16;
  }

  public static final boolean a(String paramString1, File paramFile, String paramString2, String paramString3)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (paramString2 == null) || (paramString2.length() == 0))
      return false;
    String str1;
    try
    {
      str1 = a(FileUtil.readFile(paramFile.getPath()));
    }
    catch (IOException localIOException)
    {
      return false;
    }
    String str2 = paramFile.lastModified();
    str2 = str2.substring(str2.length() - 8);
    if (paramString2.equals(a(paramString1, "", paramString3, m)))
    {
      b = 16;
      h = paramString1;
      return true;
    }
    if (paramString2.equals(b(paramString1, str1 + "-" + str2, paramString3, k)))
    {
      b = 8;
      h = paramString1;
      return true;
    }
    b = 1;
    return false;
  }

  public static final String a(File paramFile)
  {
    String str1 = "";
    try
    {
      str1 = a(FileUtil.readFile(paramFile.getPath()));
    }
    catch (IOException localIOException)
    {
      return "";
    }
    String str2 = paramFile.lastModified();
    str2 = str2.substring(str2.length() - 8);
    return str1 + "-" + str2;
  }

  public static final boolean b(String paramString1, String paramString2)
  {
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, "-", false);
    int i1 = localStringTokenizer.countTokens();
    if (i1 < 4)
    {
      b = 1;
      return false;
    }
    String str1 = localStringTokenizer.nextToken();
    String str2 = localStringTokenizer.nextToken();
    String str3 = localStringTokenizer.nextToken();
    String str4 = localStringTokenizer.nextToken();
    if ((str1.length() <= 0) || (!str1.equals(e(paramString2 + str2 + str3 + str4))))
    {
      b = 1;
      return false;
    }
    String str5 = d(str3);
    String str6 = "";
    String str7 = "";
    for (int i2 = 0; i2 < str2.length(); i2++)
    {
      String str8 = str2.charAt(i2);
      int i4 = Integer.parseInt(str8);
      String str10 = str3.charAt(i4);
      str6 = str6 + str10;
    }
    i2 = Integer.parseInt(str6);
    for (int i3 = 0; i3 < str3.length(); i3++)
    {
      String str9 = i3;
      if (i3 > 9)
      {
        str7 = str7 + str3.charAt(i3);
      }
      else
      {
        if (str2.indexOf(str9) != -1)
          continue;
        str7 = str7 + str3.charAt(i3);
      }
    }
    long l1 = Long.parseLong(str7);
    long l2 = new Date().getTime();
    long l3 = l1 - l2;
    i = l1;
    if (l3 <= 0L)
    {
      if ((i2 == 76518) && (str4.equals(str5)))
        b = 2;
      return true;
    }
    if (l3 > 315360000000L)
    {
      if ((i2 == 76518) && (str4.equals(str5)))
        b = 8;
      return true;
    }
    if ((i2 == 76518) && (str4.equals(str5)))
    {
      b = 4;
      return true;
    }
    b = 1;
    return false;
  }

  private static final int d(String paramString)
  {
    int i1 = 0;
    for (int i2 = 0; i2 < paramString.length(); i2++)
      i1 += paramString.charAt(i2);
    return i1;
  }

  private static final long a(long paramLong)
  {
    long l1 = paramLong;
    long l2 = l1 / 86400000L;
    l1 -= l2 * 3600L * 24L * 1000L;
    return l2;
  }

  private static String a(byte[] paramArrayOfByte)
  {
    long l1 = 0L;
    for (int i1 = 0; i1 < paramArrayOfByte.length; i1++)
    {
      int i2 = paramArrayOfByte[i1];
      l1 += Math.abs(i2);
    }
    return String.valueOf(l1);
  }

  private static String b(byte[] paramArrayOfByte)
  {
    long l1 = 0L;
    long l2 = 0L;
    for (int i1 = 0; i1 < paramArrayOfByte.length; i1++)
    {
      int i2 = paramArrayOfByte[i1];
      if (i1 <= paramArrayOfByte.length / 2)
        l1 += Math.abs(i2);
      else
        l2 += Math.abs(i2);
    }
    return String.valueOf(l1) + String.valueOf(l2);
  }

  public static byte[] b(String paramString)
  {
    String str = "DES";
    try
    {
      SecureRandom localSecureRandom = new SecureRandom();
      DESKeySpec localDESKeySpec = new DESKeySpec(k);
      SecretKeyFactory localSecretKeyFactory = SecretKeyFactory.getInstance(str);
      SecretKey localSecretKey = localSecretKeyFactory.generateSecret(localDESKeySpec);
      Cipher localCipher = Cipher.getInstance(str);
      localCipher.init(1, localSecretKey, localSecureRandom);
      return localCipher.doFinal(paramString.getBytes());
    }
    catch (Exception localException)
    {
    }
    return "".getBytes();
  }

  private static String e(String paramString)
  {
    String str = "DES";
    try
    {
      SecureRandom localSecureRandom = new SecureRandom();
      DESKeySpec localDESKeySpec = new DESKeySpec(l);
      SecretKeyFactory localSecretKeyFactory = SecretKeyFactory.getInstance(str);
      SecretKey localSecretKey = localSecretKeyFactory.generateSecret(localDESKeySpec);
      Cipher localCipher = Cipher.getInstance(str);
      localCipher.init(1, localSecretKey, localSecureRandom);
      return a(localCipher.doFinal(paramString.getBytes()));
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  private static int a(URL paramURL)
  {
    URLConnection localURLConnection = paramURL.openConnection();
    int i1 = localURLConnection.getContentLength();
    localURLConnection.getInputStream().close();
    return i1;
  }

  public static final boolean a(String paramString1, String paramString2, String paramString3)
  {
    URL localURL = r.class.getClassLoader().getResource("rulebuilder.dll");
    if (localURL == null)
      return false;
    String str1;
    try
    {
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(localURL.openStream());
      byte[] arrayOfByte = new byte[a(localURL)];
      localBufferedInputStream.read(arrayOfByte);
      localBufferedInputStream.close();
      str1 = a(arrayOfByte);
    }
    catch (IOException localIOException)
    {
      return false;
    }
    String str2 = "12345678";
    str2 = str2.substring(str2.length() - 8);
    if (paramString2.equals(a(paramString1, "", paramString3, m)))
    {
      b = 16;
      h = paramString1;
      return true;
    }
    if (paramString2.equals(b(paramString1, str1 + "-" + str2, paramString3, k)))
    {
      b = 8;
      h = paramString1;
      return true;
    }
    b = 1;
    return false;
  }

  public static boolean c(String paramString1, String paramString2)
  {
    String str = "DES";
    try
    {
      URL localURL = r.class.getClassLoader().getResource("rulebuilder.dll");
      if (localURL == null)
        return false;
      SecureRandom localSecureRandom = new SecureRandom();
      DESKeySpec localDESKeySpec = new DESKeySpec(m);
      SecretKeyFactory localSecretKeyFactory = SecretKeyFactory.getInstance(str);
      SecretKey localSecretKey = localSecretKeyFactory.generateSecret(localDESKeySpec);
      Cipher localCipher = Cipher.getInstance(str);
      localCipher.init(1, localSecretKey, localSecureRandom);
      byte[] arrayOfByte1 = localCipher.doFinal(("flagleader rule builder" + paramString1 + paramString2).getBytes());
      BufferedInputStream localBufferedInputStream = new BufferedInputStream(localURL.openStream());
      byte[] arrayOfByte2 = new byte[a(localURL)];
      localBufferedInputStream.read(arrayOfByte2);
      localBufferedInputStream.close();
      for (int i1 = 0; i1 < arrayOfByte1.length; i1++)
        if (arrayOfByte1[i1] != arrayOfByte2[i1])
          return false;
      b = 16;
      h = paramString1;
      return true;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private static String a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    String str = "DES";
    try
    {
      SecureRandom localSecureRandom = new SecureRandom();
      DESKeySpec localDESKeySpec = new DESKeySpec(paramArrayOfByte);
      SecretKeyFactory localSecretKeyFactory = SecretKeyFactory.getInstance(str);
      SecretKey localSecretKey = localSecretKeyFactory.generateSecret(localDESKeySpec);
      Cipher localCipher = Cipher.getInstance(str);
      localCipher.init(1, localSecretKey, localSecureRandom);
      return b(localCipher.doFinal((paramString3 + paramString1 + paramString2).getBytes()));
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  private static String b(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    String str = "DES";
    try
    {
      SecureRandom localSecureRandom = new SecureRandom();
      DESKeySpec localDESKeySpec = new DESKeySpec(paramArrayOfByte);
      SecretKeyFactory localSecretKeyFactory = SecretKeyFactory.getInstance(str);
      SecretKey localSecretKey = localSecretKeyFactory.generateSecret(localDESKeySpec);
      Cipher localCipher = Cipher.getInstance(str);
      localCipher.init(1, localSecretKey, localSecureRandom);
      return b(localCipher.doFinal((paramString3 + paramString1 + paramString2).getBytes()));
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  private static byte[] f(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i1 = 0;
    int i2 = 0;
    while (i1 < paramString.length())
      arrayOfByte[(i2++)] = new Integer(a(paramString.charAt(i1++)) * 16 | a(paramString.charAt(i1++))).byteValue();
    return arrayOfByte;
  }

  private static byte a(char paramChar)
  {
    switch (paramChar)
    {
    case '0':
      return 0;
    case '1':
      return 1;
    case '2':
      return 2;
    case '3':
      return 3;
    case '4':
      return 4;
    case '5':
      return 5;
    case '6':
      return 6;
    case '7':
      return 7;
    case '8':
      return 8;
    case '9':
      return 9;
    case 'A':
      return 10;
    case 'B':
      return 11;
    case 'C':
      return 12;
    case 'D':
      return 13;
    case 'E':
      return 14;
    case 'F':
      return 15;
    case ':':
    case ';':
    case '<':
    case '=':
    case '>':
    case '?':
    case '@':
    }
    return 0;
  }

  public static String i()
  {
    return h;
  }

  public static String j()
  {
    int i1 = 0;
    try
    {
      if ((InetAddress.getLocalHost() != null) && (InetAddress.getLocalHost().getAddress() != null))
        for (int i2 = 0; i2 < InetAddress.getLocalHost().getAddress().length; i2++)
          i1 += i1 * 31 + a(InetAddress.getLocalHost().getAddress()[i2]);
    }
    catch (UnknownHostException localUnknownHostException)
    {
      i1 = System.getProperty("user.name").hashCode();
    }
    return String.valueOf(i1);
  }

  private static int a(byte paramByte)
  {
    if (paramByte < 0)
      return 256 + paramByte;
    return paramByte;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.a.a.r
 * JD-Core Version:    0.6.0
 */