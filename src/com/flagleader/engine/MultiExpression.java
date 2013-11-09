package com.flagleader.engine;

import com.flagleader.repository.IElement;
import com.flagleader.repository.e.h;
import com.flagleader.repository.lang.GlobalMethod;
import com.flagleader.repository.m;
import com.flagleader.repository.rom.GlobalFunction;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.DecisionRelateRule;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ExpressionRule;
import com.flagleader.repository.tree.FunctionLibrary;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.util.ListUtil;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.SystemUtils;

public class MultiExpression
  implements IExpression
{
  private List vardefines = new ArrayList();
  private List funcdefines = new ArrayList();
  private List tabledefines = new ArrayList();
  private List ruledefines = new ArrayList();
  private ExpressionFactory factory;

  public MultiExpression(ExpressionFactory paramExpressionFactory)
  {
    this.factory = paramExpressionFactory;
  }

  public void addVarDefine(String paramString1, String paramString2, String paramString3)
  {
    this.vardefines.add(new b(this, paramString1, paramString2, paramString3));
  }

  public void addFuncDefine(String paramString1, String paramString2, String paramString3)
  {
    this.funcdefines.add(new c(this, paramString1, paramString2, paramString3));
  }

  public void addDecisionDefine(String paramString1, String paramString2, List paramList)
  {
    this.tabledefines.add(new a(this, paramString1, paramString2, paramList));
  }

  public void addDecisionDefine(String paramString, List paramList)
  {
    String[] arrayOfString = paramString.split(";");
    if (arrayOfString.length > 1)
      this.tabledefines.add(new a(this, arrayOfString[0], arrayOfString[1], paramList));
  }

  public void addDecisionDefine(String paramString1, String paramString2)
  {
    String[] arrayOfString = paramString1.split(";");
    List localList = ListUtil.stringToList(paramString2, "list<list>");
    if (arrayOfString.length > 1)
      this.tabledefines.add(new a(this, arrayOfString[0], arrayOfString[1], localList));
  }

  public void addRuleDefine(String paramString)
  {
    this.ruledefines.add(paramString);
  }

  public void addConditionDefine(String paramString)
  {
    this.vardefines.add(new b(this, "result", "boolean", "result"));
    this.ruledefines.add(com.flagleader.repository.lang.expression.StatementSystem.o[0] + " " + paramString + " " + com.flagleader.repository.lang.expression.StatementSystem.o[0] + " result=true " + com.flagleader.repository.lang.expression.StatementSystem.o[4]);
  }

  public void addRuleDefine(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
      this.ruledefines.add(paramList.get(i).toString());
  }

  public String testExpression(String paramString1, String paramString2)
  {
    return a(a(paramString1, paramString2), SystemUtils.JAVA_IO_TMPDIR);
  }

  private RulePackage a(String paramString1, String paramString2)
  {
    RulePackage localRulePackage = new RulePackage(paramString1);
    ValueLibrary localValueLibrary = localRulePackage.getEnvionment().getValueLibrary();
    for (int i = 0; i < this.vardefines.size(); i++)
    {
      b localb = (b)this.vardefines.get(i);
      localValueLibrary.addChildElement(new MappingVariable(localb.a, localb.c, localb.b, true));
    }
    FunctionLibrary localFunctionLibrary = localRulePackage.getEnvionment().getFunctionLibrary();
    Object localObject;
    for (int j = 0; j < this.funcdefines.size(); j++)
    {
      c localc = (c)this.funcdefines.get(j);
      GlobalMethod localGlobalMethod = new GlobalMethod();
      localGlobalMethod.setFuncName(localc.a);
      localGlobalMethod.setReturnType(localc.b);
      localGlobalMethod.setFuncBody(localc.c);
      localGlobalMethod.setDisName(localc.a);
      localObject = new GlobalFunction(localGlobalMethod.getFuncName(), localGlobalMethod.getReturnType(), localRulePackage.getEnvionment().getMethodManager().b(localGlobalMethod), localRulePackage.getEnvionment().getMethodManager().c(localGlobalMethod), localRulePackage.getEnvionment().getMethodManager().a(localGlobalMethod), localGlobalMethod.getTypeName());
      ((GlobalFunction)localObject).setVisible(true);
      localFunctionLibrary.addChildElement((IElement)localObject);
    }
    ExpressionRule localExpressionRule = new ExpressionRule("rule");
    localExpressionRule.setExpression(paramString2);
    localRulePackage.addChildElement(localExpressionRule);
    int k = 1;
    int m = 1;
    while (m <= this.ruledefines.size())
    {
      localObject = new ExpressionRule("rule" + m);
      ((ExpressionRule)localObject).setExpression((String)this.ruledefines.get(m - 1));
      localRulePackage.addChildElement((IElement)localObject);
      m++;
      k++;
    }
    try
    {
      m = 1;
      while (m <= this.tabledefines.size())
      {
        localObject = (a)this.tabledefines.get(m - 1);
        DecisionRelateRule localDecisionRelateRule = new DecisionRelateRule("decision" + m);
        localDecisionRelateRule.initByList(((a)localObject).a, ((a)localObject).b, ((a)localObject).c);
        localRulePackage.addChildElement(localDecisionRelateRule);
        m++;
        k++;
      }
    }
    catch (Exception localException)
    {
      throw new RuleExecuteException(localException.getMessage());
    }
    return (RulePackage)localRulePackage;
  }

  private RulePackage a(String paramString)
  {
    RulePackage localRulePackage = new RulePackage(paramString);
    ValueLibrary localValueLibrary = localRulePackage.getEnvionment().getValueLibrary();
    for (int i = 0; i < this.vardefines.size(); i++)
    {
      b localb = (b)this.vardefines.get(i);
      localValueLibrary.addChildElement(new MappingVariable(localb.a, localb.c, localb.b, true));
    }
    FunctionLibrary localFunctionLibrary = localRulePackage.getEnvionment().getFunctionLibrary();
    Object localObject1;
    Object localObject2;
    for (int j = 0; j < this.funcdefines.size(); j++)
    {
      localObject1 = (c)this.funcdefines.get(j);
      localObject2 = new GlobalMethod();
      ((GlobalMethod)localObject2).setFuncName(((c)localObject1).a);
      ((GlobalMethod)localObject2).setReturnType(((c)localObject1).b);
      ((GlobalMethod)localObject2).setFuncBody(((c)localObject1).c);
      ((GlobalMethod)localObject2).setDisName(((c)localObject1).a);
      GlobalFunction localGlobalFunction = new GlobalFunction(((GlobalMethod)localObject2).getFuncName(), ((GlobalMethod)localObject2).getReturnType(), localRulePackage.getEnvionment().getMethodManager().b((GlobalMethod)localObject2), localRulePackage.getEnvionment().getMethodManager().c((GlobalMethod)localObject2), localRulePackage.getEnvionment().getMethodManager().a((GlobalMethod)localObject2), ((GlobalMethod)localObject2).getTypeName());
      localGlobalFunction.setVisible(true);
      localFunctionLibrary.addChildElement(localGlobalFunction);
    }
    for (j = 1; j <= this.ruledefines.size(); j++)
    {
      localObject1 = new ExpressionRule("rule" + j);
      ((ExpressionRule)localObject1).setExpression((String)this.ruledefines.get(j - 1));
      localRulePackage.addChildElement((IElement)localObject1);
    }
    try
    {
      for (j = 1; j <= this.tabledefines.size(); j++)
      {
        localObject1 = (a)this.tabledefines.get(j - 1);
        localObject2 = new DecisionRelateRule("decision" + j);
        localRulePackage.addChildElement((IElement)localObject2);
        ((DecisionRelateRule)localObject2).initByList(((a)localObject1).a, ((a)localObject1).b, ((a)localObject1).c);
      }
    }
    catch (Exception localException)
    {
      throw new RuleExecuteException(localException.getMessage());
    }
    return (RulePackage)(RulePackage)localRulePackage;
  }

  public String deployExpression(String paramString1, String paramString2)
  {
    return a(a(paramString1, paramString2), Property.getInstance().getRuleEngineClassDir());
  }

  public String testExpression(String paramString)
  {
    return a(a(paramString), SystemUtils.JAVA_IO_TMPDIR);
  }

  public void redeployExpression(String paramString)
  {
    String str = a(a(paramString), Property.getInstance().getRuleEngineClassDir());
    if (StringUtil.isEmpty(str))
      this.factory.putExpression(paramString, this);
    else
      throw new RuleExecuteException(str);
  }

  public void deployExpression(String paramString)
  {
    if (!this.factory.exitsExpression(paramString, this))
    {
      String str = a(a(paramString), Property.getInstance().getRuleEngineClassDir());
      if (StringUtil.isEmpty(str))
        this.factory.putExpression(paramString, this);
      else
        throw new RuleExecuteException(str);
    }
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
    System.out.println(SystemUtils.IS_OS_WINDOWS);
    System.out.println(SystemUtils.OS_NAME);
    for (int i = 0; i < 10; i++)
    {
      long l = System.currentTimeMillis();
      IExpression localIExpression = ExpressionFactory.getInstance().createExpression();
      localIExpression.addVarDefine("t1", "double", "测试1");
      localIExpression.addVarDefine("t2", "string", "测试2");
      localIExpression.addVarDefine("t3", "double", "测试3");
      localIExpression.addRuleDefine("如果 测试1==100 那么 测试2=取{\"SSS\"}的大写值 否则 测试3=100 结束如果");
      try
      {
        localIExpression.deployExpression("testrule");
        RuleEngine localRuleEngine = RuleEngineFactory.newInstance().getRuleEngine();
        localRuleEngine.put("t1", 100);
        localRuleEngine.excute("testrule");
        System.out.println("t2:" + localRuleEngine.get("t2"));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof MultiExpression))
      return (((MultiExpression)paramObject).vardefines.equals(this.vardefines)) && (((MultiExpression)paramObject).funcdefines.equals(this.funcdefines)) && (((MultiExpression)paramObject).ruledefines.equals(this.ruledefines)) && (((MultiExpression)paramObject).tabledefines.equals(this.tabledefines));
    return super.equals(paramObject);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.engine.MultiExpression
 * JD-Core Version:    0.6.0
 */