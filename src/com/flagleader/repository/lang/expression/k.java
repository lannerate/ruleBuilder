package com.flagleader.repository.lang.expression;

import com.flagleader.repository.IElement;
import com.flagleader.repository.d.s;
import com.flagleader.repository.d.u;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.lang.IOperatorToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class k extends a
{
  protected ArrayList e = new ArrayList();
  private ArrayList f = new ArrayList();

  public k(StatementSystem paramStatementSystem, String paramString)
  {
    super(paramStatementSystem, paramString);
    f(paramString);
  }

  private int a(String paramString, int paramInt, String[] paramArrayOfString)
  {
    int i = -1;
    for (int j = 0; j < paramArrayOfString.length; j++)
    {
      int k = paramString.indexOf(paramArrayOfString[j], paramInt);
      if (((k + 1 < paramString.length()) && (StatementSystem.b(paramString.substring(k + 1, k + 2)))) || (k < 0) || ((k >= i) && (i != -1)) || ((k == 0) && (paramArrayOfString[j].equalsIgnoreCase("-"))))
        continue;
      i = k + paramArrayOfString[j].length();
    }
    return i;
  }

  private int a(String paramString, int paramInt)
  {
    for (int i = a(paramString, paramInt, StatementSystem.k); a(i); i = a(paramString, i + 1, StatementSystem.k));
    return i;
  }

  private int b(String paramString, int paramInt)
  {
    int i = a(paramString, paramInt, new String[] { "{" });
    int j = a(paramString, paramInt, new String[] { "}" });
    int k = a(paramString, paramInt);
    while ((k > paramInt) && (k < j) && (k > i))
    {
      i = a(paramString, j + 1, new String[] { "{" });
      k = a(paramString, j + 1);
      j = a(paramString, j + 1, new String[] { "}" });
    }
    if (k == paramString.length())
      k = -1;
    return k;
  }

  public void a(MemberToken paramMemberToken)
  {
    f localf = (f)this.e.get(0);
    String str = localf.b();
    IBusinessObject localIBusinessObject = this.a.a(str);
    if (localIBusinessObject != null)
    {
      paramMemberToken.setValueType(localIBusinessObject.getValueType());
      paramMemberToken.setMemberElement(localIBusinessObject);
      if (((localf instanceof x)) && (localIBusinessObject.getAllParams().size() > 0))
      {
        List localList = paramMemberToken.getValueTokens();
        ArrayList localArrayList = ((x)localf).g();
        for (int i = 0; i < localList.size(); i++)
        {
          ValueToken localValueToken = (ValueToken)localList.get(i);
          if (localArrayList.size() <= i)
            continue;
          ((k)localArrayList.get(i)).a(localValueToken, localValueToken.getValueType());
        }
      }
    }
    else
    {
      throw new s(u.a("notexitsbo.expression", new String[] { str }));
    }
  }

  public void a(ValueToken paramValueToken, String paramString)
  {
    if (this.e.size() > 0)
    {
      f localf = (f)this.e.get(0);
      String str = localf.b();
      Object localObject2;
      if (str.startsWith("\""))
      {
        paramValueToken.setFieldType(2);
        if (str.endsWith("\""))
          ((ConstantToken)paramValueToken.getValueElement()).setText(str.substring(1, str.length() - 1));
        else
          ((ConstantToken)paramValueToken.getValueElement()).setText(str.substring(1));
      }
      else
      {
        MemberToken localMemberToken;
        ArrayList localArrayList;
        int j;
        ValueToken localValueToken;
        if ((str.startsWith("[")) && (str.endsWith("]")))
        {
          localObject1 = this.a.a(str.substring(1, str.length() - 1));
          if (localObject1 != null)
          {
            paramValueToken.setFieldType(1);
            localMemberToken = (MemberToken)paramValueToken.getValueElement();
            localMemberToken.setMemberElement((IElement)localObject1);
            if (((localf instanceof x)) && (((IBusinessObject)localObject1).getAllParams().size() > 0))
            {
              localObject2 = localMemberToken.getValueTokens();
              localArrayList = ((x)localf).g();
              for (j = 0; j < ((List)localObject2).size(); j++)
              {
                localValueToken = (ValueToken)((List)localObject2).get(j);
                if (localArrayList.size() <= j)
                  continue;
                ((k)localArrayList.get(j)).a(localValueToken, localValueToken.getValueType());
              }
            }
          }
          else
          {
            throw new s(u.a("notexitsbo.expression", new String[] { str.substring(1, str.length() - 1) }));
          }
        }
        else
        {
          localObject1 = this.a.a(str);
          if (localObject1 != null)
          {
            paramValueToken.setFieldType(1);
            localMemberToken = (MemberToken)paramValueToken.getValueElement();
            localMemberToken.setMemberElement((IElement)localObject1);
            if (((localf instanceof x)) && (((IBusinessObject)localObject1).getAllParams().size() > 0))
            {
              localObject2 = localMemberToken.getValueTokens();
              localArrayList = ((x)localf).g();
              for (j = 0; j < ((List)localObject2).size(); j++)
              {
                localValueToken = (ValueToken)((List)localObject2).get(j);
                if (localArrayList.size() <= j)
                  continue;
                ((k)localArrayList.get(j)).a(localValueToken, localValueToken.getValueType());
              }
            }
          }
          else
          {
            paramValueToken.setFieldType(2);
            if (str.endsWith("\""))
              ((ConstantToken)paramValueToken.getValueElement()).setText(str.substring(0, str.length() - 1));
            else if (this.a.d().a(paramString).a(str.substring(0)))
              ((ConstantToken)paramValueToken.getValueElement()).setText(str.substring(0));
            else
              throw new s(u.a("typeerrorbo.expression", new String[] { str }));
          }
        }
      }
      if (StringUtil.isEmpty(paramString))
        paramString = "string";
      paramValueToken.initOperator(paramString);
      a(paramValueToken, localf);
      Object localObject1 = paramValueToken;
      for (int i = 1; i < this.e.size(); i++)
      {
        localObject2 = a((f)this.e.get(i), paramValueToken.getValueType(), paramValueToken.getValueType());
        ((ValueToken)localObject1).addChildElement((IElement)localObject2);
        localObject1 = localObject2;
      }
    }
    else
    {
      paramValueToken.setFieldType(2);
      if (StringUtil.isEmpty(paramString))
        paramString = "string";
      paramValueToken.initOperator(paramString);
    }
  }

  public ValueToken a(String paramString1, String paramString2)
  {
    ValueToken localValueToken1 = null;
    if (this.e.size() > 0)
    {
      f localf = (f)this.e.get(0);
      String str = localf.b();
      if (str.startsWith("\""))
      {
        if (paramString1 == null)
          paramString1 = "string";
        localValueToken1 = a(str.substring(1), paramString1, paramString2);
      }
      else if ((str.startsWith("[")) && (str.endsWith("]")))
      {
        localObject = this.a.a(str.substring(1, str.length() - 1));
        if (localObject != null)
        {
          if (paramString1 == null)
            paramString1 = ((IBusinessObject)localObject).getValueType();
          localValueToken1 = a((IBusinessObject)localObject, paramString1, paramString2, localf);
        }
        else
        {
          throw new s(u.a("notexitsbo.expression", new String[] { str.substring(1, str.length() - 1) }));
        }
      }
      else
      {
        localObject = this.a.a(str);
        if (localObject != null)
        {
          if (StringUtil.isEmpty(paramString1))
            paramString1 = ((IBusinessObject)localObject).getValueType();
          localValueToken1 = a((IBusinessObject)localObject, paramString1, paramString2, localf);
        }
        else
        {
          if (StringUtil.isEmpty(paramString1))
            paramString1 = "string";
          localValueToken1 = a(str, paramString1, paramString2);
        }
      }
      a(localValueToken1, localf);
      Object localObject = localValueToken1;
      for (int i = 1; i < this.e.size(); i++)
      {
        ValueToken localValueToken2 = a((f)this.e.get(i), paramString1, paramString2);
        ((ValueToken)localObject).addChildElement(localValueToken2);
        localObject = localValueToken2;
      }
    }
    return (ValueToken)localValueToken1;
  }

  private void a(ValueToken paramValueToken, f paramf)
  {
    if (paramf.d() > 0)
      paramValueToken.setLeftParenthesisNumber(paramf.d());
    if (paramf.e() > 0)
      paramValueToken.setRightParenthesisNumber(paramf.e());
    if (!StringUtil.isEmpty(paramf.c()))
    {
      IOperatorToken localIOperatorToken = paramValueToken.getOperator();
      if (localIOperatorToken != null)
        localIOperatorToken.setTextMessage(paramf.c());
    }
  }

  private ValueToken a(f paramf, String paramString1, String paramString2)
  {
    ValueToken localValueToken = null;
    String str = paramf.b();
    if (str.startsWith("\""))
    {
      if (paramString1 == null)
        paramString1 = "string";
      localValueToken = a(str.substring(1), paramString1, paramString2);
    }
    else
    {
      IBusinessObject localIBusinessObject;
      if ((str.startsWith("[")) && (str.endsWith("]")))
      {
        localIBusinessObject = this.a.a(str.substring(1, str.length() - 1));
        if (localIBusinessObject != null)
        {
          if (paramString1 == null)
            paramString1 = localIBusinessObject.getValueType();
          localValueToken = a(localIBusinessObject, paramString1, paramString2, paramf);
        }
        else
        {
          throw new s(u.a("notexitsbo.expression", new String[] { str.substring(1, str.length() - 1) }));
        }
      }
      else
      {
        localIBusinessObject = this.a.a(str);
        if (localIBusinessObject != null)
        {
          if (StringUtil.isEmpty(paramString1))
            paramString1 = localIBusinessObject.getValueType();
          localValueToken = a(localIBusinessObject, paramString1, paramString2, paramf);
        }
        else
        {
          if (StringUtil.isEmpty(paramString1))
            paramString1 = "string";
          localValueToken = a(str, paramString1, paramString2);
        }
      }
    }
    a(localValueToken, paramf);
    return localValueToken;
  }

  private ValueToken a(IBusinessObject paramIBusinessObject, String paramString1, String paramString2, f paramf)
  {
    ValueToken localValueToken1 = new ValueToken(1, paramString1, paramString2);
    MemberToken localMemberToken = new MemberToken(paramString1);
    localValueToken1.addChildElement(localMemberToken);
    if (paramIBusinessObject != null)
    {
      localMemberToken.setMemberElement(paramIBusinessObject);
      if (((paramf instanceof x)) && (paramIBusinessObject.getAllParams().size() > 0))
      {
        List localList = localMemberToken.getValueTokens();
        ArrayList localArrayList = ((x)paramf).g();
        for (int i = 0; i < localList.size(); i++)
        {
          ValueToken localValueToken2 = (ValueToken)localList.get(i);
          if (localArrayList.size() <= i)
            continue;
          ((k)localArrayList.get(i)).a(localValueToken2, localValueToken2.getValueType());
        }
      }
    }
    return localValueToken1;
  }

  private ValueToken a(String paramString1, String paramString2, String paramString3)
  {
    ValueToken localValueToken = new ValueToken(2, paramString2, paramString3);
    if (paramString1.endsWith("\""))
      localValueToken.addChildElement(new ConstantToken(paramString2, paramString1.substring(0, paramString1.length() - 1)));
    else if (this.a.d().a(paramString2).a(paramString1.substring(0)))
      localValueToken.addChildElement(new ConstantToken(paramString2, paramString1.substring(0)));
    else
      throw new s(u.a("typeerrorbo.expression", new String[] { paramString1 }));
    return localValueToken;
  }

  private f e(String paramString)
  {
    if (paramString.indexOf("{") > 0)
      return new x(this.a, paramString);
    return new y(this.a, paramString);
  }

  private boolean a(int paramInt)
  {
    for (int i = 0; i < this.f.size() / 2; i++)
      if ((i * 2 + 1 < this.f.size()) && (paramInt > ((Integer)this.f.get(i * 2)).intValue()) && (paramInt < ((Integer)this.f.get(i * 2 + 1)).intValue()))
        return true;
    return false;
  }

  private void f(String paramString)
  {
    for (int i = 0; i < paramString.length(); i++)
    {
      if (paramString.charAt(i) != '"')
        continue;
      this.f.add(new Integer(i));
    }
    i = 0;
    for (int j = b(paramString, i); j > 0; j = b(paramString, i))
    {
      a(e(paramString.substring(i, j)));
      i = j;
    }
    if (i < paramString.length())
      a(e(paramString.substring(i)));
    if (this.e.size() > 0)
      ((f)this.e.get(this.e.size() - 1)).f();
  }

  protected void a(f paramf)
  {
    this.e.add(paramf);
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < this.e.size(); i++)
      localStringBuffer.append(this.e.get(i));
    return localStringBuffer.toString();
  }

  public Object a(g paramg)
  {
    return paramg.a(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.expression.k
 * JD-Core Version:    0.6.0
 */