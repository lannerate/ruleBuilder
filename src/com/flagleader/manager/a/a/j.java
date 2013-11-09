package com.flagleader.manager.a.a;

import com.flagleader.engine.RuleService;
import com.flagleader.manager.builder.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.e.e;
import com.flagleader.repository.e.u;
import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.h;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.DecisionRule;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.Rule;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.RuleSetFlow;
import com.flagleader.repository.tree.RuleTemplate;
import com.flagleader.repository.tree.RuleTreeFlow;
import java.util.Date;
import java.util.List;

public class j extends i
{
  public j(r paramr)
  {
    super(paramr);
  }

  public List a(String paramString1, String paramString2)
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
    if (paramString1 != null)
      localRuleService.put("pname", paramString1);
    localRuleService.put("ptypename", paramString2);
    localRuleService.execute(this.a + "templatelist");
    this.c = localRuleService.getString("error");
    if ((this.c != null) && (this.c.length() > 0))
      return null;
    return (List)localRuleService.get("ruleList");
  }

  public RuleTemplate a(int paramInt)
  {
    RuleService localRuleService = j();
    String str1 = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str1 == null) || (j == 0) || (i < 1))
      return null;
    localRuleService.put("loginname", str1);
    localRuleService.put("id", paramInt);
    localRuleService.execute(this.a + "templateread");
    String str2 = localRuleService.getString("error");
    if ((str2 == null) || (str2.length() == 0))
    {
      String str3 = localRuleService.getString("disname");
      String str4 = localRuleService.getString("pname");
      String str5 = localRuleService.getString("ptypename");
      int k = localRuleService.getInteger("ruletype");
      Date localDate = (Date)localRuleService.get("mtime");
      String str6 = localRuleService.getString("document");
      String str7 = localRuleService.getString("xmlcontext");
      RuleTemplate localRuleTemplate = (RuleTemplate)new u().load(str7);
      return localRuleTemplate;
    }
    this.b.b().showError(str2);
    return null;
  }

  private int a(IRuleTree paramIRuleTree)
  {
    if ((paramIRuleTree instanceof Rule))
      return 0;
    if ((paramIRuleTree instanceof RuleSet))
      return 1;
    if ((paramIRuleTree instanceof DecisionMultiRule))
      return 2;
    if ((paramIRuleTree instanceof DecisionRelateRule))
      return 3;
    if ((paramIRuleTree instanceof DecisionRule))
      return 4;
    if ((paramIRuleTree instanceof RuleSetFlow))
      return 5;
    if ((paramIRuleTree instanceof ExpressionRule))
      return 6;
    if ((paramIRuleTree instanceof RuleTreeFlow))
      return 7;
    if ((paramIRuleTree instanceof RulePoolFlow))
      return 8;
    return 0;
  }

  public void a(IRuleTree paramIRuleTree, boolean paramBoolean, String paramString1, String paramString2)
  {
    RuleService localRuleService = j();
    String str1 = this.b.b().getUserServer();
    int i = this.b.b().getUserType();
    int j = this.b.b().getUserid();
    if ((str1 == null) || (j == 0) || (i < 2))
      return;
    try
    {
      long l = paramIRuleTree.getMaxModifyTime();
      localRuleService.put("loginname", str1);
      localRuleService.put("userid", j);
      localRuleService.put("lasttime", new Date(l));
      if (paramString1 != null)
        localRuleService.put("pname", paramString1);
      localRuleService.put("ptypename", paramString2);
      localRuleService.put("disname", paramIRuleTree.getDisplayName());
      localRuleService.put("canupdate", paramBoolean);
      localRuleService.execute(this.a + "templatesavetest");
      String str2 = localRuleService.getString("error");
      int k = localRuleService.getInteger("id");
      int m = localRuleService.getInteger("errortype");
      if ((m == 0) || ((m == 1) && (this.b.b().showQuestion(paramIRuleTree.getDisplayName() + ":\n" + str2))))
        try
        {
          localRuleService = j();
          localRuleService.put("loginname", str1);
          localRuleService.put("userid", j);
          localRuleService.put("modifytime", new Date(l));
          localRuleService.put("id", k);
          if (paramString1 != null)
            localRuleService.put("pname", paramString1);
          localRuleService.put("ptypename", paramString2);
          localRuleService.put("disname", paramIRuleTree.getDisplayName());
          localRuleService.put("rulename", paramIRuleTree.getExeRulePackageName());
          localRuleService.put("ruletype", a(paramIRuleTree));
          localRuleService.put("document", paramIRuleTree.getDocument());
          localRuleService.put("modifyuser", paramIRuleTree.getModifyUser());
          String str3 = "";
          List localList = paramIRuleTree.getRelateVarNames();
          for (int n = 0; (localList != null) && (n < localList.size()); n++)
            str3 = str3 + ((IBusinessObject)localList.get(n)).getUniqueName() + "\n";
          localRuleService.put("varinfo", str3);
          localRuleService.put("xmlcontext", e.b(paramIRuleTree));
          localRuleService.execute(this.a + "templatesave");
          str2 = localRuleService.getString("error");
          if ((str2 == null) || (str2.length() == 0))
          {
            this.b.j().c(paramIRuleTree.getDisplayName() + c.b("success.updatedb"));
            return;
          }
          this.b.j().a(paramIRuleTree.getDisplayName() + str2);
        }
        catch (Exception localException2)
        {
          this.b.b().showError(c.a("error.checkin", new String[] { localException2.getMessage() }));
        }
      else if (m == 2)
        this.b.b().showError(paramIRuleTree.getDisplayName() + str2);
    }
    catch (Exception localException1)
    {
      this.b.b().showError(c.a("error.checkin", new String[] { localException1.getMessage() }));
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.a.j
 * JD-Core Version:    0.6.0
 */