package com.flagleader.manager.a.a;

import com.flagleader.engine.RuleService;
import com.flagleader.manager.builder.b;
import com.flagleader.manager.r;
import com.flagleader.repository.export.IPage;
import java.util.ArrayList;
import java.util.List;

public class c extends i
{
  public c(r paramr)
  {
    super(paramr);
  }

  public List a(int paramInt, String paramString)
  {
    RuleService localRuleService = j();
    String str = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str == null) || (j == 0) || (i < 1))
    {
      this.c = com.flagleader.manager.d.c.b("empty.LoginDialog");
      return null;
    }
    localRuleService.put("loginname", str);
    localRuleService.put("userid", j);
    localRuleService.put("ruleid", paramInt);
    localRuleService.put("exerule", paramString);
    localRuleService.execute(this.a + "ruleversions");
    this.c = localRuleService.getString("error");
    if ((this.c != null) && (this.c.length() > 0))
      return null;
    if ((localRuleService.get("ruleList") instanceof List))
      return (List)localRuleService.get("ruleList");
    return new ArrayList(0);
  }

  public List a(String paramString)
  {
    RuleService localRuleService = j();
    String str = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str == null) || (j == 0) || (i < 1))
    {
      this.c = com.flagleader.manager.d.c.b("empty.LoginDialog");
      return null;
    }
    localRuleService.put("loginname", str);
    localRuleService.put("userid", j);
    localRuleService.put("ruleproject", paramString);
    localRuleService.execute(this.a + "checkrules");
    this.c = localRuleService.getString("error");
    if ((this.c != null) && (this.c.length() > 0))
      return null;
    if ((localRuleService.get("ruleList") instanceof List))
      return (List)localRuleService.get("ruleList");
    return new ArrayList(0);
  }

  public List a(int paramInt)
  {
    RuleService localRuleService = j();
    String str = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str == null) || (j == 0) || (i < 1))
    {
      this.c = com.flagleader.manager.d.c.b("empty.LoginDialog");
      return null;
    }
    localRuleService.put("loginname", str);
    localRuleService.put("userid", j);
    localRuleService.put("projverid", paramInt);
    localRuleService.execute(this.a + "checkrules");
    this.c = localRuleService.getString("error");
    if ((this.c != null) && (this.c.length() > 0))
      return null;
    if ((localRuleService.get("ruleList") instanceof List))
      return (List)localRuleService.get("ruleList");
    return new ArrayList(0);
  }

  public List a()
  {
    RuleService localRuleService = j();
    String str = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str == null) || (j == 0) || (i < 1))
    {
      this.c = com.flagleader.manager.d.c.b("empty.LoginDialog");
      return null;
    }
    localRuleService.put("loginname", str);
    localRuleService.put("userid", j);
    localRuleService.execute(this.a + "listRules");
    this.c = localRuleService.getString("error");
    if ((this.c != null) && (this.c.length() > 0))
      return null;
    if ((localRuleService.get("ruleList") instanceof List))
      return (List)localRuleService.get("ruleList");
    return new ArrayList(0);
  }

  public List b(String paramString)
  {
    RuleService localRuleService = j();
    String str = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str == null) || (j == 0) || (i < 1))
    {
      this.c = com.flagleader.manager.d.c.b("empty.LoginDialog");
      return null;
    }
    localRuleService.put("loginname", str);
    localRuleService.put("ruleproject", paramString);
    localRuleService.execute(this.a + "listProjvers");
    this.c = localRuleService.getString("error");
    if ((this.c != null) && (this.c.length() > 0))
      return null;
    if ((localRuleService.get("ruleList") instanceof List))
      return (List)localRuleService.get("ruleList");
    return new ArrayList(0);
  }

  public List b()
  {
    RuleService localRuleService = j();
    String str = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str == null) || (j == 0) || (i < 1))
    {
      this.c = com.flagleader.manager.d.c.b("empty.LoginDialog");
      return null;
    }
    localRuleService.put("loginname", str);
    localRuleService.put("userid", j);
    localRuleService.execute(this.a + "lanmu");
    this.c = localRuleService.getString("error");
    if ((this.c != null) && (this.c.length() > 0))
      return null;
    if ((localRuleService.get("lanmulist") instanceof List))
      return (List)localRuleService.get("lanmulist");
    return new ArrayList(0);
  }

  public String a(String paramString1, String paramString2, Object paramObject, String paramString3, String paramString4)
  {
    RuleService localRuleService = j();
    localRuleService.put("pageName", paramString1);
    localRuleService.put("url", paramString2);
    localRuleService.put("lanmu", paramObject);
    if ((paramString3 != null) && (paramString3.length() > 0))
      localRuleService.put("rescode", paramString3);
    localRuleService.put("source", paramString4);
    localRuleService.execute(this.a + "newPage");
    this.c = localRuleService.getString("error");
    if ((this.c != null) && (this.c.length() > 0))
      return this.c;
    return null;
  }

  public boolean a(IPage paramIPage)
  {
    RuleService localRuleService = j();
    localRuleService.put("url", paramIPage.getDisplayName());
    localRuleService.put("source", paramIPage.getExportStr());
    localRuleService.execute(this.a + "uploadjsp");
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.a.c
 * JD-Core Version:    0.6.0
 */