package com.flagleader.repository.lang.info;

import com.flagleader.a.M;
import com.flagleader.a.P;
import com.flagleader.a.ak;
import com.flagleader.a.y;
import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.util.StringUtil;

public abstract class InfoMember extends AbstractElement
{
  private String memberName;
  private boolean staticType;
  private String typeName;

  public InfoMember()
  {
  }

  public InfoMember(String paramString)
  {
    super(paramString);
  }

  public InfoMember(InfoMember paramInfoMember)
  {
    super(paramInfoMember);
    this.memberName = paramInfoMember.memberName;
    this.staticType = paramInfoMember.staticType;
    this.typeName = paramInfoMember.typeName;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return null;
  }

  public String getMemberName()
  {
    return this.memberName;
  }

  public void setMemberName(String paramString)
  {
    if (paramString.indexOf(", ") > 0)
      this.memberName = StringUtil.replace(", ", ",", paramString);
    else
      this.memberName = paramString;
  }

  public boolean isStaticType()
  {
    return this.staticType;
  }

  public void setStaticType(boolean paramBoolean)
  {
    this.staticType = paramBoolean;
  }

  public String getTypeName()
  {
    return this.typeName;
  }

  public void setTypeName(String paramString)
  {
    this.typeName = paramString;
  }

  public void changeValueType(String paramString)
  {
    if ((this.typeName != null) && (this.typeName.equals(paramString)))
      return;
    this.typeName = paramString;
  }

  public void setMember(M paramM)
  {
    setMemberName(paramM.I());
    if (super.getDisplayName().length() == 0)
      if (paramM.m())
        setDisplayName(paramM.G());
      else
        setDisplayName("{p}." + paramM.G());
    if ((paramM instanceof P))
      changeValueType(((P)paramM).n().K());
    else if ((paramM instanceof y))
      changeValueType(((y)paramM).e().K());
    this.staticType = paramM.m();
  }

  public boolean checkDisplay()
  {
    int i = this.memberName.indexOf("(");
    int j = this.memberName.indexOf(")");
    if ((i > 0) && (j > i))
    {
      String str = getDisplayName();
      String[] arrayOfString = this.memberName.substring(i + 1, j).split(",");
      for (int k = 1; k <= arrayOfString.length; k++)
        if ((!StringUtil.isEmpty(arrayOfString[(k - 1)])) && (str.indexOf("{arg" + k + "}") < 0))
          return false;
    }
    return true;
  }

  public String getParameterInfo()
  {
    return "";
  }

  public boolean isMethod()
  {
    return ((this instanceof InfoMethod)) || ((this instanceof InfoConstructor));
  }

  public boolean isAttribute()
  {
    return this instanceof InfoAttribute;
  }

  public String getDisplayName()
  {
    if (super.getDisplayName().length() > 0)
      return super.getDisplayName();
    return getMemberName();
  }

  public InfoClass getInfoClass()
  {
    return (InfoClass)getParent();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.info.InfoMember
 * JD-Core Version:    0.6.0
 */