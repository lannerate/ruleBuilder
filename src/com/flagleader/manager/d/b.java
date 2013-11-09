package com.flagleader.manager.d;

import com.flagleader.database.ConnectionFactory;
import com.flagleader.engine.Property;
import com.flagleader.export.PagePropertyPool;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.RuleRepository;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Properties;
import org.apache.commons.lang.SystemUtils;

public class b
{
  private static b b = null;
  private static final String c = "rulebuilder.conf";
  private File d = null;
  private boolean e = true;
  private boolean f = true;
  private String g = "";
  private String h = "Tomcat\\webapps\\ROOT";
  private String i = "Tomcat\\webapps\\ROOT\\WEB-INF\\classes";
  private String j = "yyyy-MM-dd";
  private String k = "yyyy-MM-dd HH:mm:ss";
  private String l = "HH:mm:ss";
  private String m = "rsp";
  private String n = "com.mysql.jdbc.Driver";
  private String o = "jdbc:mysql://localhost/rules";
  private String p = "rules";
  private String q = "rules";
  private String r = "http://localhost:8880/";
  private String s = "127.0.0.1";
  private String t = "anonymous";
  private String u = "anonymous";
  private String v = "/WEB-INF/classes/";
  private String w = "/";
  private String x = "/WEB-INF/rules/";
  private String y = SystemUtils.USER_NAME;
  private String z = "123456";
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  public String a = FileUtil.getCurrentDir();
  private String D = "";
  private boolean E = false;
  private boolean F = false;
  private boolean G = true;
  private String H = "";
  private boolean I = true;
  private RuleRepository J = null;

  private b()
  {
    if ((b.class.getClassLoader().getResource("engine.conf") != null) && (new File(b.class.getClassLoader().getResource("engine.conf").getPath()).getParentFile() != null) && (new File(b.class.getClassLoader().getResource("engine.conf").getPath()).getParentFile().getName().equalsIgnoreCase("classes")))
      this.a = new File(b.class.getClassLoader().getResource("engine.conf").getPath()).getParentFile().getParent();
    else
      this.a = FileUtil.getCurrentDir();
    this.D = this.a;
    J();
  }

  public static b a(IRuleRepository paramIRuleRepository)
  {
    if (b == null)
    {
      b = new b();
      if ((paramIRuleRepository != null) && ((paramIRuleRepository instanceof RuleRepository)))
        b.a((RuleRepository)paramIRuleRepository);
    }
    if (b == null)
      b = new b();
    return b;
  }

  public static b a()
  {
    return a(null);
  }

