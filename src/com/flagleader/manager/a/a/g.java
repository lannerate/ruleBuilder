package com.flagleader.manager.a.a;

import com.flagleader.engine.RuleService;
import com.flagleader.manager.builder.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.e.d;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.Date;
import org.apache.commons.lang.SystemUtils;

public class g extends i
{
  private String d;
  private int e;
  private int f;
  private String g = "";
  private String h = "";
  private int i = 0;
  private String j = "";
  private String k = "";
  private Date l;

  public g(r paramr)
  {
    super(paramr);
  }

  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    RuleService localRuleService = j();
    String str = this.b.b().getUserServer();
    int m = this.b.b().getUserType();
    int n = this.b.b().getUserid();
    if ((str == null) || (n == 0) || (m < 1))
      return false;
    localRuleService.put("loginname", str);
    localRuleService.put("userid", n);
    localRuleService.put("rulever", paramString1);
    localRuleService.put("ruleid", paramInt);
    localRuleService.put("rulename", paramString2);
    localRuleService.put("ruleright", this.b.y());
    localRuleService.execute(this.a + "loadRules");
    this.f = localRuleService.getInteger("ruleright");
    this.j = localRuleService.getString("rulecontent");
    this.d = localRuleService.getString("rulever");
    this.g = localRuleService.getString("ruleproject");
    this.c = localRuleService.getString("error");
    this.h = localRuleService.getString("projver");
    this.e = localRuleService.getInteger("ruleid");
    this.i = localRuleService.getInteger("ruletypeid");
    this.l = ((Date)localRuleService.get("modifytime"));
    this.k = localRuleService.getString("groupinfo");
    if ((this.c != null) && (this.c.length() > 0))
    {
      this.b.b().showError(this.c);
      return false;
    }
    return true;
  }

  public String a()
  {
    return this.g;
  }

  public String b()
  {
    return this.d;
  }

  public int c()
  {
    return this.f;
  }

  public RulePackage d()
  {
    RulePackage localRulePackage = (RulePackage)new d().load(this.j);
    localRulePackage.setVersion(String.valueOf(this.d));
    localRulePackage.setProjver(this.h);
    localRulePackage.setDbRules(true);
    localRulePackage.setRuletypeid(this.i);
    localRulePackage.setRulesid(this.e);
    if (this.f == 1)
    {
      localRulePackage.setEdittype(RulePackage.READER);
      localRulePackage.setLocked(true);
      this.b.b().showSuccess(localRulePackage.toString() + " : " + c.b("read.ruleright"));
    }
    else if (this.f == 2)
    {
      localRulePackage.setEdittype(RulePackage.EDITER);
    }
    else if (this.f != 3)
    {
      this.b.b().showError(localRulePackage.toString() + " : " + c.b("noread.ruleright"));
      return null;
    }
    if (new File(SystemUtils.JAVA_IO_TMPDIR, localRulePackage.getUuid()).exists())
      FileUtil.deleteAllFilesThenDirectories(new File(SystemUtils.JAVA_IO_TMPDIR, localRulePackage.getUuid()), false);
    return localRulePackage;
  }

  public RulePackage a(RulePackage paramRulePackage)
  {
    RulePackage localRulePackage = (RulePackage)new d().load(this.j);
    paramRulePackage.replaceRulePackage(localRulePackage);
    this.b.j().c(paramRulePackage.toString() + " : " + c.a("success.checkout", "success check out!"));
    if (new File(SystemUtils.JAVA_IO_TMPDIR, paramRulePackage.getUuid()).exists())
      FileUtil.deleteAllFilesThenDirectories(new File(SystemUtils.JAVA_IO_TMPDIR, paramRulePackage.getUuid()), false);
    paramRulePackage.setDbRules(true);
    paramRulePackage.setRulesid(this.e);
    if (this.f == 1)
    {
      paramRulePackage.setEdittype(RulePackage.READER);
      paramRulePackage.setLocked(true);
      this.b.b().showSuccess(paramRulePackage.toString() + " : " + c.b("read.ruleright"));
    }
    else if (this.f == 2)
    {
      paramRulePackage.setEdittype(RulePackage.EDITER);
    }
    else if (this.f != 3)
    {
      this.b.b().showError(paramRulePackage.toString() + " : " + c.b("noread.ruleright"));
      return null;
    }
    return paramRulePackage;
  }

  public String e()
  {
    return this.j;
  }

  public Date f()
  {
    return this.l;
  }

  public String g()
  {
    return this.h;
  }

  public String h()
  {
    if (this.k == null)
      return "";
    return this.k;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.a.g
 * JD-Core Version:    0.6.0
 */