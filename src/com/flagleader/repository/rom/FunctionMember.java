package com.flagleader.repository.rom;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.m;
import com.flagleader.repository.d.u;
import com.flagleader.repository.tree.CustomFunction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class FunctionMember extends AbstractBOEditen
  implements IFunctionObject
{
  private String function = "";
  private transient StringBuffer javaFunc = new StringBuffer("");
  private transient String shortFunctionName = "";
  private List params = new ArrayList(3);

  public FunctionMember(FunctionMember paramFunctionMember)
  {
    super(paramFunctionMember);
    this.function = paramFunctionMember.function;
    this.shortFunctionName = paramFunctionMember.shortFunctionName;
    Iterator localIterator = paramFunctionMember.getParams().iterator();
    while (localIterator.hasNext())
      this.params.add(new MethodParam((MethodParam)localIterator.next()));
  }

  public FunctionMember()
  {
    setVisible(true);
    f();
  }

  public String getName()
  {
    return "FunctionMember";
  }

  private void f()
  {
    setFunction("public void function" + m() + "() {\n\n}\n");
    setShortFunctionName("function" + m());
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitFunctionMember(this);
  }

  public IElement deepClone()
  {
    return new FunctionMember(this);
  }

  public void setFunction(String paramString)
  {
    this.function = paramString;
    try
    {
      parse();
    }
    catch (m localm)
    {
    }
  }

  private boolean a(String paramString)
  {
    if (paramString == null)
      return false;
    return paramString.indexOf("{") > 0;
  }

  public String getFunction()
  {
    return this.function;
  }

  public void parse()
  {
    if (this.function.length() == 0)
      throw new m(getLocalStr("functionDefEmpty.error", "the function define text is empty!"));
    this.javaFunc = new StringBuffer(this.function);
    g();
    h();
    j();
    k();
    l();
    i();
    if ((this.params.size() > 0) && (getDisplayName().indexOf("{arg" + this.params.size() + "}") < 0))
      for (int i = 0; i < this.params.size(); i++)
        setDisplayName(getDisplayName() + "{arg" + (i + 1) + "}");
  }

  public String getJavaFunction()
  {
    try
    {
      parse();
      return this.javaFunc.toString();
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  private void g()
  {
    while ((this.javaFunc.indexOf("/*") >= 0) && (this.javaFunc.indexOf("*/") >= 0))
      this.javaFunc.delete(this.javaFunc.indexOf("/*"), this.javaFunc.indexOf("*/") + 2);
    if (((this.javaFunc.indexOf("/*") >= 0) && (this.javaFunc.indexOf("*/") < 0)) || ((this.javaFunc.indexOf("/*") < 0) && (this.javaFunc.indexOf("*/") >= 0)))
      throw new m(getLocalStr("funtionHit.error", "the definition text for funtion hint is error!"));
  }

  private void h()
  {
    parseKey(this.javaFunc, getLocalStr("public.def", "public"), "public");
    parseKey(this.javaFunc, getLocalStr("private.def", "private"), "private");
    parseKey(this.javaFunc, getLocalStr("protected.def", "protected"), "protected");
    parseKey(this.javaFunc, getLocalStr("if.def", "if"), "if");
    parseKey(this.javaFunc, getLocalStr("then.def", "then"), "then");
    parseKey(this.javaFunc, getLocalStr("else.def", "else"), "else");
    parseKey(this.javaFunc, getLocalStr("while.def", "while"), "while");
    parseKey(this.javaFunc, getLocalStr("int.def", "int"), "int");
    parseKey(this.javaFunc, getLocalStr("long.def", "long"), "long");
    parseKey(this.javaFunc, getLocalStr("short.def", "short"), "short");
    parseKey(this.javaFunc, getLocalStr("char.def", "long"), "long");
    parseKey(this.javaFunc, getLocalStr("string.def", "string"), "string");
    parseKey(this.javaFunc, getLocalStr("boolean.def", "boolean"), "boolean");
    parseKey(this.javaFunc, getLocalStr("byte.def", "byte"), "byte");
    parseKey(this.javaFunc, getLocalStr("float.def", "float"), "float");
    parseKey(this.javaFunc, getLocalStr("double.def", "double"), "double");
    parseKey(this.javaFunc, getLocalStr("do.def", "do"), "do");
    parseKey(this.javaFunc, getLocalStr("for.def", "for"), "for");
  }

  private void i()
  {
    String str1 = this.javaFunc.substring(0, this.javaFunc.indexOf(getShortFunctionName()));
    str1 = str1.replaceFirst("public", "");
    str1 = str1.replaceFirst("protected", "");
    str1 = str1.replaceFirst("private", "");
    String str2 = str1.trim();
    if (str2.length() > 0)
    {
      changeValueType(str2);
    }
    else
    {
      this.javaFunc.insert(this.javaFunc.indexOf(getShortFunctionName()), " void ");
      changeValueType("void");
    }
  }

  private void j()
  {
    if (this.javaFunc.indexOf("{") < 0)
      throw new m(getLocalStr("bigparenthsis.error", "the definition text for funtion big parenthsis is error!"));
    if (this.javaFunc.indexOf("(") < 0)
      throw new m(getLocalStr("paramParenthsis.error", "the definition text for funtion parameter parenthsis is error!"));
    String str = this.javaFunc.substring(0, this.javaFunc.indexOf("("));
    setShortFunctionName(str.substring(str.lastIndexOf(" ") + 1, str.length()).trim());
  }

  private void k()
  {
    int i = this.javaFunc.indexOf("(");
    int j = this.javaFunc.indexOf(")");
    if ((i < 0) || (j < 0) || (i > j))
      throw new m(getLocalStr("paramNotMatch.error", "the param parethsis of the function is not match!"));
    String str1 = this.javaFunc.substring(i + 1, j);
    this.params.clear();
    int k = 0;
    StringTokenizer localStringTokenizer = new StringTokenizer(str1, ",");
    while (localStringTokenizer.hasMoreTokens())
    {
      String str2 = localStringTokenizer.nextToken().trim();
      int m = str2.indexOf(" ");
      if (m < 0)
        throw new m(getLocalStr("paramElement.error", "the parameter element of the function is error!"));
      addParam(new MethodParam(str2.substring(0, m), k++));
    }
  }

  private void l()
  {
    int i = 0;
    for (int j = 0; j < this.javaFunc.length(); j++)
      if (this.javaFunc.charAt(j) == '{')
      {
        i++;
      }
      else
      {
        if (this.javaFunc.charAt(j) != '}')
          continue;
        i--;
      }
    if (i != 0)
      throw new m(getLocalStr("bigNotMatch.error", "the block parethsis of the function is not match!"));
  }

  private static String getLocalStr(String paramString1, String paramString2)
  {
    return u.a(paramString1, paramString2);
  }

  private static void parseKey(StringBuffer paramStringBuffer, String paramString1, String paramString2)
  {
    int i = 0;
    while (true)
    {
      int j = paramStringBuffer.indexOf(paramString1, i);
      if (j < 0)
        return;
      int k = 0;
      for (int m = i; m < j; m++)
      {
        if (paramStringBuffer.charAt(m) != '"')
          continue;
        k++;
      }
      if (k % 2 == 0)
      {
        paramStringBuffer.replace(j, j + paramString1.length(), paramString2);
        i = j;
        continue;
      }
      i = j + paramString1.length();
    }
  }

  public String getUniqueName()
  {
    return getFunctionName();
  }

  public String getDisplayName()
  {
    if ((getParent() != null) && ((getParent() instanceof CustomFunction)))
      return getParent().getDisplayName();
    return super.getDisplayName();
  }

  private int m()
  {
    if ((getParent() != null) && ((getParent() instanceof CustomFunction)))
      return ((CustomFunction)getParent()).getFunctionNum();
    return 0;
  }

  public String getVarValue()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(getShortFunctionName());
    localStringBuffer.append("(");
    for (int i = 1; i <= this.params.size(); i++)
    {
      localStringBuffer.append("{arg" + i + "}");
      if (i == this.params.size())
        continue;
      localStringBuffer.append(",");
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }

  public int getParamCount()
  {
    return this.params.size();
  }

  public void addParam(MethodParam paramMethodParam)
  {
    this.params.add(paramMethodParam);
  }

  public String getShortFunctionName()
  {
    return this.shortFunctionName;
  }

  public void setShortFunctionName(String paramString)
  {
    this.shortFunctionName = paramString;
  }

  public String getFunctionName()
  {
    StringBuffer localStringBuffer = new StringBuffer(getShortFunctionName() + "(");
    for (int i = 0; i < this.params.size(); i++)
    {
      localStringBuffer.append(((MethodParam)this.params.get(i)).getTypeName());
      if (i == this.params.size() - 1)
        continue;
      localStringBuffer.append(",");
    }
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }

  public List getParams()
  {
    try
    {
      parse();
    }
    catch (m localm)
    {
    }
    return this.params;
  }

  public CustomFunction getCustomFunction()
  {
    if (getParent() != null)
      return (CustomFunction)getParent();
    return null;
  }

  public String getValueName()
  {
    return getFunctionName();
  }

  public void setValueName(String paramString)
  {
  }

  public void changeParams()
  {
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.FunctionMember
 * JD-Core Version:    0.6.0
 */