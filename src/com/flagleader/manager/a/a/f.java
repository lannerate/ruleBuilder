package com.flagleader.manager.a.a;

import com.flagleader.engine.RuleService;
import com.flagleader.manager.builder.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;

public class f extends i
{
  private String d = "";

  public f(r paramr)
  {
    super(paramr);
  }

  public int a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    RuleService localRuleService = j();
    String str = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str == null) || (j == 0) || (i < 1))
    {
      this.c = c.b("empty.LoginDialog");
      return -1;
    }
    localRuleService.put("loginname", str);
    localRuleService.put("userid", j);
    localRuleService.put("ruleproject", paramString1);
    localRuleService.put("projver", paramString2);
    localRuleService.put("verdesc", paramString3);
    localRuleService.put("projectnew", paramBoolean1);
    localRuleService.put("projvernew", paramBoolean2);
    localRuleService.execute(this.a + "projverid");
    this.c = localRuleService.getString("error");
    if ((this.c != null) && (this.c.length() > 0))
      return -1;
    paramString3 = localRuleService.getString("verdesc");
    return localRuleService.getInteger("projverid");
  }

  public String a()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.a.f
 * JD-Core Version:    0.6.0
 */