package com.flagleader.manager.a.a;

import com.flagleader.engine.IRuleLog;
import com.flagleader.engine.RuleService;
import com.flagleader.manager.builder.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.sql.SerializationUtils;
import java.util.ArrayList;
import java.util.List;

public class e extends i
{
  private int d = 0;

  public e(r paramr)
  {
    super(paramr);
  }

  public List a(int paramInt1, int paramInt2)
  {
    RuleService localRuleService = j();
    String str = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str == null) || (j == 0) || (i < 1))
    {
      this.c = c.b("empty.LoginDialog");
      return null;
    }
    localRuleService.put("loginname", str);
    localRuleService.put("userid", j);
    localRuleService.put("curPage", paramInt1);
    localRuleService.put("perPage", paramInt2);
    localRuleService.execute(this.a + "listLogRecords");
    this.d = localRuleService.getInteger("count");
    this.c = localRuleService.getString("error");
    if ((this.c != null) && (this.c.length() > 0))
      return null;
    if ((localRuleService.get("ruleList") instanceof List))
      return (List)localRuleService.get("ruleList");
    return new ArrayList(0);
  }

  public IRuleLog a(int paramInt)
  {
    RuleService localRuleService = j();
    String str1 = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str1 == null) || (j == 0) || (i < 1))
      return null;
    localRuleService.put("loginname", str1);
    localRuleService.put("recordid", paramInt);
    localRuleService.execute(this.a + "readlogrecord");
    String str2 = localRuleService.getString("error");
    if ((str2 == null) || (str2.length() == 0))
    {
      byte[] arrayOfByte = localRuleService.getBinary("logtrace");
      return (IRuleLog)SerializationUtils.deserialize(arrayOfByte);
    }
    this.b.b().showError(str2);
    return null;
  }

  public int a()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.a.e
 * JD-Core Version:    0.6.0
 */