  private void J()
  {
    Properties localProperties = null;
    try
    {
      localProperties = new Properties();
      File localFile = new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "rulebuilder.conf");
      if (localFile.exists())
      {
        localProperties.load(new FileInputStream(localFile));
        this.d = localFile;
      }
      else if (b.class.getClassLoader().getResource("rulebuilder.conf") != null)
      {
        localProperties.load(b.class.getClassLoader().getResourceAsStream("rulebuilder.conf"));
        this.d = localFile;
        localFile.getParentFile().mkdirs();
      }
      a(new Boolean(localProperties.getProperty("autoCompile", "false")).booleanValue());
      b(new Boolean(localProperties.getProperty("autoExportPage", "false")).booleanValue());
      a(localProperties.getProperty("classDir", this.g));
      b(localProperties.getProperty("exportPagePath", this.h));
      c(localProperties.getProperty("exportExeRulePath", this.i));
      this.j = localProperties.getProperty("dateFormat", this.j);
      this.k = localProperties.getProperty("datetimeFormat", this.k);
      this.m = localProperties.getProperty("rspRoot", this.m);
      this.l = localProperties.getProperty("timeFormat", this.l);
      this.n = localProperties.getProperty("driver", this.n);
      this.o = localProperties.getProperty("url", this.o);
      this.p = localProperties.getProperty("uid", this.p);
      this.q = ConnectionFactory.decrypt(localProperties.getProperty("passwd", "Xs9UzDAgGfLhcJn2WMXwew=="));
      this.r = localProperties.getProperty("jspRoot", this.r);
      this.s = localProperties.getProperty("ftpServer", this.s);
      this.t = localProperties.getProperty("ftpUser", this.t);
      this.u = ConnectionFactory.decrypt(localProperties.getProperty("ftpPasswd", "Xs9UzDAgGfLhcJn2WMXwew=="));
      this.v = localProperties.getProperty("ftpRscPath", this.v);
      this.w = localProperties.getProperty("ftpJspPath", this.w);
      this.x = localProperties.getProperty("ftpRulesPath", this.x);
      this.y = localProperties.getProperty("userRuleServer", this.y);
      this.z = ConnectionFactory.decrypt(localProperties.getProperty("passwdRuleServer", "Xs9UzDAgGfLhcJn2WMXwew=="));
      c(new Boolean(localProperties.getProperty("autoFtpExe", "false")).booleanValue());
      d(new Boolean(localProperties.getProperty("autoFtpPage", "false")).booleanValue());
      e(new Boolean(localProperties.getProperty("autoFtpRules", "false")).booleanValue());
      h(new Boolean(localProperties.getProperty("logtrace", "true")).booleanValue());
      this.H = localProperties.getProperty("ruleServiceUrl", this.H);
      this.D = localProperties.getProperty("dbsPath", this.D);
      f(new Boolean(localProperties.getProperty("autoCheck", "true")).booleanValue());
      g(new Boolean(localProperties.getProperty("showVarname", "true")).booleanValue());
    }
    catch (Exception localException)
    {
    }
  }

  public void b()
  {
    Properties localProperties = null;
    try
    {
      if ((this.J != null) && (this.J.getRepFile() != null))
      {
        this.J.selfSave();
      }
      else
      {
        localProperties = new Properties();
        if (this.d == null)
          this.d = new File(SystemUtils.USER_HOME + File.separator + ".visualrules", "rulebuilder.conf");
        if (!this.d.exists())
          this.d.createNewFile();
        localProperties.setProperty("autoCompile", new Boolean(this.e).toString());
        localProperties.setProperty("autoExportPage", new Boolean(this.f).toString());
        localProperties.setProperty("classDir", this.g);
        localProperties.setProperty("exportPagePath", this.h);
        localProperties.setProperty("exportExeRulePath", this.i);
        localProperties.setProperty("dateFormat", this.j);
        localProperties.setProperty("datetimeFormat", this.k);
        localProperties.setProperty("rspRoot", this.m);
        localProperties.setProperty("timeFormat", this.l);
        localProperties.setProperty("driver", this.n);
        localProperties.setProperty("url", this.o);
        localProperties.setProperty("uid", this.p);
        localProperties.setProperty("passwd", ConnectionFactory.encrypt(this.q));
        localProperties.setProperty("jspRoot", this.r);
        localProperties.setProperty("ftpServer", this.s);
        localProperties.setProperty("ftpUser", this.t);
        localProperties.setProperty("ftpPasswd", ConnectionFactory.encrypt(this.u));
        localProperties.setProperty("ftpRscPath", this.v);
        localProperties.setProperty("ftpJspPath", this.w);
        localProperties.setProperty("ftpRulesPath", this.x);
        localProperties.setProperty("userRuleServer", this.y);
        localProperties.setProperty("passwdRuleServer", ConnectionFactory.encrypt(this.z));
        localProperties.setProperty("autoFtpExe", new Boolean(this.A).toString());
        localProperties.setProperty("autoFtpPage", new Boolean(this.B).toString());
        localProperties.setProperty("autoFtpRules", new Boolean(this.C).toString());
        if (this.D == null)
          this.D = "";
        localProperties.setProperty("dbsPath", this.D);
        localProperties.setProperty("autoCheck", new Boolean(this.E).toString());
        localProperties.setProperty("showVarname", new Boolean(this.G).toString());
        localProperties.setProperty("logtrace", String.valueOf(this.F));
        localProperties.setProperty("ruleServiceUrl", this.H);
        localProperties.store(new FileOutputStream(this.d), "Business Rule Builder Config File");
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void a(String paramString)
  {
    this.g = paramString;
    if (this.J != null)
      this.J.setClassDir(this.g);
    Property.getInstance().setDynamicClassDir(this.g);
  }

  public void b(String paramString)
  {
    if (paramString.indexOf(this.a) < 0)
      this.h = paramString;
    else
      this.h = paramString.substring(this.a.length() + 1);
    if (this.J != null)
      this.J.setExportPagePath(this.h);
  }

  public void c(String paramString)
  {
    if (paramString.indexOf(this.a) < 0)
      this.i = paramString;
    else
      this.i = paramString.substring(this.a.length() + 1);
    if (this.J != null)
      this.J.setExportExeRulePath(this.i);
  }

  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (this.J != null)
      this.J.setAutoCompile(this.e);
  }

  public String c()
  {
    if (this.J != null)
      return this.J.getClassDir();
    return this.g;
  }

  public String d()
  {
    if (this.J != null)
      return this.J.getExportPagePath();
    return this.h;
  }

  public String e()
  {
    if (new File(this.a, d()).exists())
      return new File(this.a, d()).getAbsolutePath();
    if ((d() == null) || (d().length() == 0))
      return SystemUtils.JAVA_IO_TMPDIR;
    return d();
  }

  public String f()
  {
    if (this.J != null)
      return this.J.getExportExeRulePath();
    return this.i;
  }

  public boolean g()
  {
    if (this.J != null)
      return this.J.isAutoCompile();
    return this.e;
  }

  public String h()
  {
    if (this.J != null)
      return this.J.getDateFormat();
    return this.j;
  }

  public String i()
  {
    if (this.J != null)
      return this.J.getDatetimeFormat();
    return this.k;
  }

  public String j()
  {
    if (this.J != null)
      return this.J.getTimeFormat();
    return this.l;
  }

  public String k()
  {
    if (this.J != null)
      return this.J.getDriver();
    return this.n;
  }

  public String l()
  {
    if (this.J != null)
      return this.J.getRspRoot();
    return this.m;
  }

  public void d(String paramString)
  {
    this.n = paramString;
    if (this.J != null)
      this.J.setDriver(paramString);
  }

  public String m()
  {
    if (this.J != null)
      return this.J.getPasswd();
    return this.q;
  }

  public void e(String paramString)
  {
    this.q = paramString;
    if (this.J != null)
      this.J.setPasswd(ConnectionFactory.encrypt(paramString));
  }

  public String n()
  {
    if (this.J != null)
      return this.J.getUid();
    return this.p;
  }

  public void f(String paramString)
  {
    this.p = paramString;
    if (this.J != null)
      this.J.setUid(paramString);
  }

  public String o()
  {
    if (this.J != null)
      return this.J.getUrl();
    return this.o;
  }

  public void g(String paramString)
  {
    this.o = paramString;
    if (this.J != null)
      this.J.setUrl(paramString);
  }

  public String p()
  {
    if (this.J != null)
      return this.J.getJspRoot();
    return this.r;
  }

  public boolean q()
  {
    if (this.J != null)
      return this.J.isAutoExportPage();
    return this.f;
  }

  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (this.J != null)
      this.J.setAutoExportPage(paramBoolean);
  }

  public void h(String paramString)
  {
    this.j = paramString;
    if (this.J != null)
      this.J.setDateFormat(paramString);
  }

  public void i(String paramString)
  {
    this.k = paramString;
    if (this.J != null)
      this.J.setDatetimeFormat(paramString);
  }

  public void j(String paramString)
  {
    this.r = paramString;
    if (this.J != null)
      this.J.setJspRoot(paramString);
  }

  public void k(String paramString)
  {
    this.l = paramString;
    if (this.J != null)
      this.J.setTimeFormat(paramString);
  }

  public void l(String paramString)
  {
    this.m = paramString;
    if (this.J != null)
      this.J.setRspRoot(paramString);
    PagePropertyPool.setRSPDIR(paramString);
  }

  public String r()
  {
    if (this.J != null)
      return this.J.getFtpJspPath();
    return this.w;
  }

  public void m(String paramString)
  {
    this.w = paramString;
    if (this.J != null)
      this.J.setFtpJspPath(paramString);
  }

  public String s()
  {
    if (this.J != null)
      return this.J.getFtpPasswd();
    return this.u;
  }

  public void n(String paramString)
  {
    this.u = paramString;
    if (this.J != null)
      this.J.setFtpPasswd(ConnectionFactory.encrypt(paramString));
  }

  public String t()
  {
    if (this.J != null)
      return this.J.getFtpRscPath();
    return this.v;
  }

  public void o(String paramString)
  {
    this.v = paramString;
    if (this.J != null)
      this.J.setFtpRscPath(paramString);
  }

  public String u()
  {
    if (this.J != null)
      return this.J.getFtpServer();
    return this.s;
  }

  public void p(String paramString)
  {
    this.s = paramString;
    if (this.J != null)
      this.J.setFtpServer(paramString);
  }

  public String v()
  {
    if (this.J != null)
      return this.J.getFtpUser();
    return this.t;
  }

  public void q(String paramString)
  {
    this.t = paramString;
    if (this.J != null)
      this.J.setFtpUser(paramString);
  }

  public String w()
  {
    if (this.J != null)
      return this.J.getPasswdRuleServer();
    return this.z;
  }

  public void r(String paramString)
  {
    this.z = paramString;
    if (this.J != null)
      this.J.setPasswdRuleServer(ConnectionFactory.encrypt(paramString));
  }

  public String x()
  {
    if (this.J != null)
      return this.J.getUserRuleServer();
    return this.y;
  }

  public String y()
  {
    if ((x() == null) || (x().length() == 0) || (x().equals("develop")))
      return K();
    return x();
  }

  public void s(String paramString)
  {
    this.y = paramString;
    if (this.J != null)
      this.J.setUserRuleServer(paramString);
  }

  private static String K()
  {
    String str = "";
    try
    {
      for (int i1 = 0; i1 < InetAddress.getLocalHost().getAddress().length; i1++)
      {
        if (i1 > 0)
          str = str + ".";
        str = str + InetAddress.getLocalHost().getAddress()[i1];
      }
    }
    catch (UnknownHostException localUnknownHostException)
    {
      return SystemUtils.USER_NAME;
    }
    return str;
  }

  public boolean z()
  {
    if (this.J != null)
      return this.J.isAutoFtpExe();
    return this.A;
  }

  public void c(boolean paramBoolean)
  {
    this.A = paramBoolean;
    if (this.J != null)
      this.J.setAutoFtpExe(paramBoolean);
  }

  public boolean A()
  {
    if (this.J != null)
      return this.J.isAutoFtpPage();
    return this.B;
  }

  public void d(boolean paramBoolean)
  {
    this.B = paramBoolean;
    if (this.J != null)
      this.J.setAutoFtpPage(paramBoolean);
  }

  public String B()
  {
    if (this.J != null)
      return this.J.getDbsPath();
    return this.D;
  }

  public void t(String paramString)
  {
    this.D = paramString;
    if (this.J != null)
      this.J.setDbsPath(paramString);
  }

  public String C()
  {
    if (this.J != null)
      return this.J.getFtpRulesPath();
    return this.x;
  }

  public void u(String paramString)
  {
    this.x = paramString;
    if (this.J != null)
      this.J.setFtpRulesPath(paramString);
  }

  public boolean D()
  {
    if (this.J != null)
      return this.J.isAutoFtpRules();
    return this.C;
  }

  public void e(boolean paramBoolean)
  {
    this.C = paramBoolean;
    if (this.J != null)
      this.J.setAutoFtpRules(paramBoolean);
  }

  public boolean E()
  {
    if (this.J != null)
      return this.J.isAutoCheck();
    return this.E;
  }

  public void f(boolean paramBoolean)
  {
    this.E = paramBoolean;
    if (this.J != null)
      this.J.setAutoCheck(paramBoolean);
  }

  public boolean F()
  {
    if (this.J != null)
      return this.J.isShowVarname();
    return this.G;
  }

  public void g(boolean paramBoolean)
  {
    this.G = paramBoolean;
    if (this.J != null)
      this.J.setShowVarname(paramBoolean);
  }

  public void a(RuleRepository paramRuleRepository)
  {
    if (paramRuleRepository != null)
    {
      if ((paramRuleRepository.getRepFile() == null) || (!paramRuleRepository.getRepFile().exists()))
      {
        paramRuleRepository.setAutoCompile(this.e);
        paramRuleRepository.setAutoExportPage(this.f);
        paramRuleRepository.setAutoFtpExe(this.A);
        paramRuleRepository.setAutoFtpPage(this.B);
        paramRuleRepository.setAutoFtpRules(this.C);
        paramRuleRepository.setClassDir(this.g);
        paramRuleRepository.setDateFormat(this.j);
        paramRuleRepository.setDatetimeFormat(this.k);
        paramRuleRepository.setDbsPath(this.D);
        paramRuleRepository.setDriver(this.n);
        paramRuleRepository.setExportExeRulePath(this.i);
        paramRuleRepository.setExportPagePath(this.h);
        paramRuleRepository.setFtpJspPath(this.w);
        paramRuleRepository.setFtpPasswd(this.u);
        paramRuleRepository.setFtpRscPath(this.v);
        paramRuleRepository.setFtpRulesPath(this.x);
        paramRuleRepository.setFtpRulesPath(this.x);
        paramRuleRepository.setFtpServer(this.s);
        paramRuleRepository.setFtpUser(this.t);
        paramRuleRepository.setJspRoot(this.r);
        paramRuleRepository.setRspRoot(this.m);
        paramRuleRepository.setTimeFormat(this.l);
        paramRuleRepository.setUid(this.p);
        paramRuleRepository.setUrl(this.o);
        paramRuleRepository.setUserRuleServer(this.y);
        paramRuleRepository.setAutoCheck(this.E);
        paramRuleRepository.setLogtrace(this.F);
        paramRuleRepository.setShowVarname(this.G);
        paramRuleRepository.setRuleServiceUrl(this.H);
      }
      else
      {
        this.e = paramRuleRepository.isAutoCompile();
        this.f = paramRuleRepository.isAutoExportPage();
        this.A = paramRuleRepository.isAutoFtpExe();
        this.B = paramRuleRepository.isAutoFtpPage();
        this.C = paramRuleRepository.isAutoFtpRules();
        this.g = paramRuleRepository.getClassDir();
        this.j = paramRuleRepository.getDateFormat();
        this.k = paramRuleRepository.getDatetimeFormat();
        this.D = paramRuleRepository.getDbsPath();
        this.n = paramRuleRepository.getDriver();
        this.i = paramRuleRepository.getExportExeRulePath();
        this.h = paramRuleRepository.getExportPagePath();
        this.w = paramRuleRepository.getFtpJspPath();
        this.u = paramRuleRepository.getFtpPasswd();
        this.v = paramRuleRepository.getFtpRscPath();
        this.x = paramRuleRepository.getFtpRulesPath();
        this.x = paramRuleRepository.getFtpRulesPath();
        this.s = paramRuleRepository.getFtpServer();
        this.t = paramRuleRepository.getFtpUser();
        this.r = paramRuleRepository.getJspRoot();
        this.m = paramRuleRepository.getRspRoot();
        this.l = paramRuleRepository.getTimeFormat();
        this.p = paramRuleRepository.getUid();
        this.o = paramRuleRepository.getUrl();
        this.y = paramRuleRepository.getUserRuleServer();
        this.E = paramRuleRepository.isAutoCheck();
        this.F = paramRuleRepository.isLogtrace();
        this.G = paramRuleRepository.isShowVarname();
        this.H = paramRuleRepository.getRuleServiceUrl();
        PagePropertyPool.setRSPDIR(this.m);
        if (new File(this.i).exists())
          Property.getInstance().setRuleEngineClassDir(this.i);
        else if (new File(FileUtil.getCurrentDir(), this.i).exists())
          Property.getInstance().setRuleEngineClassDir(new File(FileUtil.getCurrentDir(), this.i).getPath());
        if ((!StringUtil.isEmpty(this.g)) && (new File(this.g).exists()))
          Property.getInstance().setDynamicClassDir(this.g);
      }
      this.J = paramRuleRepository;
    }
  }

  public boolean G()
  {
    if (this.J != null)
      return this.J.isLogtrace();
    return this.F;
  }

  public void h(boolean paramBoolean)
  {
    this.F = paramBoolean;
    if (this.J != null)
      this.J.setLogtrace(paramBoolean);
  }

  public String H()
  {
    if (this.J != null)
      return this.J.getRuleServiceUrl();
    return this.H;
  }

  public void v(String paramString)
  {
    this.H = paramString;
    if (this.J != null)
      this.J.setRuleServiceUrl(paramString);
  }

  public boolean I()
  {
    return this.I;
  }

  public void i(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.d.b
 * JD-Core Version:    0.6.0
 */