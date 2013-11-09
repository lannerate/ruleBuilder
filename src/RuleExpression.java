import com.flagleader.engine.Property;
import com.flagleader.repository.IElement;
import com.flagleader.repository.e.h;
import com.flagleader.repository.lang.GlobalMethod;
import com.flagleader.repository.m;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.FunctionLibrary;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.ValueLibrary;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.SystemUtils;

public class RuleExpression
{
  private List a = new ArrayList();
  private List b = new ArrayList();
  private List c = new ArrayList();

  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.a.add(new a(this, paramString1, paramString2, paramString3));
  }

  public void b(String paramString1, String paramString2, String paramString3)
  {
    this.b.add(new b(this, paramString1, paramString2, paramString3));
  }

  public void a(String paramString)
  {
    this.c.add(paramString);
  }

  public String a(String paramString1, String paramString2)
  {
    return a(c(paramString1, paramString2), SystemUtils.JAVA_IO_TMPDIR);
  }

  private RulePackage c(String paramString1, String paramString2)
  {
    RulePackage localRulePackage = new RulePackage(paramString1);
    ValueLibrary localValueLibrary = localRulePackage.getEnvionment().getValueLibrary();
    for (int i = 0; i < this.a.size(); i++)
    {
      a locala = (a)this.a.get(i);
      localValueLibrary.addChildElement(new MappingVariable(locala.a, locala.c, locala.b, true));
    }
    FunctionLibrary localFunctionLibrary = localRulePackage.getEnvionment().getFunctionLibrary();
    Object localObject;
    for (int j = 0; j < this.b.size(); j++)
    {
      b localb = (b)this.b.get(j);
      localObject = new GlobalMethod();
      ((GlobalMethod)localObject).setFuncName(localb.a);
      ((GlobalMethod)localObject).setReturnType(localb.b);
      ((GlobalMethod)localObject).setFuncBody(localb.c);
      ((GlobalMethod)localObject).setDisName(localb.a);
      GlobalFunction localGlobalFunction = new GlobalFunction(((GlobalMethod)localObject).getFuncName(), ((GlobalMethod)localObject).getReturnType(), localRulePackage.getEnvionment().getMethodManager().b((GlobalMethod)localObject), localRulePackage.getEnvionment().getMethodManager().c((GlobalMethod)localObject), localRulePackage.getEnvionment().getMethodManager().a((GlobalMethod)localObject), ((GlobalMethod)localObject).getTypeName());
      localGlobalFunction.setVisible(true);
      localFunctionLibrary.addChildElement(localGlobalFunction);
    }
    ExpressionRule localExpressionRule = new ExpressionRule("rule");
    localExpressionRule.setExpression(paramString2);
    localRulePackage.addChildElement(localExpressionRule);
    for (int k = 1; k <= this.c.size(); k++)
    {
      localObject = new ExpressionRule("rule" + k);
      ((ExpressionRule)localObject).setExpression((String)this.c.get(k - 1));
      localRulePackage.addChildElement((IElement)localObject);
    }
    return (RulePackage)localRulePackage;
  }

  private RulePackage c(String paramString)
  {
    RulePackage localRulePackage = new RulePackage(paramString);
    ValueLibrary localValueLibrary = localRulePackage.getEnvionment().getValueLibrary();
    for (int i = 0; i < this.a.size(); i++)
    {
      a locala = (a)this.a.get(i);
      localValueLibrary.addChildElement(new MappingVariable(locala.a, locala.c, locala.b, true));
    }
    FunctionLibrary localFunctionLibrary = localRulePackage.getEnvionment().getFunctionLibrary();
    Object localObject;
    for (int j = 0; j < this.b.size(); j++)
    {
      localObject = (b)this.b.get(j);
      GlobalMethod localGlobalMethod = new GlobalMethod();
      localGlobalMethod.setFuncName(((b)localObject).a);
      localGlobalMethod.setReturnType(((b)localObject).b);
      localGlobalMethod.setFuncBody(((b)localObject).c);
      localGlobalMethod.setDisName(((b)localObject).a);
      GlobalFunction localGlobalFunction = new GlobalFunction(localGlobalMethod.getFuncName(), localGlobalMethod.getReturnType(), localRulePackage.getEnvionment().getMethodManager().b(localGlobalMethod), localRulePackage.getEnvionment().getMethodManager().c(localGlobalMethod), localRulePackage.getEnvionment().getMethodManager().a(localGlobalMethod), localGlobalMethod.getTypeName());
      localGlobalFunction.setVisible(true);
      localFunctionLibrary.addChildElement(localGlobalFunction);
    }
    for (j = 1; j <= this.c.size(); j++)
    {
      localObject = new ExpressionRule("rule" + j);
      ((ExpressionRule)localObject).setExpression((String)this.c.get(j - 1));
      localRulePackage.addChildElement((IElement)localObject);
    }
    return (RulePackage)localRulePackage;
  }

  public String b(String paramString1, String paramString2)
  {
    return a(c(paramString1, paramString2), Property.getInstance().getRuleEngineClassDir());
  }

  public String b(String paramString)
  {
    return a(c(paramString), Property.getInstance().getRuleEngineClassDir());
  }

  private String a(RulePackage paramRulePackage, String paramString)
  {
    String str = null;
    try
    {
      if (paramRulePackage.getMainPackage().needCheck())
        paramRulePackage.getMainPackage().setError(new h().c(paramRulePackage.getMainPackage()));
      boolean bool = paramRulePackage.getMainPackage().hasError();
      if (paramRulePackage.getMainPackage().hasError())
        return a(paramRulePackage.getMainPackage().getErrorList());
      com.flagleader.repository.lang.a locala = m.a().f();
      File localFile1 = locala.a(paramRulePackage, paramString, false);
      str = locala.a(localFile1, paramRulePackage.getClassPath());
      if ((str != null) && (str.length() > 0))
        return str;
      File localFile2 = locala.a(paramRulePackage, true, paramString);
    }
    catch (Exception localException)
    {
      return "error:" + localException.getMessage();
    }
    if (str != null)
      return str;
    return "";
  }

  private String a(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < paramList.size(); i++)
    {
      com.flagleader.repository.d.d locald = (com.flagleader.repository.d.d)paramList.get(i);
      localStringBuffer.append(locald.a()).append("\n");
    }
    return localStringBuffer.toString();
  }

  public static void main(String[] paramArrayOfString)
  {
    RuleExpression localRuleExpression = new RuleExpression();
    localRuleExpression.a("t1", "double", "测试1");
    localRuleExpression.a("t2", "double", "测试2");
    localRuleExpression.a("t3", "double", "测试3");
    System.out.println(localRuleExpression.a("testrule", "如果 测试1==100 那么 测试2=100 否则 测试3=100 结束如果"));
    System.out.println(localRuleExpression.b("testrule", "如果 测试1==100 那么 测试2=100 否则 测试3=100 结束如果"));
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof RuleExpression))
      return (((RuleExpression)paramObject).a.equals(this.a)) && (((RuleExpression)paramObject).b.equals(this.b)) && (((RuleExpression)paramObject).c.equals(this.c));
    return super.equals(paramObject);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     RuleExpression
 * JD-Core Version:    0.6.0
 */