package com.flagleader.manager.a.a;

import com.flagleader.engine.Property;
import com.flagleader.engine.RuleService;
import com.flagleader.manager.r;
import com.flagleader.util.StringUtil;

public class d extends i
{
  private int d = 0;
  private int e = 0;
  private String f = "";
  private String g = "";
  private String h = "";

  public d(r paramr)
  {
    super(paramr);
  }

  public int a(String paramString1, String paramString2)
  {
    RuleService localRuleService = j();
    localRuleService.put("loginname", paramString1);
    localRuleService.put("passwd", paramString2);
    localRuleService.execute(this.a + "login");
    if ((localRuleService.getString("error") == null) || (localRuleService.getString("error").length() == 0))
    {
      this.d = localRuleService.getInteger("userType");
      this.e = localRuleService.getInteger("userid");
      this.h = localRuleService.getString("encoding");
      if (!StringUtil.isEmpty(this.h))
        Property.getInstance().setServerEncoding(this.h);
      this.f = paramString1;
      this.g = paramString2;
      return this.d;
    }
    this.c = localRuleService.getString("error");
    return 0;
  }

  public int a()
  {
    return this.d;
  }

  public String b()
  {
    return this.f;
  }

  public String c()
  {
    return this.g;
  }

  public int d()
  {
    return this.e;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.a.d
 * JD-Core Version:    0.6.0
 */